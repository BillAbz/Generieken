package Generieken.Opdracht3;

public class DuoAppv2 {
    public static void main(String[] args) {
        IntegerDuo integerDuo = new IntegerDuo(6,7);
        StringDuo stringDuo = new StringDuo("Bill", "John");

        integerDuo.swap();
        stringDuo.swap();
    }
}
