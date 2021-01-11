package sort;

import javax.swing.ImageIcon;

import game.Plateau;
import game.SoundManager;
import game.paladin;

public class Impact extends SortPaladin{

	public Impact(paladin J1) {
		super(J1);
		cooldownOnUse = 6;
		cout = 6;
		portee = 2;
		type = "Force";
		degat=300;
		nom = "Impact";
		anim = new ImageIcon[5];
		for (int i = 0; i < anim.length; i++) {
			anim[i] = new ImageIcon("photos/tranche"+(i+1)+".png");
		}
	}

	@Override
	public void effect(Plateau plate, int x, int y, int k) {
		animation(sprite);
		posXAnim = x*30;
		posYAnim = y*30;
		timer.start();
		onAnimation = true;
		plate.getPlateauPerso()[y][x].takeDamage(degat*k);
		SoundManager.play("sfx/paladinult.wav");
	}

}
