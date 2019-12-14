package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Auto5 extends LinearOpMode {
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

//      Move forward a little
        drivetrain.drive(10,0.2);
        runtime.reset();
        sleep(100);

//              
        drivetrain.strafe(20,0.2);
        runtime.reset();
        sleep(100);




    }
}
