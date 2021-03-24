package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * InternalFrame is a JInternalFrame 
 * Overrides the setUI method to hide the default look so we can create a custom frame to match existing software 
 * 
 * * #TODO 
 * 		* Add a bar with accept and close buttons
 *	  	* Suggested improvements:
 *	  			Change the bar methods to favor composition over inheritance
 *				Make frame resizable and movable 
 *			
 */

public abstract class InternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	final static Color blue = new Color(0,114,177);
	ActionListener listener;
	JButton closeButton;
	
	Dimension screen;
	
	public InternalFrame(ActionListener listener, Dimension screen) {
		this.screen = screen;
		this.listener = listener;
		this.setVisible(false);
		this.setBounds(posX(), posY(), width(), height());
		setUI(this.getUI());
		this.setBorder(BorderFactory.createLineBorder(blue, 2));
		this.setLayout(new BorderLayout());
		this.add(topBar(), BorderLayout.NORTH);
		this.add(bar(), BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
		//this.setResizable(true); 
	
	}
	
	private int posX() {
		return (int) (screen.width / 10.6667);
	}
	
	private int posY() {
		return (int) (screen.height / 4.5);
	}
	
	private int width() {
		return (int) (screen.width / 1.28);
	}
	
	private int height() {
		return (int) (screen.height / 2);
	}
	
	private int barHeight() {
		return (int) screen.height / 36;
	}
	
	private int topButtonWidth() {
		return (int) screen.width / 16;
	}
	
	@Override
    public void setUI(InternalFrameUI ui) {
        super.setUI(ui); // this gets called internally when updating the ui and makes the northPane reappear
        BasicInternalFrameUI frameUI = (BasicInternalFrameUI) getUI(); // so...
        if (frameUI != null) frameUI.setNorthPane(null); // lets get rid of it
    }
	
	
	/*
	 
	 */
	private JPanel topBar() {
		JPanel bar = bar();
		bar.setPreferredSize(new Dimension(width(),barHeight()));
		bar.setLayout(null);
		closeButton = new JButton("Close");
		closeButton.setBounds(width() - topButtonWidth(), -1, topButtonWidth(), barHeight());
		closeButton.setBackground(Color.LIGHT_GRAY);
		closeButton.addActionListener(listener);
		closeButton.setActionCommand("Close");
		bar.add(closeButton);
		
		return bar;
	}
	


	// base bar for top and bottom
	private JPanel bar() {
		JPanel bar = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			   public void paintComponent(Graphics g) {
			      super.paintComponent(g);
			      Graphics2D g2 = (Graphics2D) g;
			      // draw the rectangle here
			      g2.setColor(blue);
			      g2.fillRect(0, 0, this.getWidth(), this.getHeight());
			   }
		};
		bar.setPreferredSize(new Dimension(width(),barHeight()));
		bar.setLayout(null);
		return bar;
	}
}
