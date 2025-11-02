package authentications;

import apiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest_TC010 {

    @Test (description = "Stripe Post Request with Bearer Token Authentication")
    public void postRequest_bearertokenAuth(){

        String bearer_token="c2tfdGVzdF81MUl6Tm9XU0ZVZ3lJRjRCcVh5cm13aGtYNzJ5TkdXWWFqUlBGUnBpNmpKbnZhOGhoc2ZDSVJFT2VUV3pMczd0QzAzb25sSEg1OW1TRWdGemIyYVNFNFJwbDAwY1oyUVJ0Q0g=";

        RestAssured.baseURI="https://api.stripe.com/";

        RestAssured.given().header("Authorization","Bearer "+ApiUtility.decodeString(bearer_token)).contentType(ContentType.JSON)
                .queryParam("description","Test")
                .queryParam("name","Amit").
                 queryParam("email","Amit@gmail.com")
                .post("/v1/customers")
                .then().body(Matchers.contains("Amit")).assertThat().statusCode(200).log().all();
    }

    @Test(description = "Handling Bearer Authorization with Post request and deleting it")
    public void getRequest_withBearerToken() {

        String bearer_token="YWE0ZDA4YjZiYWIyODUzYzNjZmIwZDNiODUzNThlMjNhZWU1NjNiZjZiYThhN2I0YWEwMjI0MjA3YjU0NWY2Yw==";
        //declaring base URI
        RestAssured.baseURI = "https://gorest.co.in";

        //request object
        Response response = RestAssured.given().header("Authorization","Bearer "+ApiUtility.decodeString(bearer_token))
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

        RestAssured.given().header("Authorization","Bearer "+ApiUtility.decodeString(bearer_token)).when()
                .delete("/public/v2/users/"+id)
                .then().assertThat().statusCode(204).log().all();


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
