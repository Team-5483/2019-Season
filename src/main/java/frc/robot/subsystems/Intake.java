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
import frc.robot.commands.BallIntakeCommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Spark intakeMotor = new Spark(RobotMap.PORT_INTAKE);
  private double speedMultiplier = 1;

  private Compressor compressor = new Compressor(RobotMap.PORT_COMPRESSOR);
  private DoubleSolenoid  intakeSolenoid = new DoubleSolenoid(RobotMap.PORT_INTAKE_EXTEND, RobotMap.PORT_INTAKE_RETRACT);

  public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kReverse, DOWN = DoubleSolenoid.Value.kForward, OFF = DoubleSolenoid.Value.kOff;

  public void initDefaultCommand() {
    setDefaultCommand(new BallIntakeCommand(0));
    compressor.setClosedLoopControl(true);
  }

  public void shoot(double a) {
    intakeMotor.set(a * speedMultiplier);
  }

  public void setSolenoid(DoubleSolenoid.Value value) {
    intakeSolenoid.set(value);
  }
}
