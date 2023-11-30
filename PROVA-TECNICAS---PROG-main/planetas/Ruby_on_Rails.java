package planetas;

import javax.swing.ImageIcon;

public class Ruby_on_Rails extends Astros{
	public Ruby_on_Rails() {
		this.setBiografia("Ruby on Rails é um framework livre que promete aumentar velocidade e facilidade no\n"
                + "desenvolvimento de sites orientados a banco de dados (database-driven web sites), uma vez que\n"
                + "é possível criar aplicações com base em estruturas pré-definidas. Frequentemente referenciado como\n"
                + "Rails ou RoR, o Ruby on Rails é um projeto de código aberto escrito na linguagem de programação Ruby.\n"
                + "As aplicações criadas utilizando o framework Rails são desenvolvidas com base no padrão de arquitetura\n"
                + "MVC (Model-View-Controller).");

		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/ruby.png"));
		this.setX(8);
		this.setY(11);
		this.setMaxX(11);
		this.setMinX(5);
		this.setMaxY(11);
		this.setMinY(5);
		this.setHrsPorInstante(48);
		this.setVelocidadeTranslacao(2);
		this.setNome("RubyOnRails");

	}
}
