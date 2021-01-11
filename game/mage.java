package game;

import javax.swing.ImageIcon;
import sort.Glyphe;
import sort.Poussette;
import sort.Soin;
import sort.SouffleDragon;

public class mage extends perso {
	
	public mage () {  /*Choix du perso et définition des caracteristiques*/
			super(1450,40,80,30,6,25,10);	
			jetonBase = new ImageIcon("photos/jetonmage.png");
			jetonDegat = new ImageIcon("photos/jetonmagedegat.png");
			jeton = jetonBase;
			cadre = new ImageIcon("photos/mage.png");
			Sort[0] = new Poussette(this);
			Sort[1] = new Soin(this);
			Sort[2] = new Glyphe(this);
			Sort[3] = new SouffleDragon(this);
			podium = new ImageIcon("photos/magepodium.png");
		}
		
	
	public String nom () {//affiche le nom du personage
		return "Mage";
	}
	
	public int classe(){
		return 5;
	}
	
	public String [] repliqueEC(String nom){
		String [] ligne = new String [4];
		if(nom =="Poussette"){
			ligne[0]="Son ancienne vie de croupier à Las Vegas le hantant encore, le Mage leve son baton et rapproche son ennemi tel un gros tas de jeton au lieu de le repousser. ";
			ligne[1]="Celui-ci en profite pour lui assener un violent coup de boule des familles et lui brise le nez.";
			ligne[2]="";
			ligne[3]="";
		}else{
			ligne[0]="Encore fatigue de son match de quidditch d'hier contre l'En avant Guimgamp et surtout à cause de la troisieme mi-temps qui a ete tres rude, personne ne peut  ";
			ligne[1]="resister a cette excellente biere des moines trappistes. Il s'emmele les mains, perd sa concentration et tenant son baton à l'envers  sa boule de feu lui explose  ";
			ligne[2]="au visage et lui brule au passage les cheveux et les sourcils.";
			ligne[3]="";
		}
		return ligne;
	}
	public String [] repliqueCC (String nom){ //Phrase affichée lors d'un coup critique
		String [] ligne = new String [4];
		if (nom=="Poussette"){
			ligne[0]="Son ancienne vie de joueur de cricket durant laquelle la Mage s'est entraine a manier le baton lui confere une habilete surhumaine qu'il n'a absolument pas ";
			ligne[1]="herite de son grand-pere moine shaolin Guatemalteque puisque celui-ci ne se battait pas mais brassait de la biere. En revanche il a peut-etre deja rencontre ";
			ligne[2]="Donatello, enfin il a deja rencontre un homme habille en vert avec un bandeau violet, on vous laisse juger si c'etait vraiment Donatello. Il en resulte neanmoins";
			ligne[3]="que le Mage est tres habile avec un baton ce qui lui permet d'assener un violent coup dans l'abdomen de son adversaire, ce qui le repousse en arriere.";
		}else{
			ligne[0]="La veille au soir le Mage a assiste au rassemblement du corbeau pendant lequel il s'est ennuye a mourir, les duels etaient interminables et il n'y avait meme pas ";
			ligne[1]="d'alcool. Le Mage a donc lance ses deux sorts les plus impressionants, le coup du pirate et le coup du cocotier puis il est parti, laissant derriere lui les autres ";
			ligne[2]="participants bouche bee. Ayant ainsi economise ses points de magie il peut donc puiser dans les plus profonds tenebres de son etre et declencher une boule de feu";
			ligne[3]="surpuissante !";
		}
		return ligne;
	}

}
