package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InternalFrameBar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	final static Color blue = new Color(0,114,177);
	
	ActionListener actionListener;
    Dimension screen;
    
    /*
     * InternalFrameBar are the top and bottom bars of the InternalFrame
     * 
     * It uses composition to create the bar 
     * 
     */
	
	public InternalFrameBar(Dimension screen, ActionListener actionListener, MouseListener mouseListener, MouseMotionListener motionListener ) {
		this.screen = screen;
		this.actionListener = actionListener;
		this.setPreferredSize(new Dimension(width(),barHeight()));
		this.setLayout(null);
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(motionListener);

	}
	
	public void addCloseButton() {
		JButton closeButton = new JButton("Close");
		closeButton.setBounds(width() - buttonWidth(), -1, buttonWidth(), barHeight());
		closeButton.setBackground(Color.LIGHT_GRAY);
		closeButton.addActionListener(actionListener);
		closeButton.setActionCommand("Close");
		this.add(closeButton);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D) g;
	      // draw the rectangle here
	      g2.setColor(blue);
	      g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	   }
	
	private int barHeight() {
		return (int) screen.height / 36;
	}
	
	private int width() {
		return (int) (screen.width / 1.28);
	}
	
	private int buttonWidth() {
		return (int) screen.width / 16 ;
	}

}
