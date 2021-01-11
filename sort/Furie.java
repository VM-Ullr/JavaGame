package sort;

import game.Plateau;
import game.SoundManager;
import game.berserker;
import game.perso;

public class Furie extends SortBerserker{


	public Furie(berserker J1) {
		super(J1);
		cooldownOnUse = 4;
		cout = 3;
		portee = 0;
		type = "Intelligence";
		nom = "Furie";
	}

	@Override
	public void effect(Plateau plate, int x, int y, int k) {
		personnage.setFurie(true);
		SoundManager.play("sfx/berserkrage.wav");
	}
	
	public String [] lancerSort(Plateau plate, int x, int y){
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
		if(this.isUsable() && !this.isOnCooldown()){
			s[2]=DeSoutien();
			if(personnage.isReussite()){
				effect(plate,x,y,0);
				personnage.setPA(personnage.getPA()-cout);
				this.used();
				s[0]="reussite";
				s[1]="vous passez en furie";
			}else{
				personnage.setPA(personnage.getPA()-cout);
				s[0]="echec";
				s[1]="pas assez de colere en vous pour devenir furieux...";
			}
		}
		s[3]=s1[0];
		s[4]=s1[1];
		s[5]=s1[2];
		s[6]=s1[3];
		return s;
	}

}
