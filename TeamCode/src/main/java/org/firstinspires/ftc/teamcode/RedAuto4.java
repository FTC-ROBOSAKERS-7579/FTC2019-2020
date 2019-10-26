/*
   Auto for:
   - Red Team
   - Spawn location is near building site
   - Teammate is not going for sky bricks

   Pseudo Code:
   - Move forward until lined up with the blue bridge
   - Turn left
   - Move forward until the robot is next to the first block
   - Turn right
   - Move forward if needed to get closer to brick
   - Check if the brick in front of the robot is a sky block if not, move left until robot is in
     front of next block and repeat process until robot is in front of sky block
   - Move forward while intake is on until sky block is in the intake
   - Back up until robot is a little past original spot
   - Turn right
   - Move forward until robot is next to foundation
   - Turn left
   - Push sky block out of intake
   - Turn left
   - Move forward until robot is under the bridge
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class RedAuto4 extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestRangedSensor rangedSensor = new TestRangedSensor();
    TestColorSensor  colorSensor = new TestColorSensor();

    @Override
    public void runOpMode() throws InterruptedException {
        // INITIAL
        driveTrain.init(hardwareMap);
        rangedSensor.init(hardwareMap);
        colorSensor.init(hardwareMap);

        // STATUS
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // START
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

        }
    }
}
