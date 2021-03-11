package com.healthyeats.model.account;
public class Account {
    private static Account single_instance = null;
    private String firstName;
    private String lastName;
    private String name;
    private String location;
    private String units;
    private String currency;
    private String notifications;
    private String language;
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
     * @param name the user's name
     * @param location the user's location
     * @param units the desired units (metric/imperial)
     * @param currency the desired currency (dollar/pound/euro)
     * @param wBudget the user's weekly budget
     * @param people the number of people in the user's household
     */

    private Account(String name, String location, String units, String currency, String notification, String language, int wBudget, int people) {
        this.name = name;
        this.location = location;
        this.units = units;
        this.currency = currency;
        this.notifications = notification;
        this.language = language;
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

    public String getName() { return name; }

    public String getUnits() {
        return units;
    }

    public String getCurrency() {
        return currency;
    }

    public String getNotifications() { return notifications; }

    public String getLanguage() { return language; }

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

    public void setName(String name) { this.name = name; }

    public void setLocation(String location) { this.location = location; }

    public void setUnits(String units) {
        if(units.equals("imperial")|| units.equals("metric")|| units.equals("Imperial")||units.equals("Metric")) {
            this.units = units;
        }
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setWeeklyBudget(int wBudget) {
        this.weeklyBudget = wBudget;
    }

    public void setHouseholdSize(int people) {
       this.householdSize = people;
    }
}
