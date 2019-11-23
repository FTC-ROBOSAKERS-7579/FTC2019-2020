package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestIntake {

    Servo Intake1;
    Servo Intake2;

    public void init(HardwareMap hardwareMap) {
        Intake1 = hardwareMap.servo.get("INTAKE_1");
        Intake2 = hardwareMap.servo.get("INTAKE_2");

        Intake1.setDirection(Servo.Direction.FORWARD);
        Intake2.setDirection(Servo.Direction.REVERSE);
    }

    public void Intake(double power) {
        Intake1.setPosition(power);
        Intake2.setPosition(-power);
    }

}
