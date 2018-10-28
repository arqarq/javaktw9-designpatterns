package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;
import pl.sda.design_patterns.duck.ducks.DuckFactory;
import pl.sda.design_patterns.duck.ducks.DuckType;
import pl.sda.design_patterns.duck.singleton.FarmerEagerSingleton;

import java.util.ArrayList;
import java.util.List;

public class DuckMain {
    public static void main(String[] args) {
        DuckFactory duckFactory = new DuckFactory();
        Duck mallardDuck = duckFactory.createDuck(DuckType.MALLARD_DUCK);
        Duck greenWingedTealDuck = duckFactory.createDuck(DuckType.GREEN_WINGED_TEAL_DUCK);
        Duck rubberDuck = duckFactory.createDuck(DuckType.RUBBER_DUCK);

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

        FarmerEagerSingleton farmer = FarmerEagerSingleton.getInstance();
/*        farmer.addDuck(mallardDuck);
        System.out.println(farmer.hashCode());
        FarmerEagerSingleton singleton2 = FarmerEagerSingleton.getInstance();
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2.getAllDucks().size());*/

        farmer.askVet();
        System.out.println("=========");
        farmer.askVet();

        DuckCoop duckCoop = new DuckCoop();

        mallardDuck.walkToDuckCoop(duckCoop);
        greenWingedTealDuck.walkToDuckCoop(duckCoop);
        mallardDuck.layEgg();

        duckCoop.unregister(greenWingedTealDuck);
        mallardDuck.layEgg();

        System.out.println("=========");

        List<Duck> ducks = new ArrayList<>();
        Duck duck1 = duckFactory.createDuck(DuckType.MALLARD_DUCK, "Mallard Duck 2");
        Duck duck2 = duckFactory.createDuck(DuckType.MALLARD_DUCK, "Mallard Duck 3");
        Duck duck3_ = duckFactory.createDuck(DuckType.GREEN_WINGED_TEAL_DUCK, "Green Winged Teal Duck 2");
        Duck duck4_ = duckFactory.createDuck(DuckType.GREEN_WINGED_TEAL_DUCK, "Green Winged Teal Duck 3");
        ducks.add(duck1);
        ducks.add(duck2);
        ducks.add(duck3_);
        ducks.add(duck4_);
        DuckStatistics duckStatistics = new DuckStatistics(ducks);
        DuckCoop duckCoopNew = new DuckCoop();
        duck1.walkToDuckCoop(duckCoopNew); // kacznik musi być, bo inaczej NPE
        duck2.walkToDuckCoop(duckCoopNew);
        duck3_.walkToDuckCoop(duckCoopNew);
        duck4_.walkToDuckCoop(duckCoopNew);

//        for (int i = 0; i < 4; i++) {
//            duck1.layEgg();
//        }
//        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(duck2.layEgg());
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {
            System.out.println(duck3_.layEgg());
        }
        System.out.println();
        for (int i = 0; i < 1; i++) {
            System.out.println(duck4_.layEgg());
        }
        System.out.println(System.lineSeparator() + "The median of eggs laid is: " + duckStatistics.medianOfEggsLaid());
    }
}
