package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class M2BlueDepot extends LinearOpMode {

    ElapsedTime runtime = new ElapsedTime();
    AutoDrivetrain driveTrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    boolean brickscan = true;
    int brickdistance = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        // INITIAL
        driveTrain.init(hardwareMap);
        intake.init(hardwareMap);
        cascade.init(hardwareMap);

        // STATUS
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // START
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            // MOVING THE ROBOT FORWARD UNTIL IT REACHES THE FIRST BLOCK
            driveTrain.drive(34, 0.5);
            sleep(500);

            // GRAB BLOCK


            // BACK UP A LITTLE
            driveTrain.drive(5, -0.5);
            sleep(500);
            runtime.reset();

            // STRAFE LEFT UNTIL ALIGNED WITH MIDDLE OF FOUNDATION
            driveTrain.strafe(76, -0.5);
            sleep(500);
            runtime.reset();

            // MOVE FORWARD A LITTLE
            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // DROP BLOCK


            // BACK UP A LITTLE
            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // STRAFE RIGHT UNTIL ALIGNED WITH THIRD BLOCK
            driveTrain.strafe(92, 0.5);
            sleep(500);
            runtime.reset();

            // MOVE FORWARD A LITTLE
            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // GRAB BLOCK


            // BACK UP A LITTLE
            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // STRAFE LEFT UNTIL ALIGNED WITH MIDDLE OF FOUNDATION
            driveTrain.strafe(92, -0.5);
            sleep(500);
            runtime.reset();

            // MOVE FORWARD A LITTLE
            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // DROP BLOCK


            // BACK UP A LITTLE
            driveTrain.drive(5, -0.5);
            sleep(500);
            runtime.reset();

            // STRAFE RIGHT UNTIL UNDER THE ALLIANCE BRIDGE
            driveTrain.strafe(48, 0.5);
            sleep(500);
            runtime.reset();
        }
    }
}