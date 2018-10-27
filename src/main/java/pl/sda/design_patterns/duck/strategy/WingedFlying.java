package pl.sda.design_patterns.duck.strategy;

public class WingedFlying implements Flying {

    @Override
    public void flying() {
        System.out.println("I'm flying");
    }
}
