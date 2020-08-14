package com.testerhome.hogwarts.wework.contact;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.testerhome.hogwarts.wework.Wework;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Department extends Contact{

    public Response list(Integer id){
        HashMap<String,Object> map=new HashMap<>();
        map.put("id",id);
        return getResponseFromYaml("/api/list.yaml",map);

    }


    public Response create(String name, Integer parentid){
        HashMap<String,Object> map=new HashMap<>();
        map.put("name",name);
        map.put("parentid",parentid);
        map.put("_file","/data/create.json");

        return getResponseFromYaml("/api/create.yaml",map);

    }

    public Response createMap(HashMap<String, Object>map){
        reset();
        DocumentContext documentContext= JsonPath.parse(this.getClass()
                .getResourceAsStream("/data/create.json"));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });

        return requestSpecification
                .body(documentContext.jsonString())
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().extract().response();
    }


    public Response update(String name, Integer id){
        HashMap<String,Object> map=new HashMap<>();
        map.put("_file","/data/update.json");
        map.put("name",name);
        map.put("id",id);
        return getResponseFromYaml("/api/update.yaml",map);
    }

    public Response delete(Integer id){
        HashMap<String,Object> map=new HashMap<>();
        map.put("id",id);
        return getResponseFromYaml("/api/delete.yaml", map);

    }

    public Response deleteAll(){
       List<Integer> idList=list(1).then().log().all().extract().path("department.id");
        System.out.println(idList);
        idList.forEach(id->delete(id));
        return null;
    }

}
