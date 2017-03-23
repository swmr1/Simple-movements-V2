package Video;

public class LeftCamera extends Thread {
	public void run() {
        try {
        	System.out.println("Running");
            MyFrame frame = new MyFrame(1);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
