package controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import modelo.Controle;

public class TratarTeclas extends KeyAdapter{
	Controle controle;
	
	public TratarTeclas(Controle c) {
		this.controle = c;
	}

	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);		
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			controle.setBotaoCima(true);
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			controle.setBotaoBaixo(true);
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			controle.setBotaoEsquerda(true);
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			controle.setBotaoDireita(true);
		}
	}
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			controle.setBotaoCima(false);
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			controle.setBotaoBaixo(false);
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			controle.setBotaoEsquerda(false);
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			controle.setBotaoDireita(false);
		}
	}
}
