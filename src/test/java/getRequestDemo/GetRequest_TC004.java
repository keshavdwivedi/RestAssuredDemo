package getRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GetRequest_TC004 {

    @Test
    public void getRequest_verifyAllHeaders(){

        String encodedApiKey="ZmFiNWVlYjc5ZmVmNDRmMzg0NjUzMDU1MjEwNTA2";

        //request URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //getting reponse from get request
                 Response response=RestAssured.given()
                .params("key",ApiUtility.decodeString(encodedApiKey))
                .params("q","Lucknow").when().get(RestAssured.baseURI+"/timezone.json");

        //print response body
        System.out.println(response.getBody().asString());

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println("Headers are as follows");

        //capture all headers and transverse through them
        Headers allheaders=response.headers();
        for (Header header:allheaders)
        {
            System.out.println(header.getName()+"  "+header.getValue());
        }

        //validate number of headers
        List<Header> headersList=allheaders.asList();
        Assert.assertEquals(headersList.size(),24);
    }

}
