import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
	}
	

	public static void main(String[] args) throws AWTException, IOException  {
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(System.getProperty("user.dir")
				+ "/contact.png" +
				""));
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				createAndShowGUI();
			}
		});
}}
