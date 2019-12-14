package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Blue side, No Team, No Turn")
public class Auto7 extends LinearOpMode {
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
//      colorSensor.init(hardwareMap);
        enCas.autoinit(hardwareMap);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        //go forward to the foundation
        driveTrain.drive(45, 0.2);
        runtime.reset();
        sleep(500);

        //put intake down to pull the foundation
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //go backwards to pull
        driveTrain.drive(-5, 0.2);
        runtime.reset();
        sleep(500);

        //intake goes up
        intake.functionIntake(0.3, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        //go back until it aligns with bridge
        driveTrain.drive(-28, 0.2);
        runtime.reset();
        sleep(500);

        //strafe until it reaches first block
        driveTrain.strafe(72,0.2);
        runtime.reset();
        sleep(500);

        //drive forward toward the block
        driveTrain.drive(35,0.2);
        runtime.reset();
        sleep(500);

        //turn on color sensors

        //WILL ADD CODE TO TURN ON COLOR SENSOR AND TO USE IT
        //WILL USE COLOR SENSOR TO CHECK IF IT SEES YELLOW

        //picks up a block
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //go backwards until aligned with the bridge
        driveTrain.drive(-35,0.2);
        runtime.reset();
        sleep(500);

        //strafe until it aligns with the foundation
        driveTrain.drive(-72,0.2);
        runtime.reset();
        sleep(500);

        //go towards the foundation
        driveTrain.drive(-35,0.2);
        runtime.reset();
        sleep(500);

        //the lift goes up
        enCas.autoCascade(5,0.2);
        runtime.reset();
        sleep(500);

        //the intake goes down
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //the intake goes up
        intake.functionIntake(0.3, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        //lift does down
        enCas.autoCascade(-5,0.2);
        runtime.reset();
        sleep(500);

        //goes backwards until aligned with the bridge
        driveTrain.drive(-35,0.2);
        runtime.reset();
        sleep(500);

        //strafe to the right until under the bridge
        driveTrain.strafe(45,0.2);
        runtime.reset();
        sleep(500);

    }
}



