package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name = "BlueDepot_ParkingInside")
public class BlueDepotParking extends LinearOpMode {

    ElapsedTime runtime = new ElapsedTime();
    AutoDrivetrain driveTrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();

    @Override
    public void runOpMode() throws InterruptedException {
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
        driveTrain.drive(2, 0.5);
        runtime.reset();
    sleep(500);

    // Strafe left close to the Wall
        driveTrain.strafe(24, 0.5);
        runtime.reset();
    sleep(500);

}
}
