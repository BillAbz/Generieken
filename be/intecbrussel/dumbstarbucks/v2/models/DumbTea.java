package be.intecbrussel.dumbstarbucks.v2.models;

import be.intecbrussel.dumbstarbucks.v2.services.ITea;

import java.math.BigDecimal;

public class DumbTea extends MenuItem implements ITea {

    private String ancientName;


    public DumbTea() {
    }

    public DumbTea(String name, BigDecimal price, String ancientName) {
        super(name, price);
        this.ancientName = ancientName;
    }

    public DumbTea(String name, BigDecimal price, Size size, String ancientName) {
        super(name, price, size);
        this.ancientName = ancientName;
    }

    public String getAncientName() {
        return ancientName;
    }

    public void setAncientName(String ancientName) {
        this.ancientName = ancientName;
    }

    public DumbTea withAncientName(String ancientName) {
        this.setAncientName(ancientName);
        return this;
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

    @Override
    public void addHoney(Integer noOfPacks) {

    }
}
