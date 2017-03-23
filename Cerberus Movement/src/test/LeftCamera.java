package test;

public class LeftCamera extends Thread {
	public void run() {
        try {
            MyFrame frame = new MyFrame(1);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
