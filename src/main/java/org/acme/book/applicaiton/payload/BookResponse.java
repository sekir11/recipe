/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.applicaiton.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.book.domain.model.Book;

import javax.json.bind.annotation.JsonbProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

  @JsonbProperty(value = "id")
  private Integer id;

  @JsonbProperty(value = "title")
  private String title;

  @JsonbProperty(value = "author")
  private String author;

  @JsonbProperty(value = "cost")
  private Integer cost;

  public static BookResponse of(Book book) {
    return BookResponse.builder()
                       .id(book.getId())
                       .title(book.getTitle())
                       .author(book.getAuthor())
                       .cost(book.getCost())
                       .build();
  }
}
