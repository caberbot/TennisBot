package org.usfirst.frc.team868.robot.subsystems;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HeadingSubsystem extends Subsystem {
	private static HeadingSubsystem instance;

	private CANTalon MOTOR_HEADING;
	
    public void initDefaultCommand() {
    	MOTOR_HEADING = new CANTalon(RobotMap.TURN_MOTOR);
    	MOTOR_HEADING.enableBrakeMode(true);
    	MOTOR_HEADING.reverseOutput(false);
    	MOTOR_HEADING.reverseSensor(false);
    	MOTOR_HEADING.enableLimitSwitch(true, true);
    }
    public void setSpeed(double power) {
    	MOTOR_HEADING.set(power);
    }
    
    public static HeadingSubsystem getInstance() {
    	if (instance == null){
    		instance = new HeadingSubsystem();
    	}
    	return instance;
    }
    
}

