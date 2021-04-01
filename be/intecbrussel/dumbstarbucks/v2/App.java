package be.intecbrussel.dumbstarbucks.v2;

import be.intecbrussel.dumbstarbucks.v2.models.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        MenuItem[] coffees = new DumbCoffee[]{
                new DumbCoffee("Espresso", BigDecimal.valueOf(4.00)),
                new DumbCoffee("Ristretto", BigDecimal.valueOf(4.00)),
                new DumbCoffee("Cappucino", BigDecimal.valueOf(6.00)),
                new DumbCoffee("Latte", BigDecimal.valueOf(8.50)),
                null,
                null,
                null,
                null
        };

        MenuItem[] teas = new DumbTea[]{
                new DumbTea("Rooibos", BigDecimal.valueOf(2.00), "Doi Pressos"),
                new DumbTea("Mint", BigDecimal.valueOf(2.00), "Mante Freddo"),
                new DumbTea("Elderflower", BigDecimal.valueOf(3.00), "Elda Cheno"),
                new DumbTea("Blue Origin", BigDecimal.valueOf(4.50), "Origano"),
                null,
                null,
                null,
                null
        };

        MenuItem[] sandwiches = new DumbSandwich[]{
                new DumbSandwich("Sandy Witch", BigDecimal.valueOf(12.00), MenuItem.Size.MEDIUM),
                new DumbSandwich("Papa's Favorite", BigDecimal.valueOf(12.00), MenuItem.Size.SMALL),
                new DumbSandwich("Mama Never Cooks", BigDecimal.valueOf(16.00), MenuItem.Size.LARGE),
                new DumbSandwich("Mama's Best", BigDecimal.valueOf(24.50), MenuItem.Size.MEDIUM),
                null,
                null,
                null,
                null
        };

        Menu menu = new Menu(
                coffees, teas, sandwiches
        );


//        MenuItem[] filteredItems = menu.filterByPrice(4.00, 12.50);
//        for (MenuItem filteredItem : filteredItems) {
//            System.out.println(filteredItem);
//        }


//        Stream<MenuItem[]> allStreamAsArrays = Stream.of(coffees, teas, sandwiches);
        // allStreamAsArrays[0] = coffees : MenuItem[] -> 5
        // allStreamAsArrays[1] = teas : MenuItem[] -> 6
        // allStreamAsArrays[2] = sandwich:  MenuItem[] -> 4

        // the last sandwich in the sandwich array is: "Chicken Curry Sandwich"

//        Stream<MenuItem> allItemsStream = allStreamAsArrays.flatMap(Stream::of);
        // allStreamAsArrays[0] = espresso: MenuItem
        // allStreamAsArrays[1] = ristretto: MenuItem
        // allStreamAsArrays[2] = ... :  MenuItem
        // allStreamAsArrays[14] =  chickenCurry: MenuItem


        // flatMap()

//        allStreamAsArrays.forEach(menuItemArray -> System.out.println(Arrays.toString(menuItemArray)));

        Stream<MenuItem> filteredCoffees = Arrays
                .stream(coffees)
                .filter(menuItem -> Objects.nonNull(menuItem))
                .filter(menuItem -> !menuItem.getName().equals("Cappucino"));

        filteredCoffees.forEach(menuItem -> System.out.println(menuItem));

    }

}
