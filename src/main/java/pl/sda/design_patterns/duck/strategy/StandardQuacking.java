package pl.sda.design_patterns.duck.strategy;

public class StandardQuacking implements Quacking {

    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
