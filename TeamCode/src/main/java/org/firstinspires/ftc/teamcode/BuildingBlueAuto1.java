/*
Pseudo Code:
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
            // Move forward until in front of first block
            driveTrain.drive(33.5, 0.5);
            // Grab block
            intake.Intake(0.5);
            // Back up a little

            // Strafe left until aligned with foundation

            // Move forward until close to foundation

            // Drop block

            // Back up a little

            // Strafe right until aligned with fourth block

            // Move forward until in front of fourth block

            // Grab block

            // Back up a little

            // Strafe left until aligned with foundation

            // Move forward until close to foundation

            // Drop block

            // Back up a little

            // Strafe right until under alliance bridge

        }
    }
}
