package modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Personagem {

	private int posX;
	private int dx;
	private int dy;
	private int posY;
	private int tamanhoX;
	private int tamanhoY;
	private int velocidade = 10;
	private int direcao;
	private int animated;
	private BufferedImage imagem;
	private ArrayList<Item> inventario;
	private Sprite sprite;
	private int forca, defesa, hp = 113, hpMax = 113, mp = 50, mpMax = 50;
	public boolean cima, baixo, direita, esquerda;

	public Personagem(int posX, int posY) throws IOException {
		this.posX = posX;
		this.posY = posY;
		this.setImagem(ImageIO.read(getClass().getClassLoader().getResource(
				"richter.png")));
		this.setSprite(new Sprite(0, 50, 50, 8, 6, "richter.png"));
	}

	public void mexer() {

		if (direita || esquerda) {
			if (direita) {
				dx = velocidade;
				direcao = 0;
			} else {
				dx = -velocidade;
				direcao = 1;
			}
			animated++;
			if (animated > 8)
				animated = 0;
		} else {
			dx = 0;
		}

		posX += dx;
		posY += dy;

	}

	public Rectangle colisao() {
		return new Rectangle(posX, posY, 14, 14);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public ArrayList<Item> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Item> inventario) {
		this.inventario = inventario;
	}

	public int getStr() {
		return forca;
	}

	public void setStr(int str) {
		this.forca = str;
	}

	public int getDef() {
		return defesa;
	}

	public void setDef(int def) {
		this.defesa = def;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMpMax() {
		return mpMax;
	}

	public void setMpMax(int mpMax) {
		this.mpMax = mpMax;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public void setTamanhoX(int tamanhoX) {
		this.tamanhoX = tamanhoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public void setTamanhoY(int tamanhoY) {
		this.tamanhoY = tamanhoY;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}

	public int getAnimated() {
		return animated;
	}

	public void setAnimated(int animated) {
		this.animated = animated;
	}

}