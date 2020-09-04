package Monstre;

/**
 * 
 * classe representant un monstre de type troll
 */
public class Troll extends Monstre {
	
	/**
	 * attribut booleen prive qui annonce si le troll se fait attaquer 
	 */
	private boolean est_attaque;
	
	/**
	 * Constructeur avec un string en parametre
	 * @param nom correspondant au nom du monstre
	 */
	public Troll() {
		super("entities_1_10");
		this.vie = 5;
		this.est_attaque=false;
		this.maxPV=5;
	}
	
	/**
	 * methode subirdegats speciale au troll
	 */
	@Override
	public void subirDegats(int n) {
		vie = vie - n;
		if (vie<=0) {
			vie =0;
			this.vivant=false;
		}
		this.est_attaque=true;
	}
	
	/**
	 * permet au troll de se regenerer s'il ne s'est pas fait attaque
	 */
	public void regeneration() {
		if(!est_attaque) {
			if(vie<this.maxPV) {
				this.vie++;
			}
		}
		this.est_attaque=false;
	}

}
