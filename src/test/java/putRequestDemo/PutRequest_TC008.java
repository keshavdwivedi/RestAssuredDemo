package putRequestDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutRequest_TC008 {

    @Test
    public void putRequest_verifyPutRequest(){
        //base URI declared
        RestAssured.baseURI="https://reqbin.com/";

        //request object
        Response response=RestAssured.given()
                .params("Id","12345")
                .params("Customer","John Smith")
                .params("Quantity","1")
                .params("Price","10.00")
                .put(RestAssured.baseURI+"/echo/put/json");

        //print response
        response.prettyPrint();



        //assert status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify response json node value
        Assert.assertEquals(response.jsonPath().get("success"),"true");



    }
}
