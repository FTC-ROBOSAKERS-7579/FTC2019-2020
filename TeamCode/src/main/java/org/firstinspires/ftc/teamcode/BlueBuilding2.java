package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "BlueBuilding_Outside")
public class BlueBuilding2  extends  LinearOpMode{

        AutoDrivetrain drivetrain = new AutoDrivetrain();
        Intake intake = new Intake();
        Cascade cascade = new Cascade();
        ElapsedTime runtime = new ElapsedTime();

        @Override
        public void runOpMode() throws InterruptedException {

            drivetrain.init(hardwareMap);
            intake.autoinit(hardwareMap);
            cascade.init(hardwareMap);

            telemetry.addData("Status", "Initialized");
            telemetry.update();

            waitForStart();
            runtime.reset();

            // Move forward
            drivetrain.drive(2, 0.5);
            runtime.reset();
            sleep(100);


            // Move close to the bridge
            drivetrain.strafe(20,0.5);
            runtime.reset();
            sleep(100);





        }


    }




