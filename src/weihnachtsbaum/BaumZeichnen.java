package weihnachtsbaum;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Dies ist die Klasse in der der Weihnachtsbaum generiert wird.
 * In ihr wird ein Weihnachtsbaum inclusive der an ihm haengenden Kugeln generiert.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class BaumZeichnen {

	private Canvas canvas1 = new Canvas() {
	    public void paint(Graphics stift) {
	    	baumzeichnen(stift);
	    }
	};
	private JFrame frame1 = new JFrame("Weihnachtsbaum");
	private int frameWidth = 500;
	private int frameHeight = 500;
	private Weihnachtsbaum noel = new Weihnachtsbaum();
	private ArrayList<Kugel> kugeln = new ArrayList<Kugel>();
	private int kugelzahl = 35;
	
	public BaumZeichnen() {
		frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame1.setSize(frameWidth, frameHeight);
	    frame1.setLocationRelativeTo(null);
	    frame1.setResizable(false);
	    Container cp = frame1.getContentPane();
	    cp.setLayout(null);
	    canvas1.setBounds(0,0,frameWidth,frameWidth);
	    canvas1.setBackground(new Color(0x1B1E24));
	    cp.add(canvas1);
	    frame1.setVisible(true);
	    baumgenerierungdefinition();
	}
	
	/**
	 * Diese Methode generiert den Weihnachtsbaum vollstaendig.<br>
	 * Bei den Kugeln wird stets darauf geachtet, dass sie am Baum haengen und sich nicht gegenseitig ueberschneiden.
	 */
	private void baumgenerierungdefinition() {
		Random zufall = new Random();
		
		noel.setX(frameWidth/2);
		noel.setY((frameHeight/4)*3);
		noel.setKronh((frameHeight/5)*3);
		noel.setKronb((noel.getKronh()*2)/3);
		noel.setSth(noel.getKronh()/5);
		noel.setStb(noel.getSth()/5);
		int xarroben[] = {noel.getX()-(noel.getKronb()/10)*3, noel.getX()+(noel.getKronb()/10)*3, noel.getX()};
		int yarroben[] = {noel.getY()-2*(noel.getKronh()/3), noel.getY()-2*(noel.getKronh()/3), noel.getY()-noel.getKronh()};
		noel.setXpointsoben(xarroben);
		noel.setYpointsoben(yarroben);
		int xarrmitte[] = {noel.getX()-(noel.getKronb()/5)*2, noel.getX()+(noel.getKronb()/5)*2, noel.getX()+(noel.getKronb()/36)*5, noel.getX()-(noel.getKronb()/36)*5};
		int yarrmitte[] = {noel.getY()-noel.getKronh()/3, noel.getY()-noel.getKronh()/3, noel.getY()-2*(noel.getKronh()/3), noel.getY()-2*(noel.getKronh()/3)};
		noel.setXpointsmitte(xarrmitte);
		noel.setYpointsmitte(yarrmitte);
		int xarrunten[] = {noel.getX()-noel.getKronb()/2, noel.getX()+noel.getKronb()/2, noel.getX()+noel.getKronb()/6, noel.getX()-noel.getKronb()/6};
		int yarrunten[] = {noel.getY(), noel.getY(), noel.getY()-noel.getKronh()/3, noel.getY()-noel.getKronh()/3};
		noel.setXpointsunten(xarrunten);
		noel.setYpointsunten(yarrunten);
		
		Polygon boxunten = new Polygon(xarrunten, yarrunten,4);
		Polygon boxmitte = new Polygon(xarrmitte, yarrmitte,4);
		Polygon boxoben = new Polygon(xarroben, yarroben,3);
		int n=0;
		kugeln.add(new Kugel());
		while(n<kugelzahl-1) {
			boolean besetzt = false;
			kugeln.get(n).setX(noel.getX()-noel.getKronb()/2+zufall.nextInt(noel.getKronb()));
			kugeln.get(n).setY(noel.getY()-noel.getKronh()+zufall.nextInt(noel.getKronh()));
			kugeln.get(n).setHoehe(noel.getKronb()/12);
			kugeln.get(n).setBreite(kugeln.get(n).getHoehe());
			if((kugeln.get(n).intersects(boxoben)||
			    kugeln.get(n).intersects(boxmitte)||
			    kugeln.get(n).intersects(boxunten))) {
				for(int i=0;i<n;i++) {
					if(kugeln.get(i).hits(kugeln.get(n))) {
						besetzt = true;
						break;
					}
				}
			} else {
				besetzt = true;
			}
			if(besetzt==true) {
				besetzt = false;
			} else {
				n++;kugeln.add(new Kugel());
				besetzt = false;
			}
		}
	}
	
	/**
	 * Diese Methode zeichnet den Baum nach den oben definierten Eigenschaften.
	 * @param stift Nimmt das GraphicsElement entgegen.
	 */
	private void baumzeichnen(Graphics stift) {
		stift.setColor(new Color(0x8B4500));
		stift.fillRect(noel.getX()-noel.getStb()/2, noel.getY()-5, noel.getStb(), noel.getSth());
		stift.setColor(new Color(0x32CD32));
		stift.fillPolygon(noel.getXpointsunten(),noel.getYpointsunten(),4);
		stift.fillPolygon(noel.getXpointsmitte(),noel.getYpointsmitte(),4);
		stift.fillPolygon(noel.getXpointsoben(),noel.getYpointsoben(),3);
		stift.setColor(Color.RED);
		for(int n=0;n<kugeln.size();n++) {
			stift.fillOval(kugeln.get(n).getX(), kugeln.get(n).getY(), kugeln.get(n).getBreite(), kugeln.get(n).getHoehe());
		}
	}
	
	public static void main(String[] args) {
		new BaumZeichnen();
	}
}