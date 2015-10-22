package org.usfirst.frc.team868.robot.subsystems;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LaunchSubsystem extends Subsystem {
	private static LaunchSubsystem instance;

	private CANTalon MOTOR_LAUNCH;
	
    public void initDefaultCommand() {
    	MOTOR_LAUNCH = new CANTalon(RobotMap.SHOOT_MOTOR);
    	MOTOR_LAUNCH.enableBrakeMode(false);
    	MOTOR_LAUNCH.reverseOutput(false);
    	MOTOR_LAUNCH.reverseSensor(false);
    	
    }
    public void setSpeed(double power) {
    	MOTOR_LAUNCH.set(power);
    }
    
    public static LaunchSubsystem getInstance() {
    	if (instance == null){
    		instance = new LaunchSubsystem();
    	}
    	return instance;
    }
    
}
