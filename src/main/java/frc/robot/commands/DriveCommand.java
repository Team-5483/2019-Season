/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class DriveCommand extends Command {
  public DriveCommand() {
    requires(Robot.chassis);
  }
  
  protected void initialize() {
  }

  protected void execute() {
    Robot.chassis.arcadeDrive(Robot.m_oi.xbox.getY(Hand.kLeft),Robot.m_oi.xbox.getX(Hand.kRight));
  }

  protected boolean isFinished() {
    return false;
  }

}
