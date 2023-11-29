package planetas;

import javax.swing.ImageIcon;

public class Java extends Astros{
	public Java() {
		this.setBiografia("Java é uma linguagem de programação de alto nível, \n"
			    + "orientada a objetos e fortemente tipada. Foi desenvolvida \n"
			    + "pela Sun Microsystems (agora Oracle) na década de 1990. Foi \n"
			    + "projetada para ser portátil, segura, robusta e independente \n"
			    + "de plataforma.\n"
			    + "Sua história começa na década de 1990 quando a Sun Microsystems \n"
			    + "começou a desenvolver a linguagem como parte do projeto \"Green\". \n"
			    + "Java foi lançada em 1995 como \"Java 1.0\".\n"
			    + "Ganhou popularidade devido à portabilidade, segurança, orientação \n"
			    + "a objetos e uma ampla biblioteca de classes padrão. Também se expandiu \n"
			    + "na web com o Java EE para desenvolvimento de aplicativos empresariais \n"
			    + "e applets Java para melhorar a interatividade na web.\n"
			    + "A comunidade de desenvolvedores Java cresceu significativamente ao longo \n"
			    + "dos anos, e a linguagem continuou a evoluir com novas versões lançadas \n"
			    + "periodicamente.\n");

		
		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/Java.png"));
		this.setX(8);
		this.setY(8);
		this.setMaxX(8);
		this.setMinX(8);
		this.setMaxY(8);
		this.setMinY(8);
		this.setHrsPorInstante(0);
		this.setVelocidadeTranslacao(0);
		this.setNome("Java");
	}
}
