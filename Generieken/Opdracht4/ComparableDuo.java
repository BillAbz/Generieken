package Generieken.Opdracht4;

import Generieken.Duo;

public class ComparableDuo<E extends Number & Comparable<E>> extends Duo<E> {
    public ComparableDuo(E first, E second) {
        super(first, second);
    }

    public E getHighest() {
        return (getFirst().compareTo(getSecond())<0)?
                getSecond() :getFirst();
    }

    public E getLowest() {
        return (getFirst().compareTo(getSecond())<0)?
                getFirst() :getSecond();
    }

    public double getSum(){
        return getFirst().doubleValue() + getSecond().doubleValue();
    }
}
