/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.recipe.applicaiton.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.recipe.domain.model.Recipe;

import javax.json.bind.annotation.JsonbProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponse {

  @JsonbProperty(value = "id")
  private Integer id;

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

  public static RecipeResponse of(Recipe recipe) {
    return RecipeResponse.builder()
                         .id(recipe.getId())
                         .title(recipe.getTitle())
                         .makingTime(recipe.getMakingTime())
                         .serves(recipe.getServes())
                         .ingredients(recipe.getIngredients())
                         .cost(recipe.getCost())
                         .build();
  }
}
