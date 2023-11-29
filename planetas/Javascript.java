package planetas;

import javax.swing.ImageIcon;

public class Javascript extends Astros{

	public Javascript() {
		this.setBiografia("JavaScript® (às vezes abreviado para JS) é uma linguagem leve, interpretada e baseada em objetos com funções de primeira classe,\n"
                + "mais conhecida como a linguagem de script para páginas Web, mas usada também em vários outros ambientes sem browser, tais como node.js, Apache\n"
                + "CouchDB e Adobe Acrobat.\n"
                + "O JavaScript é uma linguagem baseada em protótipos, multi-paradigma e dinâmica, suportando estilos de orientação a objetos,\n"
                + "imperativos e declarativos (como por exemplo a programação funcional). Saiba mais sobre o JavaScript.");

		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/Javascript.png"));
		this.setX(8);
		this.setY(10);
		this.setMaxX(10);
		this.setMinX(6);
		this.setMaxY(10);
		this.setMinY(6);
		this.setHrsPorInstante(10);
		this.setVelocidadeTranslacao(3);
		this.setNome("Javascript");
	}
}
