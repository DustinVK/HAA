package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import frames.BackgroundFrame;


/*
 * The main App of the game. Is passed as ActionListener to  
 * Contains a BackGroundFrame which contains the visual frames and panels of the UI.  
 */

public class Application implements ActionListener{
	
	BackgroundFrame bgFrame;

	public Application() {
		bgFrame = new BackgroundFrame(screenSize(),this);
		bgFrame.setSize(screenSize().width,screenSize().height);
		bgFrame.setVisible(true);
	
		    
	}
	
	// background frame and image size is dynamic based on screen resolution
	private static Dimension screenSize() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		if (screen.width < 1920) {
			screen.height = (int) (screen.width / 1.778);
		}
		return screen;
	}
	
	   
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bgFrame.orderButton){
			bgFrame.orderFrame.setVisible(true);
			bgFrame.orderButton.setVisible(false);
		}
		else if(e.getSource() == bgFrame.tabButton) {
			bgFrame.toggleBackground();
		}
		else if(e.getActionCommand().equals("HAASummary")) {
			bgFrame.orderFrame.setVisible(false);
			bgFrame.haaFrame.setVisible(true);
		}
		else if(e.getActionCommand().equals("Close")) {
			bgFrame.haaFrame.setVisible(false);
			bgFrame.orderFrame.setVisible(false);
			bgFrame.orderButton.setVisible(true);
		}
	
		
	}
	


}
