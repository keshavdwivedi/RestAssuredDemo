package postRequestDemo;

import apiUtils.ApiUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostRequest_TC014 {

    @Test
    public void postrequest_JsonpathUsageandSendComplexJsonObject(){

        String APIKey="c2tfdGVzdF81MUl6Tm9XU0ZVZ3lJRjRCcVh5cm13aGtYNzJ5TkdXWWFqUlBGUnBpNmpKbnZhOGhoc2ZDSVJFT2VUV3pMczd0QzAzb25sSEg1OW1TRWdGemIyYVNFNFJwbDAwY1oyUVJ0Q0g=";

       //pass nested json object as payload by using address[city] and shipping[address][line1]
       Response response= given()
                .auth()
                .basic(ApiUtility.decodeString(APIKey),"")
                .baseUri("https://api.stripe.com")
                .queryParam("name","Rajiv")
                .queryParam("email","Rajiv@gmail.com")
                .queryParam("address[city]","Lucknow")
                .queryParam("address[line1]","134,Balda road,Nishatganj")
                .queryParam("shipping[address][line1]","hazratganj")
                .queryParam("shipping[name]","Manoj")
                .post("/v1/customers");

        response.prettyPrint();

        //get directly id by passing id and get line1 of address by passing address.line1
        System.out.println(response.jsonPath().get("id").toString());
        System.out.println(response.jsonPath().get("address.line1").toString());

    }

}
