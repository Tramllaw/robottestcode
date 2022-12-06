// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotContainer;




public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private Spark frontLeft;
  private Spark frontRight;
  private Spark backLeft;
  private Spark backRight;
  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;
  private DifferentialDrive drive;
  
  public DriveSubsystem() {
    frontLeft = new Spark(0);
    frontRight = new Spark(1);
    backLeft = new Spark(2);
    backRight = new Spark(3);
    leftMotors = new MotorControllerGroup(frontLeft, backLeft);
    rightMotors = new MotorControllerGroup(frontRight, backRight);
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double rightTrigger = RobotContainer.joystick.getRightTriggerAxis();
    double leftTrigger = RobotContainer.joystick.getLeftTriggerAxis();
    double forwardSpeed = rightTrigger - leftTrigger;
    double turnSpeed = RobotContainer.joystick.getLeftX();
    drive.arcadeDrive(forwardSpeed, turnSpeed);

  }


  public void setSpeedAndRotation(double speed, double rotation)
  {
    drive.arcadeDrive(speed, rotation);
  }
}