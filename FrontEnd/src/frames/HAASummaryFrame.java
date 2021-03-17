package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import charts.Slider;

public class HAASummaryFrame extends InternalFrame{

	private static final long serialVersionUID = 6457256788978318517L;	
	
	Slider slider;
	JPanel panel;
	
	public HAASummaryFrame(ActionListener listener) {
		super(listener,"HAA Summary Close");
		JPanel divider = new JPanel(new GridLayout(0,2));
		float handles[] = {216.2f,180.5f};
		
		slider = new Slider(90,270,500,20, handles, "Hemoglobin Analysis");
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		divider.add(panel);
		divider.add(slider);
		divider.setBackground(Color.WHITE);
		this.add(divider, BorderLayout.CENTER);
		this.setBackground(Color.WHITE);
		//this.actionCommand = "HAASummary Close";
	}


	
}
