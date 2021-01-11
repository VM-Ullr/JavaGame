package sort;

import game.archer;

public abstract class SortArcher extends Sort {

	protected archer personnage;
	
	public SortArcher(archer J1) {
		super(J1);
		personnage = J1;
	}

}
