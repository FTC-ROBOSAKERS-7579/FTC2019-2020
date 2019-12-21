/*
Auto for:
 - Blue side
 - Building side
 - Parking near the wall
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

@Autonomous (name = "Blue_Building_Wall_F")
public class Auto6 extends LinearOpMode {

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

        //go forward a little
        driveTrain.drive(12, 0.2);
        runtime.reset();
        sleep(500);

        //strafe to the right until it reaches first block
        driveTrain.strafe(72, 0.2);
        runtime.reset();
        sleep(500);

        //go forward toward the block
        driveTrain.drive(35, 0.2);
        runtime.reset();
        sleep(500);

        //turn on color sensors

        //WILL ADD CODE TO TURN ON COLOR SENSOR AND TO USE IT
        //WILL USE COLOR SENSOR TO CHECK IF IT SEES YELLOW

        //picks up a block
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //back off till aligned with the bridge
        driveTrain.drive(-35,0.2);
        runtime.reset();
        sleep(500);

        //strafe till aligned with the foundation
        driveTrain.strafe(-72,0.2);
        runtime.reset();
        sleep(500);

        //go forward till at foundation
        driveTrain.drive(35,0.2);
        runtime.reset();
        sleep(500);

        //drop the block
        enCas.autoCascade(5,0.2);
        runtime.reset();
        sleep(500);

        //put intake down
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //put intake up
        intake.functionIntake(0.3, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        enCas.autoCascade(-5, 0.2);
        runtime.reset();
        sleep(500);

        //go backwards till aligned with the bridge
        driveTrain.drive(-35, 0.2);
        runtime.reset();
        sleep(500);

        //strafe right till under the bridge
        driveTrain.strafe(45,0.2);
        runtime.reset();
        sleep(500);

    }

}



