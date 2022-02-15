// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static frc.robot.Constants.PNEUMATICS_DATA.*;

public class Pneumatics extends SubsystemBase {
  private final Compressor compressor = new Compressor();
  private final DoubleSolenoid solenoid = new DoubleSolenoid(
  solenoid_forward_channel, solenoid_reverse_channel);
  public XboxController xbox;
  /** Creates a new Pneumatics. */
  public Pneumatics(XboxController controller) {
    xbox = controller;
  }
  
  public Compressor getInstanceCompressor() {
    return compressor;
  }
  
  @Override
  public void periodic() {
    if (xbox.getBumperPressed(Hand.kLeft)) {
      solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else if (xbox.getBumperPressed(Hand.kRight)) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    if (xbox.getAButton()) {
      compressor.start();
    }
    else if(xbox.getBButton()) {
      compressor.stop();
    }
    // This method will be called once per scheduler run
  }
}
