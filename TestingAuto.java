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

public class TestingAuto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    TestingRobotMap robot = new TestingRobotMap();

    public void runForward(double time) {
        runtime.reset();
        robot.test1.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving forwards!", runtime);
            telemetry.update();
        }
        robot.test1.setPower(0);
    }

    @Override
    public void runOpMode() {
        waitForStart();
        robot.init(hardwareMap);
        
        runForward(3);

    }
}
