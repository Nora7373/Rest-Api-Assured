import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SingleUserTests extends TestBase {

    @Test
    void checkSingleUserExistTest() {
        given()
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2));
    }

    void checkSingleUserEmailTest() {
        given()
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.email", is("janet.weaver@reqres.in"));
    }

    @Test
    void checkSingleUserFullNameTest() {
        given()
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"));
    }
    @Test
    void checkSingleUserNotExistTest() {
        given()
                .when()
                .get("/users/9999999999")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }
}
