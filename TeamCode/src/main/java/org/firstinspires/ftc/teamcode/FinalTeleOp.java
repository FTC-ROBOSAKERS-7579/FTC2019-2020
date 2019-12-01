package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class FinalTeleOp extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    Drivetrain driveTrain = new Drivetrain();
    TestCascade cascade = new TestCascade();
    Intake Intake = new Intake();
    double speed1 = 1;
    double speed2 = 0.3;
    int motorTicks = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        driveTrain.init(hardwareMap);
        cascade.init(hardwareMap);
        Intake.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

//            colorSensor.LED(true);

            // DRIVE TRAIN
            driveTrain.arcadeDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, speed1);
            if(gamepad1.left_bumper){
                speed1 = 0.3;
            }
            else if(gamepad1.right_bumper){
                speed1 = 1;
            }

            // INTAKE
            if(gamepad2.a) {
                Intake.Intake(0.4);
            }
            else if (gamepad2.y) {
                Intake.Intake(-0.4);
            }else{
                Intake.Intake(0);
            }



            // CASCADE
            if(gamepad2.dpad_up) {
                cascade.casPow(speed2);
            }
            else if(gamepad2.dpad_down) {
                cascade.casPow(-speed2);
            }
            else {
                cascade.casPow(0);
            }
            if(gamepad2.left_bumper) {
                speed2 = 0.3;
            }
            else if(gamepad2.right_bumper) {
                speed2 = 0.5;
            }

        }
    }
}
