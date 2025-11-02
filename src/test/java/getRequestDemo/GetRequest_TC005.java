package getRequestDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetRequest_TC005 {

    @Test
    public void getRequest_extractvalue_eachnode_jsonpath(){

        //request URI
        RestAssured.baseURI="https://api.restful-api.dev";


        Response response=RestAssured.given().when().get(RestAssured.baseURI+"/objects");

        //print the response
        response.prettyPrint();

       JsonPath jsonPath=response.jsonPath();
       List<String>listName=jsonPath.getList("name");
       for (String name:listName){

           System.out.println("Mobile names are:-  "+name);
           assertThat(listName.contains("Apple AirPods"),is(true));
           assertThat(listName.contains("Apple iPhone 11, 64GB"),is(true));
           assertThat(listName.size(),is(13));
       }


         List<String>colorList=jsonPath.getList("data.color");
            for (String color:colorList){
                System.out.println("Colors are:-  "+color);
                assertThat(colorList.contains("Cloudy White"),is(true));
                assertThat(colorList.size(),is(12));
            }

        List<String>Price=jsonPath.getList("data.Price");
        for (String price:Price){
            System.out.println("Prices are:-  "+price);
            assertThat(Price.contains("519.99"),is(true));
            assertThat(Price.size(),is(12));
        }
    }
}


/*1. using map


     JsonPath jsonPath=response.jsonPath();
              Map<String, String> map=jsonPath.getMap("available[0]");
              Assert.assertEquals(map.get("amount"),0);

     2. using getbody

      JsonPath path=new JsonPath(response.asString());
      path=response.getBody().jsonPath();
      String loginToken=path.get("data.token");
      System.out.println("The login token of logged in user is:-  "+loginToken);

      3. direct from response

      Jsonpath path=response.jsonpath();
      String firstname=path.get("data.firstname");
      System.out.println("The login token of logged in user is:-  "+loginToken);*/