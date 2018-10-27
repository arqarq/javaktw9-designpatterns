package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.strategy.*;

public class RubberDuck implements Duck {
    private Quacking quackingStrategy;
    private Flying flyingStrategy;
    private Swimming swimmingStrategy;

    RubberDuck() {
        quackingStrategy = new SqueakNotQuacking();
        flyingStrategy = new FallingNotFlying();
        swimmingStrategy = new FloatingNotSwimming();
    }

    @Override
    public void quack() {
        quackingStrategy.quack();
//        System.out.println("IIIIkkkk!");
    }

    @Override
    public void swim() {
        swimmingStrategy.swim();
//        System.out.println("Weeeeee i'm floatin'");
    }

    @Override
    public void fly() {
        flyingStrategy.flying();
//        System.out.println("U kiddin, i'm falling");
    }
}
