import sorters.PointSorter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PointSorterApp {
    public static void main(String[] args) {

        PointSorter pointSorter = new PointSorter();

        Integer [] points = {5, 2 ,6, 1, 8, 12};

        pointSorter.setPoints(points);
        pointSorter.sortPoints();
        pointSorter.getAverage();

        Double [] doubleSorter = {4.5, 7.6, 1.7, 2.3, 8.5, 9.9};

        pointSorter.setPoints(doubleSorter);
        pointSorter.sortPoints();
        pointSorter.getAverage();

        Character [] charPoints = {'F', 'H', 'S', 'R', 'V', 'B'};
        pointSorter.setPoints(charPoints);
        pointSorter.sortPoints();
        pointSorter.getAverage();

//        List <Integer> list = new ArrayList<>();
//        list.add(6);

    }
}
