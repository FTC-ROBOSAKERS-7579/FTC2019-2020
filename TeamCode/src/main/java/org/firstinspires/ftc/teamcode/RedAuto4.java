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

        while (opModeIsActive()) {
            // MOVE FORWARD UNTIL IT HAS ENOUGH SPACE TO TURN LEFT
            driveTrain.drive(24, 0.5);
            sleep(500);
            runtime.reset();

            // TURN LEFT
            driveTrain.turn(-90, 0.5);
            sleep(500);
            runtime.reset();

            // MOVE FORWARD UNTIL IT IS ALIGNED WITH THE FIRST BLOCK
            driveTrain.drive(56, 0.5);
            sleep(500);
            runtime.reset();

            // TURN RIGHT
            driveTrain.turn(90, 0.5);
            sleep(500);
            runtime.reset();

            // MOVING THE ROBOT FORWARD UNTIL IT REACHES THE FIRST BLOCK
            driveTrain.drive(12, 0.5);
            sleep(500);
            runtime.reset();

            // TURNING THE COLOR SENSOR ON
            colorSensor.LED(true);

            for (int x = 0; x < 5; x++) {

                // SEEING IF THE BLOCK IN FRONT OF THE ROBOT IS YELLOW (1)
                if (colorSensor.Red() > 200 && colorSensor.Green() > 200 && colorSensor.Blue() < 50) {
                    // STRAFING RIGHT UNTIL THE ROBOT IS IN FRONT OF THE NEXT BLOCK
                    driveTrain.strafe(4, 0.5);
                    sleep(500);
                    runtime.reset();

                    // PICK UP BRICK


                    // TURN RIGHT
                    driveTrain.turn(90, 0.5);
                    sleep(500);
                    runtime.reset();

                    // MOVE FORWARD UNTIL PAST THE BRICKS
                    driveTrain.drive(26, 0.5);
                    sleep(500);
                    runtime.reset();

                    // TURN LEFT
                    driveTrain.turn(-90, 0.5);
                    sleep(500);
                    runtime.reset();

                    // MOVE FORWARD UNTIL ALIGNED WITH THE NEUTRAL BRIDGE
                    driveTrain.drive(17, 0.5);
                    sleep(500);
                    runtime.reset();

                    // TURN RIGHT
                    driveTrain.turn(90, 0.5);
                    sleep(500);
                    runtime.reset();

                    // MOVE FORWARD UNTIL THE ROBOT IS IN FRONT OF THE FOUNDATION
                    driveTrain.drive(2, 0.5);
                    sleep(500);
                    runtime.reset();

                    // DROP BRICK

                }
            }
        }
    }
}

