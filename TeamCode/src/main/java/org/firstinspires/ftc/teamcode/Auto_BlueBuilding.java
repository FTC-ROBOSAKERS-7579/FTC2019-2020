/*
- Move forward a little
- Strafe right until aligned with first block
- Move forward to brick
- Grab brick
- Back up a little
- Strafe left until aligned with middle of foundation
- Move forward a little
- Drop brick
- Back up a little
- Strafe right until aligned with third brick
- Move forward a little
- Grab brick
- Back up a little
- Strafe left until aligned with right part of foundation
- Move forward a little
- Drop block
- Back up a little
- Strafe right until under bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto_BlueBuilding extends LinearOpMode {
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

        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right until aligned with first block
        drivetrain.strafe(48, 0.5);
        runtime.reset();
        sleep(500);

        // Move forward to brick
        drivetrain.drive(24, 0.5);
        runtime.reset();
        sleep(500);

        // Grab brick
        intake.grab();
        runtime.reset();
        sleep(500);

        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left until aligned with middle of foundation
        drivetrain.strafe(-72, 0.5);
        runtime.reset();
        sleep(500);

        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Drop brick
        intake.open();
        runtime.reset();
        sleep(500);

        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right until aligned with third brick
        drivetrain.strafe(88, 0.5);
        runtime.reset();
        sleep(500);

        // Move forward a little
        drivetrain.drive(10, 0.5);
        runtime.reset();
        sleep(500);

        // Grab brick
        intake.grab();
        runtime.reset();
        sleep(500);

        // Back up a little
        drivetrain.drive(-10, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left until aligned with right part of foundation
        drivetrain.strafe(-72, 0.5);
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

        // Strafe right until under bridge
        drivetrain.strafe(24, 0.5);
        runtime.reset();
        sleep(500);

    }

}