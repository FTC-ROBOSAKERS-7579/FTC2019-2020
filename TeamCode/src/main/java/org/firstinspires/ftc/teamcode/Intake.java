package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    Servo Intake;
    Servo Intake2;

    public void init(HardwareMap hardwareMap) {

        Intake = hardwareMap.servo.get("INTAKE");
        Intake2 = hardwareMap.servo.get(("INTAKE2"));

    }

    public void grab() {
        Intake.setPosition(0.25);
        Intake2.setPosition(-0.25);

    }

    public void open() {

        Intake.setPosition(-0.25);
        Intake2.setPosition(0.25);

    }
    public  void zero(){
        Intake.setPosition(0);
        Intake2.setPosition(0);

    }

    public void close() {

        Intake.setPosition(0.5);

    }

}