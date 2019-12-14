package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Blue_Depot_Inside")
public class Auto1 extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);


// FIRST BLOCK
        // Missing color sensor code

        // Strafe right until aligned with the first skyblock
        drivetrain.strafe(15, 0.5);
        runtime.reset();
        sleep(100);

        // Grab block
        intake.functionIntake(0.2, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(100);

        // Back up a little
        drivetrain.drive(-8, 0.2);
        runtime.reset();
        sleep(100);

        // Strafe left until aligned with middle of foundation
        drivetrain.strafe(-5, 0.2);
        runtime.reset();
        sleep(100);

        // Move forward a little
        drivetrain.drive(5, 0.2);
        runtime.reset();
        sleep(100);

        // Drop block
        intake.functionIntake(0.1, Intake.POSTION.UP);
        runtime.reset();
        sleep(100);

        // Back up a little
        drivetrain.drive(-5, 0.2);
        runtime.reset();
        sleep(100);

// SECOND BLOCK
        // If the first skyblock was the third block, strafe right until aligned with first block *ColorSensor code is not working*
        drivetrain.strafe(28, 0.2);
        runtime.reset();
        sleep(100);

        // If not, strafe right until aligned with the block, 3 blocks past the first skyblock *ColorSensor code is not working*


        // Move forward a little
        drivetrain.drive(5, 0.2);
        runtime.reset();
        sleep(100);


        // Grab block
        intake.functionIntake(0.2, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(100);

        // Back up a little
        drivetrain.drive(-5, 0.2);
        runtime.reset();
        sleep(100);

        // Strafe left until aligned with middle of foundation *ColorSensor is not working*
        drivetrain.strafe(-28, 0.2);
        runtime.reset();
        sleep(100);

        // Move forward a little
        drivetrain.drive(5, 0.2);
        runtime.reset();
        sleep(100);

        // Drop block
        intake.functionIntake(0.2, Intake.POSTION.UP);
        runtime.reset();
        sleep(100);

        // Back up until close to wall
        drivetrain.strafe(12, 0.2);
        runtime.reset();
        sleep(100);

        // Strafe right until parked under alliance bridge
        runtime.reset();
        sleep(100);

    }
}

