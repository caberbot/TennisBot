package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.subsystems.AngleSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroAngle extends Command {

	private AngleSubsystem angle;

	public ZeroAngle() {
    	angle = AngleSubsystem.getInstance();
    	requires(angle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle.setPower(-.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean atBottom = angle.atBottom();
        return atBottom;
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
