package com.testerhome.hogwarts.wework;

import java.util.*;

public class Visitor {
    public static void print(Collection<? extends Object> c){
        Iterator<? extends Object> it=c.iterator();
        //遍历集合中的所有元素
        while(it.hasNext()){
            Object element=it.next();
            System.out.println(element);
        }
    }

    public static void printWithForEach(Collection<? extends Object> c){
        for (Object element:c){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Tom");
        set.add("Mary");
        set.add("Jack");
        print(set);
        System.out.println("__________________________");

        List<String> list = new ArrayList<String>();
        list.add("Linda");
        list.add("Mary");
        list.add("jane");
        print(list);
        System.out.println("__________________________");

        Queue<String> queue=new ArrayDeque<>();
        queue.add("T");
        queue.add("M");
        queue.add("A");
        print(queue);
        System.out.println("__________________________");


        Map<String,String> map = new HashMap<String,String>();
        map.put("M","男");
        map.put("F","女");
        print(map.entrySet());
        System.out.println("__________________________");

        printWithForEach(set);
        printWithForEach(list);
        printWithForEach(queue);
        printWithForEach(map.entrySet());

    }





}
