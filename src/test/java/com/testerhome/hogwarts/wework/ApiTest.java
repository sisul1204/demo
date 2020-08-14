package com.testerhome.hogwarts.wework;

import org.junit.jupiter.api.Test;

import java.net.URL;

class ApiTest {

    @Test
    void templateFromHar() {
        URL url = getClass().getResource("/api/app2.har.json");
        System.out.println(url.getFile());
        System.out.println(url.getPath());
    }

    @Test
    void getApiFromHar() {
        Api api=new Api();
        System.out.println(api.getApiFromHar("/api/app2.har.json", ".*tid=67.*").url);
        System.out.println(api.getApiFromHar("/api/app2.har.json", ".*tid=41.*").url);
        System.out.println(api.getApiFromHar("/api/app2.har.json", ".*tid=21.*").url);
    }

    @Test
    void matches(){
        String s="https://work.weixin.qq.com/api/devtools/devhandler.php?tid=67&access_token=gs4n_tfZfSWNnLxtJx_Qsww8tpRN_7fsglgvhencsjNO1uR4mvylY2vfy42sX_Oub1i1rjstiWi3D-bk4qybWhpwPHR9yQ9D-T-huOvRCO0RzLrcetj5foV1wgoXhb6fKm5f8oZa-SH4hbgenoL-FYfEuxvxOaKusrWpNAwl4NSBD_4_l4eDPFysBGTj1HDrvqt57Nij_P-jzT1jFV9v_Q&f=json";
        System.out.println(s.matches(".*tid=67.*"));
    }

    @Test
    void getResponseFromHar() {
        Api api=new Api();
        api.getResponseFromHar("/api/app2.har.json",".*tid=67.*",null);

    }
}