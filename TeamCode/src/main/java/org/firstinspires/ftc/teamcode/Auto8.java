package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Blue Side, Yes Team, Yes Turn")
public class Auto8 extends LinearOpMode {
    AutoDrivetrain driveTrain = new AutoDrivetrain();
    Cascade cascade = new Cascade();
    // TestColorSensor colorSensor = new TestColorSensor();
    Intake intake = new Intake();
    ElapsedTime runtime = new ElapsedTime();
    Cascade enCas = new Cascade();

    int cas1 = 0;
    int cas2 = 0;


    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain.init(hardwareMap);
        cascade.autoinit(hardwareMap);
//      colorSensor.init(hardwareMap);
        enCas.autoinit(hardwareMap);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

    }
}