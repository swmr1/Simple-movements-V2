package mainApp;
import java.io.*;
import java.net.*;


public class client extends Thread{
	/**
	 * Mag + ", " + XY + ", " + Yaw+ ", "+ Pitch + ", " + Roll + ", "+ fire;
	 */
	public void run() { 
			try {
				
				DatagramSocket clientSocket = new DatagramSocket(Main.portMovement);
				byte[] receiveData = new byte[1024];  
			    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			    while(!clientSocket.isClosed()){
			    	clientSocket.receive(receivePacket);
			    	String modifiedSentence = new String(receivePacket.getData());
			    	switch (modifiedSentence) {
					case "EMERGENCY":
						emgShutdown.SystemSafeState();
						break;
					default:
						String[] split = modifiedSentence.split(", ");
						Main.mag = Integer.parseInt(split[0]);
						Main.AxisXY = Integer.parseInt(split[1]);
						Main.Yaw = Integer.parseInt(split[2]);
						Main.Pitch = Integer.parseInt(split[3]);
						Main.Roll = Integer.parseInt(split[4]);
						Main.fire = Boolean.getBoolean(split[5]);
						break;
					}
			    }
			    clientSocket.close();
			      
			} catch (SocketException e) {
				System.out.println("SocketException");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  catch (SocketTimeoutException e){
				System.out.println("Timeout");
				emgShutdown.SystemSafeState();
				
			} catch (IOException e) {
				System.out.println("IO exception");
				e.printStackTrace();
			}
		    
		
                
	}

}
