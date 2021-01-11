package game;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class PanelFin extends PanelFond  {
	perso win;
	perso los;	

	public PanelFin (Frame  parent,perso J1, perso J2){
		super(parent);
		if (J1.estVivant()){
			win=J1;
			los=J2;
			fondmenu = new ImageIcon("photos/podiumP1.png");
		}else{
			win=J2;
			los=J1;
			fondmenu = new ImageIcon("photos/podiumP2.png");
		}
		
		setLayout(null);
	}

	public void paintComponent (Graphics g) {
		g.drawImage(fondmenu.getImage(),-10,-50,null);
		g.drawImage(win.getPodium().getImage(),690,80,null); 
		g.drawImage(los.getPodium().getImage(),450,150,null);
	}

	@Override
	public void onKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}