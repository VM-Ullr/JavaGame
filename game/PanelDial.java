package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class PanelDial extends PanelComp {
	
	protected String [] lignes;
	protected ImageIcon fonddial;
	protected ImageIcon cadrede;
	protected ImageIcon jeton;
	
	public PanelDial(PanelFond parent, PanelPlateau plate) {
		super(parent);
		fonddial = new ImageIcon("photos/boite.png");
		cadrede = new ImageIcon("photos/cadrede.png");
		setBounds(0,530,1400,170);
		lignes = new String [7];
		lignes [0]=plate.getPlateau().getActualPlayer().nom()+" a vous de jouer";
		lignes [1]="utilisez les touches z,q,s,d pour vous déplacer";
		lignes [2]="";
		lignes [3]="et les touches 1,2,3,4 pour lancer vos sorts";
		lignes [4]="";
		lignes [5]="";
		lignes [6]="";
		jeton=plate.getPlateau().getActualPlayer().getJeton();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(fonddial.getImage(),0,0,null);
		g.setColor(new Color(255,255,255)); 
		g.setFont(new Font("Arial", Font.BOLD,15));
		g.drawString(lignes[0],20,30);
		g.drawString(lignes[1],20,50);
		g.drawString(lignes[3],20,70);
		g.drawString(lignes[4],20,90);
		g.drawString(lignes[5], 20, 110);
		g.drawString(lignes[6], 20, 130);
		g.drawImage(cadrede.getImage(),1200,10,null);
		g.setColor(new Color(0,0,255)); 
		if(lignes[2].length() < 4){
		g.setFont(new Font("Arial", Font.BOLD,30));
		g.drawString(lignes[2], 1220, 53);
		}else{
			g.drawString(lignes[2], 1213, 53);
		}
		g.drawImage(jeton.getImage(),1195,0,null);
	}

	public String[] getLignes() {
		return lignes;
	}

	public void setLignes(String[] lignes) {
		this.lignes = lignes;
	}
	
	public void setJeton(perso J){
		jeton=J.getJeton();
	}
	
	

	
}
