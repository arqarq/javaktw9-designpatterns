package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;
import pl.sda.design_patterns.duck.singleton.FarmerEagerSingleton;

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
    }
}
