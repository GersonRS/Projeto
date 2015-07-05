package view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Logica;
import modelo.Monstro;
import modelo.Personagem;
import controle.TratarTeclas;

public class Aplicacao extends JFrame {

	private static final long serialVersionUID = 1L;

	public Aplicacao(String s) {
		super();
		setSize(600, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		Personagem p1;
		try {
			p1 = new Personagem(0, 175,s);
			ArrayList<Monstro> m = new ArrayList<Monstro>();
			Render render = new Render(p1,m);
			Logica logica = new Logica(p1,m, render);
			render.addKeyListener(new TratarTeclas(p1));
			logica.start();
			add(render);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Aplicacao("Fulano");
	}
}
