/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.recipe.domain.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.acme.recipe.domain.model.Recipe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * {@link RecipeService} の実装クラス。
 */
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
//@NoArgsConstructor
@ApplicationScoped
public class RecipeServiceImpl implements RecipeService {

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe getRecipe(Integer recipeId) {
    return null;
  }
}
