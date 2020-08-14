package com.testerhome.hogwarts.wework;

import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Project2 {
    public String random=String.valueOf(System.currentTimeMillis());
    public Response create(){
        GetToken login=new GetToken();
        String token = login.getToken();





        return given().header("token",token)
                .header("Userid",99)
                .log().all().contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("project_name","测试项目_"+random)
                .formParam("pro_type",1)
                .formParam("type", 1)
                .formParam("build_com",32)
                .formParam("investment",1)
                .formParam("address","余杭街道")
                .formParam("descs","xxxxxx")
                .formParam("status",2)
                .formParam("before_money",1000)
                .formParam("road_m","")
                .formParam("area_scenery","")
                .formParam("chongjian","")
                .formParam("road_type", "")
                .formParam("wenhao", "58"+random)
                .formParam("befor_wenhao", "")
                .formParam("project_num","323437890"+random)
                .formParam("build_name","张三")
                .formParam("build_tel","15636987452")
                .formParam("build_content","犬瘟热34人体4她4若胡清华大全")
                .formParam("precut",10)
                .formParam("outground",69).formParam("underground",2)
                .formParam("area",1231)
                .formParam("height",120)
                .formParam("declarators_name", "华安")
                .formParam("declarators_tel", "18295279527")


                .formParam("estimate_inform", "{\"one\":[{\"name\":\"220kv云窑4Q00线37#～40#、   瓶仁4Q51线4#～7#移位改造工程.docx\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/220kv云窑4Q00线37#～40#、   瓶仁4Q51线4#～7#移位改造工程1595228789.docx\",\"uid\":1595228790505,\"status\":\"success\"},{\"name\":\"220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#移位改造工程.pdf\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#移位改造工程1595228814.pdf\",\"uid\":1595228815474,\"status\":\"success\"}],\"two\":[{\"name\":\"220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#内审意见.docx\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#内审意见1595228825.docx\",\"uid\":1595228826666,\"status\":\"success\"}],\"three\":[{\"name\":\"220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#初设审查意见及回复.pdf\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#初设审查意见及回复1595228836.pdf\",\"uid\":1595228837579,\"status\":\"success\"}],\"foure\":[{\"name\":\"220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#可研批复.doc\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/220kv云窑4Q00线37#～40#、瓶仁4Q51线4#～7#可研批复1595228843.doc\",\"uid\":1595228844498,\"status\":\"success\"}],\"five\":[{\"name\":\"证书复#+~印件.jpg\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/证书复#+~印件1595228856.jpg\",\"uid\":1595228858269,\"status\":\"success\"}],\"six\":[{\"name\":\".1#$%6()表格.xlsx\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/.1#$%6()表格1595228868.xlsx\",\"uid\":1595228869433,\"status\":\"success\"}],\"seven\":[{\"name\":\".keq&%#8扫描件.docx\",\"url\":\"http://djztec.f3322.net:81/public/Uploads/App20200720/.keq&%#8扫描件1595228874.docx\",\"uid\":1595228875556,\"status\":\"success\"}]}")

                .when().post("http://djztec.f3322.net:81/estimate/report")
                .then().log().all().statusCode(200).extract().response();
    }
}
