package be.intecbrussel.dumbstarbucks.v2.models;

import be.intecbrussel.dumbstarbucks.v2.services.IAppetizer;

import java.math.BigDecimal;

public class DumbSandwich extends MenuItem implements IAppetizer {

    private Double calories;

    public DumbSandwich(String name, BigDecimal price) {
        super(name, price);
    }

    public DumbSandwich(String name, BigDecimal price, Size size) {
        super(name, price, size);
    }

    public DumbSandwich() {
    }

    public DumbSandwich(String name, BigDecimal price, Size size, Double calories) {
        super(name, price, size);
        this.calories = calories;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public DumbSandwich withCalories(Double calories) {
        this.setCalories(calories);
        return this;
    }

    @Override
    public void addSauce(MenuItem... sauces) {

    }

    @Override
    public void eatBaristasChoice() {

    }

    @Override
    public void eat(MenuItem item) {

    }
}
