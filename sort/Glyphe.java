package sort;

import game.Plateau;
import game.SoundManager;
import game.mage;
import game.perso;

public class Glyphe extends SortMage{

	/**
	 * 
	 */
	public Glyphe(mage J1) {
		super(J1);
		cooldownOnUse = 3;
		cout = 3;
		portee = 8;
		type = "Intelligence";
		degat=60;
		nom = "Glyphe";
	}

	@Override
	public void effect(Plateau plate, int x, int y, int k) {
		SoundManager.play("sfx/glyphelong.wav");
		int [][] plateauMod=plate.getPlateauMod();
		perso [][] plateauPerso = plate.getPlateauPerso();
		if(personnage.isReussite() && personnage.isReussitec()==false){
			int rand =(int) (Math.random()*100);
			if (plateauPerso[y+1][x]==null && plateauMod[y+1][x]!=3  && plateauMod[y+1][x]!=8 && plateauMod[y+1][x]!=9){ 
				plateauMod[y+1][x]=6;
			}
			if (plateauPerso[y-1][x]==null && plateauMod[y-1][x]!=3 && plateauMod[y-1][x]!=8 && plateauMod[y-1][x]!=9) { 
				plateauMod[y-1][x]=6;
			}
			if (plateauPerso[y][x+1]==null && plateauMod[y][x+1]!=3 && plateauMod[y][x+1]!=8 && plateauMod[y][x+1]!=9){ 
				plateauMod[y][x+1]=6;
			}
			if (plateauPerso[y][x-1]==null && plateauMod[y][x-1]!=3  && plateauMod[y][x-1]!=8 && plateauMod[y][x-1]!=9){ 
				plateauMod[y][x-1]=6;
			}
			int y1=y;
			int x1=x;
			if (rand < 50) {
				x1 = x+1;
			} else {
				y1 = y-1;
			}		
			if (plateauPerso[y1][x1]==null && plateauMod[y1][x1]!=3 && plateauMod[y1][x1]!=8 && plateauMod[y1][x1]!=9){ 
				plateauMod[y1][x1]=4;
			}
			x1 = x;
			y1 = y;
			rand =(int) (Math.random()*100);
			if (rand < 50) {
				y1 = y+1;
			} else {
				x1 = x-1;
			}
			if (plateauPerso[y1][x1]==null && plateauMod[y1][x1]!=3 && plateauMod[y1][x1]!=8 && plateauMod[y1][x1]!=9){ 
				plateauMod[y1][x1]=4;
			}
			plate.setPlateauMod(plateauMod);
		}else if (personnage.isReussite() && personnage.isReussitec()){
			if (plateauPerso[y+1][x]==null && plateauMod[y+1][x]!=3  && plateauMod[y+1][x]!=8 && plateauMod[y+1][x]!=9){ 
				plateauMod[y+1][x]=4;
			}
			if (plateauPerso[y-1][x]==null && plateauMod[y-1][x]!=3 && plateauMod[y-1][x]!=8 && plateauMod[y-1][x]!=9) { 
				plateauMod[y-1][x]=4;
			}
			if (plateauPerso[y][x+1]==null && plateauMod[y][x+1]!=3 && plateauMod[y][x+1]!=8 && plateauMod[y][x+1]!=9){ 
				plateauMod[y][x+1]=4;
			}
			if (plateauPerso[y][x-1]==null && plateauMod[y][x-1]!=3  && plateauMod[y][x-1]!=8 && plateauMod[y][x-1]!=9){ 
				plateauMod[y][x-1]=4;
			}
			plate.setPlateauMod(plateauMod);
		}
	}
	
	public String []  lancerSort (Plateau plate, int x, int y){
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
		if (this.isUsable() && plate.getPlateauPerso()[y][x] != null){
			s[2]=De();
			if(personnage.isReussite() && personnage.isReussitec()==false){
				effect(plate,x,y,1);
				personnage.setPA(personnage.getPA()-cout);
				this.used();
				s[0]="reussite";
				s[1]="vous placez 2 jolies glyphes";
			}else if(personnage.isReussite()==false && personnage.isReussitec()==false){
				personnage.setPA(personnage.getPA()-cout);
				s[0]="echec";
				s[1]="prout";
			}
			else if(personnage.isReussite() && personnage.isReussitec()){
				effect(plate,x,y,2);
				personnage.setPA(personnage.getPA()-cout);
				this.used();
				s[0]="reussite critique";
				s[1]="Des glyphes ! Des glyphes partout ! tremblez devant le Mage !";
			}
			else if(personnage.isReussite()==false && personnage.isReussitec()){
				personnage.takeDamage(degat/2);
				personnage.setPA(personnage.getPA()-cout);
				s[1]="La glyphe vous pete au nez... hehe";
				s[0]="echec critique";
			}
		}
		s[3]=s1[0];
		s[4]=s1[1];
		s[5]=s1[2];
		s[6]=s1[3];
		return s;
	}
}
