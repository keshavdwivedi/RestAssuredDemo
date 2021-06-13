package postRequestDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequest_TC002 {

    @Test()
    public void postRequest_verifystatuscode_jsonpathValues(){

        //base URI declared
        RestAssured.baseURI="https://reqres.in";

        Response response=RestAssured.given()
                .contentType("application/json")
                .queryParam("name","morpheus")
                .queryParam("job","leader")
                .post(RestAssured.baseURI+"/api/users");

     response.prettyPrint();

        //assert status code
        Assert.assertEquals(response.getStatusCode(),201);

        //assert date in response
        String createdAtActual=response.jsonPath().get("createdAt");
        Assert.assertTrue(createdAtActual.contains("2021-06-12"));

    }
}
