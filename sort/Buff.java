package sort;

public class Buff {
	
	protected int force;
	protected int intelligence;
	protected int chance;
	protected int vitesse;
	protected int defence;
	protected int portee;
	protected int duree;
	
	public Buff(int duree, int force, int intelligence, int chance, int vitesse, int defence, int portee) {
		this.force = force;
		this.intelligence =intelligence;
		this.chance = chance;
		this.vitesse = vitesse;
		this.defence = defence;
		this.portee = portee;
		this.duree = duree;
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
	 * @return the defence
	 */
	public int getDefence() {
		return defence;
	}

	/**
	 * @param defence the defence to set
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}

	/**
	 * @return the portee
	 */
	public int getPortee() {
		return portee;
	}

	/**
	 * @param portee the portee to set
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}

	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	public Boolean isInEffect(){
		return (duree != 0);
	}
	
	public int durationDecrease(){
		duree--;
		return (duree);
	}
}