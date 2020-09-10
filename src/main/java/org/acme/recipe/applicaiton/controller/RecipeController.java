package org.acme.recipe.applicaiton.controller;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.acme.recipe.applicaiton.payload.RecipeResponse;
import org.acme.recipe.domain.model.Recipe;
import org.acme.recipe.domain.service.RecipeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
   *
   *
   * @param recipeId
   * @return
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public RecipeResponse getRecipe(@PathParam("id") String recipeId) {
    System.out.println("111111111111111111111");
    Recipe recipe = recipeService.getRecipe(1);
    return RecipeResponse.of(recipe);
  }
}