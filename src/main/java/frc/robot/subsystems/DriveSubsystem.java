// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;


public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  PWMTalonSRX LMotor;
  PWMTalonSRX RMotor;
  DifferentialDrive m_drive;
  Gyro m_gyro;
  double target;

  public DriveSubsystem() {
    LMotor = new PWMTalonSRX(Constants.DriveConstants.LeftMotor);
    RMotor = new PWMTalonSRX(Constants.DriveConstants.RightMotor);
    m_drive = new DifferentialDrive(LMotor, RMotor);
    m_gyro = new ADXRS450_Gyro(SPI.Port.kMXP);
  }

  public void curvatureDrive(double x,double y){
		m_drive.curvatureDrive(x, y, true);
	}

  public void TankDrive(double l, double r){
    m_drive.tankDrive(l*1, r*1, true);
  }

  public void zeroHeading() {
    m_gyro.reset();
}

public double getHeading() {
  return Math.IEEEremainder(m_gyro.getAngle(), 360) * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
}

public double getTurnRate() {
  return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
}

public double getHeadingCW() {
  // Not negating
  return Math.IEEEremainder(m_gyro.getAngle(), 360);
}

public double getTurnRateCW() {
  // Not negating
  return m_gyro.getRate();
}

public double getTarget() {
  return getHeading() + target;
}

public void setTarget(double val) {
  target = val;
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
