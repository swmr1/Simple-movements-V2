import java.io.*;
import java.net.*;


public class client extends Thread{
	/**
	 * XY + ", " + Yaw+ ", "+ Pitch + ", " + Roll + ", "+ Stop;
	 */
	public void run() { 
			try {
				
				DatagramSocket clientSocket = new DatagramSocket(Main.portMovement);
				byte[] receiveData = new byte[1024];  
			    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			    clientSocket.setSoTimeout(10000);
			    while(!clientSocket.isClosed()){
			    	clientSocket.receive(receivePacket);
			    	String modifiedSentence = new String(receivePacket.getData());
			    	switch (modifiedSentence) {
					case "EMERGENCY":
						emgShutdown.SystemSafeState();
						break;
					default:
						String[] split = modifiedSentence.split(", ");
						if (split[split.length-1].equals(true)){
							
						}
						break;
					}
			    	System.out.println("FROM SERVER:" + modifiedSentence);
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
