package be.intecbrussel.dumbstarbucks.v1.services;

import be.intecbrussel.dumbstarbucks.v1.models.MenuItem;

public interface IDrinkable {

    void drinkBaristasChoice();

    void drink(MenuItem item);

    void addExtraSugar(Integer noOfPacks);

}
