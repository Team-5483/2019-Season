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

  private DifferentialDrive drive = new DifferentialDrive(lControllers, rControllers);

  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }

  public void arcadeDrive(double l, double r) {
		drive.tankDrive(l + r, l - r);
	}
}
