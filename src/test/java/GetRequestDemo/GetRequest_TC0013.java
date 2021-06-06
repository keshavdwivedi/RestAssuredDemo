package GetRequestDemo;

import ApiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;

public class GetRequest_TC0013 {

    @Test
    public void getRequest_handleAuth2(){

        String token="MTBhNWM5NDAyYWYwYTYzYmNmZTY3OGU0YWE0ODI3ZTFkOTQ1YWI5NA==";

        //declaring base URI
        RestAssured.baseURI="https://api.github.com";

        //request object
        RequestSpecification httpRequest=RestAssured.given().auth().oauth2(ApiUtility.decodeString(token));

        Response response=httpRequest.request(Method.GET,"/users/keshavdwivedi/repos");

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),200);
    }

}
