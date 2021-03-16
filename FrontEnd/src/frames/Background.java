package frames;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JFrame{

	private static final long serialVersionUID = 8173081588655862415L;

	static BufferedImage bg1, bg2;
	public Background(Dimension screen) {
		setBackgrounds();
		JPanel panel = new JPanel() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				//g.drawImage(bg1, 0, 0, null);
				g.drawImage(bg1, EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, screen.width, screen.height, null);
				
			}
		};
		this.add(panel);
	}
	
	private void setBackgrounds() {
		try {
			bg1 = ImageIO.read(new File("images/bg1.png"));
			bg2 = ImageIO.read(new File("images/bg2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	


}
