import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetTestToken {
    @Test
    public void getToken(){
        RestAssured.given().log().all().queryParam("corpid","ww27cd49cb54067c52")
                        .queryParam("corpsecret","aqI7NIn3TDQW0L7VgEkoy1mOcO0ppcb7dS1LSGrvlAc")
                    .when()
                        .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                    .then()
                        .statusCode(200).log().all().body("errcode", equalTo(0));
    }
}
