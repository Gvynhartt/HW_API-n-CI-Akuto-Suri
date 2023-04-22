import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class PostmanEchoTestNo1 {
    @Test
    void shouldPostGibberishAtSUTwithObj() {
        // Given - When - Then
        // �����������

        given()
                .baseUri("https://postman-echo.com")
                //.header("Content-Type", "application/json")
                .body("aboba") // ������������ ������ (��������� � query ����� ���������� ����������)
                .contentType(ContentType.JSON)
        // ����������� ��������
                .when()
                .post("/post")
        // ��������
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
