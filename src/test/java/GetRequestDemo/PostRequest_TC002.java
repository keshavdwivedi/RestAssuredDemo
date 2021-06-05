package GetRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostRequest_TC002 {

    @Test()
    public void postRequest_verifystatuscode_jsonpathValues(){

        //base URI declared
        RestAssured.baseURI="https://reqres.in";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //request payload sent along with post request
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","leader");

        //append payload with request body
        httpRequest.body(jsonObject.toJSONString());

        //response object
        Response response=httpRequest.request(Method.POST,"/api/users");
        System.out.println(response.getBody().asString());

        //assert status code
        Assert.assertEquals(response.getStatusCode(),201);

        //assert date in response
        String createdAtActual=response.jsonPath().get("createdAt");
        Assert.assertTrue(createdAtActual.contains("2021-06-05"));
    }


}
