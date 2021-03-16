package frames;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 8173081588655862415L;

	static BufferedImage bg1, bg2;
	JButton orderButton;
	
	OrderFrame orderFrame;
	HAASummaryFrame haaFrame;

	public BackgroundFrame(Dimension screen) {
		setBackgrounds();

		JPanel bgPanel = bgPanel(screen);
		bgPanel.setLayout(null);
		setOrderButton();
	    bgPanel.add(orderButton);
	    orderFrame = new OrderFrame(this);
	    haaFrame = new HAASummaryFrame();
	    
	    //orderFrame.setBorder(null);
		this.add(orderFrame);
		this.add(haaFrame);
		this.add(bgPanel);
	}

	private JPanel bgPanel(Dimension screen) {
		JPanel bgPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				//g.drawImage(bg1, 0, 0, null);
				g.drawImage(bg1, EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, screen.width, screen.height, null);
				
			}
		};
		return bgPanel;
	}

	private void setOrderButton() {
		orderButton = new JButton("Order Button");
		orderButton.setBounds(1470, 263, 440, 110);
		orderButton.setBackground(Color.green);
		orderButton.addActionListener(this);
		orderButton.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderButton){
			orderFrame.setVisible(true);
			orderButton.setVisible(false);
		}
		else if(e.getActionCommand().equals("HAA Summary")) {
			orderFrame.setVisible(false);
			haaFrame.setVisible(true);
		}
		
	}
	


}
