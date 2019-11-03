package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

    public class TestDriveTrain {

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


        }

        public void tankDrive(double right, double left){
            frontLeft.setPower((left) * S_R);
            frontRight.setPower((right) * S_R);
            backLeft.setPower((left) * S_R);
            backRight.setPower((right) * S_R);
        }

        public void arcadeDrive(double linear, double rotation, double strafe){
            frontLeft.setPower((linear - rotation + strafe) * S_R);
            frontRight.setPower((-linear - rotation - strafe) * S_R);
            backLeft.setPower((-linear + rotation + strafe) * S_R);
            backRight.setPower((-linear - rotation + strafe) * S_R);
        }

    }


