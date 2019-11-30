package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Cascade {

    DcMotor Cascade1;
    DcMotor Cascade2;

    public void init(HardwareMap hardwareMap) {
        Cascade1 = hardwareMap.dcMotor.get("CAS1");
        Cascade2 = hardwareMap.dcMotor.get("CAS2");

        Cascade1.setDirection(DcMotorSimple.Direction.FORWARD);
        Cascade2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void Cascade(double power){
        Cascade1.setPower(power);
        Cascade2.setPower(power);
    }


}


