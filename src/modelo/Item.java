package modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {

	private String nome;
	private int posicaoX, posicaoY;
	private BufferedImage imagem;
	private boolean visivel;
	private final int tamanhoX = 32, tamanhoY = 32;
	private int str, def, hp, ch;

	public Item(int posicaoX, int posicaoY, String nome) {
		this.visivel = true;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.nome = nome;
		try {
			imagem = ImageIO
					.read(getClass().getClassLoader().getResource(nome));
		} catch (IOException e) {
			System.out.println("Erro ao buscar imagem do Item " + nome
					+ ".\nEncerrando aplicação");
			System.exit(0);
		}
	}

	public Rectangle getColisao() {
		return new Rectangle(posicaoX, posicaoY, tamanhoX, tamanhoY);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public int getStr() {
		return str;
	}

	public int getDef() {
		return def;
	}

	public int getHp() {
		return hp;
	}

	public int getCh() {
		return ch;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

}
