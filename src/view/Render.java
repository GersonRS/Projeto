package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modelo.Personagem;

public class Render extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage tela = new BufferedImage(6400, 320,
			BufferedImage.TYPE_4BYTE_ABGR);
	private Graphics2D graphics;
	private Mapa map;
	private Personagem p1;
	private int posX;
	private BufferedImage hud;

	public Render(Personagem p1) throws IOException {
		this.p1 = p1;
		this.map = new Mapa();
		graphics = (Graphics2D) tela.getGraphics();
		hud = ImageIO.read(getClass().getClassLoader().getResource("hud.png"));
		setSize(640, 480);
		setPreferredSize(new Dimension(640, 480));
		setDoubleBuffered(true);
		setFocusable(true);
		requestFocus();
		setBackground(Color.BLUE);
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		if (p1.getPosX() >= 300 && p1.getPosX() <= 6100)
			posX = posX - p1.getDx();
		if (posX >= 0) {
			posX = 0;
		}
		if (posX <= -6400 + 600) {
			posX = -6400 + 600;
		}
		graphics.drawImage(map.getMapa(), 0, 0, null);

		graphics.drawImage((p1.getDirecao() == 1 ? imageFlip(p1.getImagem())
				: p1.getImagem()), p1.getPosX(), p1.getPosY(),
				p1.getPosX() + 50, p1.getPosY() + 50,
				(int) (p1.getAnimated() % 8) * 50, 0,
				(int) (p1.getAnimated() % 8 * 50) + 50, 0 + 50, null);
		g2d.drawRect(0, 0, getWidth(), getHeight());
		g2d.drawImage(tela, posX, 0, null);
		g2d.setColor(Color.GREEN);
		g2d.fillRect(67, 45, (p1.getHp() * 75) / p1.getHpMax(), 6);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(67, 54, (p1.getMp() * 58) / p1.getMpMax(), 6);
		g2d.drawImage(hud, 0, 0, null);
	}

	public BufferedImage imageFlip(BufferedImage img) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage dimg = new BufferedImage(w, h,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = (Graphics2D) dimg.getGraphics();
		g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
		g.dispose();
		return dimg;
	}

	public Mapa getMap() {
		return map;
	}
}
