package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;

import android.graphics.drawable.GradientDrawable;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class AutoDrivetrain {

    BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

    DcMotor FRONT_LEFT;
    DcMotor FRONT_RIGHT;
    DcMotor BACK_LEFT;
    DcMotor BACK_RIGHT;

    int POSITON_RIGHT = 0;
    int POSITION_LEFT = 0;

    double MOTOR_COUNT = 1120.0;
    int GEAR_REDUCTION = 4;
    double DIAMETER = Math.PI * 4;
    double COUNT_PER_INCH = MOTOR_COUNT / DIAMETER;


    BNO055IMU imu;
    Orientation angles;
    Acceleration gravity;
    float currAngle = 0;


    HardwareMap hardwareMap;


    public void init(HardwareMap hardwareMap) {
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






//    public void turn(int angle, double power) {
//
//        angles = this.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
//        this.imu.getPosition();
//        currAngle = angles.firstAngle;
//
//
//        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
//        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
//        parameters.loggingEnabled = true;
//        parameters.loggingTag = "IMU";
//        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
//
//        if (angle < currAngle) {
//            if (angle < 0) {
//                FRONT_RIGHT.setPower(power);
//                FRONT_LEFT.setPower(-power);
//                BACK_RIGHT.setPower(power);
//                BACK_LEFT.setPower(-power);
//            } else if (angle > 0) {
//                FRONT_RIGHT.setPower(-power);
//                FRONT_LEFT.setPower(power);
//                BACK_RIGHT.setPower(-power);
//                BACK_LEFT.setPower(power);
//            }
//        }
//
//        angle = (int)currAngle;
//    }


//    public void resetAngle(){
//        if(getAngle() > 0 || getAngle() < 0){
//            turn(0,0);
//        }
//    }

//    public int getAngle(){
//        angles = this.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
//        this.imu.getPosition();
//        currAngle = angles.firstAngle;
//        return (int)currAngle;
//    }


        public void strafe (int distance, double power){

            FRONT_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FRONT_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BACK_LEFT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BACK_RIGHT.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            int POSITION_LEFT2 = 0;
            int POSITION_RIGHT2 = 0;
            FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) -(distance * COUNT_PER_INCH) - 130);
            FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH) + 130);
            BACK_RIGHT.setTargetPosition(POSITION_RIGHT2 + (int) (distance * COUNT_PER_INCH) + 130);
            BACK_LEFT.setTargetPosition(POSITION_LEFT2 + (int) -(distance * COUNT_PER_INCH) - 130);


            FRONT_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FRONT_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BACK_RIGHT.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BACK_LEFT.setMode(DcMotor.RunMode.RUN_TO_POSITION);


                if (distance > 0 && FRONT_RIGHT.getCurrentPosition() <= distance && FRONT_LEFT.getCurrentPosition() <= distance && BACK_LEFT.getCurrentPosition() <= distance && BACK_RIGHT.getCurrentPosition() <= distance) {
                    FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) -(distance * COUNT_PER_INCH) - 130);
                    FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH) + 130);
                    BACK_RIGHT.setTargetPosition(POSITION_RIGHT2 + (int) (distance * COUNT_PER_INCH) + 130);
                    BACK_LEFT.setTargetPosition(POSITION_LEFT2 + (int) -(distance * COUNT_PER_INCH) - 130);

                    FRONT_RIGHT.setPower((-power) + 0.015);
                    FRONT_LEFT.setPower((power));
                    BACK_RIGHT.setPower((power));
                    BACK_LEFT.setPower((-power) + 0.015);
                }
                if (distance < 0 && FRONT_RIGHT.getCurrentPosition() >= distance && FRONT_LEFT.getCurrentPosition() >= distance && BACK_LEFT.getCurrentPosition() >= distance && BACK_RIGHT.getCurrentPosition() >= distance) {
                    FRONT_RIGHT.setTargetPosition(POSITON_RIGHT + (int) -(distance * COUNT_PER_INCH) + 90);
                    FRONT_LEFT.setTargetPosition(POSITION_LEFT + (int) (distance * COUNT_PER_INCH) - 90);
                    BACK_RIGHT.setTargetPosition(POSITION_RIGHT2 + (int) (distance * COUNT_PER_INCH) - 90);
                    BACK_LEFT.setTargetPosition(POSITION_LEFT2 + (int) -(distance * COUNT_PER_INCH) + 90);

                    FRONT_RIGHT.setPower(power);
                    FRONT_LEFT.setPower((-power) + 0.0145);
                    BACK_RIGHT.setPower((-power) + 0.0145);
                    BACK_LEFT.setPower(power);
                }


                while (FRONT_RIGHT.isBusy() && BACK_RIGHT.isBusy() && FRONT_LEFT.isBusy() && BACK_LEFT.isBusy()) {
                }
                FRONT_RIGHT.setPower(0);
                FRONT_LEFT.setPower(0);
                BACK_RIGHT.setPower(0);
                BACK_LEFT.setPower(0);
            }
        }
    

