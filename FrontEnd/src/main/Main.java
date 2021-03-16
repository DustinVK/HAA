package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import frames.Background;

public class Main {

	public static void main(String[] args) {
		Background bg = new Background(screenSize());
		bg.setSize(screenSize().width,screenSize().height);
		bg.setVisible(true);

	}
	
	// background frame and image size is dynamic based on screen resolution
	private static Dimension screenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

}
