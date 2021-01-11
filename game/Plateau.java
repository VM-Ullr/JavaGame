package game;

import sort.Sort;

public class Plateau {
	protected int taille = 17; //Taille du plateau
	protected int [][] plateauMod; //Tableau d'entier représentant le plateau
	protected perso[][] plateauPerso;
	protected int vide = 0;
	protected int rocher = 3;
	protected int flower1 = 5;
	protected int grass2 = 7;
	protected int flower2=6;
	protected int water=8;
	protected int bridge=9;
	protected perso J1;
	protected perso J2;
	protected perso actualPlayer;
	protected Sort selectedSort;
	
	
	
	public Plateau (perso J1, perso J2) { //Entiers désignant les différentes entités présentes sur le terrain
		this.J1 = J1;
		this.J2 = J2;
		actualPlayer = (J1.getVitesse() > J2.getVitesse())? J1 : J2;
		this.plateauMod = new int [taille][taille];
		this.plateauPerso = new perso[taille][taille];
		for (int x = 0; x < taille; x++){ //Placement des rochers autour du terrain
			this.plateauMod [0][x] = rocher;
			this.plateauMod [taille - 1][x] = rocher;
			this.plateauMod [x][0] = rocher;
			this.plateauMod [x][taille - 1] = rocher;
		}
		for (int i = 0 ; i < this.plateauMod.length; i++){
			plateauMod[8][i] = water;
		}
		plateauMod[8][4] = bridge;
		plateauMod[8][8] = bridge; 
		plateauMod[8][12] = bridge;
		J1.setPosX(5 + ((int) (Math.random()*7)));
		J1.setPosY(3 + ((int) (Math.random()*3)));
		J2.setPosX(5 + ((int) (Math.random()*7)));
		J2.setPosY((taille - 4) - ((int) (Math.random()*3)));
		plateauPerso[J1.getPosY()][J1.getPosX()] = J1;
		plateauPerso[J2.getPosY()][J2.getPosX()] = J2;
		int rand;
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if (plateauPerso[i][j] == null && plateauPerso[i][j] == null && plateauMod[i][j] != rocher && plateauMod[i][j] != bridge && plateauMod[i][j] != water){
					rand = (int) (Math.random()*100) ;
					if (rand < 3){
						plateauMod[i][j]=5;
					}else if (3 <= rand  && rand<6){
						plateauMod[i][j]=6;
					}else if (rand > 80 && rand < 95){
						plateauMod[i][j]=7;
					}else if (rand >= 95){
						plateauMod[i][j]=3;
					}
				}
			}
		}
	}
	
	public boolean pousse (int direction, perso J) { //Gestion de déplacement de J1
		if (possibleDeplacement(direction, J)){
			plateauPerso[J.getPosY()][J.getPosX()] = null;
			if (direction==8){
				J.setPosY(J.getPosY()-1);
			}
			else if (direction == 5) {
				J.setPosY(J.getPosY()+1);
			}
			else if (direction == 6){
				J.setPosX(J.getPosX()+1);
			}
			else if (direction == 4){
				J.setPosX(J.getPosX()-1);	
			}
			plateauPerso[J.getPosY()][J.getPosX()] = J;
			boolean t=testglyphe(J);
			return t;
		}
		return false;
	}	
	
	
	public String [] deplacement (int direction, perso J) { //Gestion de déplacement de J1
		String [] s=new String [7];
		s[0]="";
		s[1]="";
		s[2]="";
		s[3]="";
		s[4]="";
		s[5]="";
		s[6]="";
		if (possibleDeplacement(direction, J)){
			plateauPerso[J.getPosY()][J.getPosX()] = null;
			if (direction==8){
				J.setPosY(J.getPosY()-1);
			}
			else if (direction == 5) {
				J.setPosY(J.getPosY()+1);
			}
			else if (direction == 6){
				J.setPosX(J.getPosX()+1);
			}
			else if (direction == 4){
				J.setPosX(J.getPosX()-1);	
			}
			plateauPerso[J.getPosY()][J.getPosX()] = J;
			if(testglyphe(J)){
				s[0]="J'ai glyphé chef !";
				s[1]=J.nom()+" a perdu "+(100 - J.getDefBuff())*60/100+" PV!";
			}
			J.move();
			return s;
		}else{
			s[0]="vous ne pouvez pas vous deplacer...";
		}
		return s;
	}	
	
	public boolean possibleDeplacement(int direction, perso J){ //Déplacement impossible sous certaines conditions
		if(J.canMove()){	
			if (direction == 5){
				if (this.plateauMod[J.getPosY()+1][J.getPosX()] == 3 || this.plateauPerso[J.getPosY()+1][J.getPosX()] != null || this.plateauMod[J.getPosY()+1][J.getPosX()] == 8 ){
					return false;
				}
			}
			else if (direction == 8){
				if (this.plateauMod[J.getPosY()-1][J.getPosX()] == 3 || this.plateauPerso[J.getPosY()-1][J.getPosX()] != null || this.plateauMod[J.getPosY()-1][J.getPosX()] == 8){
					return false;
				}
			}
			else if (direction == 6){
				if (this.plateauMod[J.getPosY()][J.getPosX()+1] == 3 || this.plateauPerso[J.getPosY()][J.getPosX()+1] != null || this.plateauMod[J.getPosY()][J.getPosX()+1] == 8){
					return false;	
				}
			}
			else if (direction == 4) {
				if (this.plateauMod[J.getPosY()][J.getPosX()-1] == 3 || this.plateauPerso[J.getPosY()][J.getPosX()-1] != null || this.plateauMod[J.getPosY()][J.getPosX()-1] == 8){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean testglyphe (perso J) { //Application des dégats de la glyphe
		if (this.plateauMod[J.getPosY()][J.getPosX()] == 4){
			J.takeDamage(60);
			this.plateauMod[J.getPosY()][J.getPosX()] =0;
			SoundManager.play("sfx/explosionglyphe.wav");	
			return true;
		}
		return false;
	}
	
	public String [] passerTour(){
		String [] s = new String [7];
		s[0]="";
		s[1]="";
		s[2]="";
		s[3]="";
		s[4]="";
		s[5]="";
		s[6]="";
		actualPlayer.passerTour();
		selectedSort = null;
		actualPlayer = (actualPlayer == J1)? J2 : J1;
		actualPlayer.debutTour();
		s[0]=actualPlayer.nom()+" a vous de jouer";
		s[1]="utilisez les touches z,q,s,d pour vous déplacer";
		s[3]="et les touches 1,2,3,4 pour lancer vos sorts";
		return s;
	}

	public int[][] getPlateauMod() {
		return plateauMod;
	}

	public void setPlateauMod(int[][] plateauMod) {
		this.plateauMod = plateauMod;
	}

	public int getTaille() {
		return taille;
	}

	public perso[][] getPlateauPerso() {
		return plateauPerso;
	}

	public int getVide() {
		return vide;
	}

	public int getRocher() {
		return rocher;
	}

	public int getFlower1() {
		return flower1;
	}

	public int getGrass2() {
		return grass2;
	}

	public int getFlower2() {
		return flower2;
	}

	public int getWater() {
		return water;
	}

	public int getBridge() {
		return bridge;
	}

	/**
	 * @return the j1
	 */
	public perso getJ1() {
		return J1;
	}

	/**
	 * @return the j2
	 */
	public perso getJ2() {
		return J2;
	}

	/**
	 * @return the actualPlayer
	 */
	public perso getActualPlayer() {
		return actualPlayer;
	}

	/**
	 * @return the selectedSort
	 */
	public Sort getSelectedSort() {
		return selectedSort;
	}

	/**
	 * @param selectedSort the selectedSort to set
	 */
	public void setSelectedSort(Sort selectedSort) {
		if(this.selectedSort == selectedSort){
			this.selectedSort = null;
		}else{
			this.selectedSort = selectedSort;
		}
	}
	
	public boolean endGame(){
		return (!(J1.estVivant() && J2.estVivant()));
	}

	
}

