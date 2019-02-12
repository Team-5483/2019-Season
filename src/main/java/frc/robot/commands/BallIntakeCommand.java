/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class BallIntakeCommand extends Command {
  private double a;
  
  public BallIntakeCommand(double a) {
    requires(Robot.intake);
    this.a = a;
  }

  protected void execute() {
    Robot.intake.shoot(a);
  }

  protected boolean isFinished() {
    return false;
  }
}
