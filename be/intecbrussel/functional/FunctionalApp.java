package be.intecbrussel.functional;

public class FunctionalApp {

    public static void main(String[] args) {

        IPerson person1 = new IPerson() {
            @Override
            public void sayHello() {
                System.out.println("Hello World from Anonymous Inner Class!");
            }
        };

        person1.sayHello();


        IPerson person2 = ()  -> { System.out.println("Hello World from Lambda Expression"); };


    }

}
