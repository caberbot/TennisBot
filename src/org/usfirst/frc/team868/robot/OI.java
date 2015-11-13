package org.usfirst.frc.team868.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team868.robot.commands.ExampleCommand;
import org.usfirst.frc.team868.robot.commands.SetAngle;
import org.usfirst.frc.team868.robot.commands.SetAnglePower;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	void initSDB(){
		SmartDashboard.putData("Raise Angle", new SetAnglePower(0.4));
		SmartDashboard.putData("Lower Angle", new SetAnglePower(-0.4));
		SmartDashboard.putData("Stop Angle", new SetAnglePower(0));
		SmartDashboard.putNumber("Low Goal Counts", 6000);
		SmartDashboard.putData("Angle Low Goal", new SetAngle("Low Goal Counts"));
		//SmartDashboard.putData("Angle High Goal", new SetAngle(4000));
		SmartDashboard.putNumber("Kp", 0);
		SmartDashboard.putNumber("Ki", 0);
		SmartDashboard.putNumber("Kd", 0);
	}
}

