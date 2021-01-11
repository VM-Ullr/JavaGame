package game;

import javax.swing.ImageIcon;

import sort.CoudBoul;
import sort.DoubleLame;
import sort.EsquiveDeLaPolice;
import sort.JureJaiPasVole;

public class voleur extends perso {
	public voleur () {  /*Choix du perso et définition des caracteristiques*/
			super(1300,65,50,25,6,30,12);	
			jetonBase = new ImageIcon("photos/jetonvoleur.png");
			jetonDegat = new ImageIcon("photos/jetonvoleurdegat.png");
			jeton = jetonBase;
			cadre = new ImageIcon("photos/voleur.png");
			Sort[0] = new CoudBoul(this);
			Sort[1] = new JureJaiPasVole(this);
			Sort[2] = new EsquiveDeLaPolice(this);
			Sort[3] = new DoubleLame(this);
			podium = new ImageIcon("photos/voleurpodium.png");
		}
	
	public String nom () {//affiche le nom du personage
		return "Voleur";
	}
	
	public int classe(){
		return 3;
	}
	
	public String [] repliqueEC(String nom){
		String [] ligne = new String [4];
		if (nom == "CoudBoul"){
			ligne[0]="Le voleur croit appercevoir son ex au loin, dire qu'elle l'a plaquee pour son ami Felix, elle est si belle dans sa petite robe a fleur... Cela lui rappelle "; 
			ligne[1]="leurs vacances a la Baule, ils y avaient fait de la banane... C'est finalement elle la seule personne qui a un jour reussi a lui voler quelque chose, son";
			ligne[2]="coeur... L'esprit embrume, le voleur confond son ennemi avec un arbre et se brise le nez en voulant lui donner un violent Coudboul.";
			ligne[3]="";
		}else{
			ligne[0]="La kleptomanie du voleur prenant le dessus, il essaye de derober le rubis depassant de la poche de son adversaire, mais n'ayant pas assez de mains puisqu'il doit";
			ligne[1]="deja manier ses deux lames, il n'arrive pas a tout faire en meme temps et s'entaille le bras et la cuisse.";
			ligne[2]="";
			ligne[3]="";
		}
		return ligne;
	}
	public String[] repliqueCC (String nom){ //Phrase affichée lors d'un coup critique
		String [] ligne = new String [4];
		if (nom == "CoudBoul"){
			ligne[0]="Le voleur etant un fan de Zizou inconsiderable, il a regarde la finale de la coupe du monde 2006 une centaine de fois pour assimiler la technique parfaite.";
			ligne[1]="il s'est ensuite entraine des jours durant sur sa petite soeur Kevina ce qui lui a permis de comprendre toutes les facettes de Coudboul, ancienne technique";
			ligne[2]="de combat Guatemalteque. Grace a cet apprentissage, il reussit parfaitement son coup et brise l'integralite des cotes de son adversaire. ";
			ligne[3]="";
		}else{
			ligne[0]="La Kleptomanie du voleur atteignant un sommet colossal, sa motivation augmente en voyant tous les bijous que possede son adversaire, il entre en mode rage,";
			ligne[1]="des rubis pleins les yeux. Il se souvient tout ce que lui a appris son parrain Kenji lorsqu'ils faisaient tous les deux les poches des touristes sous la ";
			ligne[2]="tour Eiffel. Il degaine ses deux dagues, fait deux larges entailles dans le corps de son ennemi et en un tournemain le soulage de tous ses bijoux, allege  ";
			ligne[3]="sa bourse et lui derobe meme son piercing Prince Albert.";
		}
		return ligne;
	}

}
