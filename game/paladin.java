package game;

import javax.swing.ImageIcon;
import sort.Impact;
import sort.Rage;
import sort.Renfort;
import sort.Tranche;

public class paladin extends perso {
	public paladin () {  /*Choix du perso et définition des caracteristiques*/
			super(1500,75,40,45,4,20,10);
			jetonBase = new ImageIcon("photos/jetonpaladin.png");
			jetonDegat = new ImageIcon("photos/jetonpaladindegat.png");
			jeton = jetonBase;
			cadre = new ImageIcon("photos/paladin.png");
			Sort[0] = new Tranche(this);
			Sort[1] = new Renfort(this);
			Sort[2] = new Rage(this);
			Sort[3] = new Impact(this);
			podium = new ImageIcon("photos/paladinpodium.png");
		}
	
	public String nom () {//affiche le nom du personage
		return "Paladin";
	}
	
	public int classe(){
		return 1;
	}
	
	public String [] repliqueEC(String nom){
		String [] ligne = new String [4];
		if (nom=="Tranche"){
			ligne[0]="Fatigue de sa cuite d'hier soir prise a la taverne avec Dede, demoralise par sa separation la semaine derniere avec Cunegonde et affaibli par le manque ";
			ligne[1]="flagrant d'entrainement a cause de ses journees entieres passees derriere son ecran d'ordinateur. Le paladin essaye de se trancher les veines avec son epee ";
			ligne[2]="en criant le nom de sa bien aimee perdue...  ";
			ligne[3]="";
		}else{
			ligne[0]="Lorsqu'il a marche dans une crotte d'Orc ce matin en allant chercher son pain, le paladin savait que ce ne serait pas une bonne journee. Il a ensuite vu un ";
			ligne[1]="chat noir, a marche sous une echelle, n'a pas fait circuler une chaine de mail a propos de la dame blanche, et a ouvert son parapluie a l'interieur juste apres ";
			ligne[2]="avoir casse son miroir, c'est avec ces 132 annees de malheur accumulees que le paladin leve son epee au dessus de sa tete et que celle-ci lui retombe sur ";
			ligne[3]="l'epaule.";
		}
		return ligne;
	}
	public String [] repliqueCC (String nom){ //Phrase affichée lors d'un coup critique
		String [] ligne = new String [4];
		if (nom=="Tranche") {
			ligne[0]="Le moral du paladin est excellent, il a certes ete quitte par Cunegonde la semaine derniere mais il a reussi a serrer la petite AJ Lee lors de sa soiree d'hier.";
			ligne[1]="Une nuit des plus torrides , un petit dejeuner pris au lit a 11h ainsi qu'une serie de pompes a un doigt claquees dans le dos lui confere cette excellente condition"; 
			ligne[2]="psychologique et physique, 135 kg au developpe à la salle maggle, et le paladin souleve son enorme epee au dessus de sa tete et assene ";
			ligne[3]="un coup fulgurant droit dans la face de son adversaire !";				
		}else{
			ligne[0]="Le paladin, dans un moment d'emotion pendant ce combat difficille voit defiler dans sa tete moultes personnages tous plus epiques les uns que les autres, ";
			ligne[1]="tous ces gens qui l'ont fait rire lui et son ami Beber : Fatal Bazooka, Jesus, l'homme de la mer noire, Josue, le pape qui attend sa soeur, Julien Lepers, Kadoc,"; 
			ligne[2]="2G1O, Ahmed, Chuck Norris, The Rock, Eddy Malou, Le cannibal russe, Rambo, Shia LaBeouf, John Cena, Vald, Bob Ross, Ribery, JCVD et biensur l'unique,";
			ligne[3]="Alexandre Astier ! Tous ces modeles lui donnant pletor de courage et de force, il cree une onde de choc titanesque en enfoncant son epee dans le sol !";
		}
		return ligne;
	}

}
