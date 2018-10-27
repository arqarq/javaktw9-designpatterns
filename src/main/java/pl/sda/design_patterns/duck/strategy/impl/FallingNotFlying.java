package pl.sda.design_patterns.duck.strategy.impl;

import pl.sda.design_patterns.duck.strategy.Flying;

public class FallingNotFlying implements Flying {

    @Override
    public void flying() {
        System.out.println("I'm rather falling");
    }
}
