package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final Sensor sensor;
    private final SafetyMeter safetyMeter;
    private boolean alarmOn;

    public Alarm(Sensor sensor, SafetyMeter safetyMeter) {
        this.sensor = sensor;
        this.safetyMeter = safetyMeter;
        this.alarmOn = false;
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();
        if (!safetyMeter.test(psiPressureValue)) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn; 
    }
}
