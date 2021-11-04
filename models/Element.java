package models;

public abstract class Element extends References {
    public abstract void print();

    public abstract boolean add(Element element);
    public abstract boolean remove(Element element);
    public abstract Element get(int index);
}
