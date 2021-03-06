// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Push;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PushSubsystem;

public class PushCommand extends CommandBase {
  /** Creates a new PushCommand. */
  private final double m_speed;
  private final PushSubsystem m_push;
  public PushCommand(PushSubsystem push, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_speed = speed;
    this.m_push = push;
    addRequirements(m_push);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_push.runPush(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_push.runPush(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
