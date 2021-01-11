package sort;

import javax.swing.ImageIcon;

import game.Plateau;
import game.SoundManager;
import game.berserker;

public class Frappe extends SortBerserker{

	/**
	 * 
	 */
	public Frappe(berserker J1) {
		super(J1);
		cooldownOnUse = 0;
		cout = 2;
		portee = 1;
		type = "Force";
		degat=70;
		nom = "Frappe";
		anim = new ImageIcon[5];
		for (int i = 0; i < anim.length; i++) {
			anim[i] = new ImageIcon("photos/tranche"+(i+1)+".png");
		}
	}

	@Override
	public void effect(Plateau plate, int x, int y, int k) {
		int furie = 1;
		if (personnage.isFurie()){
			furie=2;
		}
		personnage.setFurie(false);
		animation(sprite);
		posXAnim = x*30;
		posYAnim = y*30;
		timer.start();
		onAnimation = true;
		plate.getPlateauPerso()[y][x].takeDamage(degat*k*furie);
		SoundManager.play("sfx/berserkQ.wav");
	}
	
	public String []  lancerSort (Plateau plate, int x, int y){
		int furie = 1;
		if (personnage.isFurie()){
			furie=2;
		}
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
		
		int damage = (100 - plate.getPlateauPerso()[y][x].getDefBuff())*degat/100;
		if (this.isUsable() && plate.getPlateauPerso()[y][x] != null){
			s[2]=De();
			if(personnage.isReussite() && personnage.isReussitec()==false){
				s[1]=plate.getPlateauPerso()[y][x].nom()+" a perdu "+damage*furie+" PV !";
				effect(plate,x,y,1);
				personnage.setPA(personnage.getPA()-cout);
				this.used();
				s[0]="Reussite";
			}else if(personnage.isReussite()==false && personnage.isReussitec()==false){
				personnage.setPA(personnage.getPA()-cout);
				s[0]="Echec";
				s[1]=" ";
			}
			else if(personnage.isReussite() && personnage.isReussitec()){
				s[1]=plate.getPlateauPerso()[y][x].nom()+" a perdu "+damage*2*furie+" PV !";
				effect(plate,x,y,2);
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
		s[3]=s1[0];
		s[4]=s1[1];
		s[5]=s1[2];
		s[6]=s1[3];
		return s;
	}
}
