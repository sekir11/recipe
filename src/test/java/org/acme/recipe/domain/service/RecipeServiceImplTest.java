package org.acme.recipe.domain.service;

import io.quarkus.test.Mock;
import org.acme.recipe.domain.model.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

//import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RecipeServiceImpl に対するテスト")
class RecipeServiceImplTest {

  @InjectMocks
  RecipeService target;

  @Test
  void test_指定したidのレシピを正常に取得できる() {
    Recipe actual = target.getRecipe(1);
    Recipe expected = Recipe.builder()
                            .id(1)
                            .title("チキンカレー")
                            .makingTime("45分")
                            .serves("4人")
                            .ingredients("玉ねぎ,肉,スパイス")
                            .cost(1000)
                            .build();

//    assertThat(actual);
  }
}