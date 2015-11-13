package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class TurningSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon TURNING_MOTOR;
	private static TurningSubsystem instance;
	private TurningSubsystem(){
		TURNING_MOTOR = new CANTalon(RobotMap.TURN_MOTOR);
		
	}
	public void setTurnSpeed(double speed){
		TURNING_MOTOR.set(rangeCheck(speed));
		TURNING_MOTOR.setPID(0, 0, 0);
	}
	
	public double rangeCheck(double speed){
		if(speed < -1)
			speed = -1;
		if(speed > 1)
			speed = 1;
		
		return speed;
	}
	
	public void incrementAngle(double x){
    	TURNING_MOTOR.pidWrite(x);
    }
	
	public static TurningSubsystem getInstance(){
    	if (instance == null){
    		instance = new TurningSubsystem();
    	}
    return instance;
   }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
