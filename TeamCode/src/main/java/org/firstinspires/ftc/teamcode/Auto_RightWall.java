/*
- Move forward a bit
- Strafe right a bit
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto_RightWall extends LinearOpMode {
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

        // Move forward a bit
        drivetrain.drive(2, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right a bit
        drivetrain.strafe(10, 0.5);
        runtime.reset();
        sleep(500);

    }

}