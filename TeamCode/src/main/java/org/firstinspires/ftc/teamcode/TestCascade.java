package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestCascade {

    DcMotor Cascade1;
    DcMotor Cascade2;

    public void init(HardwareMap hardwareMap) {

        Cascade1 = hardwareMap.dcMotor.get("Cascade_1");
        Cascade2 = hardwareMap.dcMotor.get("Cascade_2");
    
    }

    public void CasPow(double power){

        Cascade1.setPower(power);
        Cascade2.setPower(-power);

    }

}


