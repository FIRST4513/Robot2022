// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package robot;

import robot.commands.*;
import robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final payloadSubSys m_payloadSubSys = new payloadSubSys();
    public final climberSubSys m_climberSubSys = new climberSubSys();
    public final drivetrainSubSys m_drivetrainSubSys = new drivetrainSubSys();

// Joysticks
private final Joystick copilotJoystick = new Joystick(1);
private final XboxController driverController = new XboxController(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("clearEncodersCmd", new clearEncodersCmd( m_drivetrainSubSys ));
    SmartDashboard.putData("climberExtendCmd", new climberExtendCmd( m_climberSubSys ));
    SmartDashboard.putData("climberRetractCmd", new climberRetractCmd( m_climberSubSys ));
    SmartDashboard.putData("compressorOnOffCmd", new compressorOnOffCmd( m_payloadSubSys ));
    SmartDashboard.putData("resetGyroCmd", new resetGyroCmd( m_drivetrainSubSys ));
    SmartDashboard.putData("shooterFireOffCmd", new shooterFireOffCmd( m_payloadSubSys ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD

    SmartDashboard.putData("Red - Single", new autoRedSingleCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Red - Double Left", new autoRedDoubleLeftCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Red - Double Right", new autoRedDoubleRightCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Blue - Single", new autoBlueSingleCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Blue - Double Left", new autoBlueDoubleLeftCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Blue - Double Right", new autoBlueDoubleRightCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Do Nothing", new autoDoNothingCmdGrp());
    SmartDashboard.putData("Shoot Only", new autoShootOnlyCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Shoot and Cross Line", new autoShootAndCrossLineCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("Cross Line Only", new autoCrossLineOnlyCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    SmartDashboard.putData("driveTestForwardCmdGrp", new driveTestForwardCmdGrp(m_drivetrainSubSys));

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_drivetrainSubSys.setDefaultCommand(new driveByJoystick( m_drivetrainSubSys ) );


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.addOption("Do Nothing", new autoDoNothingCmdGrp());
    m_chooser.addOption("Red - Single", new autoRedSingleCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Red - Double Left", new autoRedDoubleLeftCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Red - Double Right", new autoRedDoubleRightCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Blue - Single", new autoBlueSingleCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Blud - Double Left", new autoBlueDoubleLeftCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Blue - Double Right", new autoBlueDoubleRightCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));

    m_chooser.addOption("Shoot Only", new autoShootOnlyCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Cross Line Only", new autoCrossLineOnlyCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));
    m_chooser.addOption("Shoot and Cross Line", new autoShootAndCrossLineCmdGrp( m_drivetrainSubSys, m_payloadSubSys ));

    m_chooser.setDefaultOption("Do Nothing", new autoDoNothingCmdGrp());

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton compressorOnOffBtn = new JoystickButton(copilotJoystick, 2);        
compressorOnOffBtn.whenPressed(new compressorOnOffCmd( m_payloadSubSys ) ,true);
    SmartDashboard.putData("compressorOnOffBtn",new compressorOnOffCmd( m_payloadSubSys ) );

final JoystickButton climberRetractBtn = new JoystickButton(copilotJoystick, 11);        
climberRetractBtn.whenPressed(new climberRetractCmd( m_climberSubSys ) ,true);
    SmartDashboard.putData("climberRetractBtn",new climberRetractCmd( m_climberSubSys ) );

final JoystickButton climberExtendBtn = new JoystickButton(copilotJoystick, 12);        
climberExtendBtn.whenPressed(new climberExtendCmd( m_climberSubSys ) ,true);
    SmartDashboard.putData("climberExtendBtn",new climberExtendCmd( m_climberSubSys ) );

final JoystickButton shooterFireOffBtn = new JoystickButton(copilotJoystick, 1);        
shooterFireOffBtn.whenReleased(new shooterFireOffCmd( m_payloadSubSys ) ,true);
    SmartDashboard.putData("shooterFireOffBtn",new shooterFireOffCmd( m_payloadSubSys ) );

final JoystickButton shooterFireOnBtn = new JoystickButton(copilotJoystick, 1);        
shooterFireOnBtn.whileHeld(new shooterFireOnCmd(false, m_payloadSubSys) ,true);
    SmartDashboard.putData("shooterFireOnBtn",new shooterFireOnCmd(false, m_payloadSubSys) );

final JoystickButton intakeRetractOffBtn = new JoystickButton(driverController, XboxController.Button.kB.value);        
intakeRetractOffBtn.whenReleased(new intakeRetractOffCmd(false, m_payloadSubSys) ,true);
    SmartDashboard.putData("intakeRetractOffBtn",new intakeRetractOffCmd(false, m_payloadSubSys) );

final JoystickButton intakeRetractOnBtn = new JoystickButton(driverController, XboxController.Button.kB.value);        
intakeRetractOnBtn.whenPressed(new intakeRetractOnCmd(0, m_payloadSubSys) ,true);
    SmartDashboard.putData("intakeRetractOnBtn",new intakeRetractOnCmd(0, m_payloadSubSys) );

final JoystickButton intakeExntendBtn = new JoystickButton(driverController, XboxController.Button.kY.value);        
intakeExntendBtn.whenPressed(new intakeExtendCmd( m_payloadSubSys ) ,true);
    SmartDashboard.putData("intakeExntendBtn",new intakeExtendCmd( m_payloadSubSys ) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getdriverController() {
      return driverController;
    }

public Joystick getcopilotJoystick() {
        return copilotJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

