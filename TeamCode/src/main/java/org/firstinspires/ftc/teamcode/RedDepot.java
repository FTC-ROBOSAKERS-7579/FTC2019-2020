///*
//   Pseudo Code:
//   1) Move forward until close to first brick
//   2) Scan if block is yellow
//   3) If so, strafe left until robot is aligned with next block
//   4) Loop steps 2 and 3 until the aligned block is not yellow
//   5) Grab block
//   6) Back up a little
//   7) Strafe right until aligned with middle of foundation
//   8) Move forward a little
//   9) Drop block
//   10) Back up a little
//   X 11) Strafe left until robot is aligned with the brick that is three bricks past the first sky brick
//   X 12) Move forward a little
//   X 13) Grab block
//   X 14) Back up a little
//   X 15) Strafe right until aligned with middle of foundation
//   X 16) Move forward a little
//   X 17) Drop block
//   X 18) Back up a little
//   19) Strafe left until robot is under bridge
//*/
//
//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//@Autonomous
//public class RedDepot extends LinearOpMode{
//    ElapsedTime runtime = new ElapsedTime();
//    AutoDrivetrain driveTrain = new AutoDrivetrain();
//    ColorSensor colorSensor = new ColorSensor();
//    Intake intake = new Intake();
//    boolean brickscan = true;
//    int brickdistance = 0;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//        // INITIAL
//        driveTrain.init(hardwareMap);
//        colorSensor.init(hardwareMap);
//
//        // STATUS
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//
//        // START
//        waitForStart();
//        runtime.reset();
//        colorSensor.LED(true);
//
//        while (opModeIsActive()) {
//
//            // MOVING THE ROBOT FORWARD UNTIL IT REACHES THE FIRST BLOCK
//            driveTrain.drive(34, 0.5);
//            sleep(500);
//            runtime.reset();
//
//            // SEEING IF THE BLOCK IN FRONT OF THE ROBOT IS YELLOW
//            for (int i = 1; i <= 5 && brickscan; i++) {
//                if (!(colorSensor.Red() > 200 && colorSensor.Green() > 200 && colorSensor.Blue() < 50)) {
//
//                    brickscan = false;
//
//                    // PICK UP BRICK
//                    while(runtime.seconds() < 1) {
//
//                        intake.Intake(0.5);
//                        sleep(500);
//                        runtime.reset();
//
//                    }
//
//                    // GO BACKWARDS
//                    driveTrain.drive(5, -0.5);
//                    sleep(500);
//                    runtime.reset();
//
//                    // STRAFE RIGHT
//                    driveTrain.strafe(34 + brickdistance, 0.5);
//                    sleep(500);
//                    runtime.reset();
//
//                    // GO FORWARD A LITTLE
//                    driveTrain.drive(5, 0.5);
//                    sleep(500);
//                    runtime.reset();
//
//                    // DROP BRICK
//                    while(runtime.seconds() < 1) {
//
//                        intake.Intake(-0.5);
//                        sleep(500);
//                        runtime.reset();
//
//                    }
//
//                    // BACK UP A LITTLE
//                    driveTrain.drive(5, -0.5);
//                    sleep(500);
//                    runtime.reset();
//
//                    // STRAFE LEFT
//                    driveTrain.strafe(24, -0.5);
//                    sleep(500);
//                    runtime.reset();
//
//                } else {
//
//                    // STRAFING LEFT UNTIL THE ROBOT IS IN FRONT OF THE NEXT BLOCK
//                    driveTrain.strafe(8, -0.5);
//                    sleep(500);
//                    runtime.reset();
//
//                    brickdistance += 8;
//
//                }
//            }
//        }
//    }
//
//}
