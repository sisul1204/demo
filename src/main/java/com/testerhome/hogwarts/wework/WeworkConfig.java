package com.testerhome.hogwarts.wework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;

public class WeworkConfig {
    public String agentId="1000005";
    public String secret="aqI7NIn3TDQW0L7VgEkoy1mOcO0ppcb7dS1LSGrvlAc";
    public String corpid="ww27cd49cb54067c52";
    public String contactsecret="aqI7NIn3TDQW0L7VgEkoy1mOcO0ppcb7dS1LSGrvlAc";


    public String current="test";
    public HashMap<String, HashMap<String,String>> env;

    private static WeworkConfig weworkConfig;
    public static WeworkConfig getInstance(){
        if(weworkConfig==null){
            weworkConfig=load("/conf/WeworkConfig.yaml");
            System.out.println(weworkConfig);
            System.out.println(weworkConfig.agentId);
        }
        return weworkConfig;
    }

public static WeworkConfig load(String path){
    ObjectMapper mapper=new ObjectMapper(new YAMLFactory());

    try {
        return mapper.readValue(WeworkConfig.class.getResourceAsStream(path),WeworkConfig.class);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}




}
