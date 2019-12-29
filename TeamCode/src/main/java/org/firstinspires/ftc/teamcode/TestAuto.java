/*
Auto for:
 - Blue side
 - Depot side
 - Parking near the wall
 - Teammate has not moved the foundation
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
 - Back up until close to wall
 - Strafe right until parked under alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TestAuto extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();


    double p = 0;
    double p2 = 0;
    double p3 = 0;
    double p4 = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        drivetrain.strafe(10,0.2);
        runtime.reset();
        sleep(100);


        p += drivetrain.FRONT_RIGHT.getPower();
        p2 += drivetrain.FRONT_LEFT.getPower();
        p3 += drivetrain.BACK_LEFT.getPower();
        p4 += drivetrain.BACK_RIGHT.getPower();

        telemetry.addData("FR", p);
        telemetry.addData("FL", p2 );
        telemetry.addData("BL", p3 );
        telemetry.addData("BR", p4 );
        telemetry.update();


    }

}

