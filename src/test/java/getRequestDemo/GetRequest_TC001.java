package getRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

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
                .params("aqi","yes")
                .get(RestAssured.baseURI+"/current.json");

        //print response body
        response.prettyPrint();

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify status line
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");


    }
}
