package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    DcMotor Intake;

    public void init(HardwareMap hardwareMap) {
        Intake = hardwareMap.dcMotor.get("INTAKE_1");
    }

    public void Intake(double power) {
        Intake.setPower(power);
    }

}
