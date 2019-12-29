/*
Pseudo Code:
 - Move forward until close to first block
 - Strafe right until aligned with the first skyblock
 - Grab block
 - Back up a little
 - Strafe left until aligned with middle of foundation
 - Move forward a little
 - Drop block
 - Back up a little
 - If the first skyblock was the third block, strafe right until aligned with first block
 - If not, strafe right until aligned with the block, 3 blocks past the first skyblock
 - Move forward a little
 - Grab block
 - Back up a little
 - Strafe left until aligned with middle of foundation
 - Move forward a little
 - Drop block
 - Back up a little
 - Strafe right until parked under alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "BlueDepot_DropBlock")
public class BlueDepot extends LinearOpMode {

    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() throws InterruptedException {

        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // Move forward until close to first block
        drivetrain.drive(32, 0.5);
        runtime.reset();
        sleep(100);

        // Grab block
        runtime.reset();
        while (runtime.seconds() < 1)
            intake.Intake(0.2);
        runtime.reset();
        intake.Intake(0);
        sleep(100);


        // Back up a little
        drivetrain.drive(-24, 0.5);
        runtime.reset();
        sleep(100);

        // Strafe left until on building side
        drivetrain.strafe(32, -0.5);
        runtime.reset();
        sleep(100);

        // Drop block
        runtime.reset();
        while (runtime.seconds() < 1)
            intake.Intake(-0.2);
        runtime.reset();
        intake.Intake(0);
        sleep(100);

        // Strafe right until aligned with third block
        drivetrain.strafe(8, 0.5);
        runtime.reset();
        sleep(100);

    }

}