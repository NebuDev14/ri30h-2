package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {

    private double kP, kI, kD;
    private double setpoint = 0;
    private double integralSum = 0, lastError = 0;

    private ElapsedTime timer = new ElapsedTime();

    public PIDController(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
        lastError = 0;
    };

    public double getSetpoint() { return setpoint; }

    public double calculate(double reference) {
        double error = setpoint - reference;
        double derivative = (error - lastError) / timer.seconds();
        integralSum = integralSum + (error * timer.seconds());

        lastError = error;
        timer.reset();

        return (kP * error) + (kI * integralSum) + (kD * derivative);
    }

}