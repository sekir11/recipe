/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.recipe.domain.service;

import org.acme.recipe.domain.model.Recipe;

/**
 * レシピに関するサービスのインターフェース。
 */
public interface RecipeService {

  /**
   * 指定した id のレシピを取得します。
   *
   * @param recipeId 取得したいレシピ id
   * @return 取得したレシピ
   */
  Recipe getRecipe(Integer recipeId);
}
