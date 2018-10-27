package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;

import java.util.Comparator;
import java.util.List;

public class DuckStatistics {
    private final List<Duck> ducks;

    public DuckStatistics(List<Duck> ducks) {
        this.ducks = ducks;
    }

    public Integer getOldestDuckAge() {
//        Integer oldestDuckAge = Integer.MIN_VALUE;
//
//        for (Duck duck : ducks) {
//            Integer duckAge = duck.age();
//            if (duckAge > oldestDuckAge){
//                oldestDuckAge = duckAge;
//            }
//        }
//        return oldestDuckAge;

//        return ducks.stream()
//                .map(Duck::age)
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList())
//                .get(0);

        return ducks.stream()
                .sorted(Comparator.comparing(Duck::age).reversed())
                .findFirst()
                .map(Duck::age)
                .orElse(Integer.MIN_VALUE);
    }
}
