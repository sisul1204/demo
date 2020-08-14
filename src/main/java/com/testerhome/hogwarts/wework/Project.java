package com.testerhome.hogwarts.wework;

import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Project {
    public String random=String.valueOf(System.currentTimeMillis());
    public Response create(){
        GetToken login=new GetToken();
        String token = login.getToken();





        return given().header("token",token)
                .header("Userid",99)
                .log().all().contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("type_data","综合楼工程")
                .formParam("type", 1)
                .formParam("pro_type",1).formParam("pro_type_data","建筑工程")
                .formParam("build","西湖区街道").formParam("status",2)
                .formParam("project_name","test"+random)
                .formParam("project_num","323437890"+random)
                .formParam("address","余杭街道").formParam("investment",1)
                .formParam("before_money",10000).formParam("wenhao","1"+random)
                .formParam("area",1231).formParam("outground",69).formParam("underground",2)
                .formParam("height",120).formParam("precut",12)
                .formParam("build_com",32).formParam("build_name","张三")
                .formParam("build_tel","15636987452")
                .formParam("build_content","犬瘟热34人体4她4若胡清华大全")
                .formParam("estimates","http://djztec.f3322.net:81/public/Uploads/App20200507/指标测试-综合楼估算表1588819421.xls")
                .formParam("cad","http://djztec.f3322.net:81/public/Uploads/App20200507/a1588819426.json")
                .formParam("requests","http://djztec.f3322.net:81/public/Uploads/App20200507/charles-proxy-ssl-proxying-certificate1588819433.pem")
                .formParam("opinion","http://djztec.f3322.net:81/public/Uploads/App20200507/bug记录1588819438.txt")
//                .formParam("locker","[false,true,false,false,false,false]")
                .when().post("http://djztec.f3322.net:81/report/project/add")
                .then().log().all().statusCode(200).extract().response();
    }
}
