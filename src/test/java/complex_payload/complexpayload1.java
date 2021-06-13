package complex_payload;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class complexpayload1 {

    @Test
    public void complexPayload_complexHashmap(){

        HashMap<String,Object>jsonMap=new HashMap<>();
        jsonMap.put("users", Arrays.asList(new HashMap<String,Object>(){{
         put("id",3);
         put("firstName","Naveen");
         put("lastName","Singh");
         put("subjectid",3);

        }}));

        jsonMap.put("mobile",Arrays.asList(new HashMap<String,Object>(){{
            put("number",98073424);
            put("id",3);

        }}));

        jsonMap.put("subject",Arrays.asList(new HashMap<String,Object>(){{

            put("subjectName","Devops");
            put("id",3);
        }}));

        baseURI="http://localhost:3000";


        Response response=given().contentType(ContentType.JSON).body(jsonMap).post(baseURI+"/users");
        response.prettyPrint();
    }

}
