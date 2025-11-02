package postRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest_TC013 {

    @Test(description = "Post request using Json Object in body")
    public void postrequest_JsonObject(){

        baseURI="https://api.restful-api.dev";

        // Create the inner JSON object
        JSONObject dataObject = new JSONObject();
        dataObject.put("year",2025);
        dataObject.put("price", 125000);
        dataObject.put("Processor", "M4 Chip");
        dataObject.put("Memory", "1 TB");
        dataObject.put("color", "Space Gray");

        //create the main JSON object
        JSONObject paramObj = new JSONObject();
        paramObj.put("name", "MacBook Pro 2025");
        paramObj.put("data", dataObject);


        //post request
        given().contentType(ContentType.JSON)
                .when()
                .body(paramObj)
                .post(baseURI+"/objects")
                .prettyPrint().contains("createdAt");


    }

}
