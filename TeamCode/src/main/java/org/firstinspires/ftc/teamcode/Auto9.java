package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.AutoDrivetrain;
import org.firstinspires.ftc.teamcode.Cascade;
import org.firstinspires.ftc.teamcode.Intake;

@Autonomous(name = "Red side, No Team, No Turn")
public class Auto9 extends LinearOpMode {
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

        //drive forward
        driveTrain.drive(12, 0.2);
        runtime.reset();
        sleep(500);

        //strafe to the right until it reaches the first block
        driveTrain.strafe(24, 0.2);
        runtime.reset();
        sleep(500);

        //drives toward the block
        driveTrain.drive(35, 0.2);
        runtime.reset();
        sleep(500);

        //turn on color sensors

        //WILL ADD CODE TO TURN ON COLOR SENSOR AND TO USE IT
        //WILL USE COLOR SENSOR TO CHECK IF IT SEES YELLOW

        //intake is down to get the block
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //drive backwards until aligned with the bridge
        driveTrain.drive(-35, 0.2);
        runtime.reset();
        sleep(500);

        //strafe to the right until aligned with the foundation
        driveTrain.drive(72, 0.2);
        runtime.reset();
        sleep(500);

        //drive forward toward foundation
        driveTrain.drive(35, 0.2);
        runtime.reset();
        sleep(500);

        //cascade goes up
        enCas.autoCascade(5, 0.2);
        runtime.reset();
        sleep(500);

        //intake goes down to drop the block
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //intake goes up
        intake.functionIntake(0.3, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        //drive back a little
        driveTrain.drive(-1, 0.2);
        runtime.reset();
        sleep(500);

        //cascade goes back down
        enCas.autoCascade(-5, 0.2);
        runtime.reset();
        sleep(500);

        //intake goes down
        intake.functionIntake(0.3, Intake.POSTION.DOWN);
        runtime.reset();
        sleep(500);

        //goes back a little to pull the foundation
        driveTrain.drive(-5, 0.2);
        runtime.reset();
        sleep(500);

        //the intake goes up again
        intake.functionIntake(0.3, Intake.POSTION.UP);
        runtime.reset();
        sleep(500);

        //goes back until aligned with the bridge
        driveTrain.drive(-30, 0.2);
        runtime.reset();
        sleep(500);

        //strafes to the left until under the bridge
        driveTrain.strafe(-45, 0.2);
        runtime.reset();
        sleep(500);

    }
}


