package Authentications;

import ApiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC0012 {

    @Test
    public void getRequest_handleAuth2(){

        String token="MTBhNWM5NDAyYWYwYTYzYmNmZTY3OGU0YWE0ODI3ZTFkOTQ1YWI5NA==";

        //declaring base URI
        RestAssured.baseURI="https://api.github.com";

        //request object
        Response response=RestAssured.given().
                auth().oauth2(ApiUtility.decodeString(token))
                .get(RestAssured.baseURI+"/users/keshavdwivedi/repos");

        //print response
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
    }

}
