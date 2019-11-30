package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TestAuto extends LinearOpMode {
    TestAutoDriveTrain driveTrain = new TestAutoDriveTrain();
    TestCascade cascade = new TestCascade();
    TestColorSensor colorSensor = new TestColorSensor();
    ElapsedTime runtime = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException{
        driveTrain.init(hardwareMap);
        cascade.init(hardwareMap);
        colorSensor.init(hardwareMap);


        telemetry.addData("Status","Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while(opModeIsActive()){
            driveTrain.drive(5,0.2);
            sleep(100);
            runtime.reset();
        }
    }

}
