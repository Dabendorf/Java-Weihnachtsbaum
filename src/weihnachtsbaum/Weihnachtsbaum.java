package weihnachtsbaum;

/**
 * Diese Klasse repraesentiert einen Weihnachtsbaum.<br>
 * Als Eigenschaften enthaelt sie die (x,y)-Koordinaten des Punktes unten in der Mitte, ausserdem die Kronen- und Stammhoehe und -Breite.<br>
 * Ausserdem existieren je zwei mal drei Arrays mit Zahlen, die zusammen die Koordinaten aller Baumecken bilden, damit diese einfach durchiteriert werden koennen beim Zeichen.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Weihnachtsbaum {
	
	private int x, y;
	private int sth;
	private int stb;
	private int kronh;
	private int kronb;
	private int xpointsoben[];
	private int ypointsoben[];
	private int xpointsmitte[];
	private int ypointsmitte[];
	private int xpointsunten[];
	private int ypointsunten[];

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

	public int getSth() {
		return sth;
	}

	public void setSth(int sth) {
		this.sth = sth;
	}

	public int getStb() {
		return stb;
	}

	public void setStb(int stb) {
		this.stb = stb;
	}

	public int getKronh() {
		return kronh;
	}

	public void setKronh(int kronh) {
		this.kronh = kronh;
	}

	public int getKronb() {
		return kronb;
	}

	public void setKronb(int kronb) {
		this.kronb = kronb;
	}

	public int[] getXpointsoben() {
		return xpointsoben;
	}

	public void setXpointsoben(int[] xpointsoben) {
		this.xpointsoben = xpointsoben;
	}

	public int[] getYpointsoben() {
		return ypointsoben;
	}

	public void setYpointsoben(int[] ypointsoben) {
		this.ypointsoben = ypointsoben;
	}

	public int[] getXpointsmitte() {
		return xpointsmitte;
	}

	public void setXpointsmitte(int[] xpointsmitte) {
		this.xpointsmitte = xpointsmitte;
	}

	public int[] getYpointsmitte() {
		return ypointsmitte;
	}

	public void setYpointsmitte(int[] ypointsmitte) {
		this.ypointsmitte = ypointsmitte;
	}

	public int[] getXpointsunten() {
		return xpointsunten;
	}

	public void setXpointsunten(int[] xpointsunten) {
		this.xpointsunten = xpointsunten;
	}

	public int[] getYpointsunten() {
		return ypointsunten;
	}

	public void setYpointsunten(int[] ypointsunten) {
		this.ypointsunten = ypointsunten;
	}
}