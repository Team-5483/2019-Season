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
import frc.robot.commands.LiftCommand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;

public class Lift extends Subsystem {
  
  private Spark fMotor = new Spark(RobotMap.PORT_LIFT_FRONT);
  private Spark bMotor = new Spark(RobotMap.PORT_LIFT_BACK);
  private SpeedControllerGroup controllers = new SpeedControllerGroup(fMotor, bMotor);

  public Encoder encLift;

  private DigitalInput liftSwitch;
  public Lift() {
    encLift = new Encoder(RobotMap.PORT_ENCODER_DRIVE_LIFT, RobotMap.PORT_ENCODER_DRIVE_LIFT+1, false, Encoder.EncodingType.k4X);
    liftSwitch = new DigitalInput(RobotMap.PORT_LIFT_SWITCH);
  } 

  public boolean zero() {
    controllers.set(-1);
    if (liftSwitch.get()) {
      controllers.set(0);
      encLift.reset();
      return true;
    }
    return false;
  }

 public void initDefaultCommand() {
    setDefaultCommand(new LiftCommand());
  }

  public void lift(double k) {
    controllers.set(k);
  }



}
