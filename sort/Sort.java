package sort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import game.Plateau;
import game.SoundManager;
import game.perso;
public abstract class Sort {
	
	protected int cout;
	protected int portee;
	protected int cooldownOnUse;
	protected int cooldown;
	protected perso personnage;
	protected String type;
	protected int degat;
	protected String nom;
	protected ImageIcon[] anim;
	protected ImageIcon curentAnim;
	protected int posXAnim,posYAnim;
	protected boolean onAnimation;
	protected int sprite;
	protected int delay;
	protected ActionListener taskPerformer;
	protected Timer timer;
	
	public Sort(perso J1){
		cooldown = 0;
		personnage = J1;
		onAnimation = false;
		anim = new ImageIcon[0];
		delay = 50; //milliseconds
		taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animation(sprite);				
			}
		};
		timer = new Timer(delay, taskPerformer);
		sprite = 0;
	}
	
	public abstract void effect (Plateau plate, int x, int y, int k);

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
		
		int damage = (100 - plate.getPlateauPerso()[y][x].getDefBuff())*degat/100;
		if (this.isUsable() && plate.getPlateauPerso()[y][x] != null){
			s[2]=De();
			if(personnage.isReussite() && personnage.isReussitec()==false){
				s[1]=plate.getPlateauPerso()[y][x].nom()+" a perdu "+damage+" PV !";
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
				s[1]=plate.getPlateauPerso()[y][x].nom()+" a perdu "+damage*2+" PV !";
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

	public boolean isUsable(){
		return (personnage.getPA() >= cout && !isOnCooldown())? true : false;
	}
	
	public boolean isOnPa(){
		return (personnage.getPA() >= cout)?true : false; 
	}
	
	public boolean isInRange(int posX, int posY){
		return (Math.abs(personnage.getPosX()-posX)+Math.abs(personnage.getPosY()-posY) <= portee+personnage.getPorteeBuff())? true : false;
	}
	
	public void decreaseCooldown(){
		cooldown = (cooldown-1 > 0)? cooldown-1 : 0;
	}
	
	public boolean isOnCooldown(){
		return (cooldown > 0)? true : false;
	}
	
	public void used(){
		cooldown = cooldownOnUse;
	}
	
	public String De(int carac){
		int val =(int) (Math.random()*100) ;
		int a = (int) carac/10 + personnage.getChanceBuff();
		if (val > carac && val <90+personnage.getChanceBuff()){
			personnage.setReussite(false);
			personnage.setReussitec(false);
		}
		if (val <= a) {
			personnage.setReussite(true);
			personnage.setReussitec(true);
		}
		if (val <= carac && val > a){
			personnage.setReussite(true);
			personnage.setReussitec(false);
		}
		if (val<=100 && val>=90+personnage.getChanceBuff()){
			SoundManager.play("sfx/echecc2.wav");
			personnage.setReussite(false);
			personnage.setReussitec(true);	
		}
		return Integer.toString(val);
	}
	
	public String De(){
		switch (type) {
		case "Intelligence":
			return De(personnage.getIntelBuff());
		case "Force":
			return De(personnage.getForceBuff());

		default:
			return " ";
		}
	}
	
	public String DeSoutien(int carac){
		int val =(int) (Math.random()*100) ;
		if (val > carac){
			personnage.setReussite(false);
		}
		else if (val <= carac){
			personnage.setReussite(true);
		}
		return Integer.toString(val);
	}
	
	public String DeSoutien(){
		switch (type) {
		case "Intelligence":
			return DeSoutien(personnage.getIntelBuff());
		case "Force":
			return DeSoutien(personnage.getForceBuff());

		default:
			return " ";
		}
	}

	/**
	 * @return the portee
	 */
	public int getPortee() {
		return portee+personnage.getPorteeBuff();
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getCooldown() {
		return cooldown;
	}
	
	public int getCout() {
		return cout;
	}
	
	public void animation(int i){
		if (sprite < anim.length-1) {
			curentAnim = anim[sprite];
			sprite++;
		} else {
			timer.stop();
			onAnimation = false;
			sprite = 0;
		}
	}

	/**
	 * @return the curentAnim
	 */
	public ImageIcon getCurentAnim() {
		return curentAnim;
	}

	/**
	 * @return the posXAnim
	 */
	public int getPosXAnim() {
		return posXAnim;
	}

	/**
	 * @return the posYAnim
	 */
	public int getPosYAnim() {
		return posYAnim;
	}

	/**
	 * @return the onAnimation
	 */
	public boolean isOnAnimation() {
		return onAnimation;
	}
	
	
}
