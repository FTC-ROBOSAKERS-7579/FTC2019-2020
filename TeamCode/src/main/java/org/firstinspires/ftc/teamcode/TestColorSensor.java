package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestColorSensor {

    ColorSensor color_sensor;

    public void init(HardwareMap hardwareMap) {

        color_sensor = hardwareMap.colorSensor.get("color");

    }

    public int red() {
        return color_sensor.red();
    }

    public int green() {
        return color_sensor.green();
    }

    public int blue() {
        return color_sensor.blue();
    }

    public int alpha() {
        return color_sensor.alpha();
    }
}
