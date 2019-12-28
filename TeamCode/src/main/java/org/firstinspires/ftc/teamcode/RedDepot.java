package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous (name = "Red Depot, Parking out")
public class RedDepot extends LinearOpMode {
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


        // Keep intake up for first block
        intake.functionIntake(0.2, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        // Drive toward the block
        driveTrain.drive(47, 0.2);
        runtime.reset();
        sleep(500);

        // Put intake down to hold the block
        intake.functionIntake(0.2, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        // Drive Back
        driveTrain.drive(-23, 0.2);
        runtime.reset();
        sleep(500);

        // Strafe to the right till the robot goes to the building site
        driveTrain.strafe(96, 0.2);
        runtime.reset();
        sleep(500);

        // Intake is up to release the block
        intake.functionIntake(0.2, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        // Strafe till the robot reaches the 3rd block
        driveTrain.strafe(-72, 0.2);
        runtime.reset();
        sleep(500);

        // Drive forward toward the block
        driveTrain.drive(23, 0.2);
        runtime.reset();
        sleep(500);

        // Put intake down to hold the block
        intake.functionIntake(0.2, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        // Drive Back
        driveTrain.drive(-23, 0.2);
        runtime.reset();
        sleep(500);

        // Strafe right till the robot reaches the building site
        driveTrain.strafe(60, 0.2);
        runtime.reset();
        sleep(500);

        // Put intake up to release the block
        intake.functionIntake(0.2, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        // Strafe right till the robot gos under the alliance bridge (red one)
        driveTrain.strafe(-12, 0.2);
        runtime.reset();
        sleep(500);

    }
}
