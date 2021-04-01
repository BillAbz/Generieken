package be.intecbrussel.dumbstarbucks.v2.models;

import be.intecbrussel.dumbstarbucks.v2.services.ICoffee;

import java.math.BigDecimal;

public class DumbCoffee extends MenuItem implements ICoffee {

    private String parodicName;

    public DumbCoffee() {
    }

    public DumbCoffee(String name, BigDecimal price) {
        super(name, price);
    }

    public DumbCoffee(String name, BigDecimal price, Size size) {
        super(name, price, size);
    }

    public DumbCoffee(String name, BigDecimal price, Size size, String parodicName) {
        super(name, price, size);
        this.parodicName = parodicName;
    }

    public String getParodicName() {
        return parodicName;
    }

    public void setParodicName(String parodicName) {
        this.parodicName = parodicName;
    }

    public DumbCoffee withParodicName(String parodicName) {
        this.setParodicName(parodicName);
        return this;
    }

    @Override
    public void addExtraShot(Integer noOfShots) {

    }

    @Override
    public void addExtraCream() {

    }

    @Override
    public void drinkBaristasChoice() {

    }

    @Override
    public void drink(MenuItem item) {

    }

    @Override
    public void addExtraSugar(Integer noOfPacks) {

    }
}
