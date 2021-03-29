package Generieken.Opdracht1;

public class MixedDuoApp {
    public static void main(String[] args) {
        MixedDuo<String,Integer> mixedDuo = new MixedDuo<>("Hello",5);

        String s = mixedDuo.getFirst();
        Integer i = mixedDuo.getSecond();

        System.out.println(s+" " + i);
    }
}
