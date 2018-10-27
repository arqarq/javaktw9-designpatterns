package pl.sda.design_patterns.duck;

public class DuckMain {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck greenWingedTealDuck = new GreenWingedTealDuck();
        Duck rubberDuck = new RubberDuck();

        mallardDuck.fly();
        mallardDuck.swim();
        mallardDuck.quack();
        greenWingedTealDuck.fly();
        greenWingedTealDuck.swim();
        greenWingedTealDuck.quack();
        rubberDuck.fly();
        rubberDuck.swim();
        rubberDuck.quack();

/*
        final StandardSwimming standardSwimming = new StandardSwimming();
        standardSwimming.swim2();
*/
    }
}
