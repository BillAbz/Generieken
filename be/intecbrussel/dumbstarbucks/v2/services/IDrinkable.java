package be.intecbrussel.dumbstarbucks.v2.services;

import be.intecbrussel.dumbstarbucks.v2.models.MenuItem;

public interface IDrinkable {

    void drinkBaristasChoice();

    void drink(MenuItem item);

    void addExtraSugar(Integer noOfPacks);

}
