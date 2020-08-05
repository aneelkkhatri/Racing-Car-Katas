package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPressureSafetyMeter {
    private PressureSafetyMeter pressureSafetyMeter = new PressureSafetyMeter();

    @Test
    void testLowerPressure() {
        Assertions.assertEquals(false, pressureSafetyMeter.test(10));
    }

    @Test
    void testHigherPressure() {
        Assertions.assertEquals(false, pressureSafetyMeter.test(30));
    }

    @Test
    void testPressureWithinRange() {
        Assertions.assertEquals(true, pressureSafetyMeter.test(20));
    }
}
