package be.intecbrussel.dumbstarbucks.v1.models;

import be.intecbrussel.dumbstarbucks.v1.services.IAppetizer;
import be.intecbrussel.dumbstarbucks.v1.services.ICoffee;
import be.intecbrussel.dumbstarbucks.v1.services.ITea;

import java.math.BigDecimal;
import java.util.Arrays;

public class Menu {

    private MenuItem[] coffees = new MenuItem[1];
    private MenuItem[] teas = new MenuItem[1];
    private MenuItem[] appetizers = new MenuItem[1];

    public Menu() {
    }

    public MenuItem[] getCoffees() {
        return this.coffees;
    }

    public void addCoffee(MenuItem coffee) {

        final int noOfMenuItems = this.coffees.length;
        for (int i = 0; i < noOfMenuItems; i++) {
            if (this.coffees[i] == null) {
                this.coffees[i] = coffee;
                break;
            }

            if (i == noOfMenuItems - 1) {
                this.coffees = Arrays.copyOf(this.coffees, noOfMenuItems + 1);
                this.coffees[noOfMenuItems] = coffee;
                break;
            }
        }

    }

    public void removeCoffee(MenuItem coffee) {

        final int noOfMenuItems = this.coffees.length;
        for (int i = 0; i < noOfMenuItems; i++) {
            if (this.coffees[i].equals(coffee)) {
                this.coffees[i] = null;
                break;
            }
        }

        Arrays.sort(this.coffees);
    }


    public Menu withCoffee(MenuItem coffee) {
        this.addCoffee(coffee);
        return this;
    }

    public MenuItem[] getTeas() {
        return this.teas;
    }

    public void addTea(MenuItem tea) {

        final int noOfMenuItems = this.teas.length;
        for (int i = 0; i < noOfMenuItems; i++) {
            if (this.teas[i] == null) {
                this.teas[i] = tea;
                break;
            }

            if (i == noOfMenuItems - 1) {
                this.teas = Arrays.copyOf(this.teas, noOfMenuItems + 1);
                this.teas[noOfMenuItems] = tea;
                break;
            }
        }

    }

    public void removeTea(MenuItem tea) {

        final int noOfMenuItems = this.teas.length;
        for (int i = 0; i < noOfMenuItems; i++) {
            if (this.teas[i].equals(tea)) {
                this.teas[i] = null;
                break;
            }
        }

        Arrays.sort(this.teas);

    }

    public Menu withTea(MenuItem tea) {
        this.addTea(tea);
        return this;
    }

    public MenuItem[] getAppetizers() {
        return this.appetizers;
    }

    public void addAppetizer(MenuItem appetizer) {

        final int noOfMenuItems = this.appetizers.length;
        for (int i = 0; i < noOfMenuItems; i++) {
            if (this.appetizers[i] == null) {
                this.appetizers[i] = appetizer;
                break;
            }

            if (i == noOfMenuItems - 1) {
                this.appetizers = Arrays.copyOf(this.appetizers, noOfMenuItems + 1);
                this.appetizers[noOfMenuItems] = appetizer;
                break;
            }
        }

    }

    public void removeAppetizer(MenuItem appetizer) {

        final int noOfMenuItems = this.appetizers.length;
        for (int i = 0; i < noOfMenuItems; i++) {
            if (this.appetizers[i].equals(appetizer)) {
                this.appetizers[i] = null;
                break;
            }
        }

        Arrays.sort(this.appetizers);

    }

    public Menu withAppetizers(MenuItem appetizer) {
        this.addAppetizer(appetizer);
        return this;
    }

    public MenuItem[] filterByPrice(Double minPrice, Double maxPrice) {

        final MenuItem[] allItems = mergeAllMenuItems();
        final int noOfAllItems = allItems.length;
        final MenuItem[] filteredItems = new MenuItem[noOfAllItems];
        final int noOfFilteredItems = filteredItems.length;

        // COPY ALL ITEMS TO FILTERED ITEMS ..
        for (int i = 0; i < noOfAllItems; i++) {
            filteredItems[i] = allItems[i];
        }

        // SET FILTER AND REMOVE THE ONES DOES NOT MATCH WITH THE FILTER CRITERIA
        for (int i = 0; i < noOfFilteredItems; i++) {

            if ((filteredItems[i] != null) && (filteredItems[i].getPrice() != null)
                    && ((filteredItems[i].getPrice().doubleValue() < minPrice) || (filteredItems[i].getPrice().doubleValue() > maxPrice))) {

                // set item to null, which will remove the value ..
                filteredItems[i] = null;

            }

        }

        // SORTS THE ARRAY AND PUTS ALL NULL VALUES TO THE END WHICH WILL HELP US TO REMOVE ALL NULL VALUES ..
        Arrays.sort(filteredItems);

        int firstNullIndex = 0;
        for (int i = 0; i < filteredItems.length; i++) {
            if (filteredItems[i] == null) {
                firstNullIndex = i;
                break;
            }
        }

        return Arrays.copyOfRange(filteredItems, 0, firstNullIndex);
    }

    public void adjustDiscount(Double discountRate) {

        for (int i = 0; i < this.coffees.length; i++) {
            this.coffees[i].setDiscount(discountRate);
        }

        for (int i = 0; i < this.teas.length; i++) {
            this.teas[i].setDiscount(discountRate);
        }

        for (int i = 0; i < this.appetizers.length; i++) {
            this.appetizers[i].setDiscount(discountRate);
        }
    }

    public void adjustDiscount(Double discountRate, MenuItem[] items) {

        for (MenuItem item : items) {
            if (item instanceof ICoffee) {

                for (int i = 0; i < this.coffees.length; i++) {
                    if (this.coffees[i].equals(item)) {
                        this.coffees[i].setDiscount(discountRate);
                    }
                }

            } else if (item instanceof ITea) {

                for (int i = 0; i < this.teas.length; i++) {
                    if (this.teas[i].equals(item)) {
                        this.teas[i].setDiscount(discountRate);
                    }
                }

            } else if (item instanceof IAppetizer) {

                for (int i = 0; i < this.appetizers.length; i++) {
                    if (this.appetizers[i].equals(item)) {
                        this.appetizers[i].setDiscount(discountRate);
                    }
                }
            }
        }

    }

    private MenuItem[] mergeAllMenuItems() {
        final int noOfCoffees = this.coffees.length;
        final int noOfTeas = this.teas.length;
        final int noOfAppetizers = this.appetizers.length;

        final MenuItem[] allItems = new MenuItem[noOfCoffees + noOfTeas + noOfAppetizers];
        for (int i = 0; i < this.coffees.length; i++) {
            allItems[i] = this.coffees[i];
        }

        for (int i = 0; i < this.teas.length; i++) {
            allItems[i] = this.teas[i + noOfCoffees];
        }

        for (int i = 0; i < this.appetizers.length; i++) {
            allItems[i] = this.appetizers[i + noOfCoffees + noOfTeas];
        }
        return allItems;
    }

    public MenuItem[] filterByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return this.filterByPrice(minPrice.doubleValue(), maxPrice.doubleValue());
    }


}
