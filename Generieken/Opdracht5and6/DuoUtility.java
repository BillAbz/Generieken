package Generieken.Opdracht5and6;

import Generieken.Duo;

import java.util.Locale;

public interface DuoUtility {
    static void printUpper(Duo<String> d){
        System.out.println(d.getFirst().toUpperCase() + " , " + d.getSecond().toUpperCase());
    }

    static void printDuo(Duo<?> d){
        System.out.println(d.getFirst() +" , " + d.getSecond());
    }

    static void printSum(Duo<? extends Number> d){
        Number number1 = d.getFirst();
        Number number2 = d.getSecond();

        System.out.println(number1+"+"+number2+"+"+(number1.doubleValue()+number2.doubleValue()));
    }

    static <T> void swapFirst(Duo<T> d1, Duo<T> d2){
        T temp = d1.getFirst();
        d1.setFirst(d2.getFirst());
        d2.setFirst(temp);
        System.out.println(temp);
    }
}
