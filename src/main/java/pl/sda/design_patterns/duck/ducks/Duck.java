package pl.sda.design_patterns.duck.ducks;

import pl.sda.design_patterns.duck.DuckCoop;
import pl.sda.design_patterns.duck.DuckEgg;

public interface Duck {

    void quack();
    void swim();
    void fly();
    Integer totalEggsLaid();
    Integer age();
    DuckEgg layEgg();
    void walkToDuckCoop(DuckCoop coop);
    void notify(DuckEgg egg);
}
