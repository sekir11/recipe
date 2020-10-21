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
public class CreateBookResponse {

  @JsonbProperty(value = "message")
  private String message;

  @JsonbProperty(value = "title")
  private String title;

  @JsonbProperty(value = "making_time")
  private String makingTime;

  @JsonbProperty(value = "serves")
  private String serves;

  @JsonbProperty(value = "ingredients")
  private String ingredients;

  @JsonbProperty(value = "cost")
  private Integer cost;


  public static CreateBookResponse of(Book book) {
    return CreateBookResponse.builder()
                             .message("Book successfully created!")
                             .title(book.getTitle())
                             .makingTime(book.getMakingTime())
                             .serves(book.getServes())
                             .ingredients(book.getIngredients())
                             .cost(book.getCost())
                             .build();
  }
}