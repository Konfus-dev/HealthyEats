package com.healthyeats.model.budget;

import com.healthyeats.model.recipe.Recipe;

import java.util.LinkedList;
import java.util.List;

public class Budget {
    private static Budget single_instance = null;
    private LinkedList<WeeklyBudget> budgetOverTime;

    /**
     * Make this class singleton
     * @return the instance of the budget
     */
    public static Budget getInstance() {
        if (single_instance == null) {
            single_instance = new Budget();
        }
        return single_instance;
    }

    /**
     * Creates the budget and puts in 10 fake entries
     */
//    private Budget() {
//        budgetOverTime = new LinkedList<WeeklyBudget>();
//        //temp values
//        for(int i = 0; i < 10; i++){
//            budgetOverTime.addFirst(
//                    new WeeklyBudget(i > 4 ? 55: 50,
//                            Math.round(((Math.random() * (60 - 40)) + 40)*100.0)/100.0));
//        }
//    }

    public int getAdditionOfRecipes(List<Recipe> week) {
        int total = 0;

        for (int i = 0; i < week.size(); i++) {
//            total += week.get(i).get
        }
    }

    /**
     * Adds a week worth of budgeting, put at the start of the list
     * @param budget the budget for that week
     * @param weekSpending how much was actually spend
     */
    public void addWeek(double budget, double weekSpending){
        budgetOverTime.addFirst(new WeeklyBudget(budget, weekSpending));
    }

    /**
     * get the set budget at index i
     * Note: weeks are calculated based on distance from current week.
     * Current week = 0.
     * @param i weeks from the current week
     * @return the set budget
     */
    public double getBudgetAtIndex(int i){
        return budgetOverTime.get(i).setBudget;
    }

    /**
     * get the weekly spending at index i
     * Note: weeks are calculated based on distance from current week.
     * Current week = 0.
     * @param i weeks from the current week
     * @return the spending
     */
    public double getWeekSpendingAtIndex(int i){
        return budgetOverTime.get(i).weekSpending;
    }

    /**
     * Class to store the budget and the spending
     */
    class WeeklyBudget{
        double setBudget;
        double weekSpending;
        protected WeeklyBudget(double setBudget, double weekSpending){
            this.setBudget = setBudget;
            this.weekSpending = weekSpending;
        }
        protected double getSetBudget(){
            return setBudget;
        }
        protected double getWeekSpending(){
            return weekSpending;
        }
    }

}
