package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * An InternalFrame for the order info and confirmation window 
 * 
 *  #TODO: Needs to be fleshed out more as it's currently just a placeholder 
 */

public class OrderFrame extends InternalFrame {
	
	private static final long serialVersionUID = -2104859513530411013L;
	JButton haaButton;
	
	public OrderFrame(ActionListener listener, Dimension screen) {
		super(listener, screen);
		JButton haaButton = new JButton("HAA Summary");
		haaButton.addActionListener(listener);
		haaButton.setActionCommand("HAASummary");
		JPanel divider = new JPanel(new BorderLayout());
		divider.add(haaButton, BorderLayout.WEST);
		haaButton.setPreferredSize(new Dimension(200, 50));

		
		this.add(divider, BorderLayout.CENTER);
	}



	

}
