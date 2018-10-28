package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;
import pl.sda.design_patterns.duck.strategy.Flying;
import pl.sda.design_patterns.duck.strategy.Quacking;
import pl.sda.design_patterns.duck.strategy.Swimming;

import java.util.Random;

public class AliveDuck implements Duck {
    private String duckName;
    private Quacking quackingStrategy;
    private Flying flyingStrategy;
    private Swimming swimmingStrategy;
    private DuckCoop coop;
    private Integer eggCount;

    public AliveDuck(
            String duckName,
            Quacking quackingStrategy,
            Flying flyingStrategy,
            Swimming swimmingStrategy) {
        this.duckName = duckName;
        this.quackingStrategy = quackingStrategy;
        this.flyingStrategy = flyingStrategy;
        this.swimmingStrategy = swimmingStrategy;
        eggCount = 0;
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

    @Override
    public Integer totalEggsLaid() {
        // zwróć faktyczną liczbę złożonych jaj
//        return new Random().nextInt(100);
        return eggCount;
    }

    @Override
    public Integer age() {
        return new Random().nextInt(1000) + 10;
    }

    @Override
    public DuckEgg layEgg() {
        DuckEgg.Builder eggBuilder = new DuckEgg.Builder();
        eggBuilder.setYolkWeight(123D);
        DuckEgg egg = eggBuilder.build();

        eggCount++;
        coop.notifyAboutEgg(egg);
        // stwórz jajo
        // poinformuj kacznik o nowym jaju
        // zwróć złożone jajo
        return egg;
    }

    @Override
    public void walkToDuckCoop(DuckCoop coop) {
        coop.register(this);
        this.coop = coop;
    }

    @Override
    public void notify(DuckEgg egg) {
//        String duckType = getClass().getSimpleName();
        System.out.println(duckName + ": Great eag!");
        // wyświetl pochwałę nad wspaniałością jaja
    }
}
