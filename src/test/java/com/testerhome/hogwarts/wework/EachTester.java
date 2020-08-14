package com.testerhome.hogwarts.wework;

import java.util.ArrayList;
import java.util.List;

public class EachTester {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<Person>(){
            {
                add(new Person("Tom",21));
                add(new Person("Mike",32));
                add(new Person("Linda",19));
            }
        };

        persons.forEach((Person p)->{
            p.setAge(p.getAge()+1);
            System.out.println(p.getName() + ":" + p.getAge());
        });

    }

}
