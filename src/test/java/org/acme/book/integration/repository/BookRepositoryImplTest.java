/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.integration.repository;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.book.domain.model.Book;
import org.acme.book.domain.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class BookRepositoryImplTest {

  @Inject
  BookRepository target;

  public static final Operation DELETE_BOOKS = deleteAllFrom("books");
  public static final Operation INSERT_BOOKS
      = insertInto("books").columns("id",
                                          "title",
                                          "author",
                                          "cost",
                                          "created_at",
                                          "updated_at")
                           .values(1,
                               "チキンカレー",
                               "著者1",
                               1000,
                               "2016-01-10 12:10:12",
                               "2016-01-10 12:10:12")
                           .values(2,
                               "オムライス",
                               "著者2",
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
  void 指定したidの書籍を取得できる() {
    Book actual = target.getById(1);
    Book expected = Book.builder()
                        .id(1)
                        .title("チキンカレー")
                        .author("著者1")
                        .cost(1000)
                        .build();

    assertEquals(actual, expected);
  }


}
