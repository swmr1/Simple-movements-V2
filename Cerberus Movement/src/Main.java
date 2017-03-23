import Video.LeftCamera;
import Video.RightCamera;

public class Main{
	
	static client movementInput;
	public static SerialPortHandler ThrusterMovement;
	static UDPServer SendingData;	//public static SerialPortHandler SensorInputData;
	static SensorData sensors;
	
	public static String RemoteIp = "163.118.36.65";

	public static int portCenterMainCamera = 3333;
	public static int portLeftArmCamera = 4444;
	public static int portRightArmCamera = 5555;
	public static int portMovement = 6666; 
	public static int portSending = 7777;
	
	//Serial Ports
	public static String SensorSerialPort = "COM5";
	public static String ThrusterSerialPort = "COM6";

	//Sensor Data
	public static int Prox1 = 0;
	public static int Prox2 = 0;
	public static int Prox3 = 0;
	public static int Prox4 = 0;
	public static boolean PreasureSwitch = false;
	public static int rangeFinder = 0;
	
	//Commands from controller
	public static int AxisXY;
	public static int Roll;
	public static int Pitch;
	public static int Yaw;

	public static void main(String[] args) throws Exception {
//		movementInput = new client();
//		movementInput.start();
//		SendingData = new UDPServer();
//		SendingData.start();
//		sensors = new SensorData();
//		sensors.start();
		LeftCamera left = new LeftCamera();
		left.start();
//		Thread.sleep(20);
//		RightCamera right = new RightCamera();
//		right.start();
		
	}
}

