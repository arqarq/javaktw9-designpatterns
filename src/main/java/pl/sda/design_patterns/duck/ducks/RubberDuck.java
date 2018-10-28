package pl.sda.design_patterns.duck.ducks;

import pl.sda.design_patterns.duck.DuckCoop;
import pl.sda.design_patterns.duck.DuckEgg;
import pl.sda.design_patterns.duck.strategy.Flying;
import pl.sda.design_patterns.duck.strategy.Quacking;
import pl.sda.design_patterns.duck.strategy.Swimming;
import pl.sda.design_patterns.duck.strategy.impl.FallingNotFlying;
import pl.sda.design_patterns.duck.strategy.impl.FloatingNotSwimming;
import pl.sda.design_patterns.duck.strategy.impl.SqueakNotQuacking;

import java.util.Random;

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

    @Override
    public Integer totalEggsLaid() {
        return 0;
    }

    @Override
    public Integer age() {
        return new Random().nextInt(10000) + 10;
    }

    @Override
    public DuckEgg layEgg() {
        return null;
    }

    @Override
    public void walkToDuckCoop(DuckCoop coop) {
        System.out.println("Nope.");
    }

    @Override
    public void notify(DuckEgg egg) {
        System.out.println("IIIkkIk iik iii");
    }
}
