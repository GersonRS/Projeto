package controle;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Personagem;

public class TratarMouse extends MouseAdapter {

	private Personagem p;

	public TratarMouse(Personagem p) {
		this.p = p;
	}

	public void mouseClicked(MouseEvent e) {
		Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
		for (int i = 0; i < p.getInventario().size(); i++) {
			if(p.getInventario().get(i).rec().intersects(r)){
				p.setHp(p.getHp() + p.getInventario().get(i).getHp());
				p.getInventario().remove(i);
			}
		}
	}

}
