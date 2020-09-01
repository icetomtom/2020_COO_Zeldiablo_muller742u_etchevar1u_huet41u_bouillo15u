package Monstre;

import Elements.Entite;

public abstract class Monstre extends Entite{
	private int PosMonstX;
	private int PosMonstY;
	
	public Monstre(int x, int y) {
		this.PosMonstX=x;
		this.PosMonstY=y;
	}
	
	public int getPosMonstX() {
		return this.PosMonstX;
	}
	
	public int getPosMonstY() {
		return this.PosMonstY;
	}
	
	public void setPosMonstX(int x){
		this.PosMonstX = x;
	} 
	
	public void setPosMonstY(int y) {
		this.PosMonstY=y;
	}
}
