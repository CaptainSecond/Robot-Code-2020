// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Vision;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArduinoSubsystem;

public class ReadFromArduinoCommand extends CommandBase {
  /** Creates a new ReadFromArduinoCommand. */
  boolean IsOk = false;
  ArduinoSubsystem m_arduino;
  public ReadFromArduinoCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    @SuppressWarnings("unused")
		String clear = m_arduino.getArdunioValue();
    m_arduino.Flush();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arduino.setValue(m_arduino.getArdunioValue());
    System.out.println(m_arduino.getValue());
    if(m_arduino.getValue()>155  && m_arduino.getValue()<165 ){
      IsOk=true;
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
