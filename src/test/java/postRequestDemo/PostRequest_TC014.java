package postRequestDemo;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest_TC014 {

    @Test
    public void postrequest_HashmapParams(){

        baseURI="https://reqres.in";

        //use hashmap to pass parameter
        HashMap<String,String>paramMap=new HashMap<>();
        paramMap.put("email","eve.holt@reqres.in");
        paramMap.put("password","pistol");

        //post request
        given().contentType(ContentType.JSON).body(paramMap)
                .post(baseURI+"/api/register")
                .prettyPrint();


    }

}
