package pl.sda.design_patterns.duck;

public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack!");
    }

    @Override
    public void swim() {
        System.out.println("I'm using fins and swimming");
    }

    @Override
    public void fly() {
        System.out.println("I'm using wings and flying");
    }
}
