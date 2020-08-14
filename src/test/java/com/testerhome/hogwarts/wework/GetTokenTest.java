package com.testerhome.hogwarts.wework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetTokenTest {
    GetToken getToken;

    @BeforeEach
    void setUp() {
        if(getToken==null){
            getToken=new GetToken();
        }
    }

    @Test
    void getToken() {
        String token = getToken.getToken();
        System.out.println(token);
    }
}