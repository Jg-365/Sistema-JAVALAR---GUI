package visualização;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Botao extends JButton{	
	
	public Botao(String texto) {
		setText(texto);
		setBackground(Color.lightGray);
		setFont(new Font("arial", Font.BOLD, 20));
	}
	
}
