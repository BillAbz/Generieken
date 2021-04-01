package be.intecbrussel.dumbstarbucks.v1.services;

import be.intecbrussel.dumbstarbucks.v1.models.MenuItem;

public interface IAppetizer extends IEatable {

    void addSauce(MenuItem... sauces);

}
