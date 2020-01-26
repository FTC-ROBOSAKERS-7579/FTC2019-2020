package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import android.graphics.drawable.GradientDrawable;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class AutoDrivetrain  {


    DcMotor FRONT_LEFT;
    DcMotor FRONT_RIGHT;
    DcMotor BACK_LEFT;
    DcMotor BACK_RIGHT;



    int POSITON_RIGHT = 0;
    int POSITION_LEFT = 0;

    double MOTOR_COUNT = 1120.0;
    double CIRCUMRENCE=  (Math.PI * 3.97);
    double COUNT_PER_INCH = MOTOR_COUNT / CIRCUMRENCE;
    double error = 0.05;


    BNO055IMU imu;
    Orientation angles;
    Acceleration gravity;



    double currAngle = 0;
    float offset = 0;
    double angle = 0;
    double finalAngle = 0;
    double noAngle = 0;


    HardwareMap hardwareMap;


    public void init(HardwareMap hardwareMap) {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "Imu";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        FRONT_LEFT = hardwareMap.dcMotor.get("FL");
        FRONT_RIGHT = hardwareMap.dcMotor.get("FR");
        BACK_LEFT = hardwareMap.dcMotor.get("BL");
        BACK_RIGHT = hardwareMap.dcMotor.get("BR");


        FRONT_RIGHT.setDirection(DcMotor.Direction.FORWARD);
        FRONT_LEFT.setDirection(DcMotor.Direction.REVERSE);
        BACK_RIGHT.setDirection(DcMotor.Direction.FORWARD);
        BACK_LEFT.setDirection(DcMotor.Direction.REVERSE);


    }

    public void drive(int distance, double power) {
        FRONT_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) (distance * COUNT_PER_INCH));
        FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH));
        BACK_RIGHT.setTargetPosition(POSITON_RIGHT + (int) (distance * COUNT_PER_INCH));
        BACK_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH));

        FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if (distance > 0 && FRONT_RIGHT.getCurrentPosition() <= distance && FRONT_LEFT.getCurrentPosition() <= distance && BACK_LEFT.getCurrentPosition() <= distance && BACK_RIGHT.getCurrentPosition() <= distance) {
            FRONT_RIGHT.setPower(power);
            FRONT_LEFT.setPower(power);
            BACK_RIGHT.setPower(power);
            BACK_LEFT.setPower(power);
        }
        if (distance < 0 && FRONT_RIGHT.getCurrentPosition() >= distance && FRONT_LEFT.getCurrentPosition() >= distance && BACK_LEFT.getCurrentPosition() >= distance && BACK_RIGHT.getCurrentPosition() >= distance) {
            FRONT_RIGHT.setPower(-power);
            FRONT_LEFT.setPower(-power);
            BACK_RIGHT.setPower(-power);
            BACK_LEFT.setPower(-power);
        }
        while (FRONT_RIGHT.isBusy() && FRONT_LEFT.isBusy() && BACK_RIGHT.isBusy() && BACK_LEFT.isBusy()) {

        }
        FRONT_RIGHT.setPower(0);
        FRONT_LEFT.setPower(0);
        BACK_RIGHT.setPower(0);
        BACK_LEFT.setPower(0);

        FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public int getPosition1() {
        return FRONT_LEFT.getTargetPosition();
    }

    public int getPosition2() {
        return FRONT_RIGHT.getTargetPosition();
    }

    public int getPosition3() {
        return BACK_LEFT.getTargetPosition();
    }

    public int getPosition4() {
        return BACK_RIGHT.getTargetPosition();
    }


    public double getAngle() {

        double deltaAngle = getFinalAngle() - angle;

        if(deltaAngle <= -180) {
            deltaAngle += 360;
        } else if (deltaAngle >= 180) {
            deltaAngle -= 360;
        }

        finalAngle += deltaAngle;
        double angleError = 0;

//        angleError = (targetAngle - finalAngle);

        angleError -= (360 *Math.floor(0.5+((angleError / 360.0))));

        return angleError;

    }



    public double getFinalAngle(){
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        return (angles.firstAngle + 360) % 360;
    }



    public void turn(int angle, double power) {

        if (angle > 0) {
            while(getAngle() == angle){
            }
            FRONT_RIGHT.setPower(power);
            FRONT_LEFT.setPower(-power);
            BACK_RIGHT.setPower(power);
            BACK_LEFT.setPower(-power);
        } else if (angle < 0) {
            while(getAngle() == angle){
            }
            FRONT_RIGHT.setPower(-power);
            FRONT_LEFT.setPower(power);
            BACK_RIGHT.setPower(-power);
            BACK_LEFT.setPower(power);
        }
        else {
            FRONT_RIGHT.setPower(0);
            FRONT_LEFT.setPower(0);
            BACK_RIGHT.setPower(0);
            BACK_LEFT.setPower(0);
        }
        resetAngle();
    }



    public void resetAngle(){
        noAngle = getFinalAngle();
    }



    public void strafe (int distance, double power){

        FRONT_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int POSITION_LEFT2 = 0;
        int POSITION_RIGHT2 = 0;




        if (distance > 0 && FRONT_RIGHT.getCurrentPosition() <= distance && FRONT_LEFT.getCurrentPosition() <= distance && BACK_LEFT.getCurrentPosition() <= distance && BACK_RIGHT.getCurrentPosition() <= distance) {
            FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) -(distance * COUNT_PER_INCH) - 100);
            FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH) + 100);
            BACK_RIGHT.setTargetPosition(POSITON_RIGHT + (int) (distance * COUNT_PER_INCH) + 100);
            BACK_LEFT.setTargetPosition(POSITION_LEFT + (int) -(distance * COUNT_PER_INCH) - 100);

            FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FRONT_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BACK_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BACK_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            FRONT_RIGHT.setPower((-power) -0.07);
            FRONT_LEFT.setPower((power) + 0.04);
            BACK_RIGHT.setPower((power) + 0.05);
            BACK_LEFT.setPower((-power)-0.06);
        }





        if (distance < 0 && FRONT_RIGHT.getCurrentPosition() >= distance && FRONT_LEFT.getCurrentPosition() >= distance && BACK_LEFT.getCurrentPosition() >= distance && BACK_RIGHT.getCurrentPosition() >= distance) {
            FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) -(distance * COUNT_PER_INCH) + 90);
            FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH) - 90);
            BACK_RIGHT.setTargetPosition(POSITION_RIGHT2 + (int) (distance * COUNT_PER_INCH) - 90);
            BACK_LEFT.setTargetPosition(POSITION_LEFT2 + (int) -(distance * COUNT_PER_INCH) + 90);

            FRONT_RIGHT.setPower((power)+ 0.07);
            FRONT_LEFT.setPower((-power)- 0.04);
            BACK_RIGHT.setPower((-power) - 0.05);
            BACK_LEFT.setPower((power) + 0.06);
        }


        while ( FRONT_RIGHT.isBusy() && BACK_RIGHT.isBusy() && FRONT_LEFT.isBusy() && BACK_LEFT.isBusy()) {
        }
        FRONT_RIGHT.setPower(0);
        FRONT_LEFT.setPower(0);
        BACK_RIGHT.setPower(0);
        BACK_LEFT.setPower(0);


        FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRONT_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_RIGHT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_LEFT.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}