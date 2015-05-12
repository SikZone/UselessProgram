import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Main {

	static BufferedImage image;
	
	private static void createAndShowGUI() {
	JFrame frame = new JFrame("Axrhsto programma");
	JPanel panel = new JPanel();
	panel.setSize(new Dimension(200,200));
	   frame.setSize(1024, 800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setForeground(Color.BLACK);
       frame.setVisible(true);
       while(true){
       int z = randomWithRange(0,30*1000);	// 0 - 30 seconds
       System.out.println(z/1000);			//when the pic is taken
       
    
		final Timer timer = new Timer(z, new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					takeScr();
				} catch (HeadlessException | IOException | AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		timer.start();}

	}
	private static void takeScr() throws IOException, HeadlessException, AWTException{
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(System.getProperty("user.dir")
				+ "/screenshot.png" +
				""));
	}
	
	static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public static void main(String[] args) throws AWTException, IOException  {
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				createAndShowGUI();
			}
		});
}}
