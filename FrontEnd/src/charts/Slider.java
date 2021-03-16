package charts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slider extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4584823459481295653L;
	int min, max, width, height;
	float values[];
	
	JLabel header;
	
	SliderPanel panel;
	
	public Slider(int min, int max, int width, int height, float[] values, String title) {
		panel = new SliderPanel(min, max, width, height, values);
		panel.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);

		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		setHeader(title);
	}
	
	public void setHeader(String title) {
		header = new JLabel(title);
		header.setFont(new Font("Segoe UI", Font.BOLD,20));
		header.setBackground(Color.WHITE);
		this.add(header, BorderLayout.NORTH);
	}

}
