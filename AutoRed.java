package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class AutoRed extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    RobotMap robot = new RobotMap();

    public void goForward(double time) {
        runtime.reset();
                robot.leftFrontDrive.setPower(-1);
                robot.leftBackDrive.setPower(1);
                robot.rightFrontDrive.setPower(-1);
                robot.rightBackDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving forwards!", runtime);
            telemetry.update();
        }
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
    }

    public void goBack(double time) {
        runtime.reset();
        robot.rightFrontDrive.setPower(-1);
        robot.rightBackDrive.setPower(1);
        robot.leftFrontDrive.setPower(-1);
        robot.leftBackDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving backwards!", runtime);
            telemetry.update();
        }
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
    }

    public void strafeLeft(double time) {
        runtime.reset();
        robot.leftFrontDrive.setPower(1);
        robot.leftBackDrive.setPower(-1);
        robot.rightFrontDrive.setPower(-1);
        robot.rightBackDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Strafing Left!", runtime);
            telemetry.update();
        }
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
    }

    public void strafeRight(double time) {
        runtime.reset();
        robot.leftFrontDrive.setPower(-1);
        robot.leftBackDrive.setPower(1);
        robot.rightFrontDrive.setPower(1);
        robot.rightBackDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Strafing Right!", runtime);
            telemetry.update();
        }
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
    }

    public void rotateLeft(double time) {
        runtime.reset();
        robot.rightFrontDrive.setPower(1);
        robot.rightBackDrive.setPower(-1);
        robot.leftFrontDrive.setPower(1);
        robot.leftBackDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Rotating left!", runtime);
            telemetry.update();
        }
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
    }

    public void rotateRight(double time) {
        runtime.reset();
        robot.rightFrontDrive.setPower(-1);
        robot.rightBackDrive.setPower(1);
        robot.leftFrontDrive.setPower(-1);
        robot.leftBackDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Rotating right!", runtime);
            telemetry.update();
        }
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
    }

    public void waitTime(double time) {
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Waiting...", runtime);
            telemetry.update();
        }
    }

    @Override
    public void runOpMode() {
        waitForStart();
        robot.init(hardwareMap);
        
        goForward(0.5);


    }
}
