package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public abstract class InternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	final static Color blue = new Color(0,114,177);
	
	public InternalFrame() {
		this.setVisible(false);
	
		this.setBounds(180, 200, 1500, 500);
		setUI(this.getUI());
		this.setBorder(BorderFactory.createLineBorder(blue, 2));
		this.setLayout(new BorderLayout());
		this.add(bar(), BorderLayout.NORTH);
		this.add(bar(), BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
			
	}
	
	
	@Override
    public void setUI(InternalFrameUI ui) {
        super.setUI(ui); // this gets called internally when updating the ui and makes the northPane reappear
        BasicInternalFrameUI frameUI = (BasicInternalFrameUI) getUI(); // so...
        if (frameUI != null) frameUI.setNorthPane(null); // lets get rid of it
    }
	
	// bar for top and bottom
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
		bar.setPreferredSize(new Dimension(1500,30));
		return bar;
	}
}
