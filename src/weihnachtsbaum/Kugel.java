package weihnachtsbaum;

import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * Diese Klasse repraesentiert genau eine Kugel. Dieser wird mit Hoehe, Breite und seinen (x,y)-Koordinaten angegeben.
 * Sie enthaelt ausserdem Methoden zur Ueberpruefung, ob andere Elemente die Figur beruehren, um Ueberlagerung in der Grafik zu verhindern.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Kugel {
	
	private int x, y;
	private int hoehe, breite;
	
	public boolean intersects(Polygon p) {
		return p.intersects(this.getBoundingBox());
	}
	
	public boolean intersects(Kugel k) {
		return(this.getBoundingBox().intersects(k.getBoundingBox()));
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(x+breite/2,y+hoehe/2,1,1);
	}

	public boolean hits(Polygon p) {
		return p.intersects(this.getHitBox());
	}
	
	public boolean hits(Kugel k) {
		return(this.getHitBox().intersects(k.getHitBox()));
	}
	
	public Rectangle getHitBox() {
		return new Rectangle(x-1,y-1,breite+1,hoehe+1);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}
}