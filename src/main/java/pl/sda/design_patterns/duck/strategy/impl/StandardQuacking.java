package pl.sda.design_patterns.duck.strategy.impl;

import pl.sda.design_patterns.duck.strategy.Quacking;

public class StandardQuacking implements Quacking {

    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
