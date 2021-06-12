package PostRequestDemo;

import DataDrivenSetup.APIDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequest_TC007 {

    @Test(dataProvider = "apidataprovider",dataProviderClass = APIDataProvider.class)
    public void PostRequest_dataDrivenTest(String name,String job){
        //base URI declared
        RestAssured.baseURI="https://reqres.in";

        //request object
       Response response= RestAssured.given()
               .contentType("application/json")
               .queryParam("name",name)
                .queryParam("job",job)
                .post(RestAssured.baseURI+"/api/users");

       //printing response
        response.prettyPrint();

        //assert status code
        Assert.assertEquals(response.getStatusCode(),201);

        //assert date in response
        String createdAtActual=response.jsonPath().get("createdAt");
        Assert.assertTrue(createdAtActual.contains("2021-06-12"));
    }

}
