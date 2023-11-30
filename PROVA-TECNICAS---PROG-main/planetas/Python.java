package planetas;

import javax.swing.ImageIcon;

public class Python extends Astros {
	
	public Python() {
		this.setBiografia("Python é uma linguagem de programação de alto nível, ou seja, \n"
                + "com sintaxe mais simplificada e próxima da linguagem humana, utilizada nas \n"
                + "mais diversas aplicações, como desktop, web, servidores e ciência de dados. A \n"
                + "linguagem oferece recursos como tipagem dinâmica e forte (tipo de dado do valor \n"
                + "deve ser do mesmo tipo da variável), orientação a objetos, multiparadigmas (programação \n"
                + "funcional e imperativa), além de recursos poderosos em biblioteca padrão e via módulos \n"
                + "e frameworks desenvolvidos pela comunidade. Seu código é aberto e a utilização é gratuita, \n"
                + "rodando em praticamente qualquer sistema operacional.\n");

		
		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/python.png"));
		this.setX(8);
		this.setY(9);
		this.setMaxX(9);
		this.setMinX(7);
		this.setMaxY(9);
		this.setMinY(7);
		this.setVelocidadeTranslacao(1);
		this.setHrsPorInstante(24);
		this.setNome("Python");
	}
}
