import edu.wpi.first.wpilibj.*;


public class TestRobot extends SampleRobot {

    // This declares a new RobotDrive that uses PWM outputs 0 and 1
    // The RobotDrive is used to control the motors on the robot.
    private RobotDrive drivetrain = new RobotDrive(0, 1);
    private Joystick gamepad = new Joystick(0);
     private Timer timer = new Timer();               // This declares the time delays.

    // This function gets called once when the robot wakes up
    protected void robotInit() {
        // Here, we print a welcome message
        System.out.println("Hello! I am TestRobot");

        // TODO Try driving forward (negative speed), and see which way the wheels
        // turn. if the left wheel is turning backwards, uncomment the line with
        // 'kRearLeft'. If the right wheel is turning backwards, uncomment the line
        // with 'kRearRight'. If BOTH wheels are turning backwards, uncomment both 
        // lines. 
        //
        // NOTE: You can also switch the wires around in lieu of uncommenting the
        // respective code lines
        
        // drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        // drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
   


    // The code in this function gets run when the robot enters autonomous mode

    protected void autonomous() {
 
     // if you setup the robot on right side use algo1, and if you set up the rovot use algo2.
   
       algo1();           //right side
       // algo2();      // for left side
            
 
    }
    
    
    protected void algo1(){
       
            
        
        drivetrain.arcadeDrive(-1, 0);              // (move, turn)
             timer.delay(1.0);
            
            drivetrain.arcadeDrive(0, 0.5);         //(move, turn)
        timer.delay(0.05);

        drivetrain.arcadeDrive(-1, 0);             // (move, turn)
         timer.delay(1.0);
               
			   
			   drivetrain.arcadeDrive(0,0);
    }
    
    
    protected void algo2(){
        
        drivetrain.arcadeDrive(-1, 0);         // (move, turn)
            timer.delay(1.0);
            
            drivetrain.arcadeDrive(0, -1);     // (move, turn)
        timer.delay(0.05);

        drivetrain.arcadeDrive(-1, 0);         // (move, turn)
        timer.delay(1.0);

              drivetrain.arcadeDrive(0,0);
    }
 

    // The code in this function gets run when the robot enters teleop mode


    protected void operatorControl() {
        // Fairly standard way to keep looping while in operator control mode
    while(isOperatorControl()) {
        // SENSE
        double moveVal = gamepad.getRawAxis(1);      // left stick on game pad, y-axis 
        double turnVal = gamepad.getRawAxis(2);     // right stick, x-axis

       // ACT
       drivetrain.arcadeDrive(moveVal, turnVal);

    }

    }

    // The code in this function gets run when the robot is disabled
    protected void disabled() {
        // In this case, we print a message
        System.out.println("Aww... I've been disabled");
    }
}

