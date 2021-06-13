package authentications;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostRequest_TC010 {

    @Test
    public void postRequest_bearertokenAuth(){

        String bearer_token="c2tfdGVzdF81MUl6Tm9XU0ZVZ3lJRjRCcVh5cm13aGtYNzJ5TkdXWWFqUlBGUnBpNmpKbnZhOGhoc2ZDSVJFT2VUV3pMczd0QzAzb25sSEg1OW1TRWdGemIyYVNFNFJwbDAwY1oyUVJ0Q0g=";

        RestAssured.baseURI="https://api.stripe.com/";

        RequestSpecification httpRequest=RestAssured.given().auth().preemptive().
                basic(ApiUtility.decodeString(bearer_token),"");

        httpRequest.contentType("application/x-www-form-urlencoded");
        httpRequest.accept(ContentType.JSON);

        httpRequest.queryParam("description","Test")
                .queryParam("name","Amit").queryParam("email","Amit@gmail.com")
                .post("/v1/customers")
                .then().statusCode(200).log().all();
    }
}

//method to work with nested json

//JSONObject jsonObject1=new JSONObject();
//jsonObject1.put("description","Test description");

//        jsonObject1.put("depositpaid",true);
//
//        JSONObject jsonObject2=new JSONObject();
//        jsonObject2.put("checkin","2019-01-01");
//        jsonObject2.put("checkout","2020-01-01");
//        jsonObject1.put("bookingdates",jsonObject2);
