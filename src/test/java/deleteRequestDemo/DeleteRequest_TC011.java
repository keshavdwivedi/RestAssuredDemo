package deleteRequestDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import postRequestDemo.PostRequest_TC002;

public class DeleteRequest_TC011  {

    @Test
    public void deleteRequest_VerifyDeletion(){
        //request URI
        RestAssured.baseURI="https://api.restful-api.dev";


        //request object
      Response response= RestAssured.given().when().
              delete(RestAssured.baseURI+"/objects/"+"ff8081819782e69e019a4440c7142a90");

        response.prettyPrint();

        //verify status code
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.then().extract().body().asString().contains("has been deleted"));

    }

}
