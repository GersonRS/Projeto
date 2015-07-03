package modelo;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

public class Personagem {

	private int posX;
	private int dx;
	private int dy;
	private int posY;
	private int tamanhoX;
	private int tamanhoY;
	private int velocidade = 10;
	private int direcao;
	private ArrayList<Item> inventario;
	private Sprite sprite;
	private int str, strMax = 10, def, defMax = 10, hp, hpMax = 10, mp,
			mpMax = 5;

	public Personagem(int posX, int posY) throws IOException {
		this.posX = posX;
		this.posY = posY;
		this.setSprite(new Sprite(0, 50, 50, 8, 6, "richter.png"));
	}
	
	public void mexer() {

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

}