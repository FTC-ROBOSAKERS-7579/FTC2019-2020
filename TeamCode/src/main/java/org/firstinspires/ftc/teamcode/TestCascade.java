package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class TestCascade {

    DcMotor Cascade1;
    DcMotor Cascade2;

    int TOTAL_TICKS = 0;

    public void init(HardwareMap hardwareMap) {
        Cascade1 = hardwareMap.dcMotor.get("CAS1");
        Cascade2 = hardwareMap.dcMotor.get("CAS2");
    }

    public void CasPow(double power1, double power2){
        Cascade1.setPower(power1);
        Cascade2.setPower(power2);
    }


}