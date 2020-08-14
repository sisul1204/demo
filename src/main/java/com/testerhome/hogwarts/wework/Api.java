package com.testerhome.hogwarts.wework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.Har;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarHeader;
import de.sstoehr.harreader.model.HarRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class Api {
    HashMap<String,Object> query=new HashMap<String,Object>();

    public Api(){
        useRelaxedHTTPSValidation();
    }




    public RequestSpecification getDefaultRequestSpecification(){
        return given().log().all();
    }
    
    public static String template(String path,HashMap<String, Object> map){
        DocumentContext documentContext= JsonPath.parse(Api.class
                .getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });
        return documentContext.jsonString();
        
    }








    public Response getResponseFromHar(String path, String pattern, HashMap<String,Object> map){
        //todo:支持从har文件读取接口定义并发送
        Restful restful=getApiFromHar(path,pattern);
        restful=updateApiFromMap(restful,map);
        return getResponseFromRestful(restful);


    }

    public Restful getApiFromHar(String path,String pattern){
        HarReader harReader=new HarReader();
        Boolean match=false;

        try {
            Har har=harReader.readFromFile(new File(getClass().getResource(path).getPath()));
            HarRequest request=new HarRequest();
            for(HarEntry entry:har.getLog().getEntries()){
                request=entry.getRequest();
                if(request.getUrl().matches(pattern)){
                    match=true;
                    break;
                }
            }
            if(match==false){
                request=null;
                throw new Exception("null");
            }


            Restful restful=new Restful();
            restful.method=request.getMethod().name();
            //todo:去掉url中的query部分
            restful.url=request.getUrl();
            request.getQueryString().forEach(q->{
                restful.query.put(q.getName(),q.getValue());
            });

            restful.body=request.getPostData().getText();
            return restful;


        } catch (HarReaderException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }





    public Restful getApiFromYaml(String path){
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(this.getClass().getResourceAsStream(path), Restful.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }






    public Restful updateApiFromMap(Restful restful,HashMap<String,Object> map){
        if(map==null){
            return restful;
        }

        if(restful.method.toLowerCase().contains("get")){
            map.entrySet().forEach(entry->{
                restful.query.replace(entry.getKey(),entry.getValue().toString());
                System.out.println(restful.query);
            });
        }
        if(restful.method.toLowerCase().contains("post")){
            if(map.containsKey("_body")){
                restful.body=map.get("_body").toString();
            }
            if(map.containsKey("_file")){
                String filePath=map.get("_file").toString();
                map.remove("_file");
                restful.body=template(filePath,map);

            }
        }
        return restful;

    }

    public Response getResponseFromRestful(Restful restful){
        RequestSpecification requestSpecification=getDefaultRequestSpecification();
        if(restful.query!=null){
            restful.query.entrySet().forEach(entry->{
                requestSpecification.queryParam(entry.getKey(),entry.getValue());
            });
        }

        if(restful.body!=null){
            requestSpecification.body(restful.body);
        }

        //todo:多环境支持，替换url，更新host的header
        String[] url=updateUrl(restful.url);


        return requestSpecification.log().all()
                .header("Host",url[0])
                .when().request(restful.method,url[1])
                .then().log().all().extract().response();
    }

    private String[] updateUrl(String url){
        //多环境支持，替换url,更新host的header
        HashMap<String,String> hosts=WeworkConfig.getInstance().env.get(WeworkConfig.getInstance().current);

        String host="";
        String urlNew="";
        for(Map.Entry<String,String>entry:hosts.entrySet()){
            if(url.contains(entry.getKey())){
                host=entry.getKey();
                urlNew=url.replace(entry.getKey(),entry.getValue());
            }
        }

        return new String[]{host,urlNew};


    }








    public Response getResponseFromYaml(String path,HashMap<String,Object>map){
        //todo:根据yaml生成接口定义并发送

        Restful restful=getApiFromYaml(path);
        restful=updateApiFromMap(restful,map);
        RequestSpecification requestSpecification=getDefaultRequestSpecification();
        if (restful.query != null) {
            restful.query.entrySet().forEach(entry -> {
                requestSpecification.queryParam(entry.getKey(), entry.getValue());
            });
        }

        if (restful.body != null) {
            requestSpecification.body(restful.body);
        }

        String[] url=updateUrl(restful.url);

        return requestSpecification.log().all()
                .header("Host", url[0])
                .when().request(restful.method, url[1])
                .then().log().all()
                .extract().response();




    }




}
