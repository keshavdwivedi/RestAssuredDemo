package deleteRequestDemo;

import apiUtils.ApiUtility;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest_TC015 {

    @Test
    public void deleteRequest_DeleteStripeCustomer(){

        String APIKey="c2tfdGVzdF81MUl6Tm9XU0ZVZ3lJRjRCcVh5cm13aGtYNzJ5TkdXWWFqUlBGUnBpNmpKbnZhOGhoc2ZDSVJFT2VUV3pMczd0QzAzb25sSEg1OW1TRWdGemIyYVNFNFJwbDAwY1oyUVJ0Q0g=";

                 given()
                .auth()
                .basic(ApiUtility.decodeString(APIKey),"")
                .baseUri("https://api.stripe.com")
                .delete("/v1/customers/cus_JenMgwdfZByUks")
                .prettyPrint();
    }

}
