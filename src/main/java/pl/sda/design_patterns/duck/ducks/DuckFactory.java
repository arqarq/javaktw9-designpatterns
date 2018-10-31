package pl.sda.design_patterns.duck.ducks;

import pl.sda.design_patterns.duck.strategy.impl.StandardQuacking;
import pl.sda.design_patterns.duck.strategy.impl.StandardSwimming;
import pl.sda.design_patterns.duck.strategy.impl.WingedFlying;

public class DuckFactory {
    private static final String DEFAULT_MALLARD_DUCK_NAME = "Noname Mallard Duck";
    private static final String DEFAULT_GREEN_WINGED_TEAL_NAME = "Noname Green Winged Teal Duck";
    private static final Double YOLK_WEIGHT_MALLARD = DuckType.MALLARD_DUCK.getYolkWeight();
    private static final Double YOLK_WEIGHT_GWTD = DuckType.GREEN_WINGED_TEAL_DUCK.getYolkWeight();

    private final StandardQuacking quackStrategy = new StandardQuacking();
    private final WingedFlying flyStrategy = new WingedFlying();
    private final StandardSwimming swimStrategy = new StandardSwimming();

    public Duck createDuck(DuckType type, String name, Integer age) {
        AliveDuck aliveDuck;

        switch (type) {
            case MALLARD_DUCK:
                aliveDuck = new AliveDuck(name, quackStrategy, flyStrategy, swimStrategy);
                aliveDuck.setAge(age);
                aliveDuck.setYolkWeightForThisType(YOLK_WEIGHT_MALLARD);
                return aliveDuck;
            case GREEN_WINGED_TEAL_DUCK:
                aliveDuck = new AliveDuck(name, quackStrategy, flyStrategy, swimStrategy);
                aliveDuck.setAge(age);
                aliveDuck.setYolkWeightForThisType(YOLK_WEIGHT_GWTD);
                return aliveDuck;
            default:
                throw new IllegalArgumentException("Unknown duck: " + type);
        }
    }

    public Duck createDuck(DuckType type) {
        AliveDuck aliveDuck;

        switch (type) {
            case MALLARD_DUCK:
                aliveDuck = new AliveDuck(DEFAULT_MALLARD_DUCK_NAME, quackStrategy, flyStrategy, swimStrategy);
                aliveDuck.setYolkWeightForThisType(YOLK_WEIGHT_MALLARD);
                return aliveDuck;
            case GREEN_WINGED_TEAL_DUCK:
                aliveDuck = new AliveDuck(DEFAULT_GREEN_WINGED_TEAL_NAME, quackStrategy, flyStrategy, swimStrategy);
                aliveDuck.setYolkWeightForThisType(YOLK_WEIGHT_GWTD);
                return aliveDuck;
            case RUBBER_DUCK:
                return new RubberDuck();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
