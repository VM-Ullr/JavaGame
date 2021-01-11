package sort;

import javax.swing.ImageIcon;

import game.Plateau;
import game.SoundManager;
import game.mage;
import game.perso;

public class SouffleDragon extends SortMage {

	/**
	 * 
	 */
	public SouffleDragon(mage J1) {
		super(J1);
		cooldownOnUse = 6;
		cout = 5;
		portee = 5;
		type = "Intelligence";
		degat=250;
		nom = "Souffle du dragon";
		anim = new ImageIcon[5];
		anim[0] = new ImageIcon("photos/feu1.png");
		anim[1] = new ImageIcon("photos/feu2.png");
		anim[2] = new ImageIcon("photos/feu3.png");
		anim[3] = new ImageIcon("photos/feu2.png");
		anim[4] = new ImageIcon("photos/feu1.png");

	}

	@Override
	public void effect(Plateau plate, int x, int y,int k) {
		animation(sprite);
		posXAnim = x*30;
		posYAnim = y*30;
		timer.start();
		onAnimation = true;
		plate.getPlateauPerso()[y][x].takeDamage(degat*k);
		SoundManager.play("sfx/katon2.wav");
	}

}
