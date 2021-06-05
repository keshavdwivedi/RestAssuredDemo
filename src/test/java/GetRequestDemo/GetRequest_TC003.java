package GetRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC003 {

    @Test
    public void getRequest_verifyindividualHeaders(){

        //request URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/astronomy.json?key=fab5eeb79fef44f384653055210506&q=Lucknow&dt=2021-06-05");

        //print response body
        System.out.println(response.getBody().asString());

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify individual response headers
        String contentType=response.header("Content-Type");
        Assert.assertEquals(contentType,"application/json");


    }

}
