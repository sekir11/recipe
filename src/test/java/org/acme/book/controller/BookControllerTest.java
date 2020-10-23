package org.acme.book.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.book.applicaiton.payload.CreateBookRequest;
import org.acme.book.domain.model.Book;
import org.acme.book.domain.service.BookService;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.acme.book.common.Utils.marshalToJson;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@QuarkusTest
class BookControllerTest {

  @InjectMock
  BookService bookService;

  @Test
  void test_指定したidで書籍を取得できる() {

    when(bookService.getBook(1)).thenReturn(Book.builder()
                                                .id(1)
                                                .title("チキンカレー")
                                                .author("著者1")
                                                .cost(1000)
                                                .build());

      given()
        .when()
          .pathParam("id", "1")
          .get("/books/{id}")
        .then()
           .statusCode(200)
           .body("id", equalTo(1))
           .body("title", equalTo("チキンカレー"))
           .body("author", equalTo("著者1"))
           .body("cost", equalTo(1000));

      verify(bookService).getBook(1);
  }

  @Test
  void test_POSTでリクエストして書籍が登録できる事() {

    when(bookService.createBook(Book.builder()
                                    .title("チキンカレー")
                                    .author("著者1")
                                    .cost(450)
                                    .build()))
        .thenReturn(Book.builder()
                        .id(1)
                        .title("チキンカレー")
                        .author("著者1")
                        .cost(450)
                        .build());


    given()
        .when()
        .contentType("application/json")
        .body(marshalToJson(CreateBookRequest.builder()
                                             .title("チキンカレー")
                                             .author("著者1")
                                             .cost(450)
                                             .build()))
        .post("/books")
        .then()
        .statusCode(200)
        .body("message", equalTo("Book successfully created!"))
        .body("title", equalTo("チキンカレー"))
        .body("author", equalTo("著者1"))
        .body("cost", equalTo(450));
  }

}