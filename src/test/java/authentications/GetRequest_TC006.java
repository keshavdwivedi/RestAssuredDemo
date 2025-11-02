package authentications;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetRequest_TC006 {

    String token1 = "MTBhNWM5NDAyYWYwYTYzYmNmZTY3OGU0YWE0ODI3ZTFkOTQ1YWI5NA==";
    String token2="YWE0ZDA4YjZiYWIyODUzYzNjZmIwZDNiODUzNThlMjNhZWU1NjNiZjZiYThhN2I0YWEwMjI0MjA3YjU0NWY2Yw==";

    @Test(description = "Handling Basic Authorization")
    public void getRequest_handleBasicAuthorization() {



        //declaring base URI
        RestAssured.baseURI = "https://api.github.com";

        //request object
        Response response = RestAssured.given().
                auth().basic(ApiUtility.decodeString(""), token1)
                .get(RestAssured.baseURI + "/octocat");

        //print response
        response.prettyPrint();

        assertThat(response.getStatusCode(), equalTo(200));
    }

    @Test(description = "Handling Preemptive Basic Authorization")
    public void getRequest_handlePreemptiveBasicAuthorization() {


        //declaring base URI
        RestAssured.baseURI = "https://gorest.co.in";

        //request object
        Response response=RestAssured.given().
                auth().preemptive().basic(ApiUtility.decodeString(""), token2)
                .get(RestAssured.baseURI + "/public-api/users?id=7440471");

        //print response
        response.prettyPrint();


        //assertion that response body contains pagination
        response.then().assertThat().extract().body().asString().contains("pagination");

        //assertion that status code is 200
        assertThat(response.getStatusCode(), equalTo(200));
    }





}

        /*
        difference between non-preemptive auth().basic() and preemptive basic auth().preemptive().basic():

   auth.preemptive.basic
What it is: Sends a username and password with the initial API request.
How it works: The client includes the Authorization header with the base64-encoded credentials in the first request to the server, without waiting for a challenge from the server.


oauth.basic
What it is: A token-based authorization flow.
How it works: The client first makes a request to the server without any credentials.
If the server requires authentication, it responds with a 401 Unauthorized status code and a WWW-Authenticate header.
The client then resends the request with the appropriate Authorization header containing the token or credentials.
encoding is done in base 64 format

It is by default basic auth in rest assured

digest basic auth

it is also a kind of basic auth and in this also we send credential to server with request but the difference is that
the encoding is done based on algorithms like MD5, SHA-256 etc which makes it more secure than basic auth

 */

