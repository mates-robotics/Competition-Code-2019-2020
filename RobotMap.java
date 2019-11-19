// THE ROBOT MAP CLASS

/* 
The RobotMap class is the class that sets the variables for each part of the robot (motors, servos, etc.).
When we start an autonomous or a teleop mode, we must first create the 'robot' object.
This robot object is created from the RobotMap class, defined in this file.

*/



// GOBILDA Password: matesrobotics123
// Copyright 2018-2019 FIRST Tech Challenge Team 12365

// Importing like everything
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

// Initializing the class
public class RobotMap {

    // Instantiating variables of all of the motors
    public DcMotor leftFrontDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightBackDrive = null;
    public DcMotor claw = null;

    // Initializing elapsedtime (for use in drive by time)
    private ElapsedTime period  = new ElapsedTime();

    // Constructur
    public RobotMap(){
        // This is empty because nothing needs to be done during robot creation
        // Also takes no parameters
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hwMap) {


        // Define and Initialize Motors
        leftFrontDrive = hwMap.get(DcMotor.class, "leftFrontDrive");
        rightFrontDrive = hwMap.get(DcMotor.class, "rightFrontDrive");
        leftBackDrive = hwMap.get(DcMotor.class, "leftBackDrive");
        rightBackDrive = hwMap.get(DcMotor.class, "rightBackDrive");
        claw = hwMap.get(DcMotor.class, "claw");
       
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        claw.setDirection(DcMotor.Direction.FORWARD);
       
        //Set all motors to zero power just in case
        leftFrontDrive.setPower(0);
        rightFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightBackDrive.setPower(0);
        claw.setPower(0);
       
        // Set all motors to run with or without encoders.
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        claw.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        // WHEN USING ENCODER THE TICKS ARE 1440
    }
}

