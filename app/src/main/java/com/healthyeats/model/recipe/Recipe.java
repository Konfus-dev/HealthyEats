package com.healthyeats.model.recipe;

import com.healthyeats.model.grocery.GroceryItem;

import java.util.Comparator;
import java.util.List;

public class Recipe implements Comparable<Recipe> {

    private int id;
    private String name;
    private String source;
    private String difficultyLevel;
    private int prepTime;
    private int waitTime;
    private int cookTime;
    private int servings;
    private int calories;
    private int fat;
    private int satFat;
    private int carbs;
    private int fiber;
    private int sugar;
    private int protein;
    private String comments;
    private String[] instructions;
    private Ingredient[] ingredients;
    private String[] tags;

    //Getters and setters organized by variable
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(String difficulty) {
        this.difficultyLevel = difficulty;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public int getPrepTime() {
        return prepTime;
    }
    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getWaitTime() {
        return waitTime;
    }
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getCookTime() {
        return cookTime;
    }
    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServings() {
        return servings;
    }
    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSatFat() {
        return satFat;
    }
    public void setSatFat(int satFat) {
        this.satFat = satFat;
    }

    public int getCarbs() {
        return carbs;
    }
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFiber() {
        return fiber;
    }
    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getProtein() {
        return protein;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }

    public String[] getInstructions() {
        return instructions;
    }
    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }
    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getTags() {
        return tags;
    }
    public void setTags(String[] tags) {
        this.tags = tags;
    }


    @Override
    public int compareTo(Recipe g){
        return this.name.compareTo(g.name);
    }

    //Comparator to sort array by item name alphabetically from A-Z
    public static final Comparator<Recipe> recipeAZComparator = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe recipe1, Recipe recipe2) {
            if (recipe1.getName().compareTo(recipe2.getName()) < 0) {
                return -1;
            }
            else if (recipe1.getName().compareTo(recipe2.getName()) > 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //ToDo:
    // Patch up exporting ingredients to the grocery list, make sure there are not duplicates,
    // if there are more than a certain amount increment else ignore and keep one
    // ex: no need to have 2x 1 cup of flower, just have flower
    public void exportToGroceryList(List<GroceryItem> list) {
        for (int i = 0; i < ingredients.length; i++) {
            list.add(ingredients[i].toGroceryItem());
        }
    }

    //Comparator to sort array by item name alphabetically from Z-A
    public static final Comparator<Recipe> recipeZAComparator = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe recipe1, Recipe recipe2) {
            if (recipe2.getName().compareTo(recipe1.getName()) < 0) {
                return -1;
            }
            else if (recipe2.getName().compareTo(recipe1.getName()) > 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //Sort by calories low to high
    public static final Comparator<Recipe> recipeLowHighCalComparator = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe recipe1, Recipe recipe2) {
            if (recipe1.getCalories() > recipe2.getCalories()) {
                return 1;
            }
            else if (recipe1.getCalories() < recipe2.getCalories()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //Sort by calories high to low
    public static final Comparator<Recipe> recipeHighLowCalComparator = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe recipe1, Recipe recipe2) {
            if (recipe2.getCalories() > recipe1.getCalories()) {
                return 1;
            }
            else if (recipe2.getCalories() < recipe1.getCalories()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    //For testing turns Recipe to string for printing
    public String toString() {
        String recipeString =
             "------------------------------\n" +
             id + "\n" +
             name + "\n" +
             source + "\n" +
             prepTime + "\n" +
             waitTime + "\n" +
             cookTime + "\n" +
             servings + "\n" +
             comments + "\n" +
             calories + "\n" +
             fat + "\n" +
             satFat + "\n" +
             carbs + "\n" +
             fiber + "\n" +
             sugar + "\n" +
             protein + "\n" +
             difficultyLevel + "\n" +
             instructions + "\n";

        for (Ingredient i : ingredients)
            recipeString += i.toString() + "\n";

        recipeString += tags + "------------------------------\n";

        return recipeString;
    }

}
