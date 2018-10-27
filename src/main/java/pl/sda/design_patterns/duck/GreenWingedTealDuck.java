package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.strategy.*;

public class GreenWingedTealDuck implements Duck {
    private Quacking quackingStrategy;
    private Flying flyingStrategy;
    private Swimming swimmingStrategy;

    GreenWingedTealDuck() {
        quackingStrategy = new StandardQuacking();
        flyingStrategy = new WingedFlying();
        swimmingStrategy = new StandardSwimming();
    }

    @Override
    public void quack() {
        quackingStrategy.quack();
//        System.out.println("Quack!");
    }

    @Override
    public void swim() {
        swimmingStrategy.swim();
//        System.out.println("I'm using fins and swimming");
    }

    @Override
    public void fly() {
        flyingStrategy.flying();
//        System.out.println("I'm using wings and flying");
    }
}
