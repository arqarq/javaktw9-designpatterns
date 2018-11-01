package pl.sda.design_patterns.duck;

import pl.sda.design_patterns.duck.ducks.Duck;

import java.util.List;
import java.util.stream.Collectors;

class DuckStatistics {
    private static final String LF = System.lineSeparator();
    private final List<Duck> ducks;

    DuckStatistics(List<Duck> ducks) {
        this.ducks = ducks;
    }

    Integer getOldestDuckAge() {
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

//        return ducks.stream()
//                .sorted(Comparator.comparing(Duck::age).reversed())
//                .findFirst()
//                .map(Duck::age)
//                .orElse(Integer.MIN_VALUE);

        return ducks.stream()
                .map(Duck::age)
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
    }

    Double getMeanDucksAge() {
        return ducks.stream()
                .mapToDouble(Duck::age)
                .sum()
                / ducks.size();
    }

    Double medianOfEggsLaid() {
        List<Double> eggsLaid = ducks.stream()
                .map(Duck::totalEggsLaid)
                .sorted()
                .map(Double::valueOf)
                .collect(Collectors.toList());
        int eggsLaidSize = eggsLaid.size();
        return eggsLaidSize % 2 == 0
                ? (eggsLaid.get(eggsLaidSize / 2 - 1) + eggsLaid.get(eggsLaidSize / 2)) / 2
                : eggsLaid.get(eggsLaidSize / 2);
    }

/*    List<Duck> getDucksWithNoEggs() {
        return ducks.stream()
                .filter(x -> x.totalEggsLaid() == 0)
                .collect(Collectors.toList());
    }*/

    String getDucksWithNoEggs() {
        return ducks.stream()
                .filter(x -> x.totalEggsLaid() == 0)
                .map(Duck::getDuckName)
                .collect(Collectors.joining(LF, LF, LF));
    }

    String getDucksOlderThan(Integer age) {
        return ducks.stream()
                .filter(x -> x.age() > age)
                .map(Duck::getDuckName)
                .collect(Collectors.joining(LF, LF, LF));
    }
}
