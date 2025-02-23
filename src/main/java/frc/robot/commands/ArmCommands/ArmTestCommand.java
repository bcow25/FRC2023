package frc.robot.commands.ArmCommands;
import frc.robot.joystick.FlightJoystick;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmTestCommand extends CommandBase{
    private final ArmSubsystem arm;
    private final FlightJoystick joystick;
    public ArmTestCommand(ArmSubsystem arm, FlightJoystick joystick) {
        this.arm = arm;
        this.joystick = joystick;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        arm.setPivot1Speed(joystick.getLateralMovement()/4);
        System.out.println(joystick.getLateralMovement());
        System.out.println(joystick.getHorizontalMovement());
        arm.setPivot2Speed(joystick.getHorizontalMovement()/4);
        if(joystick.getRawButtonWrapper(8)){
            arm.setTurretSpeed(-0.3);
        }
        else if(joystick.getRawButtonWrapper(9)){
            arm.setTurretSpeed(0.3);
        }
        else{
            arm.setTurretSpeed(0);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
