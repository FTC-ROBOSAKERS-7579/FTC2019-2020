package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestIntake {

    DcMotor Arm1;
    DcMotor Arm2;
    Servo Intake1;
    Servo Intake2;

    public void init(HardwareMap hardwareMap) {
        Arm1 = hardwareMap.dcMotor.get("ARM_1");
        Arm2 = hardwareMap.dcMotor.get("ARM_2");
        Intake1 = hardwareMap.servo.get("INTAKE_1");
        Intake2 = hardwareMap.servo.get("INTAKE_2");

        Arm1.setDirection(DcMotor.Direction.FORWARD);
        Arm2.setDirection(DcMotor.Direction.REVERSE);
        Intake1.setDirection(Servo.Direction.FORWARD);
        Intake2.setDirection(Servo.Direction.REVERSE);
    }
    public void Arm(double power) {
        Arm1.setPower(power);
        Arm2.setPower(-power);
    }

    public void Intake(double power) {
        Intake1.setPosition(power);
        Intake2.setPosition(-power);
    }

}
