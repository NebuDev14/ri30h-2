package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.subsystems.Climber;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Drive;

@TeleOp
public class TestClimber extends LinearOpMode {

    Climber climb = new Climber();
    Drive drive = new Drive();
    Intake intake = new Intake();

    @Override
    public void runOpMode() throws InterruptedException {
        climb.init(hardwareMap);
        drive.init(hardwareMap);
        intake.init(hardwareMap);
        waitForStart();
        while(!isStopRequested()) {
            if(gamepad1.left_bumper) {
                climb.releaseClimb();
            }
            if(gamepad1.a) {
                intake.in();
            }
            if(gamepad1.b) {
                intake.out();
            }

            drive.loop(gamepad1);
            climb.setClimbPower(gamepad1.right_trigger - gamepad1.left_trigger);
        }

    }
}
