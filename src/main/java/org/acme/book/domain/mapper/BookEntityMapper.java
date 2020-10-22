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

import static java.util.Objects.isNull;

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
    bookEntity.id = book.getId();
    bookEntity.cost = book.getCost();
    bookEntity.title = book.getTitle();
    bookEntity.serves = book.getServes();
    bookEntity.ingredients = book.getIngredients();
    bookEntity.makingTime = book.getMakingTime();
    bookEntity.createdAt = Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter));
    bookEntity.updatedAt = Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter));

    return bookEntity;
  }

  public static Book fromEntity(BookEntity bookEntity) {

    return Book.builder()
               .id(bookEntity.getId())
               .title(bookEntity.getTitle())
               .makingTime(bookEntity.getMakingTime())
               .serves(bookEntity.getServes())
               .ingredients(bookEntity.getIngredients())
               .cost(bookEntity.getCost())
               .build();
  }

}
