package be.intecbrussel.dumbstarbucks.v1.services;

import be.intecbrussel.dumbstarbucks.v1.models.MenuItem;

public interface IEatable {

    void eatBaristasChoice();

    void eat(MenuItem item);
}
