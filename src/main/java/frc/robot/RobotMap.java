/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  //PWM ports
  public static final int PORT_DRIVE_LEFT_BACK = 0;
  public static final int PORT_DRIVE_RIGHT_BACK = 9;
  public static final int PORT_DRIVE_LEFT_FRONT = 1;
  public static final int PORT_DRIVE_RIGHT_FRONT = 8;

  public static final int PORT_INTAKE = 3;

  public static final int PORT_LIFT_FRONT = 2;
  public static final int PORT_LIFT_BACK = 7;

  //Pneumatic ports
  public static final int PORT_INTAKE_EXTEND = 0;
  public static final int PORT_INTAKE_RETRACT = 1;
  
  public static final int PORT_HATCH_EXTEND = 4;
  public static final int PORT_HATCH_RETRACT = 5;

  public static final int PORT_CLIMB_BACK_EXTEND = 1;
  public static final int PORT_CLIMB_BACK_RETRACT = 1;

  public static final int PORT_CLIMB_FRONT_EXTEND = 1;
  public static final int PORT_CLIMB_FRONT_RETRACT = 1;

  public static final int PORT_COMPRESSOR = 0;

  //Encoder ports
  //Each encoder uses assigned port and the port above it
  public static final int PORT_ENCODER_DRIVE_LEFT = 0;
  public static final int PORT_ENCODER_DRIVE_RIGHT = 2;
  public static final int PORT_ENCODER_DRIVE_LIFT = 4;

  //Limit switches
  public static final int PORT_LIFT_SWITCH = 1;
}
