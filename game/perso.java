package game;

import sort.Sort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import sort.Buff;

/**Classe qui gère tout concernant les personnages, leurs sorts etc...
 */	
	public abstract class perso {
	protected int PVMax; ;
	protected int PV;
	protected int force ;
	protected int intelligence ;
	protected int defense ;
	protected int chance;
	protected int vitesse ;
	protected int PAMax;
	protected int PA;
	protected int PosX;
	protected int PosY;
	protected int portee;
	protected Sort[] Sort;
	protected ArrayList<Buff> Buff;
	protected boolean reussite ;
	protected boolean reussitec ; //Réussite critique
	protected double sound = 0; /*Son utilisé*/
	protected ImageIcon jetonBase;
	protected ImageIcon jetonDegat;
	protected ImageIcon jeton;
	protected ImageIcon cadre;
	protected ImageIcon podium;
	protected int delay;
	protected ActionListener taskPerformer;
	protected Timer timer;
	
	public perso (int pv , int forc , int intell , int def, int chan , int vit, int Pa) {  /*Choix du perso et définition des caracteristiques*/	
		this.PV = pv;
		this.PVMax = pv;
		this.force = forc;
		this.intelligence =intell; 
		this.defense = def;
		this.chance = chan;
		this.vitesse =vit;
		this.PA = Pa;
		this.PAMax = Pa;
		Sort = new Sort[4];
		Buff = new ArrayList<Buff>(0);
		delay = 250; //milliseconds
		taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jeton == jetonBase) {
					jeton = jetonDegat;
				}else{
					timer.stop();
					jeton = jetonBase;
				}
				
			}
		};
		timer = new Timer(delay, taskPerformer);
	}
	
	public boolean passerTour() {
		this.PA=PAMax;
		for (int i = 0; i < Sort.length; i++) {
			Sort[i].decreaseCooldown();
		}
		return true;
	}
	
	public  void debutTour () {
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();){
			if (iterator.next().durationDecrease() == 0) iterator.remove();
		}
	} /*Toutes les action effectuées en début de tour (gestion des cooldowns, remise à normale des stats...)*/
		
	
	//Debuff des sorts de soutien après leur durée achevée et gestion des cooldowns
	
	
	public abstract int classe();
	
	
	public boolean estVivant () { 
		if (this.PV <= 0) {
			return false ;
		} else { 
			return true ;
		}
	}
	
	public boolean canMove() { 
		return (this.PA < 2)? false : true;
	}
	
	public void move() { 
		this.PA -= 2;
	}
	
	public abstract String nom () ;
	
	public abstract String[] repliqueEC (String nom); //Phrase affichée lors d'un échec critique
	
	public abstract String[] repliqueCC (String nom); //Phrase affichée lors d'un coup critique


	/**
	 * @return the pV
	 */
	public int getPV() {
		return PV;
	}


	/**
	 * @param pV the pV to set
	 */
	public void setPV(int pV) {
		PV = pV;
	}


	/**
	 * @return the force
	 */
	public int getForce() {
		return force;
	}


	/**
	 * @param force the force to set
	 */
	public void setForce(int force) {
		this.force = force;
	}


	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}


	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}


	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}


	/**
	 * @return the chance
	 */
	public int getChance() {
		return chance;
	}


	/**
	 * @param chance the chance to set
	 */
	public void setChance(int chance) {
		this.chance = chance;
	}


	/**
	 * @return the vitesse
	 */
	public int getVitesse() {
		return vitesse;
	}


	/**
	 * @param vitesse the vitesse to set
	 */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}


	/**
	 * @return the pA
	 */
	public int getPA() {
		return PA;
	}


	/**
	 * @param pA the pA to set
	 */
	public void setPA(int pA) {
		PA = pA;
	}


	/**
	 * @return the reussite
	 */
	public boolean isReussite() {
		return reussite;
	}


	/**
	 * @param reussite the reussite to set
	 */
	public void setReussite(boolean reussite) {
		this.reussite = reussite;
	}


	/**
	 * @return the reussitec
	 */
	public boolean isReussitec() {
		return reussitec;
	}


	/**
	 * @param reussitec the reussitec to set
	 */
	public void setReussitec(boolean reussitec) {
		this.reussitec = reussitec;
	}


	/**
	 * @return the sound
	 */
	public double getSound() {
		return sound;
	}


	/**
	 * @return the jeton
	 */
	public ImageIcon getJeton() {
		return jeton;
	}
	
	public void setPosX(int PosX) {
		this.PosX = PosX;
	}
	
	public void setPosY(int PosY) {
		this.PosY = PosY;
	}
	
	public int getPosX() {
		return PosX;
	}
	
	public int getPosY() {
		return PosY;
	}
	
	public int getDefBuff() {
		int def = defense;
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();) {
			def += iterator.next().getDefence();
		}
		return def;
	}
	
	public int getIntelBuff() {
		int intel = intelligence;
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();) {
			intel += iterator.next().getIntelligence();
		}
		return intel;
	}
	
	public int getForceBuff() {
		int force = this.force;
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();) {
			force += iterator.next().getForce();
		}
		return force;
	}
	
	public int getChanceBuff() {
		int chance = this.chance;
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();) {
			chance += iterator.next().getChance();
		}
		return chance;
	}
	
	public int getVitesseBuff() {
		int vitesse = this.vitesse;
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();) {
			vitesse += iterator.next().getVitesse();
		}
		return vitesse;
	}
	
	public int getPorteeBuff() {
		int portee = this.portee;
		for (Iterator<Buff> iterator = Buff.iterator(); iterator.hasNext();) {
			portee += iterator.next().getPortee();
		}
		return portee;
	}
	
	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	
	public void takeDamage(int damage){
		timer.start();
		damage = (100 - getDefBuff())*damage/100;
		this.PV = (this.PV - damage > 0)? this.PV - damage : 0;
	}
	
	public void heal(int amount){
		this.PV = (this.PV + amount < PVMax)? this.PV + amount : PVMax;
	}
	
	public void addBuff(Buff b){
		this.Buff.add(b);
	}

	/**
	 * @return the sort
	 */
	public Sort[] getSort() {
		return Sort;
	}
	
	public ImageIcon getCadre() {
		return cadre;
	}

	/**
	 * @return the podium
	 */
	public ImageIcon getPodium() {
		return podium;
	}

	
}
