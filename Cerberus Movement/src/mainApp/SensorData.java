import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SensorData extends Thread implements SerialPortEventListener {

	
	public void run() {
		initialize();
	}

	SerialPort serialPort;
	/** The port we're normally going to use. */
//	private static final String PORT_NAMES[] = { 
//			"/dev/tty.usbmodem1421", // Mac os x
//			"/dev/ttyACM0", // Raspberry Pi
//			"/dev/ttyUSB0", // Linux
//			"COM5", // Windows
//	};

	/**
	 * A BufferedReader which will be fed by a InputStreamReader converting the
	 * bytes into characters making the displayed results codepage independent
	 */
	private BufferedReader input;
	/** The output stream to the port */
	@SuppressWarnings("unused")
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 115200;

	public void initialize() {
		// the next line is for Raspberry Pi and
		// gets us into the while loop and was suggested here was suggested
		// http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
		// System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

		CommPortIdentifier portId = null;
		@SuppressWarnings("rawtypes")
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			//for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(Main.SensorSerialPort)) {
					portId = currPortId;
					break;
				}
			//}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams
				(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				//System.out.println("TEST");
				String inputLine = input.readLine();
				String[] SplitIn = inputLine.split(", ");
				Main.Prox1 = Integer.parseInt(SplitIn[0]);
				Main.Prox2 = Integer.parseInt(SplitIn[1]);
				Main.Prox3 = Integer.parseInt(SplitIn[2]);
				Main.Prox4 = Integer.parseInt(SplitIn[3]);
				Main.PreasureSwitch = Boolean.getBoolean(SplitIn[4]);
				Main.rangeFinder = Integer.parseInt(SplitIn[5]);

				
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}
}