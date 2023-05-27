package models;

public class Donkey extends Pack_animal{
    @Override
    public void eat() {
        System.out.println("Ослик питается");
    }

    @Override
    public void breath() {
        System.out.println("Ослик дышит");
    }

    @Override
    public void multiply() {
        System.out.println("Ослик размножается");
    }
}
