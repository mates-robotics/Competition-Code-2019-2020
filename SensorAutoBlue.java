package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;

@Autonomous
public class SensorAutoBlue extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    TestingRobotMap robot = new TestingRobotMap();

    public void setForward() {
        robot.leftFrontDrive.setPower(-1);
        robot.leftBackDrive.setPower(1);
        robot.rightFrontDrive.setPower(-1);
        robot.rightBackDrive.setPower(-1);
    }
    
    public void setBackward() {
        robot.leftFrontDrive.setPower(1);
        robot.leftBackDrive.setPower(-1);
        robot.rightFrontDrive.setPower(1);
        robot.rightBackDrive.setPower(1);
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
        
        ColorSensor sensorColor;
        // get a reference to the color sensor.
        sensorColor = hardwareMap.get(ColorSensor.class, "sensor_colorDistance");

        // get a reference to the distance sensor that shares the same name.
 
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};
 
        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;
 
        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;
 
        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
 
        // Initialize the hardware variables.
        robot.init(hardwareMap);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Last Modified: October 30th, 2019", "Hello MATES Driver!");
        // you can use this as a regular DistanceSensor.
    
        // convert the RGB values to HSV values.
        // multiply by the SCALE_FACTOR.
        // then cast it back to int (SCALE_FACTOR is a double)
        Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                (int) (sensorColor.green() * SCALE_FACTOR),
                (int) (sensorColor.blue() * SCALE_FACTOR),
                hsvValues);
        
        telemetry.addData(">>", "Press start to continue");
        
        waitForStart();
        robot.init(hardwareMap);

        setBackward();
        while (sensorColor.blue() < 350) {
        }
        runtime.reset();
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        
        while(opModeIsActive()) {
    
            // send the info back to driver station using telemetry function.
            telemetry.addData("Alpha", sensorColor.alpha());
            telemetry.addData("Red  ", sensorColor.red());
            telemetry.addData("Green", sensorColor.green());
            telemetry.addData("Blue ", sensorColor.blue());
            telemetry.addData("Hue", hsvValues[0]);
            telemetry.update();


 
            
        }


        


    }
}
