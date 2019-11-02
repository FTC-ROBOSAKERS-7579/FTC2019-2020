/*
   Auto for:
   - Red Team
   - Spawn location is near depot
   - Teammate is going for sky bricks

   Pseudo Code:
   - Move forward a little
   - Turn right
   - Move forward until robot is under blue bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class RedAuto1 extends LinearOpMode {
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
            runtime.reset();

                // Will drive straight
                driveTrain.drive(34, 0.5);
                sleep(500);

                // Color Sensor will turn on
                colorSensor.LED(true);

                // Checks if the robot is near the yellow block and will turn right and go straight to park
                if (colorSensor.Red() > 200 && colorSensor.Green() > 200 && colorSensor.Blue() < 50) {

                    driveTrain.turn(90, 0.5);
                    sleep(500);

                    driveTrain.drive(30, 0.5);
                    sleep(500);
            }
        }
    }
}

