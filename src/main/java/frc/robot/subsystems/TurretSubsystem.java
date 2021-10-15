// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new HeadRotateSubsystem. */
  PWMVictorSPX TurretMotor;
  double cpr = 64; //if am-4027
  double whd = 6; // for 6 inch wheel
  Encoder TurretEncoder;

  public TurretSubsystem() {
    TurretMotor = new PWMVictorSPX(Constants.PWM.TurretMotor);
    TurretEncoder = new Encoder(Constants.HeadRotate.kTurretEncoderA, Constants.HeadRotate.kTurretEncoderB, Constants.HeadRotate.kTurretEncoderIsReversed);
  }

  public double HeadEncoderGetValue(){
    TurretEncoder.setDistancePerPulse(1.0 / (Constants.HeadRotate.TurretEncoderPPR));
    //TurretEncoder.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
    return TurretEncoder.getDistance();
  }

  public void runTurret(double m_speed){
		TurretMotor.set(m_speed);
  }

  public void resetEncoders() {
    TurretEncoder.reset();
}

  @Override
  public void periodic() { }
}
