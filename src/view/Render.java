package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Item;
import modelo.Monstro;
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
	private ArrayList<Monstro> monstros;
	private ArrayList<Item> inventario;
	private ArrayList<Item> itens;

	public Render(Personagem p1, ArrayList<Monstro> m, ArrayList<Item> i)
			throws IOException {
		this.p1 = p1;
		this.inventario = p1.getInventario();
		this.itens = i;
		this.monstros = m;
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
		if (p1.getHp() <= 0) {

			int resposta = JOptionPane.showConfirmDialog(null,
					"morreu, Deseja Tentar Novamente ?");

			if (resposta == JOptionPane.YES_OPTION)
				p1.setHp(100);
			else
				System.exit(0);
		} else {

			if (p1.getPosX() >= 300 && p1.getPosX() <= 6100)
				posX = posX - p1.getDx();
			if (posX >= 0) {
				posX = 0;
			}
			if (posX <= -6400 + 600) {
				posX = -6400 + 600;
			}
			graphics.drawImage(map.getMapa(), 0, 0, null);
			for (int i = 0; i < monstros.size(); i++) {

				graphics.setColor(Color.RED);
				graphics.fillRect(monstros.get(i).getPosX() + 3, monstros
						.get(i).getPosY() - 5, (monstros.get(i).getHp() * 25)
						/ monstros.get(i).getHpMax(), 4);

				graphics.drawImage(
						(monstros.get(i).getDirecao() == 1 ? imageFlip(monstros
								.get(i).getImagem()) : monstros.get(i)
								.getImagem()), monstros.get(i).getPosX(),
						monstros.get(i).getPosY(),
						monstros.get(i).getPosX() + 30, monstros.get(i)
								.getPosY() + 45, (int) (monstros.get(i)
								.getAnimated() % 8) * 29, 0, (int) (monstros
								.get(i).getAnimated() % 8 * 29) + 30, 0 + 45,
						null);
			}
			for (int i = 0; i < itens.size(); i++) {
				graphics.drawImage(itens.get(i).getImagem(), itens.get(i)
						.getPosX(), itens.get(i).getPosY(), itens.get(i)
						.getPosX() + 32, itens.get(i).getPosY() + 32,
						(int) (itens.get(i).getAnimated() % 3) * 32, 0,
						(int) (itens.get(i).getAnimated() % 3 * 32) + 32,
						0 + 32, null);
			}
			graphics.drawImage(
					(p1.getDirecao() == 1 ? imageFlip(p1.getImagem()) : p1
							.getImagem()), p1.getPosX(), p1.getPosY(), p1
							.getPosX() + 50, p1.getPosY() + 50, (int) (p1
							.getAnimated() % 8) * 50, 0, (int) (p1
							.getAnimated() % 8 * 50) + 50, 0 + 50, null);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(tela, posX, 0, null);
			g2d.setColor(Color.GRAY);
			g2d.fillRect(67, 45, 75, 6);
			g2d.fillRect(67, 54, 58, 6);
			g2d.setColor(Color.GREEN);
			g2d.fillRect(67, 45, (p1.getHp() * 75) / p1.getHpMax(), 6);
			g2d.setColor(Color.BLUE);
			g2d.fillRect(67, 54, (p1.getMp() * 58) / p1.getMpMax(), 6);
			g2d.setColor(Color.GRAY);
			g2d.drawString(p1.getNome(), 100, 30);
			g2d.drawImage(hud, 0, 0, null);
			for (int i = 0; i < inventario.size(); i++) {
				g2d.drawImage(inventario.get(i).getImagem(), (inventario.get(i)
						.getPosX()), inventario.get(i).getPosY(),
						(inventario.get(i).getPosX()) + 32,
						inventario.get(i).getPosY() + 32, 0, 0, 32, 32, null);
			}
		}
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
