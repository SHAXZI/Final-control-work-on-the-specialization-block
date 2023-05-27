package models;

public class Cat extends Pet {
    @Override
    public void eat() {
        System.out.println("Кошка питается");
    }

    @Override
    public void breath() {
        System.out.println("Кошка дышит");
    }

    @Override
    public void multiply() {
        System.out.println("Кошка размножается");

    }
}
