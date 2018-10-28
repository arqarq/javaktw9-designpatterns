package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;

import java.util.ArrayList;
import java.util.List;

public class DuckCoop {

    private List<Duck> ducks;

    public DuckCoop() {
        ducks = new ArrayList<>();
    }

    public void register(Duck duck) {
//        if (!ducks.contains(duck)) {
        ducks.add(duck);
//        }
        // zapisz kaczkę w liście kaczek
    }

    public void unregister(Duck duck) {
        ducks.remove(duck);
        // usunąć kaczkę z listy kaczek
    }

    public void notifyAboutEgg(DuckEgg egg) {
        ducks.forEach(duck -> duck.notify(egg));
        // poinformować za pomocą notify inne kaczki o nowym jaju
    }
}
