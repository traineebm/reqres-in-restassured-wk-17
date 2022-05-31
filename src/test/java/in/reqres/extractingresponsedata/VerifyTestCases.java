package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyTestCases {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        response = given()
                .queryParam("page", "2")
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    // 1) Verify page = 2
    @Test
    public void test001() {

       int page = response.extract().path("page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of page is : " + page);
        System.out.println("------------------End of Test---------------------------");
    }

    // 2) Verify per_page = 6
    @Test
    public void test002() {

        int per_page = response.extract().path("per_page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value per page is : " + per_page);
        System.out.println("------------------End of Test---------------------------");
    }

    // 3) Verify data[1].id = 8
    @Test
    public void test003() {

        int id = response.extract().path("data[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[1] is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Verify data[3].first_name = Byron
    @Test
    public void test004() {

        String firstName = response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[3].first_name : " + firstName);
        System.out.println("------------------End of Test---------------------------");
    }

    // 5) Verify list of data = 6
    @Test
    public void test005() {

        List<String> listOfData = response.extract().path("data.");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of the data is : " + listOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) to verify data[5].avatar
    @Test
    public void test006() {

        String avatar = response.extract().path("data[5].avatar");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of avatar data 5 is : " + avatar);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Verify - support.url :https://reqres.in/#support-heading
    @Test
    public void test007() {
        String url = response.extract().path("support.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("support of url : " + url);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Verify - support.txt  :To keep ReqRes free, contributions towards server costs are appreciated!
    @Test
    public void test008() {
        String text = response.extract().path("support.text");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("support of text : " + text);
        System.out.println("------------------End of Test---------------------------");
    }

}
