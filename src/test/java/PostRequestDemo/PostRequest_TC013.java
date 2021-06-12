package PostRequestDemo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest_TC013 {

    @Test
    public void postrequest_JsonstringbodyRequest(){

        baseURI="https://reqres.in";

        String bodyString="{\"email\": \"eve.holt@reqres.in\",\"password\":\"cityslicka\"}";

        Response response=given().contentType("application/json")
                .body(bodyString)
                .post(baseURI+"/api/login");

        //print response
        response.prettyPrint();
    }



}
