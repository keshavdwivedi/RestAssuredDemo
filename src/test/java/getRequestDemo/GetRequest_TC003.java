package getRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC003 {

    @Test
    public void getRequest_verifyindividualHeaders(){

        String encodedApiKey="ZmFiNWVlYjc5ZmVmNDRmMzg0NjUzMDU1MjEwNTA2";

        //request URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //bdd style request
        Response response=RestAssured.given().get(RestAssured.baseURI+"/astronomy.json?key="+ ApiUtility.decodeString(encodedApiKey) +"&q=Lucknow&dt=2021-06-05");


        //print response body
        response.prettyPrint();

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify individual response headers
        String contentType=response.header("Content-Type");
        Assert.assertEquals(contentType,"application/json");


    }

}
