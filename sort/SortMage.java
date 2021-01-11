package sort;

import game.mage;

public abstract class SortMage extends Sort {

	protected mage personnage;
	
	public SortMage(mage J1) {
		super(J1);
		personnage = J1;
	}

}
