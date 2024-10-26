package RandomUser;


import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestCases {
    @Test
    public void getrandomuser(){
        given().baseUri("https://randomuser.me/")
                .when().get("https://randomuser.me/api/")
                .then().log().all()
                .assertThat().statusCode(200)
                .time(lessThan(3000L))
                .body("results.size()", equalTo(1));



    }


    @Test
    public void getrandomfiveusers(){
        given().baseUri("https://randomuser.me/")
                .param("results", 5)
                .when().get("https://randomuser.me/api?results=5")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("results.size()", is(5));
    }


    @Test

    public void getrandomuserbygender(){
        given().baseUri("https://randomuser.me/")
                .param("gender", "male")
                .when().get("https://randomuser.me/api?gender=male")
                .then().log().all()
                .assertThat().statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("results", notNullValue())
                .body("info", notNullValue())
                .body("results[0].gender", equalTo("male"));

    }

    @Test
  public void createnewuser(){
        HashMap<String, Object> boody = new HashMap<>();
        boody.put("name", "Jane Smith");
        boody.put("username", "janesmith");
        boody.put("email", "jane.smith@example.com");
        boody.put("phone", "987-654-3210");
        boody.put("website", "http://janesmith.com");

        HashMap<String, Object> addressMap = new HashMap<>();
        addressMap.put("street", "456 Elm St");
        addressMap.put("city", "Los Angeles");
        addressMap.put("zipcode", "90001");
        boody.put("address", addressMap);

        HashMap<String, Object> Company = new HashMap<>();
        Company.put("name", "Smith Solutions");
        boody.put("company", Company);

        given().baseUri("https://jsonplaceholder.typicode.com/users")
                .body(boody)
                .header("Content-Type" , "application/json")
                .when().post()
                .then().log().all()
                .assertThat().statusCode(201)
                .body("name", notNullValue())
                .body("username", notNullValue())
                .body("email", notNullValue())
                .body("address", notNullValue())
                .body("phone", notNullValue())
                .body("website", notNullValue())
                .body("company", notNullValue())
                .body("id", notNullValue())
                .body("name", equalTo("Jane Smith"))
                .body("username", equalTo("janesmith"))
                .body("email", equalTo("jane.smith@example.com"))
                .body("phone", equalTo("987-654-3210"))
                .body("website", equalTo("http://janesmith.com"))
                .body("id", equalTo(11));





    }

    @Test
    public void deleteuser(){


        given().baseUri("https://jsonplaceholder.typicode.com")
                .when().delete("/users/1")
                .then().log().all()
                .assertThat().statusCode(200);


    }

@Test
    public void updateuserdata(){


    HashMap<String, Object> boody = new HashMap<>();
    boody.put("name", "Alice Johnson Updated");
    boody.put("username", "alice.johnson.updated");
    boody.put("email", "alice.johnson.updated@example.com");
    boody.put("phone", "555-123-4567 Updated");
    boody.put("website", "http://alicejohnsonupdated.com");

    HashMap<String, Object> address = new HashMap<>();
    address.put("street", "789 Oak St Updated");
    address.put("city", "Chicago Updated");
    address.put("zipcode", "60601");
    boody.put("address", address);

    HashMap<String, Object> Company = new HashMap<>();
    Company.put("name", "Johnson Innovations Updated");
    boody.put("company", Company);

    given().baseUri("https://jsonplaceholder.typicode.com")
            .body(boody)
            .header("Content-Type" , "application/json")
            .when().put("/users/8")
            .then().log().all()
            .assertThat().statusCode(200);
}


@Test
    public void updatesomeofuserdata(){
    HashMap<String, Object> boody = new HashMap<>();
    boody.put("name", "Nada Ahmed");
    boody.put("username", "nada");
    boody.put("email", "nada@gmail.com");
    boody.put("phone", "111-222-9999");

    given().baseUri("https://jsonplaceholder.typicode.com")
            .body(boody)
            .header("Content-Type" , "application/json")
            .when().patch("/users/11")
            .then().log().all()
            .assertThat().statusCode(200)
            .body("email", notNullValue())
            .body("phone", notNullValue())
            .body("email", equalTo("nada@gmail.com"));



}

}
