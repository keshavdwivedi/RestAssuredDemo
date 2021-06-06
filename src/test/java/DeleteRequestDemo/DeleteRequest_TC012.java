package DeleteRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRequest_TC012 {

    @Test
    public void deleteRequest_VerifyDeletion(){
        //request URI
        RestAssured.baseURI="https://reqres.in";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //capture deletion response
        Response response=httpRequest.request(Method.DELETE,"/api/users/2");

        //verify status code
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),204);

    }

}
