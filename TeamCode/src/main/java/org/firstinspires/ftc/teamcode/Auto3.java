/*
Auto for:
- Red
- Depot

Pseudo Code:
- Move forward until near the first block
- Grab block
- Raise cascade a little
- Back up a little
- Strafe right until aligned with left part of foundation
- Move forward a little
- Drop block
- Back up a little
- Strafe left until aligned with third block
- Lower cascade a little
- Move forward a little
- Grab block
- Raise cascade a little
- Back up a little
- Strafe right until aligned with middle part of foundation
- Move forward a little
- Drop block
- Back up a little
- Strafe left until aligned with fifth block
- Lower cascade a little
- Move forward a little
- Grab block
- Raise cascade a little
- Back up a little
- Strafe right until aligned with right part of foundation
- Move forward a little
- Drop block
- Back up a little
- Strafe left until aligned with alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto3 extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);
        cascade.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // Move forward until near the first block
        drivetrain.drive(32, 0.5);
        runtime.reset();
        sleep(500);

        // Grab block
        intake.grab();
        runtime.reset();
        sleep(500);

        // Raise cascade a little


        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right until aligned with left part of foundation
        drivetrain.strafe(78, 0.5);
        runtime.reset();
        sleep(500);

        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Drop block
        intake.open();
        runtime.reset();
        sleep(500);

        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left until aligned with third block
        drivetrain.strafe(-94, 0.5);
        runtime.reset();
        sleep(500);

        // Lower cascade a little


        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Grab block
        intake.grab();
        runtime.reset();
        sleep(500);

        // Raise cascade a little


        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right until aligned with middle part of foundation
        drivetrain.strafe(78, 0.5);
        runtime.reset();
        sleep(500);

        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Drop block
        intake.open();
        runtime.reset();
        sleep(500);

        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left until aligned with fifth block
        drivetrain.strafe(-94, 0.5);
        runtime.reset();
        sleep(500);

        // Lower cascade a little


        // Move forward a little
        drivetrain.drive(10, 0.5);

        // Grab block
        intake.grab();
        runtime.reset();
        sleep(500);

        // Raise cascade a little


        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right until aligned with right part of foundation
        drivetrain.strafe(78, 0.5);
        runtime.reset();
        sleep(500);

        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Drop block
        intake.open();
        runtime.reset();
        sleep(500);

        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left until aligned with alliance bridge
        drivetrain.strafe(-42, 0.5);
        runtime.reset();
        sleep(500);

    }

}
