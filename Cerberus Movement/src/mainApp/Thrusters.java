package mainApp;

import java.io.*;

import gnu.io.*;

public class Thrusters extends Thread {
	private static SerialPort serialPort;
	private static OutputStream outStream;

	public Thrusters() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		try {
			CommPortIdentifier port = CommPortIdentifier.getPortIdentifier(Main.ThrusterSerialPort);
			serialPort = (SerialPort) port.open("Demo application", 5000);
			outStream = serialPort.getOutputStream();
			serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
			int i = 0;
			while (i == 0) {
				String toSend = "";
				if (Main.AxisXY <= 135 && Main.AxisXY >= 45) {
					System.out.println("Back");
					toSend = "180,0,180,0,180,0";
				} else if (Main.AxisXY <= 225 && Main.AxisXY >= 136) {
					System.out.println("Left");
					toSend = "270,0,0,0,90,60";
				} else if (Main.AxisXY <= 315 && Main.AxisXY >= 225) {
					System.out.println("Forward");
					toSend = "0,0,0,0,0,0";
				} else if (Main.Yaw > 20) {
					System.out.println("Cw");
					toSend = "0,0,0,0,180,0";
				} else if (Main.Yaw < -20) {
					System.out.println("Ccw");
					toSend = "0,0,180,0,0,0";
				} else if (Main.Pitch == 1) {
					System.out.println("Up");
					toSend = "0,0,90,30,90,150";
				} else if (Main.Pitch == -1) {
					System.out.println("down");
					toSend = "0,90,0,0,0,0";
				} else {
					System.out.println("right");
					toSend = "90,0,90,120,0";
				}
				// Config Left(1,0,1); // declares thruster positions for
				// different commands
				// Config Right(1,1,0); // stepper servo stepper servo stepper
				// servo t1on t2on t3on
				// Config Fwd(1,1,1);
				// Config Bwd(1,1,1);
				// Config Up(0,0,90,30,90,150,0,1,1);
				// Config Down(0,90,0,0,0,0,1,0,0);
				// Config Cw(0,1,1);
				// Config Ccw(0,1,1);
				outStream.write(toSend.getBytes());
				Thread.sleep(50);
			}

		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}