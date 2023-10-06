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
        arm = hardwareMap.get(DcMotor.class, "arm");
        rightServo = hardwareMap.get(Servo.class, "right");
        leftServo = hardwareMap.get(Servo.class, "left");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double forward = gamepad1.left_stick_y;
        }
    }
}
