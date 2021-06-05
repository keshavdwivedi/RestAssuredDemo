package GetRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC005 {

    @Test
    public void getrequest_verifyjsonResponse_singleField(){

        //request URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/forecast.json?key=fab5eeb79fef44f384653055210506&q=Lucknow&days=1&aqi=no&alerts=no");

        //asserting text in response body
        Assert.assertTrue(response.getBody().asString().contains("Partly cloudy"));

    }
}
