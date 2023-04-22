import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasValue;

class PostmanEchoTestNo1 {
    @Test
    void shouldPostGibberishAtSUTwithObj() {
        // Given - When - Then
        // Предусловия

        given()
                .baseUri("https://postman-echo.com")
                //.header("Content-Type", "application/json")
                .body("aboba") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .contentType(ContentType.JSON)
        // Выполняемые действия
                .when()
                .post("/post")
        // Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", hasValue("aboba"));
    }
}
