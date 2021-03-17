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

public abstract class InternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	final static Color blue = new Color(0,114,177);
	ActionListener listener;
	JButton closeButton;
	String actionCommand;
	
	public InternalFrame(ActionListener listener) {
		actionCommand = "test blank command";
		this.listener = listener;
		this.setVisible(false);
		this.setBounds(180, 200, 1500, 500);
		setUI(this.getUI());
		this.setBorder(BorderFactory.createLineBorder(blue, 2));
		this.setLayout(new BorderLayout());
		this.add(topBar(actionCommand), BorderLayout.NORTH);
		this.add(topBar(actionCommand), BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
	
			
	}
	
	public InternalFrame(ActionListener listener, String ac) {
		
		this.listener = listener;
		this.setVisible(false);
		this.setBounds(180, 200, 1500, 500);
		setUI(this.getUI());
		this.setBorder(BorderFactory.createLineBorder(blue, 2));
		this.setLayout(new BorderLayout());
		this.add(topBar(ac), BorderLayout.NORTH);
		this.add(topBar(ac), BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
		
		this.actionCommand = ac;
			
	}
	
	
	@Override
    public void setUI(InternalFrameUI ui) {
        super.setUI(ui); // this gets called internally when updating the ui and makes the northPane reappear
        BasicInternalFrameUI frameUI = (BasicInternalFrameUI) getUI(); // so...
        if (frameUI != null) frameUI.setNorthPane(null); // lets get rid of it
    }
	
	// bar for top and bottom
	private JPanel topBar(String ac) {
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
		bar.setPreferredSize(new Dimension(1500,30));
		bar.setLayout(null);
		closeButton = new JButton("Close");
		closeButton.setBounds(1417, -1, 80, 30);
		closeButton.setBackground(Color.LIGHT_GRAY);
		closeButton.addActionListener(listener);
		closeButton.setActionCommand("Close");
		bar.add(closeButton);
		
		return bar;
	}
}
