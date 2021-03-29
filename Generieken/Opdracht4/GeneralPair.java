package Generieken.Opdracht4;

public class GeneralPair<E> implements Pair<E>{
    private E left;
    private E right;

    public GeneralPair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public E getLeft() {
        return null;
    }

    @Override
    public E getRight() {
        return null;
    }

    @Override
    public void setLeft(E left) {

    }

    @Override
    public void setRight(E right) {

    }
}
