package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    DcMotor Intake;

    public void init(HardwareMap hardwareMap) {
        Intake = hardwareMap.dcMotor.get("INTAKE_1");
    }

    public void autoinit(HardwareMap hardwareMap){
        Intake = hardwareMap.dcMotor.get("INTAKE_1");

    }

    public void Intake(double power) {
        Intake.setPower(power);
    }

    public void autoIntake(int ticks, double power){

        Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Intake.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (Intake.getCurrentPosition() <= ticks) {

        }


        Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


}
