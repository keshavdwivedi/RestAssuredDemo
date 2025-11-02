package postRequestDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostRequest_TC002 {


    @Test(description = "post request by hashmap and verifying jsonpath values")
    public void postRequest_verifystatuscode_jsonpathValues(){

        //base URI declared
        RestAssured.baseURI="https://api.restful-api.dev";

        //creating nested map for request body and passing it in payload
        Map<String,Object>dataMap=new HashMap<>();
        dataMap.put("year",2025);
        dataMap.put("price",100000);
        dataMap.put("iOS Version","iOS 18.2");
        dataMap.put("Memory","512 GB");

        Map<String,Object>headerMap=new HashMap<>();
        headerMap.put("name","iPhone 17 Pro Max");
        headerMap.put("data",dataMap);

        Response response=RestAssured.given()
                .contentType("application/json")
                .when()
                .body(headerMap)
                .post(RestAssured.baseURI+"/objects");

          response.prettyPrint();

        //assert status code
        Assert.assertEquals(response.getStatusCode(),200);

        //assert date in response
        String createdAtActual=response.jsonPath().get("createdAt");
        Assert.assertTrue(createdAtActual.contains("2025"));

        //capture product id of product created and this will be deleted in deletion class TC0011
        String product_id = response.jsonPath().get("id");
        System.out.println("Product ID: "+ product_id);
    }

}
