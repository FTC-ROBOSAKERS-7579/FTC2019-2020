package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestAutoDriveTrain {
    DcMotor FRONT_LEFT;
    DcMotor FRONT_RIGHT;
    DcMotor BACK_LEFT;
    DcMotor BACK_RIGHT;

    int position = FRONT_LEFT.getCurrentPosition();

    HardwareMap hardwareMap;

    // INITIAL
    public void init(HardwareMap hardwareMap){
        FRONT_LEFT = hardwareMap.dcMotor.get("FL");
        FRONT_RIGHT = hardwareMap.dcMotor.get("FR");
        BACK_LEFT = hardwareMap.dcMotor.get("BL");
        BACK_RIGHT = hardwareMap.dcMotor.get("BR");

        FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    // DRIVE
    public void drive(int distance , double power){


        while(position <= distance){
        FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        }
    }





}
