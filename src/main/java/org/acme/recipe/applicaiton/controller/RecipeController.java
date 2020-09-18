package org.acme.recipe.applicaiton.controller;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.acme.recipe.applicaiton.payload.CreateRecipeRequest;
import org.acme.recipe.applicaiton.payload.CreateRecipeResponse;
import org.acme.recipe.applicaiton.payload.RecipeResponse;
import org.acme.recipe.domain.model.Recipe;
import org.acme.recipe.domain.service.RecipeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@NoArgsConstructor
@ApplicationScoped
@Path("/recipe")
public class RecipeController {

  @NonNull
  private RecipeService recipeService;

  /**
   * 指定した id のレシピを取得するためのエンドポイントです!
   *
   * @param recipeId 取得したいレシピの id
   * @return 取得したレシピ
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public RecipeResponse getRecipe(@PathParam("id") String recipeId) {
    Recipe recipe = recipeService.getRecipe(1);
    return RecipeResponse.of(recipe);
  }

  /**
   * 指定したレシピを登録するためのエンドポイントです
   *
   * @param request 登録したいレシピのリクエスト
   * @return 登録したレシピ
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public CreateRecipeResponse getRecipe(CreateRecipeRequest request) {
    Recipe recipe = recipeService.createRecipe(request.toModel());
    return CreateRecipeResponse.of(recipe);
  }
}