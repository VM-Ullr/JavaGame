package game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class PanelFond extends JPanel {
	protected Frame parent;
	protected ImageIcon fondmenu;
	
	public PanelFond(Frame parent) {
		this.parent = parent;
	}
	
	public void goToPanelFond(PanelFond next) {
		parent.setToPanel(next);
	}
	
	public abstract void onKeyPressed(KeyEvent e);
	
	public abstract void onMousePressed(MouseEvent e);

}