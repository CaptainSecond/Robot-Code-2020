// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.ArmIntake.ArmIntakeCommand;
import frc.robot.commands.ArmIntake.ArmIntakeGroupCommand;
import frc.robot.commands.Climb.ClimbCommand;
import frc.robot.commands.Drive.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Push.PushCommand;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.commands.Trigger.TriggerCommand;
import frc.robot.commands.Turret.EncoderValueCommand;
import frc.robot.commands.Turret.TurretGroupCommand;
import frc.robot.subsystems.ArmIntakeSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.PushSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TriggerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public Joystick m_driverController = new Joystick(JoystickConstants.F310);
  public Joystick m_operatorController = new Joystick(JoystickConstants.Panel);
  public final DriveSubsystem m_robotDrive = new DriveSubsystem();
  public final ArmIntakeSubsystem m_intake = new ArmIntakeSubsystem();
  public final PushSubsystem m_push = new PushSubsystem();
  public final TriggerSubsystem m_trigger = new TriggerSubsystem();
  public final TurretSubsystem m_head = new TurretSubsystem();
  public final ShooterSubsystem m_shooter = new ShooterSubsystem();
  public final ClimbSubsystem m_climb = new ClimbSubsystem();
  
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    m_robotDrive.setDefaultCommand(
      new DriveCommand(m_robotDrive,() -> -m_driverController.getRawAxis(1)* -0.8,() -> -m_driverController.getRawAxis(4)* 0.8));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Kol Top Alma ve Taşıma Birlikte
    new JoystickButton(m_driverController, 6).whileHeld(new ArmIntakeGroupCommand(m_intake, m_push));

    // Kol Top Alma
    new JoystickButton(m_driverController, 2).whileHeld(new ArmIntakeCommand(m_intake, 0.8));
    new JoystickButton(m_driverController, 3).whileHeld(new ArmIntakeCommand(m_intake, -0.8));

    // Top Taşıma
    new JoystickButton(m_operatorController, 10).whileHeld(new PushCommand(m_push, 0.8));
    new JoystickButton(m_operatorController, 9).whileHeld(new PushCommand(m_push, -0.8));

    // Kafaya Tetik
    new JoystickButton(m_operatorController, 7).whileHeld(new TriggerCommand(m_trigger, 1));
    new JoystickButton(m_operatorController, 5).whileHeld(new TriggerCommand(m_trigger, -1));

    // Kafa Dönme
    new POVButton(m_driverController, 270).whileHeld(new TurretGroupCommand(m_head,0.25));
    new POVButton(m_driverController, 90).whileHeld(new TurretGroupCommand(m_head,-0.25));

    // Top Fırlatma
    new JoystickButton(m_operatorController, 12).whileHeld(new ShooterCommand(m_shooter, 1));

    // Encoder
    new JoystickButton(m_driverController, 1).whenPressed(new EncoderValueCommand(m_head));

    // Tırmanma
    new JoystickButton(m_driverController, 8).whileHeld(new ClimbCommand(m_climb, 0.7));
    new JoystickButton(m_driverController, 7).whileHeld(new ClimbCommand(m_climb, -0.7));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
