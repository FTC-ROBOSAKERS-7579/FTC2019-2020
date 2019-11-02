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
    public void setArm1(double power1) {
        Arm1.setPower(power1);
    }

    public void setArm2(double power2) {
        Arm2.setPower(power2);
    }

    public void setIntake1(double power1) {
        Intake1.setPosition(power1);
    }
    
    public void setIntake2(double power2) {
        Intake2.setPosition(power2);
    }

}
