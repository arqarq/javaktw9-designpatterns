package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;
import pl.sda.design_patterns.duck.ducks.RubberDuck;
import pl.sda.design_patterns.duck.strategy.impl.StandardQuacking;
import pl.sda.design_patterns.duck.strategy.impl.StandardSwimming;
import pl.sda.design_patterns.duck.strategy.impl.WingedFlying;

public class DuckFactory {

    public Duck createDuck(DuckType type) {
        switch (type) {
            case MALLARD_DUCK:
                return new AliveDuck("Mallard Duck",
                        new StandardQuacking(),
                        new WingedFlying(),
                        new StandardSwimming());
            case GREEN_WINGED_TEAL_DUCK:
                return new AliveDuck("Green Wing Teal Duck",
                        new StandardQuacking(),
                        new WingedFlying(),
                        new StandardSwimming());
            case RUBBER_DUCK:
                return new RubberDuck();
            default:
                throw new IllegalArgumentException("Unknown duck: " + type);
        }
    }
}
