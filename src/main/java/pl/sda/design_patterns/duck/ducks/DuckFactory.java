package pl.sda.design_patterns.duck.ducks;

import pl.sda.design_patterns.duck.strategy.impl.StandardQuacking;
import pl.sda.design_patterns.duck.strategy.impl.StandardSwimming;
import pl.sda.design_patterns.duck.strategy.impl.WingedFlying;

public class DuckFactory {
    private final StandardQuacking quackStrategy = new StandardQuacking();
    private final WingedFlying flyStrategy = new WingedFlying();
    private final StandardSwimming swimStrategy = new StandardSwimming();

    public Duck createDuck(DuckType type) {
        switch (type) {
            case MALLARD_DUCK:
                return new AliveDuck("Mallard Duck", quackStrategy, flyStrategy, swimStrategy);
            case GREEN_WINGED_TEAL_DUCK:
                return new AliveDuck("Green Wing Teal Duck", quackStrategy, flyStrategy, swimStrategy);
            case RUBBER_DUCK:
                return new RubberDuck();
            default:
                throw new IllegalArgumentException("Unknown duck: " + type);
        }
    }
}
