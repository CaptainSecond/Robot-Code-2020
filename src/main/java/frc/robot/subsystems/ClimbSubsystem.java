// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  PWMVictorSPX ClimbMotor;
  public ClimbSubsystem() {
    ClimbMotor = new PWMVictorSPX(Constants.PWM.ClimbMotor);
  }

  public void runClimb(double m_speed){
		ClimbMotor.set(m_speed);
	}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
