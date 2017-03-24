package cameraBackup;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class MyFrame extends JFrame {
    /**
	 * 
	 */
	//private static final long serialVersionUID = -1363938950107966953L;
	private JPanel contentPane;
  /**
  * Launch the application.
  */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //MyFrame frame = new MyFrame(0);
                   // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

  /**
  * Create the frame.
  */
    public MyFrame() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 490, 650 );
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
  
        new MyThread().start();
    }


 
    public void paint(Graphics g){
        g = contentPane.getGraphics();

        Mat mat1 = new Mat(480, 640, CvType.CV_8UC1);
        BufferedImage img = new BufferedImage(mat1.cols(),mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
        img.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), client.img);
        g.drawImage(img, 0, 0, this);
    }
 
    class MyThread extends Thread{
        @Override
        public void run() {
            for (;;){
                repaint();
                try { Thread.sleep(0);
                } catch (InterruptedException e) {    }
            }  
        } 
    }
}