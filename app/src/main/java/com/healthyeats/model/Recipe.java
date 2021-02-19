package com.healthyeats.model;

import java.util.Comparator;

public class Recipe implements Comparable<Recipe> {
    private String id;
    private String name;
    private String source;
    private int prepTime;
    private int waitTime;
    private int cookTime;
    private int servings;
    private String comments;
    private int calories;
    private int fat;
    private int satFat;
    private int carbs;
    private int fiber;
    private int sugar;
    private int protein;
    private int difficultyLevel;
    private String instructions;
    private String[] ingredients;
    private String[] tags;

    //Empty Constructor
    public Recipe() {
    }

    //Getters and setters organized by variable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * get difficulty level gives user difficulty level of recipe.
     * 1 - Beginner
     * 2 - Intermediate
     * 3 - Hard
     * @return
     */
    public int getDifficultyLevel(){
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel){
        this.difficultyLevel = difficultyLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
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

}
