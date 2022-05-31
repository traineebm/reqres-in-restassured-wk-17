package in.reqres.usersinfo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;


public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        Response response = given()
                .queryParam("page", "2")
                .when()
                .get("/api");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo() {
        Response response = given()
                .pathParam("id",4)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchUserWithParameter() {
        Response response = given()
                .queryParam("page","2")
                .when()
                .get("/users/4");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
