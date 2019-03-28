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
import frc.robot.commands.LiftToStageCommand;
import frc.robot.commands.SwitchCameraCommand;
import frc.robot.commands.ToggleCompressorCommand;
import frc.robot.commands.HatchIntakeCommand;
import frc.robot.subsystems.Intake;

public class OI {
  public XboxController xbox = new XboxController(0);
  
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
   // rt.whenPressed(new LiftToStageCommand(1));
    //lt.whenPressed(new LiftToStageCommand(-1));
    rt.whenPressed(new ToggleCompressorCommand(true));
    lt.whenPressed(new ToggleCompressorCommand(false));
    a.whenPressed(new BallIntakeCommand(1));
    //a.whenReleased(new BallIntakeCommand(0));
    b.whenPressed(new BallIntakeCommand(Robot.intake.getShoot()-1));
    b.whenReleased(new BallIntakeCommand(0));
    x.whenPressed(new HatchIntakeCommand());
    //y.whenPressed(new HatchIntakeCommand(Intake.EXTENDED));
    y.whenPressed(new SwitchCameraCommand());
    start.whenPressed(new LiftIntakeCommand(Intake.EXTENDED)); //Toggle intake up/down 
    select.whenPressed(new LiftIntakeCommand(Intake.RETRACTED)); 

    // button.whileHeld(new ExampleCommand());
    // button.whenReleased(new ExampleCommand());
    // button.toggleWhenActive(new ExampleCommand());
  }
}
