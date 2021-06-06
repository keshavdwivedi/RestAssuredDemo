package GetRequestDemo;

import ApiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC003 {

    @Test
    public void getRequest_verifyindividualHeaders(){

        String encodedApiKey="ZmFiNWVlYjc5ZmVmNDRmMzg0NjUzMDU1MjEwNTA2";

        //request URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/astronomy.json?key="+ ApiUtility.decodeString(encodedApiKey) +"&q=Lucknow&dt=2021-06-05");

        //print response body
        System.out.println(response.getBody().asString());

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify individual response headers
        String contentType=response.header("Content-Type");
        Assert.assertEquals(contentType,"application/json");


    }

}
