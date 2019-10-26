package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestRangedSensor {
    ModernRoboticsI2cRangeSensor Range;
    double distance = Range.getDistance(DistanceUnit.INCH);

    // INITIAL
    public void init(HardwareMap hardwareMap) {
        TestRangedSensor Range = hardwareMap.get(TestRangedSensor.class, "RANGED_SENSOR");
    }

    // TO GET THE DISTANCE
    public double getDistance() {
        return distance;
    }
}