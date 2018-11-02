package pl.sda.design_patterns.duck;

import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.design_patterns.duck.ducks.Duck;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DuckStatisticsTest {
    private static final String LF = System.lineSeparator();

    private Duck duck1 = mock(Duck.class);
    private Duck duck2 = mock(Duck.class);
    private Duck duck3 = mock(Duck.class);
    private List<Duck> ducks = new ArrayList<>();
    private DuckStatistics duckStatistics = new DuckStatistics(ducks);

    @Before
    public void setUp() {
        ducks.add(duck1);
        ducks.add(duck2);
        ducks.add(duck3);
    }

/*    @Test // sprawdzanie oczywistosci jest zle
    public void shouldAcceptDuckListAsParameter() {
        // Given
        List<Duck> ducks = new ArrayList<>();
        // When
        new DuckStatistics(ducks);
        // Then
    }*/

    @Test
    public void shouldReturnOldestDuck() {
        // Given
        Duck oldestDuck = mock(Duck.class);
        ducks.add(oldestDuck);

        doReturn(555).when(oldestDuck).age();
        when(duck1.age()).thenReturn(15);
        doReturn(7).when(duck3).age();
        // When
        Integer age = duckStatistics.getOldestDuckAge();
        // Then
        Assert.assertEquals((Integer) 555, age);
    }

    @Test
    public void shouldReturnMedianOfEggsLaid() {
        // Given
        Duck duck4 = mock(Duck.class);
        ArrayList<Duck> ducksEven = new ArrayList<>(ducks);
        ducksEven.add(duck4);

        DuckStatistics duckStatisticsForEvenCount = new DuckStatistics(ducksEven);

        when(duck1.totalEggsLaid()).thenReturn(1);
        doReturn(2).when(duck2).totalEggsLaid();
        doReturn(3).when(duck3).totalEggsLaid();
        doReturn(4).when(duck4).totalEggsLaid();
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
        doReturn(0).when(duck1).age();
        doReturn(0).when(duck2).age();
        doReturn(1).when(duck3).age();
        // When
        Double meanDucksAge = duckStatistics.getMeanDucksAge();
        // Then
        Assert.assertEquals("sprawdz delte jesli blad", 0.33, meanDucksAge, 0.01);
        System.out.println(duckStatistics.getMeanDucksAge());
    }

    @Test
    public void shouldReturnDucksWithNoEggs() {
        // Given
        doReturn(0).when(duck1).totalEggsLaid();
        doReturn("b").when(duck1).getDuckName();
        doReturn(0).when(duck2).totalEggsLaid();
        doReturn("a").when(duck2).getDuckName();
        doReturn(4).when(duck3).totalEggsLaid();
        // When
        String zeroEggs = duckStatistics.getDucksWithNoEggs();
        // Then
        Assert.assertEquals(LF + "a" + LF + "b" + LF, zeroEggs);
    }

    @Test
//    @Parameters("20")
    public void shouldReturnDucksOlderThan() {
        // Given
        doReturn(10).when(duck1).age();
        doReturn(21).when(duck2).age();
        doReturn("b").when(duck2).getDuckName();
        doReturn(30).when(duck3).age();
        doReturn("a").when(duck3).getDuckName();
        // When
        String ducksOlderThan = duckStatistics.getDucksOlderThan(20);
        // Then
        assertThat(ducksOlderThan).isEqualTo(LF + "a" + LF + "b" + LF);
    }
}
