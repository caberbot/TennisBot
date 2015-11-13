package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;

/**
 *
 */
public class AngleSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon ANGLE_MOTOR;
	private static AngleSubsystem instance;
	private double Ki = 0;
	private double Kp = .001;
	private double Kd = 0;
	
	private AngleSubsystem(){
		super ("Angle");
		ANGLE_MOTOR = new CANTalon(RobotMap.ANGLE_MOTOR);
		ANGLE_MOTOR.enableBrakeMode(true);
		ANGLE_MOTOR.enableLimitSwitch(true, true);
		ANGLE_MOTOR.reverseOutput(false);
		ANGLE_MOTOR.reverseSensor(false);
		
		ANGLE_MOTOR.changeControlMode(ControlMode.PercentVbus);
		
	}
	
	public void updateDashboard(){
		SmartDashboard.putNumber("Angle Counts", ANGLE_MOTOR.getEncPosition());
		SmartDashboard.putBoolean("At Top", ANGLE_MOTOR.isFwdLimitSwitchClosed());
		SmartDashboard.putBoolean("At Bottom", atBottom());
		SmartDashboard.putNumber("Angle Power", ANGLE_MOTOR.get());
		SmartDashboard.putData(this);
	}
	
	public boolean atBottom(){
		boolean atBottom = ANGLE_MOTOR.isRevLimitSwitchClosed();
		if(atBottom){
			ANGLE_MOTOR.setPosition(0);
		}
		return atBottom;
	}
	
	public void setPower(double power) {
		ANGLE_MOTOR.changeControlMode(ControlMode.PercentVbus);
		ANGLE_MOTOR.set(rangeCheck(power));
	}
	
	
	public void setAngle(double speed){
		ANGLE_MOTOR.setPID(SmartDashboard.getNumber("Kp"), SmartDashboard.getNumber("Ki"), SmartDashboard.getNumber("Kd"));
		ANGLE_MOTOR.changeControlMode(ControlMode.Position);
		ANGLE_MOTOR.set(speed);
	}
	
	
	public double rangeCheck(double speed){
		if(speed < -1)
			speed = -1;
		if(speed > 1)
			speed = 1;
		
		return speed;
	}
	
	public void incrementAngle(double x){
		ANGLE_MOTOR.pidWrite(x);
	}
	public static AngleSubsystem getInstance(){
    	if (instance == null){
    		instance = new AngleSubsystem();
    	}
    return instance;
   }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public int getPosition() {
		// TODO Auto-generated method stub
		return ANGLE_MOTOR.getEncPosition();
	}
}
