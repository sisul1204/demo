package com.testerhome.hogwarts.wework;

import java.util.Arrays;
import java.util.List;

public class SimpleTester {
    public static void main(String[] args) {
        String[] data={"Tom","Mike","Linda","Jack"};
        List<String> names = Arrays.asList(data);

        //传统的遍历集合的方式
        for(String name:names){
            System.out.println(name);
        }

        names.forEach(name->{
            System.out.println(name);
        });


    }
}
