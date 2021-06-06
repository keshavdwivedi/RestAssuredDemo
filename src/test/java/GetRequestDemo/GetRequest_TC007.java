package GetRequestDemo;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC007 {

    @Test
    public void getRequest_handleBasicAuthorization(){

        //request base URI
        RestAssured.baseURI="https://qa-task.backbasecloud.com";

        //declaring preemptivebasicauthschme object and setting username and password
        PreemptiveBasicAuthScheme preemptiveAuth=new PreemptiveBasicAuthScheme();
        preemptiveAuth.setUserName("candidatex");
        preemptiveAuth.setPassword("qa-is-cool");
        RestAssured.authentication=preemptiveAuth;

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/");

        //printing response body
        System.out.println(response.getBody().asString());

        //validating status code
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
