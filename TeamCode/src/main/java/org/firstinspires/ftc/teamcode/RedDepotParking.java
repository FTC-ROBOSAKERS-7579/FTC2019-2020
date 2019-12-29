/*
Pseudo Code:
 - Move forward a little
 - Strafe right until aligned with the first block
 - Move forward until close to first block
 - Grab block
 - Back up a little
 - Strafe left until on building side
 - Drop block
 - Strafe right until aligned with third block
 - Move forward a little
 - Grab block
 - Back up a little
 - Strafe left until on building side
 - Drop block
 - Strafe right until parked under alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RedDepot_ParkingInside")
public class RedDepotParking extends LinearOpMode {

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

        // Move forward a little


        // Strafe right close to the wall
        drivetrain.strafe(24, -0.5);
        runtime.reset();
        sleep(500);


    }

}
