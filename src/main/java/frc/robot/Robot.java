/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;

public class Robot extends TimedRobot {
  public static OI m_oi;

  public static Intake intake;
  public static Chassis chassis;
  public static Lift lift;
  

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private static CameraServer server;
  private static int cam = 0;
  public void robotInit() {
    intake = new Intake();
    chassis = new Chassis();
    lift = new Lift();

    m_oi = new OI();

    server = CameraServer.getInstance();
    //server.startAutomaticCapture();
    server.startAutomaticCapture(cam);
    server.startAutomaticCapture(cam+1);

    
    //VideoSource cam = new VideoSource();
    
    //server.setQuality(50);
    //server.startAutomaticCapture("cam0");
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    //SmartDashboard.putData("Auto mode", m_chooser);
  }

  public static void setCamera(int a) {
    cam = a;
    int remove = a-1;
    if(remove < 0) {
      remove = Constants.NUMBER_OF_CAMERAS;
    }
  //  server.removeCamera("cam" + (remove));
   // server.
//  server.addSwitchedCamera("cam0");
    
    
  }

  public static int getCamera() {
    return cam;
  }
  
  public void robotPeriodic() {
  }

  
  public void disabledInit() {
  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
    //Cancel auto
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  
  public void testPeriodic() {
  }
}
