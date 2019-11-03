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

    // public void TARGET

    public void RUN(){
        Cascade1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void RUNWITHENCODER(){
        Cascade1.setMode((DcMotor.RunMode.RUN_WITHOUT_ENCODER));
    }

    public void DIRECTION(){
        Cascade1.setDirection(DcMotor.Direction.REVERSE);
    }

    public int GETTICKS(){
        return TOTAL_TICKS += Cascade1.getCurrentPosition();
    }

    public void RESET(){
        Cascade1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void HARDSTOP(double power){
        if(Cascade1.getCurrentPosition() >= 4800){
            Cascade1.setPower(0);
            Cascade2.setPower(0);
        }
        else{
            Cascade1.setPower(power);
            Cascade2.setPower(power);
        }
    }
}