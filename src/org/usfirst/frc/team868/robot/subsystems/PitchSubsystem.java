package org.usfirst.frc.team868.robot.subsystems;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PitchSubsystem extends Subsystem {
    
	private static PitchSubsystem instance;
	private CANTalon MOTOR_PITCH;

    public void initDefaultCommand() {
    	MOTOR_PITCH = new CANTalon(RobotMap.ANGLE_MOTOR);
    	MOTOR_PITCH.enableBrakeMode(true);
    	MOTOR_PITCH.reverseOutput(false);
    	MOTOR_PITCH.reverseSensor(false);
    	MOTOR_PITCH.enableLimitSwitch(true, true);
    }
    public void setSpeed(double power) {
    	MOTOR_PITCH.set(power);
    }
    public static PitchSubsystem getInstance() {
    	if (instance == null) {
    		instance = new PitchSubsystem();
    	}
    	return instance;
    }
}





