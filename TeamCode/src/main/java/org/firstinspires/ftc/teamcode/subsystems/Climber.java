package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Climber extends Mechanism{
    Servo releaseServo;
    DcMotor climbMotor;
    public void init(HardwareMap hwMap) {
        releaseServo = hwMap.get(Servo.class, "cRelease");
        climbMotor = hwMap.get(DcMotor.class, "climb");
        climbMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void releaseClimb() {
        releaseServo.setPosition(-1);
    }
    public void setClimbPower(double power) {
        climbMotor.setPower(power);
    }
}
