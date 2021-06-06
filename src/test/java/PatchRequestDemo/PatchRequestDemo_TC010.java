package PatchRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchRequestDemo_TC010 {
    @Test
    public void patchRequest_verifyPatchRequest(){
        //base URI declared
        RestAssured.baseURI="https://reqres.in";

        //request object
        RequestSpecification httpRequest= RestAssured.given();

        //request payload sent along with post request
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("job","Manager");


        httpRequest.body(jsonObject.toJSONString());

        //response object
        Response response=httpRequest.request(Method.PATCH,"/api/users/2");
        System.out.println(response.getBody().asString());

        //assert status code
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
