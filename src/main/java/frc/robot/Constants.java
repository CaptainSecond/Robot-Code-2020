// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Joystick
    public static final class JoystickConstants {
        public static final int F310  = 0; // Joystick
        public static final int Panel = 1; // Driver Station Button
    }

    // Drive Base Motors PWM
    public static final class DriveConstants {
        
        public static final int LeftMotor = 0;  // Sase Sol 
        public static final int RightMotor = 1; // Sase Sağ 
        public static final boolean LeftMotorInverted = true;
        public static final boolean RightMotorInverted = true;
        public static final boolean kGyroReversed = false;
    }

    // Robot Base Motors PWM
    public static final class PWM {
        public static final int ArmIntakeMotor  = 2; // Kol Top Alma
        public static final int PushMotor       = 3; // Top Taşıma 
        public static final int TriggerMotor    = 4; // Kafaya Tetik
        public static final int ShooterMotor    = 5; // Top Fırlatma
        public static final int TurretMotor     = 6; // Kafa Dönme
        public static final int ClimbMotor      = 7; // Tırmanma 
    }

    public static final class HeadRotate {
        public static final byte kTurretEncoderA = 0;
        public static final byte kTurretEncoderB = 1;
        public static final boolean kTurretEncoderIsReversed = false;
        public static final boolean kTurretInvertedMode1 = true;
        public static final double kP = 0.005;
        public static final double kI = 0.000;
        public static final double kD = 0.000;

        public static final double kS = 0.656;
        public static final double kV = 0.00202;
        public static final double kA = 0.000494;
        public static final int TurretEncoderPPR = 2048; // AMT-103
        public static final byte kToleranceInDegrees = 0;
    }
}
