package com.testerhome.hogwarts.wework;

import io.restassured.RestAssured;

public class Wework {
    private static String token;
    public static String getWeWorkToken(String secret){
        return RestAssured.given().queryParam("corpid",WeworkConfig.getInstance().corpid)
                                    .queryParam("corpsecret",WeworkConfig.getInstance().secret)
                            .when()
                                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                            .then()
                                .log().all()
                            .extract().path("access_token");
    }

    public static String getToken(){
        if(token==null){
            token=getWeWorkToken(WeworkConfig.getInstance().contactsecret);
        }
        return token;
    }

}
