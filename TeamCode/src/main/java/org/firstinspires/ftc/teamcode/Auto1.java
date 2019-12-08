package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto1 extends LinearOpMode {
    AutoDrivetrain drivetrain = new AutoDrivetrain();
    Intake intake = new Intake();
    Cascade cascade = new Cascade();
    ElapsedTime runtime = new ElapsedTime();



    public void runOpMode() throws InterruptedException{
        drivetrain.init(hardwareMap);
        intake.autoinit(hardwareMap);
        cascade.init(hardwareMap);

//Move forward until close to first block
        drivetrain.drive(10,0.5);
        runtime.reset();
        sleep(100);

//      Missing color sensor code


//      Strafe right until aligned with the first skyblock
        drivetrain.strafe(15,0.5);
        runtime.reset();
        sleep(100);


//
        intake.grab(0.2, Intake.POSTION.UP);
        runtime.reset();
        sleep(100);


        intake.grab(0.2,Intake.POSTION.DOWN);
        runtime.reset();
        sleep(100);


        drivetrain.drive(-10,0.5);
        runtime.reset();
        sleep(100);



    }


}
