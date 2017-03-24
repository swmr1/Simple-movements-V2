package cameraBackup;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class test {
	public static void main(String[] args) {
		client cl = new client();
		cl.start();
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		//Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
	

		MyFrame my = new MyFrame();
		my.setVisible(true);
	}
}


