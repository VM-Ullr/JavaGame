package sort;

import javax.swing.ImageIcon;

import game.Plateau;
import game.SoundManager;
import game.archer;
import game.perso;

public class TirDirect extends SortArcher {

	public TirDirect(archer J1) {
		super(J1);
		cooldownOnUse = 0;
		cout = 3;
		portee = 5;
		type = "Force";
		degat=70;
		nom = "Tir direct";
	}

	@Override
	public void effect(Plateau plate, int x, int y,int k) {
		plate.getPlateauPerso()[y][x].takeDamage(degat*k);
		SoundManager.play("sfx/archerQ.wav");
	}

}
