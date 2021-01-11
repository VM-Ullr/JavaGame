package game;

import javax.swing.JPanel;

public abstract class PanelComp extends JPanel {
	protected PanelFond parent;
	
	public PanelComp(PanelFond	parent) {
		this.parent = parent;
	}

}
