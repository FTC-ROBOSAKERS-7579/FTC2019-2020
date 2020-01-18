/*
- Move forward a little
- Strafe left until aligned with first block
- Move forward to brick
- Grab brick
- Back up a little
- Strafe right until aligned with middle of foundation
- Move forward a little
- Drop brick
- Back up a little
- Strafe left until aligned with third brick
- Move forward a little
- Grab brick
- Back up a little
- Strafe right until aligned with right part of foundation
- Move forward a little
- Drop block
- Back up a little
- Strafe left until under bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto_RedBuilding extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // Move forward a little


        // Strafe left until aligned with first block


        // Move forward to brick


        // Grab brick


        // Back up a little


        // Strafe right until aligned with middle of foundation


        // Move forward a little


        // Drop brick


        // Back up a little


        // Strafe left until aligned with third brick


        // Move forward a little


        // Grab brick


        // Back up a little


        // Strafe right until aligned with right part of foundation


        // Move forward a little


        // Drop block


        // Back up a little


        // Strafe left until under bridge


    }

}


