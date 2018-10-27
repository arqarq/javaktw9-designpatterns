package pl.sda.design_patterns.duck.strategy;

public class StandardSwimming implements Swimming {

    @Override
    public void swim() {
        System.out.println("Swim with fins");
    }

    public void swim2() {
        System.out.println("dodatkowy swim");
    }
}
