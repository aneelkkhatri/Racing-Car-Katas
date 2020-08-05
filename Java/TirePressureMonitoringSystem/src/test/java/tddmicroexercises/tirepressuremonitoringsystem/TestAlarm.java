package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TestAlarm {
    private Sensor sensor = Mockito.mock(Sensor.class);
    private SafetyMeter safetyMeter = Mockito.mock(SafetyMeter.class);

    private Alarm alarm = new Alarm(sensor, safetyMeter);

    @Test
    public void testDefaultState() {
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void testAlarmOnWithPressureValueFailingSafetyMeter() {
        final double sensorValue = 14.32;
        Mockito.doReturn(sensorValue).when(sensor).popNextPressurePsiValue();
        Mockito.doReturn(false).when(safetyMeter).test(sensorValue);

        alarm.check();

        assertEquals(true, alarm.isAlarmOn());
    }
}
