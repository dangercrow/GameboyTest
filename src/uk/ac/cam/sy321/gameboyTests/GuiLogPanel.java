package uk.ac.cam.sy321.gameboyTests;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class GuiLogPanel extends JPanel{
	private static final long serialVersionUID = -6538767763087380975L;

	public GuiLogPanel(){
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Log"));
		
		//TODO
	}
}
