// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class getGyroSubsystem extends SubsystemBase {
  /** Creates a new getGyroSubsystem. */
  double error;
  Gyro m_gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
  public getGyroSubsystem() {
    zeroHeading();
  }

  public double GyroGetValue(){
    error = m_gyro.getRate();
    return error;
  }

  public void zeroHeading() {
    m_gyro.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
