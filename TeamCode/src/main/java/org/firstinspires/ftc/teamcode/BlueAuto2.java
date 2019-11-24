/*
   Auto for:
   - Blue Team
   - Spawn location is near depot
   - Teammate is not going for sky bricks

   Pseudo Code:
   - Move forward until the robot reaches the blocks
   - Check if the brick in front of the robot is a sky block if not, move right until robot is in
     front of next block and repeat process until robot is in front of sky block
   - Move forward while intake is on until sky block is in the intake
   - Back up until robot is a little past original spot
   - Strafe left until next to foundation
   - Push sky block out of intake
   - Strafe right until robot is under the bridge
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BlueAuto2 extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestColorSensor  colorSensor = new TestColorSensor();
    TestIntake intake = new TestIntake();
    boolean brickscan = true;
    int brickdistance = 0;
    int i = 1;

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

        // AUTONOMOUS PERIOD
        while (opModeIsActive()) {
            // MOVING THE ROBOT FORWARD UNTIL IT REACHES THE FIRST BLOCK
            driveTrain.drive(34, 0.5);
            sleep(500);
            runtime.reset();

            // TURNING THE COLOR SENSOR ON
            colorSensor.LED(true);

            // SEEING IF THE BLOCK IN FRONT OF THE ROBOT IS YELLOW
            for(int i = 1; i <= 5, brickscan = true; i++) {
                if(!(colorSensor.Red() > 200 && colorSensor.Green() > 200 && colorSensor.Blue() < 50)) {

                    brickscan = false;

                    // PICK UP BRICK
                    intake.Intake(0.5);
                    sleep(500);
                    runtime.reset();

                    // GO BACKWARDS
                    driveTrain.drive(-5, 0.5);
                    sleep(500);
                    runtime.reset();

                    // STRAFE LEFT
                    driveTrain.strafe(-34 - brickdistance , 0.5);
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