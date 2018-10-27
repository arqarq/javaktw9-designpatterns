package pl.sda.design_patterns.duck.strategy;

public class SqueakNotQuacking implements Quacking {

    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
