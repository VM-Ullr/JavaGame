package sort;

import game.voleur;

public abstract class SortVoleur extends Sort {
	
	protected voleur personnage;
	
	public SortVoleur(voleur J1) {
		super(J1);
		personnage = J1;
	}

}
