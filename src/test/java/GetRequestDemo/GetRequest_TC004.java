package GetRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC004 {

    @Test
    public void getRequest_verifyAllHeaders(){

        //request URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/timezone.json?key=fab5eeb79fef44f384653055210506&q=Lucknow");

        //print response body
        System.out.println(response.getBody().asString());

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println("Headers are as follows");

        //capture all headers and transverse through them
        Headers allheaders=response.headers();
        for (Header header:allheaders)
        {
            System.out.println(header.getName()+"  "+header.getValue());
        }
    }

}
