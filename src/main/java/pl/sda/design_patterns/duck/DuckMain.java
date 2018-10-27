package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.impl.GreenWingedTealDuck;
import pl.sda.design_patterns.duck.impl.MallardDuck;
import pl.sda.design_patterns.duck.impl.RubberDuck;

public class DuckMain {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck greenWingedTealDuck = new GreenWingedTealDuck();
        Duck rubberDuck = new RubberDuck();

        mallardDuck.fly();
        mallardDuck.swim();
        mallardDuck.quack();
        greenWingedTealDuck.fly();
        greenWingedTealDuck.swim();
        greenWingedTealDuck.quack();
        rubberDuck.fly();
        rubberDuck.swim();
        rubberDuck.quack();

/*      final StandardSwimming standardSwimming = new StandardSwimming();
        standardSwimming.swim2();*/ // dodatkowa metoda z samej implementacji

        DuckEgg.Builder builder = new DuckEgg.Builder();
        builder.setYolkWeight(28D);
        DuckEgg egg = builder.build();

        System.out.println(egg);

        Fodder.Builder fodderBuilder = Fodder.builder(500, 500);
        Fodder fodder = fodderBuilder
                .minerals(true)
                .triticaleGrams(321)
                .build();
        Fodder pasza = Fodder.builder(1, 2).build();
    }
}
