package com.example.recipe;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;

import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

         int uniqueRecipeId = 6;
    public ArrayList<Recipe> getrecipes() {
        Collections<Recipe> recipeCollection = recipeBook.values();
        ArrayList<Recipe> allrecipes = new ArrayList<>(recipeCollection);
        return allrecipes;
    }

    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = recipeBook.get(recipeId);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe;
    }
    public Recipe addRecipe(Recipe recipe) {
        recipe.setRecipeId(uniqueRecipeId);
        recipeBook.put(uniqueRecipeId, recipe);
        uniqueRecipeId += 1;
        return recipe;
    }
    public Recipe updateRecipe(int recipeId, Recipe recipe) {
        Recipe existingRecipe = recipeBook.get(recipeId);
        if (existingRecipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (recipe.getRecipeName() != null) {
            existingRecipe.setRecipeName(recipe.getRecipeName());
        }
        if (recipe.getRecipeType() != null) {
            existingRecipe.setRecipeType(recipe.getRecipeType());
        }
        if (recipe.getIngredients() != null) {
            existingRecipe.setIngredients(recipe.getIngredients());
        }
        return existingRecipe;
    }
    public void deleteRecipe(int recipeId) {
        Recipe recipe = recipeBook.get(recipeId);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            recipeBook.remove(recipeId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

