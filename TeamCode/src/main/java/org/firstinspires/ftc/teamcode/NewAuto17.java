package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;




@Autonomous (name = "Red Building, Parking out")
public class NewAuto17 extends LinearOpMode {
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

        // Moving Close to neutral bridge
        driveTrain.drive(48, 0.5);
        runtime.reset();
        sleep(500);

        // strafe left to middle of bridge
        driveTrain.strafe(-24, 0.5);
        runtime.reset();
        sleep(500);
