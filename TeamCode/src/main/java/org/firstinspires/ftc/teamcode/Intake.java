package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Intake {

    DcMotor Intake;

    ElapsedTime runtime = new ElapsedTime();

    public void init(HardwareMap hardwareMap) {
        Intake = hardwareMap.dcMotor.get("INTAKE");

    }

    public void testIntake(double power){
        Intake.setPower(power);
    }
    public void intakeDown(double power) {
        Intake.setPower(power);
    }

    public void intakeUp(double power) {
        Intake.setPower(power);
    }


}
