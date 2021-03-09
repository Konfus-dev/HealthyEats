package com.healthyeats.model.account;
public class Account {
    private static Account single_instance = null;
    private String firstName;
    private String lastName;
    private String units;
    private String currency;
    private int weeklyBudget;
    private int householdSize;


    /**
     * Get single instance of our Account, or if one doesn't exist, create one
     */

    public static Account getInstance() {
        if (single_instance == null) {
            single_instance = new Account();
        }
        return single_instance;
    }

    /**
     * Basic constructor for an Account
     */
    private Account() {}

    /**
     * Constructor for an Account
     * @param fName the user's first name
     * @param lName the user's last name
     * @param units the desired units (metric/imperial)
     * @param currency the desired currency (dollar/pound/euro)
     * @param wBudget the user's weekly budget
     * @param people the number of people in the user's household
     */

    private Account(String fName, String lName, String units, String currency, int wBudget, int people) {
        this.firstName = fName;
        this.lastName = lName;
        this.units = units;
        this.currency = currency;
        this.weeklyBudget = wBudget;
        this.householdSize = people;
    }

    /**
     * Getters
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUnits() {
        return units;
    }

    public String getCurrency() {
        return currency;
    }

    public int getWeeklyBudget() {
        return weeklyBudget;
    }

    public int getHouseholdSize() {
        return householdSize;
    }

    /**
     * Setters
     */
    public void etFirstName(String fName) {
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public void setUnits(String units) {
        if(units.equals("imperial")|| units.equals("metric")|| units.equals("Imperial")||units.equals("Metric")){
            this.units = units;
        }
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setWeeklyBudget(int wBudget) {
        this.weeklyBudget = wBudget;
    }

    public void setHouseholdSize(int people) {
       this.householdSize = people;
    }


}
