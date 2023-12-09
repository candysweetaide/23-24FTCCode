package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Movement extends LinearOpMode {
    private MecanumDrive mecanumDrive = new MecanumDrive();
    private double maxSpeed = 1;
    private DcMotor arm;
    private Servo rightServo;
    private Servo leftServo;

    public void runOpMode() {
        mecanumDrive.init(hardwareMap);
        //arm = hardwareMap.get(DcMotor.class, "arm");
        //rightServo = hardwareMap.get(Servo.class, "right");
        //leftServo = hardwareMap.get(Servo.class, "left");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double forward = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double rotate = gamepad1.right_stick_x;

            //Gamepad 1 Code
            if(gamepad1.right_trigger >= 0.5){
                maxSpeed = 0.1;
                mecanumDrive.setMaxSpeed(0.1);
            }
            else{
                maxSpeed = 0.5;
                mecanumDrive.setMaxSpeed(1);
            }

            /*if(gamepad1.x)
            {
                arm.setPower(-0.3);
            }
            else if(gamepad1.y)
            {
                arm.setPower(0.3);
            }
            else
            {
                arm.setPower(0.1);
            }*/

            /*if(gamepad1.right_bumper)
            {
                rightServo.setPosition(0.5);
                leftServo.setPosition(0.8);
            }
            else
            {
                rightServo.setPosition(-1);
                leftServo.setPosition(0.8);
            }*/

            mecanumDrive.driveMecanum(forward, strafe, rotate);

            telemetry.addData("Max Speed = ", maxSpeed);
            telemetry.update();
        }
    }
}
