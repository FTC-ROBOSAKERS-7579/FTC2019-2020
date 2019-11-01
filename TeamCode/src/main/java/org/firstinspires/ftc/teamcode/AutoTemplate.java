package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class AutoTemplate extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
//    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
//    TestRangedSensor rangedSensor = new TestRangedSensor();
    TestColorSensor  colorSensor = new TestColorSensor();

    @Override
    public void runOpMode() throws InterruptedException {
        // INITIAL
//        driveTrain.init(hardwareMap);
//        rangedSensor.init(hardwareMap);
        colorSensor.init(hardwareMap);

        // STATUS
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // START
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            colorSensor.LED(false);

            telemetry.addData("red: ", colorSensor.Red());
            telemetry.addData("blue: ", colorSensor.Blue());
            telemetry.addData("green: ",colorSensor.Green());
            telemetry.addData("alpha: ",colorSensor.Alpha());
            telemetry.update();

        }
    }
}
