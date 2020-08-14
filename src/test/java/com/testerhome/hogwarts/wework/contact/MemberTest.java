package com.testerhome.hogwarts.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    static Member member;
    String random=String.valueOf(System.currentTimeMillis());

    @BeforeAll
    static void setUp() {
        member=new Member();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/members.csv")
    void create(String name, String alias){
        String nameNew=name+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0,5+8);
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("userid",nameNew);
        map.put("name",name);
        map.put("alias",alias);
        map.put("mobile","182"+random);
        map.put("department", Arrays.asList(1));
        map.put("email",random+"@qq.com");
        member.create(map).then().statusCode(200).body("errcode",equalTo(0));
    }

    @Test
    void delete() {
        member.delete("nnnnn").then().body("errcode",equalTo(0));
    }


    @Test
    void list() {
        member.list("csv_11588473485732").then().body("errcode",equalTo(0));
    }

    @Test
    void update() {
        member.update("sisul_1588382279830","aaaaa","测试工程师").then().body("errcode", equalTo(0));
    }

    @Test
    void deletebatch() {
        List<String> list=new ArrayList<>();
        list.add("csv_11588473485732");
        list.add("csv_11588474715545");
        System.out.println(list.toString());
        member.deletebatch(list).then().body("errcode", equalTo(0));
    }
}