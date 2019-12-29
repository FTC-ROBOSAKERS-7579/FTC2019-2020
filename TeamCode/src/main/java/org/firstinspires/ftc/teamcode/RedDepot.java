package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "BlueSquare_DropBlock")
public class RedDepot extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    boolean brickscan = true;
    int brickdistance = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        // INITIAL CODE
        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);
        cascade.init(hardwareMap);

        // STATUS CODE
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Start Auto
        waitForStart();
        runtime.reset();


        // Move forward until close to first block
        drivetrain.drive(32, 0.5);
        runtime.reset();
        sleep(100);

        // Grab block
        runtime.reset();
        while (runtime.seconds() < 1)
            intake.Intake(0.2);
        runtime.reset();
        intake.Intake(0);
        sleep(100);

        // Back up a little
        drivetrain.drive(-24, 0.5);
        runtime.reset();
        sleep(100);

        // Strafe right until on building side
        drivetrain.strafe(32, 0.5);
        runtime.reset();
        sleep(100);

        // Drop block
        runtime.reset();
        while (runtime.seconds() < 1)
            intake.Intake(-0.2);
        runtime.reset();
        intake.Intake(0);
        sleep(100);

        // Strafe left until aligned with bridge
        drivetrain.strafe(-8, 0.5);
        runtime.reset();
        sleep(100);

    }
}
