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
import frc.robot.commands.HatchIntakeCommand;
import frc.robot.subsystems.Intake;

public class OI {
  public XboxController xbox = new XboxController(1);
  
  public Button a = new JoystickButton(xbox, 1);
	public Button b = new JoystickButton(xbox, 2);
	public Button x = new JoystickButton(xbox, 3);
  public Button y = new JoystickButton(xbox, 4);
  
  public  Button lt = new JoystickButton(xbox, 5);
  public Button rt = new JoystickButton(xbox, 6);

	public Button select = new JoystickButton(xbox, 7);
  public Button start = new JoystickButton(xbox, 8);
  
  public Button leftPress = new JoystickButton(xbox, 9);
  public Button rightPress = new JoystickButton(xbox, 10);
  
  public OI() {
    rt.whenPressed(new BallIntakeCommand(1));
    lt.whenPressed(new BallIntakeCommand(-1));
    a.whenPressed(new BallIntakeCommand(1));
    b.whenPressed(new BallIntakeCommand(-1));
    x.whenPressed(new HatchIntakeCommand(Intake.EXTENDED));
    y.whenPressed(new HatchIntakeCommand(Intake.RETRACTED));
    start.whenPressed(new LiftIntakeCommand()); //Toggle intake up/down 
    select.whenPressed(new LiftIntakeCommand(Intake.RETRACTED)); 

    // button.whileHeld(new ExampleCommand());
    // button.whenReleased(new ExampleCommand());
    // button.toggleWhenActive(new ExampleCommand());
  }
}
