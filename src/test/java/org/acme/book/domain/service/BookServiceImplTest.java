package org.acme.book.domain.service;

import org.acme.book.domain.model.Book;
import org.acme.book.domain.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("BookServiceImpl に対するテスト")
class BookServiceImplTest {

  @InjectMocks
  BookServiceImpl target;

  @Mock
  BookRepository bookRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void test_指定したidの書籍を正常に取得できる() {
    when(bookRepository.getById(1)).thenReturn(Book.builder()
                                                          .id(1)
                                                          .title("チキンカレー")
                                                          .author("著者1")
                                                          .cost(1000)
                                                          .build());
    Book actual = target.getBook(1);
    Book expected = Book.builder()
                        .id(1)
                        .title("チキンカレー")
                        .author("著者1")
                        .cost(1000)
                        .build();

    assertEquals(actual, expected);
  }




  @Test
  void test_指定した書籍を正常に登録できる事() {
    when(bookRepository.createBook(Book.builder()
                                       .title("チキンカレー")
                                       .author("著者1")
                                       .cost(450)
                                       .build())).thenReturn(Book.builder()
                                                                 .title("チキンカレー")
                                                                 .author("著者1")
                                                                 .cost(450)
                                                                 .build());

    Book actual = target.createBook(Book.builder()
                                        .title("チキンカレー")
                                        .author("著者1")
                                        .cost(450)
                                        .build());
    Book expected = Book.builder()
                        .title("チキンカレー")
                        .author("著者1")
                        .cost(450)
                        .build();

    assertEquals(expected, actual);
  }


}