package pl.sda.design_patterns.duck.ducks._out;

import pl.sda.design_patterns.duck.ducks.AliveDuck;
import pl.sda.design_patterns.duck.strategy.impl.StandardQuacking;
import pl.sda.design_patterns.duck.strategy.impl.StandardSwimming;
import pl.sda.design_patterns.duck.strategy.impl.WingedFlying;

//public class GreenWingedTealDuck implements Duck {
public class GreenWingedTealDuck extends AliveDuck {
//    private Quacking quackingStrategy;
//    private Flying flyingStrategy;
//    private Swimming swimmingStrategy;
//    private DuckCoop coop;
//    private Integer eggCount;

    public GreenWingedTealDuck() {
        super("Green Winged Duck", new StandardQuacking(), new WingedFlying(), new StandardSwimming());
    }

//    public GreenWingedTealDuck() {
//        quackingStrategy = new StandardQuacking();
//        flyingStrategy = new WingedFlying();
//        swimmingStrategy = new StandardSwimming();
//        eggCount = 0;
//    }

/*    @Override
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
        eggBuilder.setYolkWeight(12D);
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
        String duckType = getClass().getSimpleName();
        System.out.println(duckType + ": Great eag!");
        // wyświetl pochwałę nad wspaniałością jaja
    }*/
}
