package pl.sda.design_patterns.duck;

public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        Duck duck2 = new RubberDuck();
        Duck duck3 = new GreenWingedTealDuck();

        duck.fly();
        duck.swim();
        duck.quack();
        duck2.fly();
        duck2.swim();
        duck2.quack();
        duck3.fly();
        duck3.swim();
        duck3.quack();
    }
}
