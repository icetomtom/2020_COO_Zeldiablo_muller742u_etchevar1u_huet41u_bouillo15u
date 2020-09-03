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
	public Troll(String nom) {
		super(nom);
		this.vie = 5;
		this.est_attaque=false;
		this.maxPV=5;
	}
	
	/**
	 * methode subirdegats speciale au troll
	 */
	@Override
	public void subirDegats(int n) {
		super.subirDegats(n);
		this.est_attaque=true;
	}
	
	public void regeneration() {
		if(!est_attaque) {
			if(vie<this.maxPV) {
				this.vie++;
			}
		}
		this.est_attaque=false;
	}

}
