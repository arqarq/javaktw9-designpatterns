package pl.sda.design_patterns.duck.singleton;

import pl.sda.design_patterns.duck.ducks.Duck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FarmerEagerSingleton {
    private static final FarmerEagerSingleton INSTANCE = new FarmerEagerSingleton();

    private List<Duck> ducks;

    private FarmerEagerSingleton() {
        List<Duck> notSyncedList = new ArrayList<>();
        ducks = Collections.synchronizedList(notSyncedList); // synchronizowana lista
    }

    public static FarmerEagerSingleton getInstance() {
        return INSTANCE;
    }

    public boolean addDuck(Duck duck) {
        return ducks.add(duck);
    }

    public boolean removeDuck(Duck duck) {
        return ducks.remove(duck);
    }

    public List<Duck> getAllDucks() {
        return new ArrayList<>(ducks);
//        return ducks; // oddajemy cały obiekt, słabo defensywne
    }
}
