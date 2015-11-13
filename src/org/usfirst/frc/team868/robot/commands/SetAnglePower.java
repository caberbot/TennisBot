package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.subsystems.AngleSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetAnglePower extends Command {

    private double power;
	private AngleSubsystem angle;

	public SetAnglePower(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	angle = AngleSubsystem.getInstance();
    	requires(angle);
    	this.power=power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle.setPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
