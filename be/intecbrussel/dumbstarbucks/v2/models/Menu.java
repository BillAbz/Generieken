package be.intecbrussel.dumbstarbucks.v2.models;

//import be.intecbrussel.dumbstarbucks.sandbox.StreamExamplesApp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    private MenuItem[] coffees = new MenuItem[10];
    private MenuItem[] teas = new MenuItem[10];
    private MenuItem[] appetizers = new MenuItem[10];

    public Menu() {
    }

    public Menu(MenuItem[] coffees, MenuItem[] teas, MenuItem[] appetizers) {
        this.coffees = coffees;
        this.teas = teas;
        this.appetizers = appetizers;
    }

    public MenuItem[] getCoffees() {
        return this.coffees;
    }

    public void addCoffee(MenuItem coffee) {
        if (coffee != null) {
            this.coffees = Stream
                    .concat(Arrays.stream(this.coffees), Stream.of(coffee))
                    .toArray(MenuItem[]::new);
        }
    }

    public void removeCoffee(MenuItem coffee) {

        this.coffees = Arrays
                .stream(this.coffees)
                .filter(menuItem -> Objects.nonNull(menuItem))
                .filter(menuItem -> !menuItem.equals(coffee))
                .toArray(MenuItem[]::new);
    }

    public Menu withCoffee(MenuItem coffee) {
        this.addCoffee(coffee);
        return this;
    }

    public MenuItem[] getTeas() {
        return this.teas;
    }

    public void addTea(MenuItem tea) {

        // TODO: volg de code style van addCoffee ..
        if (tea != null) {
            this.teas =Stream
                    .concat(Arrays.stream(this.teas), Stream.of(tea))
                    .toArray(MenuItem[]::new);
        }

    }

    public void removeTea(MenuItem tea) {

        // TODO:
        // 1: Creëer een stream van thee
        // 2: zoek thee in de stream en filter ..
        // 3: converteer deze stream naar een array van menuItems.
        // 4: vervang de thee-array door een nieuwe array uit de stream
        this.teas = Arrays
                .stream(this.teas)
                .filter(menuItem -> Objects.nonNull(menuItem))
                .filter(menuItem -> !menuItem.equals(tea))
                .toArray(MenuItem[]::new);

    }

    public Menu withTea(MenuItem tea) {
        this.addTea(tea);
        return this;
    }

    public MenuItem[] getAppetizers() {
        return this.appetizers;
    }

    public void addAppetizer(MenuItem appetizer) {

        // TODO: volg de code style van addCoffee ..
        if (appetizer != null){
            this.appetizers = Stream
                    .concat(Arrays.stream(this.appetizers), Stream.of(appetizer))
                    .toArray(MenuItem[]::new);
        }

    }

    public void removeAppetizer(MenuItem appetizer) {

        // TODO:
        // 1: Creëer een stream van thee
        // 2: zoek thee in de stream en filter ..
        // 3: converteer deze stream naar een array van menuItems.
        // 4: vervang de thee-array door een nieuwe array uit de stream

        this.appetizers = Arrays
                .stream(this.appetizers)
                .filter(menuItem -> Objects.nonNull(menuItem))
                .filter(menuItem -> !menuItem.equals(appetizer))
                .toArray(MenuItem[]::new);
    }

    public Menu withAppetizers(MenuItem appetizer) {
        this.addAppetizer(appetizer);
        return this;
    }

    public MenuItem[] filterByPrice(Double minPrice, Double maxPrice) {
        return Stream
                .of(this.coffees, this.teas, this.appetizers)
                .flatMap(Stream::of)
                .filter(menuItem -> Objects.nonNull(menuItem))
                .filter(menuItem -> menuItem.getPrice().doubleValue() > minPrice && menuItem.getPrice().doubleValue() < maxPrice)
                .toArray(MenuItem[]::new);
    }

    public void adjustDiscount(Double discountRate) {

        // TODO: COFFEES
        // 1: create a stream from all coffees ..
        // 2: set new prices with the formula => price * discountRate
        // 3: set new array values this.coffees..

        Stream
                .of(this.coffees)
                .forEach(menuItem -> menuItem.setPrice(menuItem.getPrice().multiply(BigDecimal.valueOf(discountRate))));



        // TODO: TEAS
        // 1: create a stream from all coffees ..
        // 2: set new prices with the formula => price * discountRate
        // 3: set new array values this.teas..

        // TODO: APPETIZERS
        // 1: create a stream from all coffees ..
        // 2: set new prices with the formula => price * discountRate
        // 3: set new array values this.appeizers..


    }

    public void adjustDiscount(Double discountRate, MenuItem[] items) {
        // TODO:
        //

    }

    public MenuItem[] filterByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return this.filterByPrice(minPrice.doubleValue(), maxPrice.doubleValue());
    }


}
