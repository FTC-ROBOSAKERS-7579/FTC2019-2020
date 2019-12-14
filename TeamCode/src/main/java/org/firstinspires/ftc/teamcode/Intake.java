package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    DcMotor Intake;

    int INTAKE_POSTION = 0;


    public enum POSTION{
        UP,DOWN
    }

    public void init(HardwareMap hardwareMap) {
        Intake = hardwareMap.dcMotor.get("INTAKE_1");

    }

    public void autoinit(HardwareMap hardwareMap){
        Intake = hardwareMap.dcMotor.get("INTAKE_1");

        Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void Intake(double power) {
        Intake.setPower(power);
    }

    public void functionIntake(double power, POSTION postion){
        Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
     switch (POSTION.UP){
         case UP:
             Intake.setTargetPosition(5500);
             Intake.setPower(power);
             break;
         case DOWN:
             Intake.setTargetPosition(0);
             Intake.setPower(-power);
             break;
         default:
             Intake.setPower(0);
             break;
     }
    }
}
