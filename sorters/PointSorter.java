package sorters;

import java.util.Arrays;

public class PointSorter <T>{
    private T [] points;

    public T[] getPoints() {
        return points;
    }

    public void setPoints(T[] points) {
        this.points = points;
    }

    public void sortPoints(){
        Arrays.sort(points);
        System.out.println(Arrays.toString(points));
    }

    public void getAverage(){
        if (points instanceof Integer[]){
            int sum =0;
            for (int i =0; i< points.length; i++){
                sum += (Integer)points[i];
            }
            System.out.println(sum/points.length);
        }
        else if (points instanceof Double[]){
            double sum =0;
            for (int i =0; i< points.length; i++){
                sum += (Double)points[i];
            }
            System.out.println(sum/points.length);
        }
        else if (points instanceof Character[]){
            int sum =0;
            for (int i =0; i< points.length; i++){
                sum += (Character)points[i];
            }
            System.out.println((char)(sum/points.length));
        }
    }
}
