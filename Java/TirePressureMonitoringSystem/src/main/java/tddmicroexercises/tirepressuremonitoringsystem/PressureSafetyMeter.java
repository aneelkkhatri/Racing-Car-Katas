package tddmicroexercises.tirepressuremonitoringsystem;

public class PressureSafetyMeter implements SafetyMeter {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    @Override
    public boolean test(double psiPressureValue) {
        return psiPressureValue >= LowPressureThreshold
            && HighPressureThreshold >= psiPressureValue;
    }
}
