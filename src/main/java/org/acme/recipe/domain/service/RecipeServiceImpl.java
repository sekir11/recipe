/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.recipe.domain.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.acme.recipe.domain.mapper.RecipeEntityMapper;
import org.acme.recipe.domain.model.Recipe;
import org.acme.recipe.integration.entity.RecipeEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * {@link RecipeService} の実装クラス。
 */
@NoArgsConstructor
@ApplicationScoped
public class RecipeServiceImpl implements RecipeService {

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe getRecipe(Integer recipeId) {
    return null;
  }

  @Override
  @Transactional
  public Recipe createRecipe(Recipe recipe) {
    RecipeEntity recipeEntity = RecipeEntityMapper.toEntity(recipe);
    recipeEntity.persist();
    return RecipeEntityMapper.fromEntity(recipeEntity);
  }
}
