package postRequestDemo;

import apiUtils.ApiUtility;
import dataDrivenSetup.APIDataProvider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest_TC007 {

    @Test(dataProvider = "apidataprovider",dataProviderClass = APIDataProvider.class)
    public void PostRequest_dataDrivenTest(String name,String gender,String email,String status) {
        //base URI declared
        String bearer_token="YWE0ZDA4YjZiYWIyODUzYzNjZmIwZDNiODUzNThlMjNhZWU1NjNiZjZiYThhN2I0YWEwMjI0MjA3YjU0NWY2Yw==";
        //declaring base URI
        RestAssured.baseURI = "https://gorest.co.in";

        //request object
        Response response = RestAssured.given().header("Authorization","Bearer "+ ApiUtility.decodeString(bearer_token))
                .queryParam("name",name)
                .queryParam("gender",gender)
                .queryParam("email",email)
                .queryParam("status", status).when()
                .post("/public/v2/users");

        //print response
        response.prettyPrint();

        assertThat(response.getStatusCode(), equalTo(201));

        JsonPath path= response.jsonPath();
        int id= path.getInt("id");
        System.out.println("The id created is: "+id);


//        //assert date in response
//        String createdAtActual=response.jsonPath().get("success");
//        Assert.assertTrue(createdAtActual.contains("2021-06-12"));
    }

}
