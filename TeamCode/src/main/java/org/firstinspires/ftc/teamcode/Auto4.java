package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Auto4 extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);


        // Move forward until close to first block
        drivetrain.drive(13, 0.2);
        sleep(100);
        runtime.reset();

//      Strafe right until aligned with the first skyblock

//      Grab block
        intake.functionIntake(0.2, Intake.POSTION.DOWN);
        sleep(100);
        runtime.reset();

//      Back up until aligned with middle of bridge
        drivetrain.drive(-10,0.2);
        sleep(100);
        runtime.reset();

//      Strafe left until next to foundation
        drivetrain.strafe(-10,0.2);
        sleep(100);
        runtime.reset();

//


    }
}
