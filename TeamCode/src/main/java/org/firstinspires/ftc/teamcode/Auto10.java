/*
Auto for:
 - Red side
 - Depot side
 - Parking near the wall
 - Teammate has moved the foundation
Pseudo Code:
 - Move forward until close to first block
 - Strafe left until aligned with the first skyblock
 - Grab block
 - Back up until aligned with middle of bridge
 - Strafe right until next to foundation
 - Turn right
 - Drop block
 - Turn left
 - If the first skyblock was the third block, strafe left until aligned with first block
 - If not, strafe left until aligned with the block, 3 blocks past the first skyblock
 - Move forward until close to brick
 - Grab block
 - Back up until aligned with middle of bridge
 - Strafe right until next to foundation
 - Turn right
 - Drop block
 - Turn left
 - Back up until close to wall
 - Strafe left until parked under alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Red_Depot_Wall_Yes")
public class Auto10 extends LinearOpMode {
    AutoDrivetrain driveTrain = new AutoDrivetrain();
    Cascade cascade = new Cascade();
    // TestColorSensor colorSensor = new TestColorSensor();
    Intake intake = new Intake();
    ElapsedTime runtime = new ElapsedTime();
    Cascade enCas = new Cascade();

    int cas1 = 0;
    int cas2 = 0;


    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain.init(hardwareMap);
        cascade.autoinit(hardwareMap);
//      colorSensor.init(hardwareMap);
        enCas.autoinit(hardwareMap);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

    }
}