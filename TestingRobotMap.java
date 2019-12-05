// Copyright 2018-2019 FIRST Tech Challenge Team 12365
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

public class TestingRobotMap {

    /* Public OpMode members. */
    public Servo servo1 = null;
    public Servo servo2 = null;
    public DcMotor test1 = null;

    /* local OpMode members. */
    private ElapsedTime period  = new ElapsedTime();


    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hwMap) {

        // Save reference to Hardware map

        // Define and Initialize Motors
        test1 = hwMap.get(DcMotor.class, "test1");
        servo1 = hwMap.get(Servo.class, "servo1");
        servo2 = hwMap.get(Servo.class, "servo2");


        test1.setDirection(DcMotor.Direction.FORWARD);

        //Set all motors to zero power
        test1.setPower(0);
        
        // Set all motors to run with or without encoders.
        test1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.

        //colorFront = hwMap.colorSensor.get("colorFront");
        //distanceFront = hwMap.get(DistanceSensor.class, "distanceFront");
        //
        
        
        //WHEN USING ENCODER THE TICKS ARE 1440
    }
}

