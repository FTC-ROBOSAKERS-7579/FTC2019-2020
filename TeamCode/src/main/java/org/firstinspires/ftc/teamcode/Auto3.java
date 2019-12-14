package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Blue_Depot_Outside")
public class Auto3 extends LinearOpMode {
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


//      Move forward until close to first block
        drivetrain.drive(13, 0.2);
        sleep(100);
        runtime.reset();

//      Strafe right until aligned with the first skyblock

//      Grab block
        intake.functionIntake(0.2, Intake.POSTION.DOWN);
        sleep(100);
        runtime.reset();

//      Back up a little
        drivetrain.drive(-10, 0.2);
        sleep(100);
        runtime.reset();

//      Strafe left until aligned with middle of foundation
        drivetrain.strafe(-20,0.2);
        sleep(100);
        runtime.reset();

//      Move forward a little
        drivetrain.drive(-10, 0.2);
        sleep(100);
        runtime.reset();

//      Drop block
        intake.functionIntake(0.2,Intake.POSTION.UP);
        sleep(100);
        runtime.reset();

//      Back up a little
        drivetrain.drive(-9,0.2);
        sleep(100);
        runtime.reset();

//      If the first skyblock was the third block, strafe right until aligned with first block

//      If not, strafe right until aligned with the block, 3 blocks past the first skyblock

//      Move forward a little
        drivetrain.drive(-9,0.2);
        sleep(100);
        runtime.reset();

//      Grab block
        intake.functionIntake(0.2,Intake.POSTION.DOWN);
        sleep(100);
        runtime.reset();

//      Back up a little
        drivetrain.drive(-9,0.2);
        sleep(100);
        runtime.reset();

//      Strafe left until aligned with middle of foundation
        drivetrain.strafe(28,0.2);
        sleep(100);
        runtime.reset();

//      Move forward a little
        drivetrain.drive(-10,0.2);
        sleep(100);
        runtime.reset();

//      Drop Block
        intake.functionIntake(0.2,Intake.POSTION.DOWN);
        sleep(100);
        runtime.reset();

//      Back up a little
        drivetrain.drive(-11,0.2);
        sleep(100);
        runtime.reset();

//      Strafe right until parked under alliance bridge
        drivetrain.strafe(-28,0.2);
        sleep(100);
        runtime.reset();
    }
}
