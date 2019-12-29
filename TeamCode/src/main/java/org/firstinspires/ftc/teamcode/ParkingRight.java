/*
Pseudo Code:
 - Move forward a little
 - Strafe right until under alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Red Depot, Parking in")
public class ParkingRight extends LinearOpMode {
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

        // START AUTO
        waitForStart();
        runtime.reset();

        // Move forward a l ittle
        driveTrain.drive(12, 0.5);
        runtime.reset();
        sleep(500);

        // Strafe right to the middle of the bridge
        driveTrain.strafe(24, 0.5);
        runtime.reset();
        sleep(500);

    }

}