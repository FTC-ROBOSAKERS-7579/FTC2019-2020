/*
    - Blue team on depot side
    - Red team on building site side
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto1 extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestDriveTrain driveTrain = new TestDriveTrain();

    @Override
    public void runOpMode() throws InterruptedException {
        // INITIAL
        driveTrain.init(hardwareMap);

        // STATUS
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // START
        waitForStart();
        runtime.reset();


        runtime.startTime();

        while (opModeIsActive()) {
            if(runtime.seconds() >= 1){
                driveTrain.frontRight.setPower(0);
                driveTrain.frontLeft.setPower(0);
                driveTrain.backRight.setPower(0);
                driveTrain.backLeft.setPower(0);
            }
            else {
                driveTrain.frontRight.setPower(0.025);
                driveTrain.frontLeft.setPower(0.025);
                driveTrain.backRight.setPower(-0.025);
                driveTrain.backLeft.setPower(0.025);
            }
            if (runtime.seconds() >= 4.5) {
                driveTrain.frontRight.setPower(0);
                driveTrain.frontLeft.setPower(0);
                driveTrain.backRight.setPower(0);
                driveTrain.backLeft.setPower(0);
            } else if(runtime.seconds() >= 1.5){
                driveTrain.frontRight.setPower(0.025);
                driveTrain.frontLeft.setPower(-0.025);
                driveTrain.backRight.setPower(0.025);
                driveTrain.backLeft.setPower(0.025);
            }

        }
    }
}
