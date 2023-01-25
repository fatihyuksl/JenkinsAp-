package Get_Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class get {

    @Test
    public  void get01(){

        //Set the URL
        String url = "https://reqres.in/api/users/3";

        //Set The Expected Data

        //Send The Request and Get The Response
        Response response = given().when().get(url);
        response.prettyPrint();


        //Do Assertion

//        HTTP Status Code should be 200
//        Content Type should be JSON
//        Status Line should be HTTP/1.1 200 OK
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }
    @Test
    public void get02(){

        // Set The URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";



        // Set The Expected  Data (Put, Patch, Post)

        // Send the request and Get Response

        Response response = given().when().get(url);
        response.prettyPrint();

        // Do Assertion

        // 1. Yol ( Hard Assert)
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        // 2. Yol Sadece body içerisinde geçerli bir (Soft Assert)

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));


    }

}
