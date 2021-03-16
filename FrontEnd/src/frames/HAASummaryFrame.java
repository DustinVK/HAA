package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import charts.Slider;

public class HAASummaryFrame extends InternalFrame{

	private static final long serialVersionUID = 6457256788978318517L;	
	
	public HAASummaryFrame() {
		super();
		JPanel divider = new JPanel(new GridLayout(0,2));
		float handles[] = {216.2f,180.5f};
		
		Slider slider = new Slider(90,270,500,20, handles, "Hemoglobin Analysis");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		divider.add(p1);
		divider.add(slider);
		divider.setBackground(Color.WHITE);
		this.add(divider, BorderLayout.CENTER);
		this.setBackground(Color.WHITE);
	}
	
}
