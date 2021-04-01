package be.intecbrussel.dumbstarbucks.v2.services;

import be.intecbrussel.dumbstarbucks.v2.models.MenuItem;

public interface IAppetizer extends IEatable {

    void addSauce(MenuItem... sauces);

}
