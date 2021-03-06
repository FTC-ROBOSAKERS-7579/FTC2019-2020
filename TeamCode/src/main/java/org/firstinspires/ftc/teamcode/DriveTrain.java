package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DriveTrain {

    double count = 0;

    ElapsedTime runtime = new ElapsedTime();

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    private double S_R = 0.5;

    public void init(HardwareMap hardwareMap){

        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

    }


    public void arcadeDrive(double linear, double rotation, double strafe, double speed){

        frontLeft.setPower((linear - rotation + strafe) * speed );
        frontRight.setPower((-linear - rotation - strafe) * speed * 0.5);
        backLeft.setPower((linear - rotation - strafe) * speed );
        backRight.setPower((-linear - rotation + strafe) * speed * 0.5);

    }

    public double currentCount(){
        return count += frontLeft.getCurrentPosition();
    }

    public void reset(){
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
