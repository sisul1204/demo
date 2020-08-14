package com.testerhome.hogwarts.wework;

import java.util.ArrayList;
import java.util.List;

public class ColTester {
    public static void main(String[] args) {
        List<Person> persons=new ArrayList<Person>(){
            {
                add(new Person("Tom",21));
                add(new Person("Mike",32));
                add(new Person("Linda",19));
                add(new Person("Mary", 29));
            }
        };

        persons.stream()
                .filter(p->p.getAge()>20)
                .forEach(p->{
                     System.out.println(p.getName()+":"+p.getAge());
                });

        persons.stream()
                .sorted((p1,p2)->(p1.getAge()-p2.getAge()))
                .limit(3)
                .forEach(p->System.out.println(p.getName()+":"+p.getAge()));

        int maxAge=persons.parallelStream()
                .mapToInt(p->p.getAge())
                .max()
                .getAsInt();
        System.out.println("Max Age:"+maxAge);
    }
}
