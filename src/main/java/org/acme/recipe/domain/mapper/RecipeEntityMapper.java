/*
 * (c)Copyright Since 2019, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.recipe.domain.mapper;

import org.acme.recipe.domain.model.Recipe;
import org.acme.recipe.integration.entity.RecipeEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * レシピのドメインモデルとエンティティを相互に変換を行うマッパー。
 */
public final class RecipeEntityMapper {

  private static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

  private RecipeEntityMapper() {
    // Do Nothing.
  }

  public static RecipeEntity toEntity(Recipe recipe) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT);
//    return RecipeEntity.builder()
//                       .cost(recipe.getCost())
//                       .title(recipe.getTitle())
//                       .serves(recipe.getServes())
//                       .ingredients(recipe.getIngredients())
//                       .makingTime(recipe.getMakingTime())
//                       .createdAt(Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter)))
//                       .updatedAt(Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter)))
//                       .build();

    RecipeEntity recipeEntity = new RecipeEntity();
    recipeEntity.cost = recipe.getCost();
    recipeEntity.title = recipe.getTitle();
    recipeEntity.serves = recipe.getServes();
    recipeEntity.ingredients = recipe.getIngredients();
    recipeEntity.makingTime = recipe.getMakingTime();
    recipeEntity.createdAt = Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter));
    recipeEntity.updatedAt = Timestamp.valueOf(LocalDateTime.now().format(dateTimeFormatter));

    return recipeEntity;
  }

  public static Recipe fromEntity(RecipeEntity recipeEntity) {

    return Recipe.builder()
                 .id(recipeEntity.getId())
                 .title(recipeEntity.getTitle())
                 .makingTime(recipeEntity.getMakingTime())
                 .serves(recipeEntity.getServes())
                 .ingredients(recipeEntity.getIngredients())
                 .cost(recipeEntity.getCost())
                 .build();
  }

}
