package complex_payload;

import complex_payload.pojoclassesforcomplexPayload.POJOMain;
import complex_payload.pojoclassesforcomplexPayload.POJOMobile;
import complex_payload.pojoclassesforcomplexPayload.POJOSubject;
import complex_payload.pojoclassesforcomplexPayload.POJOUsers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class complexpayload4 {

    POJOMain mainPojo=new POJOMain(
      new POJOUsers("Ramesh","Singh",3,3),
      new POJOMobile(98073424,3),
      new POJOSubject(3,"Dev")
    );

    @Test
    public void complexPayload_POJOClass(){

        baseURI="http://localhost:3000";

        Response response=given().contentType(ContentType.JSON).body(mainPojo).post(baseURI+"/users");
        response.prettyPrint();


    }

}
