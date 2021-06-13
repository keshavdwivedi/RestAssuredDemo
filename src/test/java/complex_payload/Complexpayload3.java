package complex_payload;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Complexpayload3 {

    @Test
    public void complexPayload_JsonAPI(){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstname", "Jim");
        jsonObject.put("lastname", "Brown");
        jsonObject.put("totalprice", 111);
        jsonObject.put("depositpaid", true);

        JSONObject bookingjson=new JSONObject();
        bookingjson.put("checkin", "2021-07-01");
        bookingjson.put("checkout", "2021-07-01");

        jsonObject.put("bookingdates",bookingjson);
        jsonObject.put("additionalneeds","Breakfast");

        given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .post()
                .prettyPrint();

    }

}
