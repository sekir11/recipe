/*
 * (c)Copyright Since 2019, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.domain.mapper;

import org.acme.book.domain.model.Book;
import org.acme.book.integration.entity.BookEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 本のドメインモデルとエンティティを相互に変換を行うマッパー。
 */
public final class BookEntityMapper {

  private static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

  private BookEntityMapper() {
    // Do Nothing.
  }

  public static BookEntity toEntity(Book book) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT);

    BookEntity bookEntity = new BookEntity();
    bookEntity.setId(book.getId());
    bookEntity.setCost(book.getCost());
    bookEntity.setTitle(book.getTitle());
    bookEntity.setAuthor(book.getAuthor());
    bookEntity.setCreatedAt(Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter)));
    bookEntity.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter)));

    return bookEntity;
  }

  public static Book fromEntity(BookEntity bookEntity) {

    return Book.builder()
               .id(bookEntity.getId())
               .title(bookEntity.getTitle())
               .author(bookEntity.getAuthor())
               .cost(bookEntity.getCost())
               .build();
  }

}
