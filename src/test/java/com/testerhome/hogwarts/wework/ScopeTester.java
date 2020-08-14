package com.testerhome.hogwarts.wework;

import java.util.Arrays;
import java.util.List;

public class ScopeTester {
    int var1=0;

    public void test(){
        String[] data = {"Tom","Mike","Mary"};
        List<String> names= Arrays.asList(data);

        char var2=',';


        names.forEach((name)->{
            var1++;
            System.out.println(this.var1+":"+name+var2);
        });
    }

    public static void main(String[] args) {
        new ScopeTester().test();
    }
}
