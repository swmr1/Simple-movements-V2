import java.io.*;

import gnu.io.*;

public class Thrusters extends Thread {
	private static SerialPort serialPort;
	private static OutputStream outStream;
	
	public Thrusters() {
		// TODO Auto-generated constructor stub
	}
	public void run(){
    	
    	try {
			CommPortIdentifier port = CommPortIdentifier.getPortIdentifier(Main.ThrusterSerialPort);
			serialPort = (SerialPort)port.open("Demo application", 5000);
			outStream = serialPort.getOutputStream();
			serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			String toSend = (Main.AxisXY + ", " + Main.Pitch + ", " + Main.Yaw + ", " + Main.Roll + ", " + Main.mag);
			outStream.write(toSend.getBytes());
			Thread.sleep(50);

			
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