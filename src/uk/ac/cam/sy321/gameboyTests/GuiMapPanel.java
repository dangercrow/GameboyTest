package uk.ac.cam.sy321.gameboyTests;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class GuiMapPanel extends JPanel{
	private static final long serialVersionUID = -7621642262931495171L;

	public GuiMapPanel(){
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Map"));
		
		//TODO
	}
}
