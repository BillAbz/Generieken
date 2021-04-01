package be.intecbrussel.functional;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamApp {

    public static void main(String[] args) {


        for (int rangeIndex = 0; rangeIndex < 10; rangeIndex++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(100);
            System.out.println("Random number for : " + rangeIndex + "= " + randomNumber);
        }

        System.out.println("--------------------------------------");

        IntStream intStream = IntStream.range(0, 10);
        Stream<String> formattedStream = intStream.mapToObj(rangeIndex -> {
            Random rand = new Random();
            int randomNumber = rand.nextInt(100);
            return "Random number for : " + rangeIndex + "= " + randomNumber;
        });

        formattedStream.forEach(formattedText -> System.out.println(formattedText));

        System.out.println("--------------------------------------");


        IntStream
                .range(0, 10)
                .mapToObj(rangeIndex -> {
                    Random rand = new Random();
                    int randomNumber = rand.nextInt(100);
                    return "Random number for : " + rangeIndex + "= " + randomNumber;
                })
                .forEach(formattedText -> System.out.println(formattedText));


    // TODO: print every dog name as Dog 1, Dog 2, Dog 3 ... Dog 10


        System.out.println("--------------------------------------");

        Stream<Dog> dogStream = IntStream
                .rangeClosed(1, 10)
                .mapToObj(rangeIndex -> {
                    String[] nameOptions = {"Akita", "Mockito", "Tokko"};
                    Random random = new Random();
                    int randomDogIndex = random.nextInt(3);
                    Dog dog = new Dog("Dog " + nameOptions[randomDogIndex]);
                    return dog;
                });

        dogStream.forEach(dog -> {
            System.out.println(dog.getName());
        });

        dogStream.forEach(dog -> {
            System.out.println(dog.getName());
        });


        // COUNT STREAM
//        long noOfItemsInStream = intStream.count();
//        System.out.println("The number of items in stream: " + noOfItemsInStream);


    }

}
