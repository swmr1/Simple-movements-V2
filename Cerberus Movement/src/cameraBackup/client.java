package cameraBackup;



import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Arrays;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class client extends Thread {

	public static int mag;
	public static int dir;
	public static byte[] img;

	public void run() {

		try {
			DatagramSocket clientSocket = new DatagramSocket(4444);

			byte[] receiveData = new byte[640];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.setSoTimeout(100000);
			img = new byte[480 * 640];

			while (!clientSocket.isClosed()) {
				byte[] wait = new byte[5];
				DatagramPacket in = new DatagramPacket(wait, wait.length);
				clientSocket.receive(in);
				String test = new String(wait);
				if (test.equals("start")) {
					System.out.println("start");
					for (int i = 0; i < 480; i++) {
						clientSocket.receive(receivePacket);
						byte[] temp = receivePacket.getData();
						for (int j = 0; j < 640; j++) {
							img[(i * 640) + j] = temp[j];
						}
					}
				}
			}
			clientSocket.close();

		} catch (SocketException e) {
			System.out.println("SocketException");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			System.out.println("Timeout");
		} catch (IOException e) {
			System.out.println("IO exception");
			e.printStackTrace();
		}

	}

}
