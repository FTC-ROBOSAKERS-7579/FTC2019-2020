/*
- Move forward until close to neutral bridge
- Strafe left a bit
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "RedBuilding_Outside")
public class P2RedBuilding extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);
        cascade.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // Move forward until close to neutral bridge
        drivetrain.drive(24, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe left a bit
        drivetrain.strafe(-10, 0.5);
        runtime.reset();
        sleep(500);

    }

}