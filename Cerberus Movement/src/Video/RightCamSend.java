package Video;

import java.io.IOException;
import java.net.*;

import org.opencv.core.Mat;

import mainApp.Main;

public class RightCamSend extends Thread {
	// TODO Edit to fit our needs
	public static int dir;
	public static double mag;

	public void run() {
		try {
			InetAddress host;
			
			host = InetAddress.getByName(Main.RemoteIp);
			@SuppressWarnings("resource")
			DatagramSocket serverSocket = new DatagramSocket();
			serverSocket.connect(host, Main.portRightArmCamera);
			VideoCap vid = new VideoCap(Main.RightCamNum);
			int i = 1;


			while (i == 1) {
				byte[] ready = "start".getBytes();
				DatagramPacket receivePacket = new DatagramPacket(ready, ready.length);
				serverSocket.send(receivePacket);
				
				Mat sendData = vid.getOneFrame();
				byte[] data = new byte[(int)(sendData.total() * sendData.channels())];
				sendData.get(0, 0, data);
				
				for(int k = 0; k < sendData.height(); k++){
					byte[] temp = new byte[sendData.width()];
					for(int j = 0; j < sendData.width(); j++){
						int index = j + (k*sendData.width());
						temp[j] = data[index];
					}
					receivePacket = new DatagramPacket(temp, temp.length);
					serverSocket.send(receivePacket);
					//Thread.sleep();
				}
				Thread.sleep(100);

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}