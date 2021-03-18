package frames;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundFrame extends JFrame {

	private static final long serialVersionUID = 8173081588655862415L;

	static BufferedImage backgrounds[];
	static int currentBackground;
	public JButton orderButton;
	public JButton tabButton;
	
	
	public OrderFrame orderFrame;
	public HAASummaryFrame haaFrame;
	

	public BackgroundFrame(Dimension screen, ActionListener listener) {
		backgrounds = getBackgrounds();
		currentBackground = 0;

		JPanel bgPanel = bgPanel(screen);
		bgPanel.setLayout(null);
		setOrderButton(listener, screen);
		setTabButton(listener);
	    bgPanel.add(orderButton);
	    bgPanel.add(tabButton);

	    this.orderFrame = new OrderFrame(listener, screen);
	    this.haaFrame = new HAASummaryFrame(listener, screen);
	    
		this.add(orderFrame);
		this.add(haaFrame);
		this.add(bgPanel);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	backgrounds[0].flush();
		    	backgrounds[1].flush();
		    	System.exit(0);  
		    }
		});
	}

	private JPanel bgPanel(Dimension screen) {
		JPanel bgPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgrounds[currentBackground], EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, screen.width, screen.height, null);
				
			}
		};
		return bgPanel;
	}
	
	public void toggleBackground() {
		if(currentBackground == 0) {
			currentBackground = 1;
		}
		else {
			currentBackground = 0;
		}
		this.repaint();
	}

	private void setTabButton(ActionListener listener) {
		tabButton = new JButton("Switch Tab");
		tabButton.setBounds(150, 45, 90, 45);
		tabButton.setBackground(Color.red);
		tabButton.addActionListener(listener);
		tabButton.setVisible(true);
	}
	
	private void setOrderButton(ActionListener listener, Dimension screen) {
		orderButton = new JButton("Order Button");
		orderButton.setBounds((int) orderButtonPosX(screen), (int)orderButtonPosY(screen), (int)orderButtonWidth(screen), (int)orderButtonHeight(screen));
		orderButton.setBackground(Color.green);
		orderButton.addActionListener(listener);
		orderButton.setActionCommand("Order");
		orderButton.setVisible(true);
	}

	private double orderButtonHeight(Dimension screen) {
		return screen.height/9.2;
	}

	private double orderButtonWidth(Dimension screen) {
		return screen.width / 4.28;
	}

	private double orderButtonPosY(Dimension screen) {
		return screen.height * .24;
	}

	private double orderButtonPosX(Dimension screen) {
		return screen.width*0.765;
	}
	
	private BufferedImage[] getBackgrounds() {
		BufferedImage backgrounds[] = new BufferedImage[2];
		try {
			backgrounds[0] = ImageIO.read(new File("images/bg1.png"));
			backgrounds[1] = ImageIO.read(new File("images/bg2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return backgrounds;
	}
	
	

	public JButton getOrderButton() {
		return orderButton;
	}


	public JButton getTabButton() {
		return tabButton;
	}



	


}
