/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;

public class LiftToStageCommand extends Command {
  double desiredHeight;
  public LiftToStageCommand(int direction) {
    requires(Robot.lift);

    //If were going up, round stage down. going down round stage up
    /*int stage = Robot.lift.getCurrentStage(direction < 0);
    //int direction = up ? 1 : -1; 
    double[] heights;
    if(Robot.intake.hasHatch()) 
      heights = Constants.HATCH_HEIGHTS;
    else 
      heights = Constants.BALL_HEIGHTS;

    desiredHeight = heights[stage + direction];*/
  }

  protected void initialize() {
  }

  double integral = 0;
  double lastError = 0;
  double P = 1, I = 1, D = 1;
  /*double PID() {
    double error = desiredHeight - Robot.lift.encLift.getDistance();
    this.integral += error * .02; // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
    double derivative = (error - this.lastError) / .02;
    this.lastError = error;
    return  (P * error) + (I * this.integral) + (D * derivative);
}*/

  protected void execute() {
    //Robot.lift.lift(PID());
  }

  
  protected boolean isFinished() {
    return false;
  }
}
