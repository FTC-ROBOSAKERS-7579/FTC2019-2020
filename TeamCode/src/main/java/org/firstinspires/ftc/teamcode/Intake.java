package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    Servo Intake;

    public void init(HardwareMap hardwareMap) {

        Intake = hardwareMap.servo.get("INTAKE");

    }

    public void grab() {

        Intake.setPosition(0);

    }

    public void open() {

        Intake.setPosition(0.25);

    }

    public void close() {

        Intake.setPosition(0.5);

    }

}