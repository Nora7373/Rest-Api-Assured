import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateUserTests extends TestBase {
    @Test
    void checkCreateUserSuccessfulTest() {
        String createUserData = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        given()
                .body(createUserData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .body("createdAt", notNullValue());

    }

    @Test
    void checkCreateNewUserSuccessfulTest() {
        String createUserData = "{\"name\": \"ivan\",\"job\": \"leader\"}";

        given()
                .body(createUserData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("ivan"))
                .body("job", is("leader"))
                .body("createdAt", notNullValue());

    }

    @Test
    void checkCreateEmtyUserDataTest() {
        String createUserData = "{}";

        given()
                .body(createUserData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201);
    }
}
