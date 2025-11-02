package authentications;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest_TC0012 {

    //oauth2 authentication is used when we have to when 3rd party applications need to access user data without exposing user credentials.

    @Test
    public void getRequest_handleAuth2(){

        String token="MTBhNWM5NDAyYWYwYTYzYmNmZTY3OGU0YWE0ODI3ZTFkOTQ1YWI5NA==";

        //declaring base URI
        RestAssured.baseURI="https://api.github.com";

        //request object
        Response response= RestAssured.given().
                auth().preemptive().basic(ApiUtility.decodeString(""), token)
                .when()
                .get(RestAssured.baseURI+"/octocat");

        //print response
        response.prettyPrint();

        assertThat(response.getStatusCode(), equalTo(200));
    }

}
