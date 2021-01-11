package sort;

import game.berserker;

public abstract class SortBerserker extends Sort {

	protected berserker personnage;
	
	public SortBerserker(berserker J1) {
		super(J1);
		personnage = J1;
	}

}
