


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class FinalTeleOp extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    Drivetrain driveTrain = new Drivetrain();
    Cascade cascade = new Cascade();
    Intake intake = new Intake();

    double speed1 = 0.4;
    double speed2 = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {

        driveTrain.init(hardwareMap);
        cascade.init(hardwareMap);
        intake.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            driveTrain.arcadeDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, speed1);
            // DRIVE TRAIN
            if(gamepad1.left_bumper){
                speed1 = 0.3;
            }
            else if(gamepad1.right_bumper){
                speed1 = 0.5;
            }


            // INTAKE
            if(gamepad2.a) {
                intake.grab();
            }
            else if (gamepad2.y) {
                intake.open();
            }



            // CASCADE
            if(gamepad2.dpad_up) {
                cascade.teleOpCascade(speed2);
            }
            else if(gamepad2.dpad_down) {
                cascade.teleOpCascade(-speed2);
            }
            else {
                cascade.teleOpCascade(0);
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