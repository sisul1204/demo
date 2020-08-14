package com.testerhome.hogwarts.wework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    Project project;
    String random=String.valueOf(System.currentTimeMillis());

    @BeforeEach
    void setUp() {
        if(project==null){
            project=new Project();
        }
    }

    @Test
    void create() {
        project.create()
                .then().body("code",equalTo(0)).body("msg",equalTo("success"));
    }
}