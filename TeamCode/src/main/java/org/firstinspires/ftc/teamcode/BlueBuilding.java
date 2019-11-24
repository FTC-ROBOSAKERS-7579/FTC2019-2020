/*
   Pseudo Code:
   1) Move forward a little
   2) Strafe right until aligned with first brick
   3) Move forward until close to first brick
   4) Scan if block is yellow
   5) If so, strafe right until robot is aligned with next block
   6) Loop steps 2 and 3 until the aligned block is not yellow
   7) Grab block
   8) Back up a little
   9) Strafe left until aligned with middle of foundation
   10) Move forward a little
   11) Drop block
   12) Back up a little
   X 13) Strafe right until robot is aligned with the brick that is three bricks past the first sky brick
   X 14) Move forward a little
   X 15) Grab block
   X 16) Back up a little
   X 17) Strafe left until aligned with middle of foundation
   X 18) Move forward a little
   X 19) Drop block
   X 20) Back up a little
   21) Strafe right until robot is under bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BlueBuilding extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestColorSensor colorSensor = new TestColorSensor();
    TestIntake intake = new TestIntake();

    @Override
    public void runOpMode() throws InterruptedException {
        // INITIAL
        driveTrain.init(hardwareMap);
        colorSensor.init(hardwareMap);

        // STATUS
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // START
        waitForStart();
        runtime.reset();
        colorSensor.LED(true);

        // AUTONOMOUS PERIOD
        while (opModeIsActive()) {

        }
    }
}
