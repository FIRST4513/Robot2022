// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import robot.Constants;
import robot.RobotContainer;
import edu.wpi.first.wpilibj.Joystick;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import robot.subsystems.payloadSubSys;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class shooterFireOnCmd extends CommandBase {


        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final payloadSubSys m_payloadSubSys;
    private boolean m_autonomous;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    Timer delayTimer = new Timer();
    RobotContainer robot;
    Joystick copilotJoystick;


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public shooterFireOnCmd(boolean autonomous, payloadSubSys subsystem) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_autonomous = autonomous;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_payloadSubSys = subsystem;
        addRequirements(m_payloadSubSys);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        delayTimer.reset();
        delayTimer.start();
        m_payloadSubSys.shooterMotorStart(Constants.shooter_speed_fire);
        System.out.println("---------- shooterFireOnCmd has started");
        robot = RobotContainer.getInstance();
        copilotJoystick = robot.getcopilotJoystick();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // System.out.println(copilotJoystick.getThrottle());
        // double initialDelay = (0.25 * -((copilotJoystick.getThrottle() + 1)/2));  // if -1 -> 1
        // (0.25 * copilotJoystick.getThrottle());  // if 0 -> 1
        // (0.25 * ((copilotJoystick.getThrottle() + 1)/2))  // if -1 -> 1
        if (delayTimer.get() > 0.25) {
            m_payloadSubSys.conveyorMotorStart(Constants.conveyor_speed_fire);
        }
        
        if (delayTimer.get() > (0.25 + 0.4)) {
            m_payloadSubSys.handoffMotorStart(Constants.handoff_speed_fire);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_payloadSubSys.handoffMotorStop();
        m_payloadSubSys.conveyorMotorStop();
        m_payloadSubSys.shooterMotorStop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if ((m_autonomous) && (delayTimer.get() > 2.5)) { return true; }
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
