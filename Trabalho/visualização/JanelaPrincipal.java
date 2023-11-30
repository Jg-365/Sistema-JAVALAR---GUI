package visualização;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import posicionamento.Arquivos;
import posicionamento.Malha;

public class JanelaPrincipal extends JFrame{
	private Malha malhaPrincipal = new Malha();
	
	Arquivos arquivos = new Arquivos();
    PainelMalha malha = new PainelMalha(malhaPrincipal);
    PainelButton botoes = new PainelButton(malha, malhaPrincipal,arquivos);
    
	ImageIcon icone = new ImageIcon("C:/Users/Dr José Clerton/Downloads/PROVA-TECNICAS---PROG-main/PROVA-TECNICAS---PROG-main/visualização/Icones/iconeJavalar.png");
	
	public JanelaPrincipal() {
		
		
		setLayout(new BorderLayout());
		setTitle("O Sistema JavaLar");
		setBackground(Color.darkGray);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(955,600));
		setLocationRelativeTo(null);
		setResizable(false);
		malha.setPreferredSize(new Dimension(525,300));
		botoes.setPreferredSize(new Dimension(430,300));
		add(malha, BorderLayout.WEST);
		add(botoes, BorderLayout.EAST);
		
        setVisible(true);
	}
	
}
