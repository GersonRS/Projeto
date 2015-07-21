package modelo;

import java.awt.Rectangle;
import java.io.IOException;

public class Item extends Entidade {

	private String nome;
	private boolean visivel;
	private int hp;

	public Item(int posX, int posY, String s) throws IOException {
		super(posX, posY, s);
		this.nome = s;
		this.visivel = true;
		this.tamanhoX = 32;
		this.tamanhoY = 32;
		this.setHp(20);
	}

	@Override
	public Rectangle rec() {
		return new Rectangle(posX, posY, tamanhoX, tamanhoY);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
