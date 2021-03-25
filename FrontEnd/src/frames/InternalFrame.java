package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * InternalFrame is a custom JInternalFrame 
 * 
 *  - it Overrides the setUI method to hide the default look so we can create a custom frame to match existing software 
 *  - and Contains a top and bottom InternalFrameBar
 *			
 */

public abstract class InternalFrame extends JInternalFrame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	final static Color blue = new Color(0,114,177);
	ActionListener listener;
	JButton closeButton;
	
	public InternalFrameBar topBar;
	public InternalFrameBar bottomBar;
	
	static Dimension screen;
	
	private volatile int screenX, screenY, myX, myY;
	
	public InternalFrame(ActionListener listener, Dimension screen) {
		this.screen = screen;
		this.listener = listener;
		this.setVisible(false);
		topBar = new InternalFrameBar(screen, listener, this, this);
		topBar.addCloseButton();
		bottomBar = new InternalFrameBar(screen, listener, this, this);
		screenX = 0;
		screenY = 0;
		myX = 0;
		myY = 0;
		this.setBounds(posX(), posY(), width(), height());
		setUI(this.getUI());
		this.setBorder(BorderFactory.createLineBorder(blue, 2));
		this.setLayout(new BorderLayout());
		this.add(topBar, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
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
	

	@Override
    public void setUI(InternalFrameUI ui) {
        super.setUI(ui); // this gets called internally when updating the ui and makes the northPane reappear
        BasicInternalFrameUI frameUI = (BasicInternalFrameUI) getUI(); // so...
        if (frameUI != null) frameUI.setNorthPane(null); // lets get rid of it
    }
	
	
	// mouse listening methods 
	@Override
	public void mouseClicked(MouseEvent e) {
		screenX = e.getXOnScreen();
		screenY = e.getYOnScreen();
		
	    myX = getX();
	    myY = getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();

        myX = getX();
        myY = getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        setLocation(myX + deltaX, myY + deltaY);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
