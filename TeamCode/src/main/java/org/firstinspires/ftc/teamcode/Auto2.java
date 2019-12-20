/*
Auto for:
 - Blue side
 - Depot side
 - Parking near the wall
 - Teammate has moved the foundation
Pseudo Code:
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
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Blue_Depot_Wall_Yes")
public class Auto2 extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);



    }

}
