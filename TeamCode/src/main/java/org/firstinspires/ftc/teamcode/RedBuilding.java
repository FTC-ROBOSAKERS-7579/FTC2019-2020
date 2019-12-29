package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "RedBuilding_ParkingInside")
public class RedBuilding extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    AutoDrivetrain driveTrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    boolean brickscan = true;
    int brickdistance = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        // INITIAL CODE
        driveTrain.init(hardwareMap);
        intake.init(hardwareMap);
        cascade.init(hardwareMap);

        // STATUS CODE
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Start Auto
        waitForStart();
        runtime.reset();


        // Move forward a little
        driveTrain.drive(5, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left close to the Wall
        driveTrain.strafe(-24, 0.5);
        runtime.reset();
        sleep(500);

    }
}
