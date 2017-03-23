package test;




public class RightCamera extends Thread {
	//EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MyFrame frame = new MyFrame(0);
				frame.setVisible(true);
			} 	catch (Exception e) {
				e.printStackTrace();
			}
		}
	//}

}
