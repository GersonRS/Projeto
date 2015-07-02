package view;

import javax.swing.JFrame;

import modelo.Controle;
import modelo.Logica;
import modelo.Personagem;
import controle.TratarTeclas;

public class Aplicacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private Render render;
	private Logica logica;
	private Personagem p1;
	private Mapa m;

//	private Dimension dimTela = Toolkit.getDefaultToolkit().getScreenSize();

	public Aplicacao() {
		super();
		setSize(600, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		m = new Mapa();
		Controle c = new Controle(38, 39, 40, 37);
		p1 = new Personagem(100, 100, c);
		logica = new Logica(p1, m);
		render = new Render(m, p1);
		render.addKeyListener(new TratarTeclas(c));
		logica.start();
		new Thread(render).start();
		add(render);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Aplicacao();
	}
}
