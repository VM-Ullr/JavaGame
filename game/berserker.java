package game;

import javax.swing.ImageIcon;

import sort.Concentration;
import sort.Frappe;
import sort.Furie;
import sort.Sacrifice;

public class berserker extends perso {
	
	protected boolean furie;
	

	public berserker
	 () {  /*Choix du perso et définition des caracteristiques*/
			super(1450,60,45,25,5,25,10);
			Sort[0] = new Frappe(this);
			Sort[1] = new Furie(this);
			Sort[2] = new Concentration(this);
			Sort[3] = new Sacrifice(this);
			furie =false;
			jetonBase = new ImageIcon("photos/jetonberserker.png");
			jetonDegat = new ImageIcon("photos/jetonberserkerdegat.png");
			jeton = jetonBase;
			cadre = new ImageIcon("photos/berserker.png");
			podium = new ImageIcon("photos/berserkerpodium.png");
		}
	
	public void passifberserker () { //active le passif du Berserker (+1 de force tout les 50 PVs perdus en fin de tour)
			int a = (int) ((1450-this.PV)/50);
			this.force = 60 + a ;
	}
	
	public void takeDamage(int damage){
		timer.start();
		damage = (100 - getDefBuff())*damage/100;
		this.PV = (this.PV - damage > 0)? this.PV - damage : 0;
		passifberserker();
	}
	
	public void testpassifberserker () {
			this.force = 60;
	}
	
	
	public boolean passerTour() {
		this.PA=PAMax;
		for (int i = 0; i < Sort.length; i++) {
			Sort[i].decreaseCooldown();
		}
		passifberserker();
		return true;
	}
	
	public String nom () {//affiche le nom du personage
		return "Berserker";
	}
	
	public int classe(){
		return 4;
	}
	
	public boolean isFurie() {
		return furie;
	}

	public void setFurie(boolean furie) {
		this.furie = furie;
	}
	
	public String [] repliqueEC(String nom){
		String [] ligne = new String [4];
		if(nom == "Frappe"){
			ligne[0]="Fatigue par sa titanesque seance de muscu a la salle ce matin pendant laquelle il a pratique un genocide des biceps pour impressionner une petite qui faisait";
			ligne[1]="des squats, le Berserker ne parvient pas a lever son bras pour frapper son ennemi et son enorme avant bras lui retombe en plein sur la face. ";
			ligne[2]="";
			ligne[3]="";
		}else{
			ligne[0]="Lorsque le Berserker se concentre pour puiser dans ses forces vitales afin de lancer son ultime attaque son esprit est attire par l'image de Garry, son escargot ";
			ligne[1]="de compagnie qui est mort ce matin. Ce deces tragique laissant un profond vide dans le coeur du Berserker, celui-ci puise dans son energie vitale mais n'a ";
			ligne[2]="plus la force de frapper son adversaire.";
			ligne[3]="";
		}
		return ligne;
	}
	public String [] repliqueCC (String nom){ //Phrase affichée lors d'un coup critique
		String [] ligne = new String [4];
		if (nom =="Frappe") {
			ligne[0]="On ne sait toujours pas par quel magie le Berserker a reussi a penetrer la matrice dans laquelle il a frappe le lanceur du de de 100 jusqu'a ce que celui ci ";
			ligne[1]="accepte de lui accorder un coup critique mais il en resulte tout de meme que lorque le Berserker revient sur le plateau son adversaire a perdu enormement de";
			ligne[2]="PV sans qu'il ait besoin de lever le doigt.Comme quoi la diplomatie musclee finit toujours par payer. Un vieux sage a dit un jour : si la force ne resoud ";
			ligne[3]="pas tes problemes, c'est probablement que tu ne tapes pas assez fort et ca le Berserker l'a bien compris !";
		}else{
			ligne[0]="Apparemment le Berserker n'est pas une brute sans cervelle, c'est aussi un intellectuel et il a semble-t-il recemment appris le codage Java, il a surement ";
			ligne[1]="passe plusieurs heures au centre IF pour obtenir ces competences. Il a reussi a penetrer la matrice, Tank ne l'a meme pas vu passer, et a modifie le code ";
			ligne[2]="du de de 100 pour obtenir ce coup critique. C'est ainsi que le Berserker puise sans aucun effort dans ses forces vitales pour infliger un coup titanesque ";
			ligne[3]="à son adversaire !";
		}
		return ligne;
	}


}
