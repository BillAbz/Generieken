package be.intecbrussel.dumbstarbucks.v1.services;

public interface ICoffee extends IDrinkable {

    void addExtraShot(Integer noOfShots);

    void addExtraCream();

}
