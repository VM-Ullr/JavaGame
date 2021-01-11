package sort;

import game.paladin;

public abstract class SortPaladin extends Sort {

	protected paladin personnage;
	
	public SortPaladin(paladin J1) {
		super(J1);
		personnage = J1;
	}

}
