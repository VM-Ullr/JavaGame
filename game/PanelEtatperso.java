package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PanelEtatperso extends PanelComp{
	protected perso J;
	
	public PanelEtatperso(PanelFond parent,perso J, int pos ) {
		super(parent);  
		setBounds(600, pos, 500, 250);
		this.J=J;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(J.getCadre().getImage(),0,0,null);
		g.setColor(new Color(255,255,255)); 
		g.setFont(new Font("Arial", Font.BOLD,15));
		g.drawString("classe : "+J.nom(),140,30);
		g.drawString("point de vie : "+J.getPV(),140,48);
		g.drawString("force : "+J.getForceBuff(),140,66);
		g.drawString("intelligence : "+J.getIntelBuff(),140,84);
		g.drawString("defense : "+J.getDefBuff(),140,102);
		g.drawString("vitesse : "+J.getVitesseBuff(),140,120);
		g.drawString("chance : "+J.getChanceBuff(),140,138);
		g.drawString("PA : "+J.getPA(),20,156);
		g.drawString("sort 1 : "+ (J.getSort()[0]).getNom()+ " | cout : "+(J.getSort()[0]).getCout()+ " | Cooldown : "+(J.getSort()[0]).getCooldown() , 20, 174);
		g.drawString("sort 2 : "+ (J.getSort()[1]).getNom()+ " | cout : "+(J.getSort()[1]).getCout()+ " | Cooldown : "+(J.getSort()[1]).getCooldown() , 20, 192);
		g.drawString("sort 3 : "+ (J.getSort()[2]).getNom()+ " | cout : "+(J.getSort()[2]).getCout()+ " | Cooldown : "+(J.getSort()[2]).getCooldown() , 20, 210);
		g.drawString("sort 4 : "+ (J.getSort()[3]).getNom()+ " | cout : "+(J.getSort()[3]).getCout()+ " | Cooldown : "+(J.getSort()[3]).getCooldown() , 20, 228);

	}

}
