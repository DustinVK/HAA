package frames;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BackgroundFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 8173081588655862415L;

	static BufferedImage backgrounds[];
	static int currentBackground;
	JButton orderButton;
	JButton tabButton;
	
	OrderFrame orderFrame;
	HAASummaryFrame haaFrame;

	public BackgroundFrame(Dimension screen) {
		backgrounds = getBackgrounds();
		currentBackground = 0;

		JPanel bgPanel = bgPanel(screen);
		bgPanel.setLayout(null);
		setOrderButton();
		setTabButton();
	    bgPanel.add(orderButton);
	    bgPanel.add(tabButton);
	    orderFrame = new OrderFrame(this);
	    haaFrame = new HAASummaryFrame(this);
	    
	    //orderFrame.setBorder(null);
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
				//g.drawImage(bg1, 0, 0, null);
				g.drawImage(backgrounds[currentBackground], EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, screen.width, screen.height, null);
				
			}
		};
		return bgPanel;
	}
	
	private void toggleBackground() {
		if(currentBackground == 0) {
			currentBackground = 1;
		}
		else {
			currentBackground = 0;
		}
		this.repaint();
	}

	private void setTabButton() {
		tabButton = new JButton("Switch Tab");
		tabButton.setBounds(150, 45, 90, 45);
		tabButton.setBackground(Color.red);
		tabButton.addActionListener(this);
		tabButton.setVisible(true);
	}
	
	private void setOrderButton() {
		orderButton = new JButton("Order Button");
		orderButton.setBounds(1470, 263, 440, 110);
		orderButton.setBackground(Color.green);
		orderButton.addActionListener(this);
		orderButton.setVisible(true);
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
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderButton){
			orderFrame.setVisible(true);
			orderButton.setVisible(false);
		}
		else if(e.getSource() == tabButton) {
			toggleBackground();
		}
		else if(e.getActionCommand().equals("HAASummary")) {
			System.out.print("sup");
			orderFrame.setVisible(false);
			haaFrame.setVisible(true);
		}
		else if(e.getActionCommand().equals("Close")) {
			System.out.print("sup");
			haaFrame.setVisible(false);
			orderFrame.setVisible(false);
			orderButton.setVisible(true);
		}
	
		
	}
	


}
