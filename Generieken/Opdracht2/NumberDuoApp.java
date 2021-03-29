package Generieken.Opdracht2;

public class NumberDuoApp {
    public static void main(String[] args) {
        NumberDuo<Number> numberDuo = new NumberDuo<>(7,2);

        System.out.println(numberDuo.getFirst());
        System.out.println(numberDuo.getSecond());
        System.out.println(numberDuo.getSum());
    }
}
