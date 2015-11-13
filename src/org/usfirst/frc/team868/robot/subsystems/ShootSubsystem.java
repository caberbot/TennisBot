package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class ShootSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon SHOOT_MOTOR;
	private static ShootSubsystem instance;
	private ShootSubsystem(){
		SHOOT_MOTOR = new CANTalon(RobotMap.SHOOT_MOTOR);
		
	}
	public void setShootSpeed(double speed){
		SHOOT_MOTOR.set(rangeCheck(speed));
		
	}
	
	public double rangeCheck(double speed){
		if(speed < -1)
			speed = -1;
		if(speed > 1)
			speed = 1;
		
		return speed;
	}
	
	public static ShootSubsystem getInstance(){
    	if (instance == null){
    		instance = new ShootSubsystem();
    	}
    return instance;
   }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
