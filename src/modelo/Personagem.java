package modelo;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

public class Personagem extends Entidade{

	private String nome;
	private int status;
	private ArrayList<Item> inventario;
	private int forca, defesa, hp = 113, hpMax = 113, mp = 50, mpMax = 50;
	public boolean cima=true, baixo, direita, esquerda, pulo;
	private int aceleracao = 8;
	private boolean batendo;

	public Personagem(int posX, int posY, String nome) throws IOException {
		super(posX, posY, "richter.png");
		this.setNome(nome);
		this.velocidade = 8;
		this.tamanhoX=16;
		this.tamanhoY=48;
		this.status=0;
		this.inventario = new ArrayList<Item>();
	}

	public void mexer() {

		if(batendo){
			status=3;
		}else{
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
			
			if(pulo)
			{
				aceleracao-=1;
				posY-=aceleracao*4;
				if(aceleracao<-8){
					aceleracao=8;
					pulo=false;
				}
			}
			
			posX += dx;
			posY += dy;
		}
	}

	public Rectangle rec(){
		return new Rectangle(posX+16,posY,tamanhoX,tamanhoY);
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
		if(hp>hpMax)
			hp=hpMax;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isBatendo() {
		return batendo;
	}

	public void setBatendo(boolean batendo) {
		this.batendo = batendo;
	}
}