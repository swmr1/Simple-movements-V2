package mainApp;
import Video.LeftCamSend;
import Video.RightCamSend;

public class Main{
	
	static client movementInput;
	static Thrusters ThrusterMovement;
	static UDPServer SendingData;	//public static SerialPortHandler SensorInputData;
	static SensorData sensors;
	static OtherData other;
	
	public static String RemoteIp = "192.168.0.3";

	public static int portCenterMainCamera = 3333;
	public static int portLeftArmCamera =	 4444;
	public static int portRightArmCamera =	 5555;
	public static int portMovement =		 6666; 
	public static int portSending = 		 7777;
	public static int portOtherComands =	 8888;
	
	//Serial Ports
	public static String SensorSerialPort = "COM5";
	public static String ThrusterSerialPort = "COM6";
	
	// camera numbers
	public static int RightCamNum = 0;
	public static int LeftCamNum = 0;
	
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
	public static int mag;
	public static boolean fire;
	
	public static LeftCamSend left;
	public static RightCamSend right;
	public static void main(String[] args) throws Exception {
		
		movementInput = new client();
		movementInput.start();
		ThrusterMovement = new Thrusters();
		ThrusterMovement.start();
//		SendingData = new UDPServer();
//		SendingData.start();
//		sensors = new SensorData();
//		sensors.start();
//		other = new OtherData();
//		other.start();
		left = new LeftCamSend();
		left.start();
//		right = new RightCamSend();
//		right.start();
		
	}
}

