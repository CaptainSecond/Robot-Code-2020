// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SPI;



public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  PWMTalonSRX LMotor;
  PWMTalonSRX RMotor;
  DifferentialDrive m_drive;
  double error;
  Gyro m_gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
  double kP = 1;
  public DriveSubsystem() {
    LMotor = new PWMTalonSRX(Constants.DriveConstants.LeftMotor);
    RMotor = new PWMTalonSRX(Constants.DriveConstants.RightMotor);
    m_drive = new DifferentialDrive(LMotor, RMotor);
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

  public double Rotate(){
    error = 180 - m_gyro.getRate();
    m_drive.tankDrive(kP * error, kP * error);
    return error;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
