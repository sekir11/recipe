package org.acme.book.domain.service;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.book.domain.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;


import static com.ninja_squad.dbsetup.Operations.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BookServiceImpl に対するテスト")
@QuarkusTest
class BookServiceImplTest {

  @Inject
  BookServiceImpl target;

  public static final Operation DELETE_BOOKS = deleteAllFrom("books");
  public static final Operation INSERT_BOOKS
      = insertInto("book").columns("id",
                                            "title",
                                            "making_time",
                                            "serves",
                                            "ingredients",
                                            "cost",
                                            "created_at",
                                            "updated_at")
                                    .values(1,
                                            "チキンカレー",
                                            "45分",
                                            "4人",
                                            "玉ねぎ,肉,スパイス",
                                            1000,
                                            "2016-01-10 12:10:12",
                                            "2016-01-10 12:10:12")
                                    .values(2,
                                            "オムライス",
                                            "30分",
                                            "2人",
                                            "玉ねぎ,卵,スパイス,醤油",
                                            700,
                                            "2016-01-11 13:10:12",
                                            "2016-01-11 13:10:12")
                                    .build();


  @BeforeEach
  void setUp() {
    Operation operation = sequenceOf(DELETE_BOOKS, INSERT_BOOKS);
    DbSetup dbSetup = new DbSetup(new DriverManagerDestination("jdbc:h2:mem:test;MODE=MSSQLServer;DB_CLOSE_DELAY=-1", "sa", "sa"), operation);
    dbSetup.launch();
  }

  @Test
  void test_指定したidのレシピを正常に取得できる() {
    Book actual = target.getBook(1);
    Book expected = Book.builder()
                        .id(1)
                        .title("チキンカレー")
                        .makingTime("45分")
                        .serves("4人")
                        .ingredients("玉ねぎ,肉,スパイス")
                        .cost(1000)
                        .build();

    assertEquals(actual, expected);
  }

  @Test
  void test_指定したレシピを正常に登録できる事() {

    Book actual = target.createBook(Book.builder()
                                        .title("チキンカレー")
                                        .makingTime("45分")
                                        .serves("5人")
                                        .ingredients("玉ねぎ,肉,スパイス")
                                        .cost(450)
                                        .build());
    Book expected = Book.builder()
                        .id(3)
                        .title("チキンカレー")
                        .makingTime("45分")
                        .serves("5人")
                        .ingredients("玉ねぎ,肉,スパイス")
                        .cost(450)
                        .build();

    assertEquals(expected, actual);
  }


}