// Copyright 2018-2019 FIRST Tech Challenge Team 12365
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TestingTankMode extends OpMode{
    
    double servo1Pos = 0.775;
    double servo2Pos = 0.175;
    
    int s1count = 2;
    int s2count = 2;
    int sbothcount = 2;

    TestingRobotMap robot = new TestingRobotMap(); // use the class created to define a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    @Override // Code to run ONCE when the driver hits INIT
    public void init() {
        
        // Initialize the hardware variables.
        robot.init(hardwareMap);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Last Modified: March 5th, 2019", "Hello MATES Driver!");
    }

    @Override
    public void init_loop() { //Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    }

    @Override // Code to run ONCE when the driver hits PLAY
    public void start() {
    }

    @Override // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    public void loop() {
        
        robot.servo1.setPosition(servo1Pos);
        robot.servo2.setPosition(servo2Pos);

        if (gamepad1.dpad_left || gamepad2.dpad_left)  {
            runtime.reset();
            while (runtime.seconds() < 0.15) {
                telemetry.addData("waitingL", "Hello MATES Driver!");
            }
            if (s1count % 2 == 0) {
                servo1Pos = 0.3; //closed
            }
            else {
                servo1Pos = 0.775; //open
            }
            s1count++;
        }
        if (gamepad1.dpad_right || gamepad2.dpad_right) {
            runtime.reset();
            while (runtime.seconds() < 0.15) {
            }
            if (s2count % 2 == 0) {
                servo2Pos = 0.69; //closed
            }
            else {
                servo2Pos = 0.175; //open
            }
            s2count++;
        }
        
        if (gamepad1.dpad_down || gamepad2.dpad_down) {
            runtime.reset();
            while (runtime.seconds() < 0.15) {
            }
            if (sbothcount % 2 == 0) {
                servo1Pos = 0.3;
                servo2Pos = 0.69; //closed
            }
            else {
                servo1Pos = 0.775;
                servo2Pos = 0.175; //open
            }
            sbothcount++;
        }
        
        if (gamepad1.right_trigger > 0.2) {
            robot.test1.setPower(gamepad1.right_trigger);
        }
        else if (gamepad1.left_trigger > 0.2) {
            robot.test1.setPower(-gamepad1.left_trigger);
        }
        else if (gamepad2.right_trigger > 0.2) {
            robot.test1.setPower(gamepad2.right_trigger);
        }
        else if (gamepad2.left_trigger > 0.2) {
            robot.test1.setPower(-gamepad2.left_trigger);
        }
        else {
            robot.test1.setPower(0);
        }
        
        if (gamepad1.right_bumper || gamepad2.right_bumper) {
            double pow = 1;
            robot.leftFrontDrive.setPower(-pow);
            robot.leftBackDrive.setPower(-pow);
            robot.rightFrontDrive.setPower(pow);
            robot.rightBackDrive.setPower(-pow);
        }
        else if (gamepad1.left_bumper || gamepad2.left_bumper) {
            double pow = 1;
            robot.leftFrontDrive.setPower(pow);
            robot.leftBackDrive.setPower(pow);
            robot.rightFrontDrive.setPower(-pow);
            robot.rightBackDrive.setPower(pow); 
        }
        else {
            if ((Math.abs(gamepad1.left_stick_y) > 0.2 || Math.abs(gamepad1.right_stick_y) > 0.2)) {
                robot.leftFrontDrive.setPower(gamepad1.left_stick_y);
                robot.leftBackDrive.setPower(-gamepad1.left_stick_y);
                robot.rightFrontDrive.setPower(gamepad1.right_stick_y);
                robot.rightBackDrive.setPower(gamepad1.right_stick_y);
            } else if ((Math.abs(gamepad2.left_stick_y) > 0.2 || Math.abs(gamepad2.right_stick_y) > 0.2)) {
                robot.leftFrontDrive.setPower(gamepad2.left_stick_y);
                robot.leftBackDrive.setPower(-gamepad2.left_stick_y);
                robot.rightFrontDrive.setPower(gamepad2.right_stick_y);
                robot.rightBackDrive.setPower(gamepad2.right_stick_y);
            } else {
                robot.leftFrontDrive.setPower(0);
                robot.leftBackDrive.setPower(0);
                robot.rightFrontDrive.setPower(0);
                robot.rightBackDrive.setPower(0);
            }
        }

    }
    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}
