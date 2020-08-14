package com.testerhome.hogwarts.wework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class Project2Test {
    Project2 project;
    String random=String.valueOf(System.currentTimeMillis());

    @BeforeEach
    void setUp() {
        if(project==null){
            project=new Project2();
        }
    }

    @Test
    void create() {
        project.create()
                .then().body("code",equalTo(0)).body("msg",equalTo("添加成功"));
    }
}