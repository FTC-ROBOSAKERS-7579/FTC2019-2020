package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class TeleOp extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    DriveTrain driveTrain = new DriveTrain();
    Cascade cascade = new Cascade();
    Intake Intake = new Intake();

    double speed1 = 0.4;
    double speed2 = 0.4;

    int casvaule = 0;
    int casvaule2 = 0;

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
                Intake.grab();
            }
            else if (gamepad2.y) {
                Intake.open();
            }



            // CASCADE
            if(gamepad2.dpad_up) {
                cascade.teleOpCascade(speed2);
                telemetry.addData("CAS1: " , casvaule += cascade.getCPOSTION());
                telemetry.addData("CAS2: " , casvaule2 += cascade.getCPOSTION2());
                telemetry.update();
            }
            else if(gamepad2.dpad_down) {
                cascade.teleOpCascade(-speed2);
                telemetry.addData("CAS1: " , casvaule -= cascade.getCPOSTION());
                telemetry.addData("CAS2: " , casvaule2 -= cascade.getCPOSTION2());
                telemetry.update();
            }


            if(casvaule < 0){
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

