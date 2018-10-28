package pl.sda.design_patterns.duck.ducks;

import pl.sda.design_patterns.duck.strategy.impl.StandardQuacking;
import pl.sda.design_patterns.duck.strategy.impl.StandardSwimming;
import pl.sda.design_patterns.duck.strategy.impl.WingedFlying;

public class DuckFactory {
    private final StandardQuacking quackStrategy = new StandardQuacking();
    private final WingedFlying flyStrategy = new WingedFlying();
    private final StandardSwimming swimStrategy = new StandardSwimming();
    private final Double yolkWeightMallard = DuckType.MALLARD_DUCK.getYolkWeight();
    private final Double yolkWeightGWTD = DuckType.GREEN_WINGED_TEAL_DUCK.getYolkWeight();

    public Duck createDuck(DuckType type, String name) {
        AliveDuck aliveDuck = new AliveDuck(name, quackStrategy, flyStrategy, swimStrategy);
        switch (type) {
            case MALLARD_DUCK:
                aliveDuck.setYolkWeightForThisType(yolkWeightMallard);
                return aliveDuck;
            case GREEN_WINGED_TEAL_DUCK:
                aliveDuck.setYolkWeightForThisType(yolkWeightGWTD);
                return aliveDuck;
            default:
                throw new IllegalArgumentException("Unknown duck: " + type);
        }
    }

    public Duck createDuck(DuckType type) {
        switch (type) {
            case MALLARD_DUCK:
                AliveDuck aliveDuck = new AliveDuck(
                        "Noname Mallard Duck", quackStrategy, flyStrategy, swimStrategy);
                aliveDuck.setYolkWeightForThisType(yolkWeightMallard);
                return aliveDuck;
            case GREEN_WINGED_TEAL_DUCK:
                AliveDuck aliveDuck1 = new AliveDuck(
                        "Noname Green Winged Teal Duck", quackStrategy, flyStrategy, swimStrategy);
                aliveDuck1.setYolkWeightForThisType(yolkWeightGWTD);
                return aliveDuck1;
            case RUBBER_DUCK:
                return new RubberDuck();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
