package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Cascade {

    DcMotor Cascade1;
    DcMotor Cascade2;

    int CPOSTION = 0;
    int CPOSTION2 = 0;

    double MOTOR_COUNT = 1120.0;
    double HEIGHT = 21.50;
    double COUNT_PER_INCH = MOTOR_COUNT / HEIGHT;

    public void init(HardwareMap hardwareMap) {

        Cascade1 = hardwareMap.dcMotor.get("CAS1");
        Cascade2 = hardwareMap.dcMotor.get("CAS2");


    }

    public void autoinit(HardwareMap hardwareMap){

        Cascade1 = hardwareMap.dcMotor.get("CAS1");
        Cascade2 = hardwareMap.dcMotor.get("CAS2");

        Cascade1.setDirection(DcMotorSimple.Direction.FORWARD);
        Cascade2.setDirection(DcMotorSimple.Direction.REVERSE);

        Cascade1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Cascade2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void teleOpCascade(double power){
        if(getCPOSTION() < 0){
            Cascade1.setPower(0);
            Cascade2.setPower(0);
        }


        Cascade1.setPower(power);
        Cascade2.setPower(power);

    }

    public void autoCascade(int distance, double power){

        Cascade1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Cascade2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Cascade1.setTargetPosition(CPOSTION + (int) (distance * COUNT_PER_INCH));
        Cascade2.setTargetPosition(CPOSTION2 + (int) (distance * COUNT_PER_INCH));

        Cascade1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Cascade2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if(Cascade1.getCurrentPosition() <= distance && Cascade2.getCurrentPosition() <= distance){

            Cascade1.setPower(power - 0.015);
            Cascade2.setPower(power - 0.015);
        }



        while(Cascade1.isBusy() && Cascade2.isBusy()){}

        Cascade1.setPower(0);
        Cascade2.setPower(0);

        Cascade1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Cascade2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public int getCPOSTION(){
        return Cascade1.getCurrentPosition();
    }
    public int getCPOSTION2(){
        return Cascade2.getCurrentPosition();
    }

}
