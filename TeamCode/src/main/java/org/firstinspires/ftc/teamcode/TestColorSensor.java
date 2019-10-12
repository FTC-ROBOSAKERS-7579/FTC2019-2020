package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;

public class TestColorSensor {
    ColorSensor Color;

    public int Red() {
        return Color.red();
    }

    public int Green() {
        return Color.green();
    }

    public int Blue() {
        return Color.blue();
    }

    public int RGB() {
        return Color.argb();
    }

    public int Alpha() {
        return Color.alpha();
    }
    
    public void LED(boolean lights) {
        Color.enableLed(lights);
    }
}
