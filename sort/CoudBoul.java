package sort;

import game.Plateau;
import game.SoundManager;
import game.perso;
import game.voleur;

public class CoudBoul extends SortVoleur{

	public CoudBoul(voleur J1) {
		super(J1);
		cooldownOnUse = 0;
		cout = 3;
		portee = 1;
		type = "Force";
		degat = 80;
		nom = "CoudBoul";
	}

	@Override
	public void effect(Plateau plate, int x, int y, int k) {
		plate.getPlateauPerso()[y][x].takeDamage(degat*k);
		SoundManager.play("sfx/coudboul.wav");
	}

}
