/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  private Spark lfMotor = new Spark(RobotMap.PORT_DRIVE_LEFT_FRONT);
	private Spark lbMotor = new Spark(RobotMap.PORT_DRIVE_LEFT_BACK);
  private SpeedControllerGroup lControllers = new SpeedControllerGroup(lfMotor, lbMotor);
  
	private Spark rfMotor = new Spark(RobotMap.PORT_DRIVE_RIGHT_BACK);
	private Spark rbMotor = new Spark(RobotMap.PORT_DRIVE_RIGHT_FRONT);
  private SpeedControllerGroup rControllers = new SpeedControllerGroup(rfMotor, rbMotor);
  
  public Encoder encLeft;
  public Encoder encRight;

  private DifferentialDrive drive = new DifferentialDrive(lControllers, rControllers);

  public Chassis() {
    encLeft = new Encoder(RobotMap.PORT_ENCODER_DRIVE_LEFT, RobotMap.PORT_ENCODER_DRIVE_LEFT+1, false, Encoder.EncodingType.k4X);
    encRight = new Encoder(RobotMap.PORT_ENCODER_DRIVE_RIGHT, RobotMap.PORT_ENCODER_DRIVE_RIGHT+1, false, Encoder.EncodingType.k4X);

    double gearRatio = 1; //Drive gearbox ratio
    double wheelCircumference = 0.1524 * Math.PI; //Wheel circumference in meters (6 inches * pi)
    int pulsesPerRevolution = 1024; //One rotation of encoder gives 1024 pulses

    double distancePerPulse = (gearRatio * wheelCircumference)/pulsesPerRevolution;
    encLeft.setDistancePerPulse(distancePerPulse);
    encRight.setDistancePerPulse(distancePerPulse);
  }
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }

  private double P = 1, I = 1, D = 1;
  int countDifference= 0; //Impose an artificial difference in counts to cause turn
  double PID() {
    int leftCount = encLeft.get() - countDifference; 
    int rightCount = encRight.get() + countDifference;
    
    //double error = Math.pow((leftCount - rightCount) - countDifference,3);
    double error = (leftCount - rightCount) - countDifference;
    return error * P;
  }

  //Turning rate cant be faster than robot turning speed
  private int turningRate = 64; //In pulses per second
  public void arcadeDrive(double l, double r) {
    countDifference += turningRate * r;
    double pid_value = PID();
    
		drive.tankDrive(l - pid_value, l  + pid_value);
	}
}
