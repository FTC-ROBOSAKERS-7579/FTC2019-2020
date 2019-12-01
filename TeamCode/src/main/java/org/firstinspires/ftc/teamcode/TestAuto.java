package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TestAuto extends LinearOpMode {
    AutoDrivetrain driveTrain = new AutoDrivetrain();
        Cascade cascade = new Cascade();
//    TestColorSensor colorSensor = new TestColorSensor();
    ElapsedTime runtime = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException{
        driveTrain.init(hardwareMap);
//        cascade.init(hardwareMap);
//        colorSensor.init(hardwareMap);


        telemetry.addData("Status","Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while(opModeIsActive()) {
//            driveTrain.drive(5, 0.5);
//            sleep(500);
//            runtime.reset();
//
//            driveTrain.strafe(5,0.2);
//            sleep(500);
//            runtime.reset();
//
//            driveTrain.drive(-5, 0.5);
//            sleep(500);
//            runtime.reset();
//
//            driveTrain.strafe(-5,0.2);
//            sleep(500);
//            runtime.reset();

            cascade.autoCascade(5, 0.5);
        }
    }

}
