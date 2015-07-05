package modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entidade {

	protected int posX;
	protected int posY;
	protected int dx;
	protected int dy;
	protected int tamanhoX;
	protected int tamanhoY;
	protected int velocidade;
	protected int direcao;
	protected int animated;
	protected BufferedImage imagem;

	protected Entidade(int posX, int posY, String s) throws IOException {
		this.posX = posX;
		this.posY = posY;
		this.imagem = (ImageIO.read(getClass().getClassLoader().getResource(s)));
	}
	
	public abstract Rectangle rec();

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

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public int getAnimated() {
		return animated;
	}

	public void setAnimated(int animated) {
		this.animated = animated;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}
}
