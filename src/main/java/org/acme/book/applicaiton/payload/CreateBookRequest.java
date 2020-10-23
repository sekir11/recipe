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
public class CreateBookRequest {

  @JsonbProperty(value = "title")
  private String title;

  @JsonbProperty(value = "author")
  private String author;

  @JsonbProperty(value = "cost")
  private Integer cost;

  public Book toModel() {
    return Book.builder()
               .title(title)
               .author(author)
               .cost(cost)
               .build();
  }

  public Book toModel(Integer id) {
    return Book.builder()
               .id(id)
               .title(title)
               .author(author)
               .cost(cost)
               .build();
  }
}
