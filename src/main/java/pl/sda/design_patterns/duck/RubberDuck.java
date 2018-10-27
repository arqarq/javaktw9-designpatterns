package pl.sda.design_patterns.duck;

public class RubberDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Piszczę");
    }

    @Override
    public void swim() {
        System.out.println("Dryfuję");
    }

    @Override
    public void fly() {
        System.out.println("spadam");
    }
}
