package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.subsystems.Climber;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@TeleOp
public class TestClimber extends LinearOpMode {

    Climber climb;

    @Override
    public void runOpMode() throws InterruptedException {
        climb.init(hardwareMap);
        waitForStart();
        while(!isStopRequested()) {
            if(gamepad1.left_bumper) {
                climb.releaseClimb();
            }
            climb.setClimbPower(gamepad1.right_trigger - gamepad1.left_trigger);
        }

    }
}
