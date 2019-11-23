/*
Pseudo Code:
 - Move forward a little
 - Strafe right until aligned with first block
 - Move forward until in front of first block
 - Grab block
 - Back up a little
 - Strafe left until aligned with foundation
 - Move forward until close to foundation
 - Drop block
 - Back up a little
 - Strafe right until aligned with fourth block
 - Move forward until in front of fourth block
 - Grab block
 - Back up a little
 - Strafe left until aligned with foundation
 - Move forward until close to foundation
 - Drop block
 - Back up a little
 - Strafe right until under alliance bridge
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BuildingBlueAuto1  extends LinearOpMode{
    ElapsedTime runtime = new ElapsedTime();
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestColorSensor  colorSensor = new TestColorSensor();
    TestIntake intake = new TestIntake();

    @Override
    public void runOpMode() throws InterruptedException {
        // INITIAL
        driveTrain.init(hardwareMap);
        colorSensor.init(hardwareMap);

        // STATUS
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // START
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            // Move forward a little

            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // Strafe right until aligned with first block

            driveTrain.strafe(48, 0.5);
            sleep(500);
            runtime.reset();

            // Move forward until in front of first block

            driveTrain.drive(29, 0.5);
            sleep(500);
            runtime.reset();

            // Grab block

            intake.Intake(0.5);
            sleep(500);
            runtime.reset();

            // Back up a little

            driveTrain.drive(-5, 0.5);
            sleep(500);
            runtime.reset();

            // Strafe left until aligned with foundation

            driveTrain.strafe(-80, 0.5);
            sleep(500);
            runtime.reset();

            // Move forward until close to foundation

            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // Drop block

            intake.Intake(0.5);
            sleep(500);
            runtime.reset();

            // Back up a little

            driveTrain.drive(-5, 0.5);
            sleep(500);
            runtime.reset();

            // Strafe right until aligned with fourth block

            driveTrain.strafe(104, 0.5);
            sleep(500);
            runtime.reset();

            // Move forward until in front of fourth block

            driveTrain.drive(5,0.5);
            sleep(500);
            runtime.reset();

            // Grab block

            intake.Intake(0.5);
            sleep(500);
            runtime.reset();

            // Back up a little

            driveTrain.drive(-5, 0.5);
            sleep(500);
            runtime.reset();

            // Strafe left until aligned with foundation

            driveTrain.drive(-104, 0.5);
            sleep(500);
            runtime.reset();

            // Move forward until close to foundation

            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // Drop block

            intake.Intake(0.5);
            sleep(500);
            runtime.reset();

            // Back up a little

            driveTrain.drive(-5, 0.5);
            sleep(500);
            runtime.reset();

            // Strafe right until under alliance bridge

            driveTrain.strafe(48, 0.5);
            sleep(500);
            runtime.reset();
        }
    }
}
