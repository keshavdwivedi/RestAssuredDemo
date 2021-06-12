package PatchRequestDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchRequestDemo_TC009 {
    @Test
    public void patchRequest_verifyPatchRequest(){
        //base URI declared
        RestAssured.baseURI="https://reqres.in";

        //request object
     Response response=RestAssured.given()
             .params("job","manager")
             .patch(RestAssured.baseURI+"/api/users/2");

     //print the response
       response.prettyPrint();

        //assert status code
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
