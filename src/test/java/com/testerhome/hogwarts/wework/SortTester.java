package com.testerhome.hogwarts.wework;

import java.util.*;

public class SortTester {
    public static void main(String[] args) {
        String[] data = {"Tom","Mike","Mary","Linda","Jack"};
        List<String> names=Arrays.asList(data);

        Comparator<String> cp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        Collections.sort(names,cp);

        Comparator<String> sortByName=(String s1, String s2)->(s1.compareTo(s2));
        Collections.sort(names, sortByName);


        Collections.sort(names,(String s1,String s2)->(s1.compareTo(s2)));

        names.forEach(System.out::println);






    }
}
