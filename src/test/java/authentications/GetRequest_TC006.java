package authentications;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC006 {

    @Test
    public void getRequest_handleBasicAuthorization(){

        //request base URI
        RestAssured.baseURI="https://qa-task.backbasecloud.com";

        Response response=RestAssured.given()
                .auth()
                .preemptive()
                .basic("candidatex","qa-is-cool").
                get(RestAssured.baseURI+"/");

        //printing response body
        response.prettyPrint();

        //validating status code
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
