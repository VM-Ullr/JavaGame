package sort;

import game.Plateau;
import game.SoundManager;
import game.archer;
import game.perso;

public class TirPuissant extends SortArcher{

	public TirPuissant(archer J1) {
		super(J1);
		cooldownOnUse = 6;
		cout = 5;
		portee = 4;
		type = "Force";
		degat=250;
		nom = "Tir puissant";
	}

	@Override
	public void effect(Plateau plate, int x, int y,int k) {
		plate.getPlateauPerso()[y][x].takeDamage(degat*k);
		SoundManager.play("sfx/archerult.wav");
	}

}
