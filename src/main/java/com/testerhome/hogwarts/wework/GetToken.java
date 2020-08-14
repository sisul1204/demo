package com.testerhome.hogwarts.wework;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;

public class GetToken {
    public String token;
    public String getToken(){
//        String body= JsonPath.parse(this.getClass().getResourceAsStream("/data/login.json"))
//                .set("$.username","test9527").set("$.password","111111").jsonString();
        return RestAssured.given()
                .formParam("username","test9527")
                .formParam("password","111111")
                .when().post("http://djztec.f3322.net:81/declare/loginuser")
                .then().log().all()
                    .extract().path("result.token");
    }
}
