package pl.sda.design_patterns.duck.strategy.impl;

import pl.sda.design_patterns.duck.strategy.Swimming;

public class FloatingNotSwimming implements Swimming {
    @Override
    public void swim() {
        System.out.println("I'm rather driffing");
    }
}
