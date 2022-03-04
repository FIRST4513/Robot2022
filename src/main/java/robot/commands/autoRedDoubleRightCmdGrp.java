// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: SequentialCommandGroup.

package robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import robot.subsystems.drivetrainSubSys;
import robot.subsystems.payloadSubSys;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class autoRedDoubleRightCmdGrp extends SequentialCommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public autoRedDoubleRightCmdGrp(drivetrainSubSys drivetrainSubSys, payloadSubSys payloadSubSys){

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    addCommands(
        // Add Commands here:
        // Also add parallel commands using the
        //
        // addCommands(
        //      new command1(argsN, subsystem),
        //      parallel(
        //          new command2(argsN, subsystem),
        //          new command3(argsN, subsystem)
        //      )    
        //  );
        parallel(
            new intakeExtendCmd(payloadSubSys),
            new driveCmd(-43, -0.5, 0, "CURRENT_HEADING", 5, true, drivetrainSubSys)
        ),
        new delayCmd(2.0),
        new intakeRetractOnCmd( 0.0, payloadSubSys),
        new delayCmd(2.0),
        new intakeRetractOffCmd(true, payloadSubSys),

        new driveSwingTurnCmd(0.2, 0.5, 0, 45, "HDG", false, 5, drivetrainSubSys),
        new driveSwingTurnCmd(0.2, -0.5, 0, 10, "HDG", false, 5, drivetrainSubSys),
        new driveCmd(16, 0.5, 0, "NEW_HEADING", 2, true, drivetrainSubSys),
        
        new shooterFireOnCmd(true, payloadSubSys),
        new delayCmd(3.0),
        new shooterFireOffCmd(payloadSubSys)

        // new driveCmd(-48, -0.5, 0, "CURRENT_HEADING", 5, true, drivetrainSubSys),
        // new intakeRetractOnCmd(payloadSubSys),
        // new intakeRetractOffCmd(payloadSubSys),
        // new delayCmd(3.0),
        // new driveCmd(48, 0.5, 0, "CURRENT_HEADING", 5, false, drivetrainSubSys),
        // new driveSwingTurnCmd(0.4, 0.5, 24, 0, "DIST", true, 4, drivetrainSubSys),
        // new shooterFireOnCmd(payloadSubSys),
        // new delayCmd(5.0),
        // new shooterFireOffCmd(payloadSubSys)
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
