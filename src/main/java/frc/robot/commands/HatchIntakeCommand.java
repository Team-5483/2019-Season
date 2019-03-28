/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class HatchIntakeCommand extends Command {
  DoubleSolenoid.Value value;
  boolean toggle = false;
  public HatchIntakeCommand(DoubleSolenoid.Value value) {
    requires(Robot.intake);
    this.value = value;
  }

  public HatchIntakeCommand() {
    requires(Robot.intake);
    toggle = true;
  }

  protected void execute() {
   if (!toggle) 
    Robot.intake.setHatchSolenoid(value);
  else
    Robot.intake.toggleHatchSolenoid();
  
  }

  protected boolean isFinished() {
    return true;
  }
}
