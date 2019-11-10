package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class TestTeleOp extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    TestDriveTrain Dtrain = new TestDriveTrain();
//    TestCascade cascade = new TestCascade();
//    TestIntake Intake = new TestIntake();


    @Override
    public void runOpMode() throws InterruptedException {

        Dtrain.init(hardwareMap);
//        cascade.init(hardwareMap);
//        Intake.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // DRIVE TRAIN
            Dtrain.arcadeDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

            // INTAKE
//            if(gamepad1.x)
//                Intake.ARMIN(0.4, 0.2);
//
//            else if(gamepad1.y)
//                Intake.ARMOUT(0.4, 0.2);
//
//            else
//                Intake.ARMSTOP();

            // CASCADE
//            if (gamepad1.dpad_up)
//                cascade.CasPow(0.4, -0.4);
//            else if (gamepad1.dpad_down)
//                cascade.CasPow(-0.4, 0.4);
//            else
//                cascade.CasPow(0, 0);
//
//        }

        }


    }
}
