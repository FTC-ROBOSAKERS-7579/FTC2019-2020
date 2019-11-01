package org.firstinspires.ftc.teamcode;
import android.graphics.drawable.GradientDrawable;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class TestAutoDriveTrain {

    BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

    DcMotor FRONT_LEFT;
    DcMotor FRONT_RIGHT;
    DcMotor BACK_LEFT;
    DcMotor BACK_RIGHT;

    int POSITON_RIGHT= FRONT_LEFT.getCurrentPosition();
    int POSITION_LEFT= FRONT_RIGHT.getCurrentPosition();


    double diameter = 3.76;
    double COUNT_PER_INCH = diameter * Math.PI;
    int COUNTS_MOTOR = 1440;


    BNO055IMU imu;

    Orientation angles;
    Acceleration gravity;



    HardwareMap hardwareMap;

    // INITIAL
    public void init(HardwareMap hardwareMap) {
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        FRONT_LEFT = hardwareMap.dcMotor.get("FL");
        FRONT_RIGHT = hardwareMap.dcMotor.get("FR");
        BACK_LEFT = hardwareMap.dcMotor.get("BL");
        BACK_RIGHT = hardwareMap.dcMotor.get("BR");


        FRONT_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    // DRIVE
    public void drive(int distance, double power) {

            FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) (distance * COUNT_PER_INCH));
            FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH));
            BACK_RIGHT.setTargetPosition(POSITON_RIGHT + (int) (distance * COUNT_PER_INCH));
            BACK_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH));


            FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FRONT_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BACK_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BACK_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            FRONT_RIGHT.setPower(power);
            FRONT_LEFT.setPower(power);
            BACK_RIGHT.setPower(power);
            BACK_LEFT.setPower(power);
        while (FRONT_RIGHT.isBusy() && FRONT_LEFT.isBusy() && BACK_RIGHT.isBusy() && BACK_LEFT.isBusy()) {
            FRONT_RIGHT.setPower(0);
            FRONT_LEFT.setPower(0);
            BACK_RIGHT.setPower(0);
            BACK_LEFT.setPower(0);
        }

            FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FRONT_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BACK_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BACK_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void turn(int angle, double power){

        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();


            if (angle > 0) {
                FRONT_LEFT.setPower(-power);
                BACK_LEFT.setPower(-power);
                FRONT_RIGHT.setPower(power);
                BACK_RIGHT.setPower(power);
            } else if (angle < 0) {
                FRONT_RIGHT.setPower(-power);
                BACK_RIGHT.setPower(-power);
                FRONT_LEFT.setPower(power);
                BACK_LEFT.setPower(power);
            } else {
                FRONT_RIGHT.setPower(0);
                FRONT_LEFT.setPower(0);
                BACK_RIGHT.setPower(0);
                BACK_LEFT.setPower(0);
            }
        }


        public void strafe(int distance, double power){
        
        }
    }

