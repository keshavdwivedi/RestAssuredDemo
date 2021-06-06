package PostRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequest_TC011 {

    @Test
    public void postRequest_nestedJsonRequestPayload(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com";

        RequestSpecification httpRequest=RestAssured.given();

        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("firstname","John");
        jsonObject1.put("lastname","Brown");
        jsonObject1.put("totalprice",190);
        jsonObject1.put("depositpaid",true);

        JSONObject jsonObject2=new JSONObject();
        jsonObject2.put("checkin","2019-01-01");
        jsonObject2.put("checkout","2020-01-01");
        jsonObject1.put("bookingdates",jsonObject2);

        jsonObject1.put("additionalneeds","Breakfast");

        httpRequest.contentType(ContentType.JSON);
        httpRequest.accept(ContentType.JSON);

        httpRequest.body(jsonObject1.toJSONString());

        Response response=httpRequest.request(Method.POST,"/booking");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

    }

}
