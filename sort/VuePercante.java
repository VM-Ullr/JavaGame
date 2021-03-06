package sort;

import javax.swing.ImageIcon;

import game.Plateau;
import game.SoundManager;
import game.archer;
import game.perso;

public class VuePercante extends SortArcher{

	public VuePercante(archer J1) {
		super(J1);
		cooldownOnUse = 4;
		cout = 2;
		portee = 0;
		type = "Intelligence";
		nom = "Vue percante";
		delay = 100;
		anim = new ImageIcon[5];
		anim[0] = new ImageIcon("photos/star1.png");
		anim[1] = new ImageIcon("photos/star2.png");
		anim[2] = new ImageIcon("photos/star3.png");
		anim[3] = new ImageIcon("photos/star2.png");
		anim[4] = new ImageIcon("photos/star1.png");
	}

	@Override
	public void effect(Plateau plate, int x, int y,int k) {
		animation(sprite);
		posXAnim = x*30;
		posYAnim = y*30;
		timer.start();
		onAnimation = true;
		personnage.addBuff(new Buff(2,0,0,0,0,0,3));
		SoundManager.play("sfx/archerpo.wav");
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
				s[1]="Vous gagnes 3 de portee";
			}else{
				personnage.setPA(personnage.getPA()-cout);
				s[0]="echec";
				s[1]="Vous avez de la peau de saucisson devant les yeux...";
			}
		}
		s[3]=s1[0];
		s[4]=s1[1];
		s[5]=s1[2];
		s[6]=s1[3];
		return s;
	}

}
