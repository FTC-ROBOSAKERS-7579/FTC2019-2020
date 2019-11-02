/*
   Auto for:
   - Blue Team
   - Spawn location is near depot
   - Teammate is going for sky bricks

   Pseudo Code:
   - Move forward a little
   - Turn left
   - Move forward until robot is under blue bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BlueAuto1 extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestRangedSensor rangedSensor = new TestRangedSensor();
    TestColorSensor colorSensor = new TestColorSensor();

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

            // MOVING THE ROBOT FORWARD UNTIL IT CAN TURN LEFT INTO THE ALLIANCE BRIDGE
            driveTrain.drive(24, 0.5);
            sleep(500);
            runtime.reset();

            // TURN LEFT
            driveTrain.turn(-90, 0.5);
            sleep(500);
            runtime.reset();

            // MOVING FORWARD UNTIL WHEEL IS UNDER BRIDGE
            driveTrain.drive(24, 0.5);
            sleep(500);
            runtime.reset();

        }
    }
}