/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.BallIntakeCommand;
import frc.robot.commands.LiftIntakeCommand;
import frc.robot.subsystems.Intake;
public class OI {
  public XboxController xbox = new XboxController(1);
  
  Button a = new JoystickButton(xbox, 1);
	Button b = new JoystickButton(xbox, 2);
	Button x = new JoystickButton(xbox, 3);
  Button y = new JoystickButton(xbox, 4);
  
  Button lt = new JoystickButton(xbox, 5);
  Button rt = new JoystickButton(xbox, 6);

	Button select = new JoystickButton(xbox, 7);
  Button start = new JoystickButton(xbox, 8);
  
  Button leftPress = new JoystickButton(xbox, 9);
  Button rightPress = new JoystickButton(xbox, 10);
  
	
  
  public OI() {
    rt.whenPressed(new BallIntakeCommand(1));
    lt.whenPressed(new BallIntakeCommand(-1));
    a.whenPressed(new LiftIntakeCommand(Intake.UP));
    b.whenPressed(new LiftIntakeCommand(Intake.DOWN));
    // button.whileHeld(new ExampleCommand());
    // button.whenReleased(new ExampleCommand());
    // button.toggleWhenActive(new ExampleCommand());
  }
}
