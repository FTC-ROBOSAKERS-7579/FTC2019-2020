package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TestAutoToRight extends LinearOpMode {
    AutoDrivetrain driveTrain = new AutoDrivetrain();
    ElapsedTime runtime = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException{
        driveTrain.init(hardwareMap);


        telemetry.addData("Status","Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        driveTrain.drive(2, 0.5);
        runtime.reset();
        sleep(100);

        driveTrain.strafe(24, 0.5);
        runtime.reset();
        sleep(100);
    }

}
