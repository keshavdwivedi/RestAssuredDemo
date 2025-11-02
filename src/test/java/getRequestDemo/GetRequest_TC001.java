package getRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetRequest_TC001 {

    @Test
    public void getRequest_verifyStatuscode_statusLine(){

        String encodedApiKey="ZmFiNWVlYjc5ZmVmNDRmMzg0NjUzMDU1MjEwNTA2";
        //declaring base URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //passing parameters to get request
       Response response= given()
                .params("key",ApiUtility.decodeString(encodedApiKey))
                .params("q","Lucknow")
                .params("aqi","yes").when()
                .get(RestAssured.baseURI+"/current.json");

        //print response body
        response.prettyPrint();

        //verify status code
        assertThat(response.getStatusCode(), Matchers.equalTo(200));

        //verify status line
        assertThat(response.getStatusLine(),Matchers.comparesEqualTo("HTTP/1.1 200 OK"));
        //Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");


    }
}
