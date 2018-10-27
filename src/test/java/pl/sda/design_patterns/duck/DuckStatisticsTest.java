package pl.sda.design_patterns.duck;

import org.junit.Assert;
import org.junit.Test;
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
}
