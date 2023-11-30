package planetas;

import javax.swing.ImageIcon;

public class Cplusplus extends Astros{
	
		public Cplusplus() {
			this.setBiografia("Podemos descrever C++ por duas palavras: elegância e performance.\n"
	                + "Seus códigos possuem uma sintaxe elegante e bem menos verbosa que as linguagens de alto\n"
	                + "nível modernas. Usando C++ você pode usar os paradigmas de programação estruturada, programação\n"
	                + "orientada a objetos e programação genérica.\n"
	                + "Além de permitir acesso a recursos de baixo nível que melhoram a performance do código escrito, seus compiladores\n"
	                + "possuem recursos de otimização excelentes o que torna os programas escritos em C++ excelentes em termos de performance.\n"
	                + "Com C++ você pode escrever compiladores, interpretadores, games, bancos de dados, sistemas operacionais,\n"
	                + "aplicações para IoT, aplicações de Machine Learning e aplicações diversas. Existem muitas bibliotecas gráficas\n"
	                + "que podem ser usadas para criação de interfaces de usuário gráficas e bibliotecas especializadas para diversas tarefas.");

			
			this.setVivoMorto(true);
			this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/c++.png"));
			this.setX(8);
			this.setY(14);
			this.setMaxX(14);
			this.setMinX(2);
			this.setMaxY(14);
			this.setMinY(2);
			this.setHrsPorInstante(0.5f);
			this.setVelocidadeTranslacao(2);
			this.setNome("C++");

	}
}


