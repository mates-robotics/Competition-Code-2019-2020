// Copyright 2018-2019 FIRST Tech Challenge Team 12365
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Testing Tank Mode")
public class TestingTankMode extends OpMode{

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
        
        robot.test1.setPower(gamepad1.left_stick_y);
        
        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        // if (Math.abs(gamepad1.left_stick_y) > 0) {
        //     robot.test1.setPower(gamepad1.left_stick_y);
        //     }
    }
    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}
