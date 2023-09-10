package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.firstinspires.ftc.teamcode.util.PIDController;

@TeleOp
public class ManualPivotTest extends LinearOpMode {
    private static int target = 0;
    private static int pivotTarget = 0;

    @Override
    public void runOpMode() throws InterruptedException {
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

        waitForStart();
        while(opModeIsActive() && !isStopRequested()) {
            if (gamepad1.a) {
                target += 10;
            } else if (gamepad1.b) {
                target -= 10;
            } else if (gamepad1.x) {
                pivotTarget = 800;
            } else if (gamepad1.y) {
                pivotTarget = 0;
            }
//            slide.setPower(gamepad1.left_stick_y);
            pivot.setTargetPosition(pivotTarget);
            slide.setTargetPosition(target);


            telemetry.addData("slide pos", slide.getCurrentPosition());
            telemetry.addData("pivot pos", pivot.getCurrentPosition());
            telemetry.addData("target", target);
            telemetry.update();
        }
    }
}
