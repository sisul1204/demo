package com.testerhome.hogwarts.wework.contact;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    Department department;
    String random=String.valueOf(System.currentTimeMillis());

    @BeforeEach
    void setUp() {
        if(department==null){
            department=new Department();
        }
    }

    @Test
    void list() {
        department.list(1).then().statusCode(200).body("department[0].name", equalTo("你的益达")).body("errcode",equalTo(0));


    }

    @Test
    void create() {
        department.create("TINGHUA"+random,1).then().body("errcode",equalTo(0));
        department.create("清华大学"+random,1).then().body("errcode",equalTo(0));
    }

    @Test
    void createMap(){
        
    }

    @Test
    void update() {
        String nameOld="TingHUA"+random;
        department.create(nameOld,1);
        Integer id=department.list(1).path("department.find{it.name=='"+nameOld+"'}.id");
        department.update("nanjingdaxue"+random,id).then().body("errcode",equalTo(0));
    }


    @Test
    void delete() {
        String nameOld="aaaaaaaaaaa"+random;
        department.create(nameOld,1);
        Integer id=department.list(0).path("department.find{it.name=='"+nameOld+"'}.id");
        department.delete(id).then().body("errcode",equalTo(0));

    }

//    @Test
//    void deleteAll() {
//        department.deleteAll();
//    }
}