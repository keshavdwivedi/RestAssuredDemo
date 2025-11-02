package patchRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class PatchRequestDemo_TC009 {
    @Test
    public void patchRequest_verifyPatchRequest(){

        String bearer_token="YWE0ZDA4YjZiYWIyODUzYzNjZmIwZDNiODUzNThlMjNhZWU1NjNiZjZiYThhN2I0YWEwMjI0MjA3YjU0NWY2Yw==";
        //declaring base URI
        RestAssured.baseURI = "https://gorest.co.in";

        //request object
        Response response = given().header("Authorization","Bearer "+ ApiUtility.decodeString(bearer_token))
                .queryParam("name","Nambi Narayanan")
                .queryParam("gender","Male")
                .queryParam("email","nambinarayan@gmail.com")
                .queryParam("status","Active").when()
                .post("/public/v2/users");

        //print response
        response.prettyPrint();

        assertThat(response.getStatusCode(), equalTo(201));

        JsonPath path= response.jsonPath();
        int id= path.getInt("id");
        System.out.println("The id created is: "+id);

        response = RestAssured.given().header("Authorization","Bearer "+ ApiUtility.decodeString(bearer_token))
                .queryParam("name","Ravi Shukla")
                .queryParam("email","Ravishukla@gmail.com")
                .when()
                .patch("/public/v2/users/"+id);

        System.out.println("Updated response after patch request is");
        response.prettyPrint();

        assertThat(response.getStatusCode(), equalTo(200));

                given().header("Authorization","Bearer "+ApiUtility.decodeString(bearer_token)).when()
                .delete("/public/v2/users/"+id)
                .then().assertThat().statusCode(204).log().all();


    }
}
