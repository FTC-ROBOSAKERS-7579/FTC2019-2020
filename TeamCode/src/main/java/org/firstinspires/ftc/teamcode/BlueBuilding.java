/*
   Pseudo Code:
   - Move forward until lined up with the blue bridge
   - Turn right
   - Move forward until the robot is next to the first block
   - Turn left
   - Move forward if needed to get closer to brick
   - Check if the brick in front of the robot is a sky block if not, move right until robot is in
     front of next block and repeat process until robot is in front of sky block
   - Move forward while intake is on until sky block is in the intake
   - Back up until robot is a little past original spot
   - Turn left
   - Move forward until robot is next to foundation
   - Turn right
   - Push sky block out of intake
   - Turn right
   - Move forward until robot is under the bridge
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BlueBuilding extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestRangedSensor rangedSensor = new TestRangedSensor();
    TestColorSensor colorSensor = new TestColorSensor();
    TestIntake intake = new TestIntake();
    boolean brickscan = true;
    int brickdistance = 0;

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

        // AUTONOMOUS PERIOD
        while (opModeIsActive()) {
            // MOVE FORWARD A LITTLE
            driveTrain.drive(5, 0.5);
            sleep(500);
            runtime.reset();

            // STRAFE RIGHT UNTIL ALIGNED WITH FIRST BLOCK
            driveTrain.strafe(48, 0.5);

            // MOVING THE ROBOT FORWARD UNTIL IT REACHES THE FIRST BLOCK
            driveTrain.drive(34, 0.5);
            sleep(500);
            runtime.reset();

            // TURNING THE COLOR SENSOR ON
            colorSensor.LED(true);

            // SEEING IF THE BLOCK IN FRONT OF THE ROBOT IS YELLOW
            for (int i = 1; i <= 5 && brickscan == true; i++) {
                if (!(colorSensor.Red() > 200 && colorSensor.Green() > 200 && colorSensor.Blue() < 50)) {

                    brickscan = false;

                    // PICK UP BRICK
                    while
                    intake.Intake(0.5);
                    sleep(500);
                    runtime.reset();

                    // GO BACKWARDS
                    driveTrain.drive(5, -0.5);
                    sleep(500);
                    runtime.reset();

                    // STRAFE LEFT
                    driveTrain.strafe(34 + brickdistance, -0.5);
                    sleep(500);
                    runtime.reset();

                    // GO FRONT A LITTLE
                    driveTrain.drive(5, 0.5);
                    sleep(500);
                    runtime.reset();

                    // DROP BRICK
                    intake.Intake(-0.5);
                    sleep(500);
                    runtime.reset();

                } else {

                    // STRAFING RIGHT UNTIL THE ROBOT IS IN FRONT OF THE NEXT BLOCK
                    driveTrain.strafe(8, 0.5);
                    sleep(500);
                    runtime.reset();

                    brickdistance += 8;
                }
            }
        }
    }
}
