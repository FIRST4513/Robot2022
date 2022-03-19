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

package robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import robot.commands.*;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import robot.subsystems.drivetrainSubSys;
import robot.subsystems.payloadSubSys;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class autoDoubleRightCmdGrp extends SequentialCommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public autoDoubleRightCmdGrp(drivetrainSubSys drivetrainSubSys, payloadSubSys payloadSubSys){

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

        // ***************************************************************
        // **** Line up the robot parallel with the right line ****
        // ***************************************************************

        // New Route - Robot parallel with side line
        // preferred because robot gets clearly of the box
        
        // Reset Gyro and Encoders prior to auto run
        new resetGyroCmd(drivetrainSubSys),
        new clearEncodersCmd(drivetrainSubSys),
        
        // Lets get started so extend intake mechanism
        new intakeExtendCmd(payloadSubSys),
        new delayCmd(0.5),

        // Drive straight backwards to get ball
        new driveCmd(-50, -0.5, 0, "CURRENT_HEADING", 8, true, drivetrainSubSys),
        
        // give time for ball to get into robot the retract intake mechanism
        new delayCmd(0.5),
        new intakeRetractCmd( payloadSubSys),
        
        // Drforward S turn (dbl arc) to target
        // driveSwingTurnCmd(speed, rotation, dist, hdg, mode, brakeFlag, timeOut, subsystem)
        new driveCmd(4, 0.5, 0, "CURRENT_HEADING", 3, true, drivetrainSubSys),
        new driveSwingTurnCmd(0.3, 0.3, 20, 0, "DIST", false, 5, drivetrainSubSys),
        new driveSwingTurnCmd(0.3, -0.35, 43, 0, "DIST", false, 5, drivetrainSubSys),
        // driveCmd(dist, pwr, hdg,    mode,    timeOut, brakeFlag, subsystem)
        
        new clearEncodersCmd(drivetrainSubSys),
        new driveCmd(6, 0.5, 0, "CURRENT_HEADING", 4,    false, drivetrainSubSys),

        // Were in position - so shoot the balls
        new shooterFireOnCmd(true, payloadSubSys),
        new delayCmd(2.0),
        new shooterFireOffCmd(payloadSubSys)

        // Original Route - Robot parallel with front line
        // not preferred because did not get far out of the box
        /*
        parallel(
            new intakeExtendCmd(payloadSubSys),
            new driveCmd(-43, -0.5, 0, "CURRENT_HEADING", 5, true, drivetrainSubSys)
        ),
        new delayCmd(2.0),
        new intakeRetractOnCmd(payloadSubSys),
        new intakeRetractOffCmd(true, payloadSubSys),

        new driveSwingTurnCmd(0.2, 0.5, 0, 45, "HDG", false, 5, drivetrainSubSys),
        new driveSwingTurnCmd(0.2, -0.5, 0, 10, "HDG", false, 5, drivetrainSubSys),
        new driveCmd(16, 0.5, 0, "NEW_HEADING", 2, true, drivetrainSubSys),
        
        new shooterFireOnCmd(true, payloadSubSys)
        */

        );
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
