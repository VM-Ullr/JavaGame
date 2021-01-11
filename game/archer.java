package game;

import javax.swing.ImageIcon;

import sort.FlecheDeRecul;
import sort.TirDirect;
import sort.TirPuissant;
import sort.VuePercante;

public class archer extends perso {
	public archer () {  /*Choix du perso et définition des caracteristiques*/
			super(1250,75,50,20,6,35,10);	
			jetonBase = new ImageIcon("photos/jetonarcher.png");
			jetonDegat = new ImageIcon("photos/jetonarcherdegat.png");
			jeton = jetonBase;
			cadre = new ImageIcon("photos/archer.png");
			podium = new ImageIcon("photos/archerpodium.png");
			Sort[0] = new TirDirect(this);
			Sort[1] = new VuePercante(this);
			Sort[2] = new FlecheDeRecul(this);
			Sort[3] = new TirPuissant(this);
		}
	
	public String nom () {//affiche le nom du personage
		return "archer";
	}
	
	public int classe(){
		return 2;
	}
	
	public String [] repliqueEC(String nom){
		String [] ligne = new String [4];
		if(nom=="Tir direct"){
			ligne[0]="L'orc ,la biere deguste hier a la taverne et regurgite par l'Archer plus tard dans la nuit surement car il n'etait pas frais ou bien plutot  ";
			ligne[1]="a cause de cette bouteille d'alcool fort dans laquelle macerait plusieurs frelons et que le joueur a descendu d'une traite pour montrer qu'il  ";
			ligne[2]="etait un vrai bonhomme a ce frimeur de nain qui venait de le battre au babyfoot. C'est dans cet etat lamentable que l'Archer essaye de tirer sa ";
			ligne[3]="fleche, ouvre la mauvaise main et se prend son arc dans la tronche.";
		}else {	
			ligne[0]="Lors de sa soiree d'hier soir, apres avoir ingurgite une bouteille d'alcool fort ou macerait plusieurs frelons, l'Archer totalement bourre n'a pas pu s'empecher";
			ligne[1]="d'aller se moquer d'un nain sur la taille de son anatomie, lorque cette joute verbale a degenere l'Archer ivre mort a degaine son sandwich au thon au lieu de ";
			ligne[2]="sa dague et s'est pris un low-kick dans la hanche. C'est avec cette hanche en mauvais etat que l'elfe glisse sur ses propres cheveux, s'etale sur";
			ligne[3]=" le dos, libere ses 3 fleches au dessus de lui, celles-ci retombent et viennent se loger dans differentes parties fort douloureuses de son corps.";
		}
		return ligne;
	}
	public String [] repliqueCC (String nom){ //Phrase affichée lors d'un coup critique
		String [] ligne = new String [4];
		if(nom =="Tir direct"){
			ligne[0]="Ayant participe a un stage de tir a l'arc dans lequel intervenait notamment Oliver Queen et Robin de bois, il a perfectionne sa technique de tir et il est ";
			ligne[1]="maintenant capable de tirer plus loin, plus vite, les yeux bandes, en grand ecart (merci JCVD), sur un pied tel un flamand rose, et meme sur les mains en ";
			ligne[2]="tirant avec les pieds, ce qui est totalement inutile mais entre nous tellement classe. L'Archer libere donc sa fleche qui fonce droit sur sa cible et se ";
			ligne[3]="loge directement dans son epaule.";
		}else{
			ligne[0]="L'Archer ayant deja regarde la trilogie du seigneur des anneaux en version longue plusieurs fois et enchaine sur la trilogie le Hobbit, il a etudie";
			ligne[1]=" parfaitement la technique de Legolas pour tirer trois fleches en même temps. C'est ainsi que l'archer prend bien son temps (merci le tour par tour)";
			ligne[2]=" pour encocher ses trois fleches et pour viser son adversaire. Ainsi les trois fleches partent et fusent sur l'ennemi et le transpercent de part en part.";
			ligne[3]="";
		}
		return ligne;
	}

}
