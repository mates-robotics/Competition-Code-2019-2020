// Copyright 2018-2019 FIRST Tech Challenge Team 12365
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TestServoTM extends OpMode{
    

    TestServoRM robot = new TestServoRM(); // use the class created to define a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();
            
    double servo1Pos = 1;
    double servo2Pos = 0;
    
    int s1count = 2;
    int s2count = 2;


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

        if (gamepad1.left_bumper)  {
            runtime.reset();
            while (runtime.seconds() < 0.15) {
                telemetry.addData("waitingL", "Hello MATES Driver!");
            }
            if (s1count % 2 == 0) {
                servo1Pos = 0.3; //closed
            }
            else {
                servo1Pos = 1; //open
            }
            s1count++;
        }

        if (gamepad1.right_bumper) {
            runtime.reset();
            while (runtime.seconds() < 0.15) {
                telemetry.addData("waitingR", "Hello MATES Driver!");
            }
            if (s2count % 2 == 0) {
                servo2Pos = 0.67; //closed
            }
            else {
                servo2Pos = 0; //open
            }
            s2count++;
        }
        
        
    }
    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}
