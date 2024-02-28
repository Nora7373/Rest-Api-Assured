import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationTests extends TestBase {
    @Test
    void checkRegistrationSuccessfulTest() {
        String registrationData = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}";

        given()
                .body(registrationData)
                .contentType(JSON)
                .log().uri()
            .when()
                .post("/register")
            .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", notNullValue())
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void checkRegistrationEmptyEmailTest() {
        String registrationData = "{\"email\": \"\",\"password\": \"pistol\"}";

        given()
                .body(registrationData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }

    @Test
    void checkRegistrationEmptyPasswordTest() {
        String registrationData = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"\"}";

        given()
                .body(registrationData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

    @Test
    void checkRegistrationEmptyEmailAndPasswordTest() {
        String registrationData = "{\"email\": \"\",\"password\": \"\"}";

        given()
                .body(registrationData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }

    @Test
    void checkRegistrationEmptyDataTest() {
        String registrationData = "{}";

        given()
                .body(registrationData)
                .contentType(JSON)
                .log().uri()
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }
}
