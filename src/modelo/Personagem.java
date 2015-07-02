package modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Personagem {

	private int posX;
	private int posY;
	private int tamanhoX;
	private int tamanhoY;
	private int velocidade = 5;
	private BufferedImage imagem;
	private Controle controle;
	private ArrayList<Item> inventario;
	private int str, strMax = 10, def, defMax = 10, hp, hpMax = 10, mp, mpMax = 5;
	
	public Personagem(int posX, int posY, Controle controle) {
		this.posX = posX;
		this.posY = posY;
		this.controle = controle;
		try {
			imagem = ImageIO.read(this.getClass().getClassLoader()
					.getResource("personagem.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void andar(int novaDirecao) {
		switch (novaDirecao) {
		case 0:
			posY -= (velocidade);
			break;
		case 1:
			posX += (velocidade);
			break;
		case 2:
			posY += (velocidade);
			break;
		case 3:
			posX -= (velocidade);
			break;
		}
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

	public BufferedImage getImagem() {
		return imagem;
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
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
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getStrMax() {
		return strMax;
	}

	public void setStrMax(int strMax) {
		this.strMax = strMax;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getDefMax() {
		return defMax;
	}

	public void setDefMax(int defMax) {
		this.defMax = defMax;
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

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
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
}