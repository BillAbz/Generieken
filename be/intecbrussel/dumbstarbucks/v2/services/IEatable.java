package be.intecbrussel.dumbstarbucks.v2.services;

import be.intecbrussel.dumbstarbucks.v2.models.MenuItem;

public interface IEatable {

    void eatBaristasChoice();

    void eat(MenuItem item);
}
