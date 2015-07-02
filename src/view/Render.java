package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import modelo.Personagem;

public class Render extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private BufferedImage tela = new BufferedImage(6400, 320,
			BufferedImage.TYPE_4BYTE_ABGR);
	private Graphics2D graphics;
	private Mapa map;
	private Personagem p1;

	boolean run = true;

	public Render(Mapa m, Personagem p1) {
		this.p1 = p1;
		graphics = (Graphics2D) tela.getGraphics();
		setSize(640, 480);
		setPreferredSize(new Dimension(640, 480));
		setDoubleBuffered(true);
		setFocusable(true);
		requestFocus();
		setBackground(Color.BLUE);
		this.map = m;
	}

	public void paint(Graphics g) {

		graphics.drawImage(map.getMapa(), 0, 0, null);
		graphics.drawImage(p1.getImagem(), p1.getPosX(), p1.getPosY(), null);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(tela, 0, 0, null);
	}

	public void run() {
		while (run) {
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
