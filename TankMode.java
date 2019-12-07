//TELEOP MODE WITHOUT SENSOR OUTPUT (NOT NEEDED)

// Copyright 2018-2019 FIRST Tech Challenge Team 12365
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Mode")
public class TankMode extends OpMode{

    double lidPos = 1;
    RobotMap robot = new RobotMap(); // use the class created to define a Pushbot's hardware
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

        //Map:
        //leftFrontDrive      rightFrontDrive
        //leftBackDrive       rightBackDrive

        if (gamepad1.right_bumper || gamepad2.right_bumper) {
            robot.leftFrontDrive.setPower(-1);
            robot.leftBackDrive.setPower(-1);
            robot.rightFrontDrive.setPower(1);
            robot.rightBackDrive.setPower(-1);
        }
        else if (gamepad1.left_bumper || gamepad2.left_bumper) {
            robot.leftFrontDrive.setPower(1);
            robot.leftBackDrive.setPower(1);
            robot.rightFrontDrive.setPower(-1);
            robot.rightBackDrive.setPower(1); 
        }
        else if ((!gamepad1.left_bumper && !gamepad1.right_bumper) && (!gamepad2.left_bumper && !gamepad2.right_bumper)) {
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
        
        
        if (gamepad1.right_trigger != 0) {
            robot.claw.setPower(gamepad1.right_trigger);
        } else if (gamepad1.left_trigger != 0) {
            robot.claw.setPower(-gamepad1.left_trigger);
        } else if (gamepad2.right_trigger != 0) {
            robot.claw.setPower(gamepad2.right_trigger);
        } else if (gamepad2.left_trigger != 0) {
            robot.claw.setPower(-gamepad2.left_trigger);
        } else {
            robot.claw.setPower(0);
        }

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "Left Drive (%.2f), Right Drive (%.2f)", -gamepad1.left_stick_y, gamepad1.right_stick_y);
        telemetry.addData("Current Arm Position", "Left (%.2f), Right (%.2f)", gamepad1.left_trigger, gamepad1.right_trigger);
        telemetry.addData("Status", "Running");
        telemetry.update();
        
    }
    
    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}
