/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Robot;

public class LiftIntakeCommand extends Command {
  DoubleSolenoid.Value value;
  public LiftIntakeCommand(DoubleSolenoid.Value value) {
    requires(Robot.intake);
    this.value = value;
  }
  public LiftIntakeCommand() {
    requires(Robot.intake);
  }

  protected void execute() {
    //if (value != null) {
      Robot.intake.setIntakeSolenoid(value);
    //} else {
    //  Robot.intake.toggleIntakeSolenoid();
    //}
  }

  protected boolean isFinished() {
    return false;
  }
}
