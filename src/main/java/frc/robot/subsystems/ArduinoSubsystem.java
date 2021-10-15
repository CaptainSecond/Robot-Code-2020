// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArduinoSubsystem extends SubsystemBase {
  /** Creates a new ArduinoSubsystem. */
  float deger;
	SerialPort arduinoMXP =  new SerialPort(9600 ,SerialPort.Port.kMXP);
  public ArduinoSubsystem() {}

  public void Flush(){
		arduinoMXP.flush();
  }
  public String getArdunioValue(){
		return arduinoMXP.readString().trim();
  }
  
  public void setValue(String value){
		String val = value.trim();
    if(!val.isEmpty())
    {try{
      deger = Float.parseFloat(val);
    }catch(NumberFormatException e){
				//not int
			}
		}
  }
  
  public float getValue(){
		return deger;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
