package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class TestColorSensor {
    ColorSensor Color;

    // INITIAL
    public void init(HardwareMap hardwareMap) {
        Color = hardwareMap.colorSensor.get("COLOR");
    }

    // RED
    public int Red() {
        return Color.red();
    }

    // GREEN
    public int Green() {
        return Color.green();
    }

    // BLUE
    public int Blue() {
        return Color.blue();
    }

    // RGB
    public int RGB() {
        return Color.argb();
    }

    // ALPHA
    public int Alpha() {
        return Color.alpha();
    }

    // LED
    public void LED(boolean lights) {
        Color.enableLed(lights);
    }
}
