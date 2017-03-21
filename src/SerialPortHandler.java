import java.io.*;

import gnu.io.*;

public class SerialPortHandler {
    private static SerialPort serialPort;
    private static OutputStream outStream;
    public static void connect(String com){
    	
    	try {
			CommPortIdentifier port = CommPortIdentifier.getPortIdentifier(com);
			serialPort = (SerialPort)port.open("Demo application", 5000);
			outStream = serialPort.getOutputStream();
			serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			//outStream.write(messageString.getBytes());
			
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
		}
    	
    }
//    
//            // Get the port's ownership
//            serialPort =
//                    (SerialPort) portId.open("Demo application", 5000);
// 
//            // Set the parameters of the connection.
//            setSerialPortParameters();
// 
//            // Open the input and output streams for the connection. If they won't
//            // open, close the port before throwing an exception.
//            outStream = serialPort.getOutputStream();
//            inStream = serialPort.getInputStream();
//        } catch (NoSuchPortException e) {
//            throw new IOException(e.getMessage());
//        } catch (PortInUseException e) {
//            throw new IOException(e.getMessage());
//        } catch (IOException e) {
//            serialPort.close();
//            throw e;
//        }
//    }
// 
//    /**
//     * Get the serial port input stream
//     * @return The serial port input stream
//     */
//    public InputStream getSerialInputStream() {
//        return inStream;
//    }
// 
//    /**
//     * Get the serial port output stream
//     * @return The serial port output stream
//     */
//    public OutputStream getSerialOutputStream() {
//        return outStream;
//    }
//    public static void sendSerial(String toSend){
//    	byte[] t = toSend.getBytes();
//    	try {
//			outStream.write(t);
//		} catch (IOException e) {
//			System.out.println();
//			e.printStackTrace();
//		}
//    	
//    }
// 
//    /**
//     * Sets the serial port parameters
//     */
//    private void setSerialPortParameters() throws IOException {
//        int baudRate = 115200; // 115200bps
// 
//        try {
//            // Set serial port to 57600bps-8N1..my favourite
//            serialPort.setSerialPortParams(
//                    baudRate,
//                    SerialPort.DATABITS_8,
//                    SerialPort.STOPBITS_1,
//                    SerialPort.PARITY_NONE);
// 
//            serialPort.setFlowControlMode(
//                    SerialPort.FLOWCONTROL_NONE);
//        } catch (UnsupportedCommOperationException ex) {
//            throw new IOException("Unsupported serial port parameter");
//        }
//    }
}