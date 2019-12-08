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
    Intake intake = new Intake();
    ElapsedTime runtime = new ElapsedTime();
    Cascade enCas = new Cascade();

    int cas1 = 0;
    int cas2 = 0;


    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain.init(hardwareMap);
        cascade.autoinit(hardwareMap);
//        colorSensor.init(hardwareMap);
        enCas.autoinit(hardwareMap);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

//            driveTrain.drive(5, 0.5);
//            sleep(500);
//            runtime.reset();
//
            driveTrain.strafe(24,0.5);
            sleep(500);
            runtime.reset();

//            driveTrain.drive(-5, 0.5);
//            sleep(500);
//            runtime.reset();
//
//            driveTrain.strafe(-5,0.2);
//            sleep(500);
//            runtime.reset();



//                if(runtime.seconds() >= 3){
//                    cascade.casPow(0);
//               }
//                cascade.casPow(0.1);

//            enCas.autoCascade(5,0.2);
//            runtime.reset();
//            sleep(100);



        telemetry.addData("CAS1: " , cas1 += enCas.getCPOSTION());
        telemetry.addData("CAS2: " , cas2 += enCas.getCPOSTION2());
        telemetry.update();

    }
}


