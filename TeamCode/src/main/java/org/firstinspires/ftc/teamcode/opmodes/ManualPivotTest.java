package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Climber;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.util.PIDController;

@TeleOp
public class ManualPivotTest extends LinearOpMode {
    private static int target = 0;
    private static int pivotTarget = 0;


    Climber climb = new Climber();
    Drive drive = new Drive();
    Intake intake = new Intake();


    @Override
    public void runOpMode() throws InterruptedException {
        climb.init(hardwareMap);
        drive.init(hardwareMap);
        intake.init(hardwareMap);

        Servo door = hardwareMap.get(Servo.class, "door");
        Servo piv = hardwareMap.get(Servo.class, "piv");
        DcMotorEx slide = hardwareMap.get(DcMotorEx.class, "slide");
        DcMotorEx pivot = hardwareMap.get(DcMotorEx.class, "pivot");
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setPower(1);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        pivot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pivot.setTargetPosition(0);
        pivot.setPower(1);
        pivot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //800 pivot
        piv.setPosition(0);
        waitForStart();
        while(opModeIsActive() && !isStopRequested()) {
            if (gamepad1.dpad_up) {
                target += 10;
            } else if (gamepad1.dpad_down) {
                target -= 10;
            } else if (gamepad1.x) {
                piv.setPosition(-0.5);
                pivotTarget = 800;
            } else if (gamepad1.y) {
                piv.setPosition(0);
                pivotTarget = 0;
            } else if (gamepad1.a) {
                intake.in();
            } else if (gamepad1.b) {
                intake.out();
            } else if(gamepad1.dpad_right) {
                climb.releaseClimb();
            } else if (gamepad1.dpad_left) {
                intake.stop();
            } else if (gamepad1.left_bumper) {
                door.setPosition(0.5);
            } else if (gamepad1.right_bumper) {
                door.setPosition(0.2);
            }




            //trnhrymjletrmnhlktr.bnedtrkvhlety;mnetlgbm.k;trnhljtlkhmotp;nhkyo
//            slide.setPower(gamepad1.left_stick_y);
            pivot.setTargetPosition(pivotTarget);
            slide.setTargetPosition(target);
            drive.loop(gamepad1);
            climb.setClimbPower(gamepad1.right_trigger - gamepad1.left_trigger);

            telemetry.addData("slide pos", slide.getCurrentPosition());
            telemetry.addData("pivot pos", pivot.getCurrentPosition());
            telemetry.addData("target", target);
            telemetry.update();
        }

    }



}
