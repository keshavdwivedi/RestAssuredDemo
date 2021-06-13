package deleteRequestDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRequest_TC011 {

    @Test
    public void deleteRequest_VerifyDeletion(){
        //request URI
        RestAssured.baseURI="https://reqres.in";

        //request object
      Response response= RestAssured.given().delete(RestAssured.baseURI+"/api/users/2");

        //verify status code
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),204);

    }

}
