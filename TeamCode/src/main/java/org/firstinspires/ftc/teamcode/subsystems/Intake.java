package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends Mechanism{
    private DcMotor intakeMotor;

    @Override
    public void init(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "intake");
    }

    public void in() {
        intakeMotor.setPower(1);
    }

    public void out() {
        intakeMotor.setPower(-1);
    }

    public void stop() {
        intakeMotor.setPower(0);
    }
}
