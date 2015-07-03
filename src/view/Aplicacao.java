package view;

import java.io.IOException;

import javax.swing.JFrame;

import modelo.Logica;
import modelo.Personagem;
import controle.TratarTeclas;

public class Aplicacao extends JFrame {

	private static final long serialVersionUID = 1L;

	public Aplicacao() {
		super();
		setSize(600, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		Personagem p1;
		try {
			p1 = new Personagem(0, 228-54);
			Render render = new Render(p1);
			Logica logica = new Logica(p1, render);
			render.addKeyListener(new TratarTeclas(p1));
			logica.start();
			add(render);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Aplicacao();
	}
}
