package com.healthyeats.model.budget;

import java.util.LinkedList;

public class Budget {
    private static Budget single_instance = null;
    private LinkedList<WeeklyBudget> budgetOverTime;
    public static Budget getInstance() {
        if (single_instance == null) {
            single_instance = new Budget();
        }
        return single_instance;
    }

    private Budget() {
        budgetOverTime.addFirst(new WeeklyBudget(50.00, 49.23));
        //temp values
        for(int i = 0; i < 10; i++){
            budgetOverTime.addFirst(
                    new WeeklyBudget(i > 4 ? 55: 50,
                            Math.round(((Math.random() * (60 - 40)) + 40)*100.0)/100.0));
        }
    }

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
    public double getWeekSpendingAtIndex(int i){
        return budgetOverTime.get(i).weekSpending;
    }

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
