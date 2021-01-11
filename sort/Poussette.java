package sort;

import game.Plateau;
import game.SoundManager;
import game.mage;
import game.perso;

public class Poussette extends SortMage{
	
	public Poussette(mage J1){
		super(J1);
		cooldownOnUse = 0;
		cout = 3;
		portee = 3;
		type = "Force";
		degat=70;
		nom = "Poussette";
	}
	
	@Override
	public void effect(Plateau plate, int x, int y, int k) {}
	
	public boolean effect2(Plateau plate, int x, int y, int k) {
		boolean glyphe = false;
		int J1posX = personnage.getPosX();
		int J1posY = personnage.getPosY();
		int J2posX = x;
		int J2posY = y;
		plate.getPlateauPerso()[y][x].takeDamage(degat*k);
		if (J2posY-J1posY == 0) {
			if (J2posX-J1posX>0) {
				glyphe=plate.pousse(6, plate.getPlateauPerso()[y][x]);
			}else {
				glyphe=plate.pousse(4, plate.getPlateauPerso()[y][x]);
			}
		}else if(J2posX-J1posX==0){
			if (J2posY-J1posY>0) {
				glyphe=plate.pousse(5, plate.getPlateauPerso()[y][x]);
			}else {
				glyphe=plate.pousse(8, plate.getPlateauPerso()[y][x]);	
			}
		}
		SoundManager.play("sfx/poussette2.wav");
		return glyphe;
	}
	
	public String []  lancerSort (Plateau plate, int x, int y){
		perso adverse = plate.getPlateauPerso()[y][x];
		boolean glyphe = false;
		String [] s = new String [7];
		String [] s1 = new String [4];
		s1[0]="";
		s1[1]="";
		s1[2]="";
		s1[3]="";
		s[0]="";
		s[1]="";
		s[2]="";
		if(!this.isOnPa() && this.isOnCooldown()){
			s[0]="Vn peu de patience pour lancer ce sort, de plus vous n'avez pas assez de PA...";
		}else if (!this.isOnPa() && !this.isOnCooldown()){
			s[0]="Vous n'avez pas assez de PA pour ce sort...";
		}else if (this.isOnPa() && this.isOnCooldown()){
			s[0]="Un peu de patience pour lancer ce sort !";
		}
		
		int damage = (100 - adverse.getDefBuff())*degat/100;
		if (this.isUsable() && plate.getPlateauPerso()[y][x] != null){
			s[2]=De();
			if(personnage.isReussite() && personnage.isReussitec()==false){
				s[1]=adverse.nom()+" a perdu "+damage+" PV !";
				glyphe=effect2(plate,x,y,1);
				personnage.setPA(personnage.getPA()-cout);
				this.used();
				s[0]="Reussite";
			}else if(personnage.isReussite()==false && personnage.isReussitec()==false){
				personnage.setPA(personnage.getPA()-cout);
				s[0]="Echec";
				s[1]=" ";
			}
			else if(personnage.isReussite() && personnage.isReussitec()){
				s[1]=adverse.nom()+" a perdu "+damage*2+" PV !";
				glyphe=effect2(plate,x,y,2);
				personnage.setPA(personnage.getPA()-cout);
				this.used();
				s[0]="Reussite critique";
				s1=personnage.repliqueCC(this.getNom());
			}
			else if(personnage.isReussite()==false && personnage.isReussitec()){
				personnage.takeDamage(degat/2);
				personnage.setPA(personnage.getPA()-cout);
				s[1]="Vous perdez "+(100-personnage.getDefBuff())*degat/200+" PV !";
				s[0]="Echec critique";
				s1=personnage.repliqueEC(this.getNom());
			}
		}
		if (glyphe){
			s[1]=s[1]+adverse.nom()+" a glyphé et a perdu "+(100 - adverse.getDefBuff())*60/100+" PV!";
		}
		s[3]=s1[0];
		s[4]=s1[1];
		s[5]=s1[2];
		s[6]=s1[3];
		return s;
	}
}
