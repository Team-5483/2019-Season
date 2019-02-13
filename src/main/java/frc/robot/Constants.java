/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Constants {
    //All distance measurements in meters

    public static final double[] BALL_HEIGHTS = {0,1,2}; //intake resting on ground is considered 0 meters, note that hatch and balls are offset
    public static final double[] HATCH_HEIGHTS = {0,1,2};
    public static final double INTAKE_EXTENSION_HEIGHT = 1; //Change in height extending intake cylinder
    public static final double LIFT_MAX_HEIGHT = 1; //Total possible change in height without using intake extension

    public static final double DRIVE_WHEEL_DIAMETER = 0.1524; //6 inches


    public static final int PULSES_PER_REVOLUTION = 1024; //Pulses sent by the encoders for one revolution 

    public static final double DRIVE_GEARBOX_RATIO = 1; //Gear ratio on drive gearboxes

    public static final double LIFT_GEARBOX_RATIO = 1;
    public static final double LIFT_DISTANCE_RATIO = 1; //Ratio from one turn to distance lifted
}
