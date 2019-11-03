package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestIntake {
    DcMotor Arm1;
    DcMotor Arm2;

    // INITIAL
    public void init(HardwareMap hardwareMap) {
        Arm1 = hardwareMap.dcMotor.get("ARM1");
        Arm2 = hardwareMap.dcMotor.get("ARM2");
    }

    //     ARM
    public void ARMIN (double Arm_1, double Arm_2) {
        Arm1.setPower(Arm_1);
        Arm2.setPower(-Arm_2);
    }

    public void ARMOUT(double Arm_1, double Arm_2){
        Arm1.setPower(-Arm_1);
        Arm2.setPower(Arm_2);
    }

    public void ARMSTOP(){
        Arm1.setPower(0);
        Arm2.setPower(0);
    }

}
