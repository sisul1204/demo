package com.testerhome.hogwarts.wework.contact;

import com.jayway.jsonpath.JsonPath;
import com.testerhome.hogwarts.wework.Wework;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Member extends Contact{
//    public Response create(String userid,String name){
//        String body= JsonPath.parse(this.getClass()
//                .getResourceAsStream("/data/member.json"))
//                .set("$.userid",userid).set("$.name",name).jsonString();
//        return given().log().all()
//                .contentType(ContentType.JSON)
//                .queryParam("access_token", Wework.getToken())
//                .body(body)
//                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
//                .then().log().all().statusCode(200).extract().response();
//    }

    public Response create(HashMap<String,Object> map){

        String body=template("/data/member.json", map);

        return getDefaultRequestSpecification().body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                    .then().log().all().extract().response();
    }



    public Response delete(String userid){
        return given().log().all().queryParam("userid",userid)
                .queryParam("access_token",Wework.getToken())
                .when()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then().log().all()
                    .statusCode(200).extract().response();
    }


    public Response list(String userid){
        return given().log().all().queryParam("userid",userid)
                .queryParam("access_token",Wework.getToken())
                .when()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/user/get")
                .then().log().all()
                    .statusCode(200).extract().response();
    }

    public Response update(String userid, String name, String position){
        String body=JsonPath.parse(this.getClass().getResourceAsStream("/data/memberupdate.json"))
                .set("$.userid", userid).set("$.name", name).set("$.position",position).jsonString();
        return given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("access_token",Wework.getToken())
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
                .then().log().all().statusCode(200).extract().response();
    }

    public Response deletebatch(List<String> list){
//        HashMap<String,List> map = new HashMap<>();
//        map.put("userlist", list);
        String body=JsonPath.parse(this.getClass().getResourceAsStream("/data/deletebatch.json"))
                .set("$.useridlist",list).jsonString();
        return given().log().all()
                .queryParam("access_token",Wework.getToken())
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete")
                .then().log().all().statusCode(200).extract().response();
    }

}
