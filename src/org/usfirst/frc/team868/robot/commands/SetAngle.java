package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.subsystems.AngleSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetAngle extends Command {

    private AngleSubsystem angle;
    // TODO - NEED TO DETERMINE VALUES
	private int targetCount;
	int TOLERANCE = (7000 * 5 /100);	//%5 Tolerance
	private String keyName;

	public SetAngle(String keyName) {   //Range 0-7000
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	angle = AngleSubsystem.getInstance();
    	requires(angle);
    	this.keyName=keyName;
		this.targetCount = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetCount= (int) SmartDashboard.getNumber(keyName);
    	angle.setAngle(targetCount);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	int position = angle.getPosition();
    	int error = Math.abs(position-targetCount);
        return (error<TOLERANCE);
    }
    

    // Called once after isFinished returns true
    protected void end() {
    	angle.setPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
