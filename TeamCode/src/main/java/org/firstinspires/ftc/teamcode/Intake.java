package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    Servo Intake;
    Servo Intake2;


    double power = 0;
    double power2 = 0;

    public void init(HardwareMap hardwareMap) {

        Intake = hardwareMap.servo.get("LEFT");
        Intake2 = hardwareMap.servo.get(("RIGHT"));

    }

    public void grab() {
        Intake.setPosition(power);
        Intake2.setPosition(power2);

    }

    public void teleGrab(double p, double p2){
        Intake.setPosition(p);
        Intake2.setPosition(p2);
    }

    public void teleClose(double p, double p2){
        Intake.setPosition(p);
        Intake2.setPosition(p2);
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

        Intake.setPosition(0.25);
        Intake2.setPosition(-0.25);

    }

}