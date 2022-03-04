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
import edu.wpi.first.wpilibj.Timer;
import robot.Constants;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import robot.subsystems.payloadSubSys;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class intakeRetractOffCmd extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final payloadSubSys m_payloadSubSys;
    private boolean m_autonomous;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    Timer delayTimer = new Timer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public intakeRetractOffCmd(boolean autonomous, payloadSubSys subsystem) {

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
        System.out.println("----------- Intake Retract Off");
        delayTimer.reset();
        delayTimer.start();
        m_payloadSubSys.handoffMotorStart(Constants.handoff_speed);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
       
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_payloadSubSys.handoffMotorStop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (m_autonomous) { return true; }
        if (delayTimer.get() > 0.5) {
            return true;
        }
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
