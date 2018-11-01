package pl.sda.design_patterns.duck;

import org.junit.Assert;
import org.junit.Test;
import junitparams.Parameters;

import pl.sda.design_patterns.duck.ducks.Duck;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DuckStatisticsTest {

    @Test // sprawdzanie oczywistosci jest zle
    public void shouldAcceptDuckListAsParameter() {
        // Given
        List<Duck> ducks = new ArrayList<>();
        // When
        new DuckStatistics(ducks);
        // Then
    }

    @Test
    public void shouldReturnOldestDuck() {
        // Given
        Duck duck1 = mock(Duck.class);
        when(duck1.age()).thenReturn(15);

        Duck oldestDuck = mock(Duck.class);
        doReturn(555).when(oldestDuck).age();

        Duck duck3 = mock(Duck.class);
        doReturn(7).when(duck3).age();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(duck1);
        ducks.add(oldestDuck);
        ducks.add(duck3);

        DuckStatistics duckStatistics = new DuckStatistics(ducks);
        // When
        Integer age = duckStatistics.getOldestDuckAge();
        // Then
        Assert.assertEquals((Integer) 555, age);
    }

    @Test
    public void shouldReturnMedianOfEggsLaid() {
        // Given
        Duck duck1 = mock(Duck.class);
        when(duck1.totalEggsLaid()).thenReturn(1);

        Duck duck2 = mock(Duck.class);
        doReturn(2).when(duck2).totalEggsLaid();

        Duck duck3 = mock(Duck.class);
        doReturn(3).when(duck3).totalEggsLaid();

        Duck duck4 = mock(Duck.class);
        doReturn(4).when(duck4).totalEggsLaid();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(duck1);
        ducks.add(duck2);
        ducks.add(duck3);

        DuckStatistics duckStatistics = new DuckStatistics(ducks);

        List<Duck> ducksEven = new ArrayList<>(ducks);
        ducksEven.add(duck4);
        DuckStatistics duckStatisticsForEvenCount = new DuckStatistics(ducksEven);
        // When
        Double medianOfEggsLaid = duckStatistics.medianOfEggsLaid();
        Double medianOfEggsLaidForEvenCount = duckStatisticsForEvenCount.medianOfEggsLaid();
        // Then
        Assert.assertEquals((Double) 2D, medianOfEggsLaid);
        Assert.assertEquals((Double) 2.5, medianOfEggsLaidForEvenCount);
    }

    @Test
    public void shouldReturnMeanAgeOfDucks() {
        // Given
        Duck duck1 = mock(Duck.class);
        doReturn(0).when(duck1).age();
        Duck duck2 = mock(Duck.class);
        doReturn(0).when(duck2).age();
        Duck duck3 = mock(Duck.class);
        doReturn(1).when(duck3).age();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(duck1);
        ducks.add(duck2);
        ducks.add(duck3);

        DuckStatistics duckStatistics = new DuckStatistics(ducks);
        // When
        Double meanDucksAge = duckStatistics.getMeanDucksAge();
        // Then
        Assert.assertEquals("sprawdz delte", 0.33, meanDucksAge, 0.01);
        System.out.println(duckStatistics.getMeanDucksAge());
    }

    @Test
    public void testDucksWithNoEggs() {
        // Given
        // When
        // Then
    }

    @Test
    @Parameters("0")
    public void testDucksOlderThan() {
        // Given
        // When
        // Then
    }
}
