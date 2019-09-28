package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class TestTeleOp extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();

    public DcMotor FRONT_RIGHT;
    public DcMotor FRONT_LEFT;
    public DcMotor BACK_RIGHT;
    public DcMotor BACK_LEFT;


    public void runOpMode() throws InterruptedException{
        if(gamepad1.a){
            FRONT_RIGHT.setPower(0.5);
        }
        else if(gamepad1.)
    }





}
