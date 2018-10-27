package pl.sda.design_patterns.duck.impl;

import pl.sda.design_patterns.duck.Duck;
import pl.sda.design_patterns.duck.strategy.*;
import pl.sda.design_patterns.duck.strategy.impl.StandardQuacking;
import pl.sda.design_patterns.duck.strategy.impl.StandardSwimming;
import pl.sda.design_patterns.duck.strategy.impl.WingedFlying;

public class MallardDuck implements Duck {
    private Quacking quackingStrategy;
    private Flying flyingStrategy;
    private Swimming swimmingStrategy;

    public MallardDuck() {
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
