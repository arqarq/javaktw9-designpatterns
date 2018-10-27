package pl.sda.design_patterns.duck.strategy;

public class FallingNotFlying implements Flying {

    @Override
    public void flying() {
        System.out.println("I'm rather falling");
    }
}
