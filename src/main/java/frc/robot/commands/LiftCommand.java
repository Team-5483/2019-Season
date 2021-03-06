/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class LiftCommand extends Command {
  public LiftCommand() {
    requires(Robot.lift);
  }

  protected void initialize() {
  }
  
  protected void execute() {
    
    Robot.lift.lift((Robot.m_oi.xbox.getTriggerAxis(Hand.kRight) - Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft))*2);
    //System.out.println(((Robot.m_oi.xbox.getTriggerAxis(Hand.kRight) - Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft))*2));
    
  }

  protected boolean isFinished() {
    return false;
  }
}
