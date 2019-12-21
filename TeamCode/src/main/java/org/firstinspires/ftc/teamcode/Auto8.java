/*
Auto for:
 - Blue side
 - Building side
 - Parking near the neutral bridge
 - Teammate has moved the foundation
Pseudo Code:
 - Move forward a little
 - Strafe right until aligned with the first block
 - Move forward until close to first block
 - Strafe right until aligned with the first skyblock
 - Grab block
 - Back up until aligned with middle of bridge
 - Strafe left until next to foundation
 - Turn left
 - Drop block
 - Turn right
 - If the first skyblock was the third block, strafe right until aligned with first block
 - If not, strafe right until aligned with the block, 3 blocks past the first skyblock
 - Move forward until close to brick
 - Grab block
 - Back up until aligned with middle of bridge
 - Strafe left until next to foundation
 - Turn left
 - Drop block
 - Turn right
 - Back up until close to wall
 - Strafe right until parked under alliance bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Blue_Building_Bridge_F")
public class Auto8 extends LinearOpMode {

    AutoDrivetrain driveTrain = new AutoDrivetrain();
    Cascade cascade = new Cascade();
    Intake intake = new Intake();
    ElapsedTime runtime = new ElapsedTime();
    Cascade enCas = new Cascade();

    int cas1 = 0;
    int cas2 = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        driveTrain.init(hardwareMap);
        cascade.autoinit(hardwareMap);
        enCas.autoinit(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

    }

}