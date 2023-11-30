package planetas;

import javax.swing.ImageIcon;

public class C_sharp extends Astros {
	public C_sharp() {
		this.setBiografia("C# é uma linguagem de programação orientada a objetos e orientada a componentes.\n"
                + "C# fornece construções de linguagem para dar suporte diretamente a esses conceitos, tornando\n"
                + "C# uma linguagem natural para criação e uso de componentes de software. Desde sua origem, o C#\n"
                + "adicionou recursos para dar suporte a novas cargas de trabalho e práticas emergentes de design de software.\n"
                + "Em sua essência, o C# é uma linguagem orientada a objetos. Você define os tipos e o comportamento deles.\n"
                + "Vários recursos do C# ajudam a criar aplicativos robustos e duráveis. A coleta de lixo recupera automaticamente\n"
                + "a memória ocupada por objetos não utilizados inacessíveis. Tipos anuláveis são protegidos contra variáveis que\n"
                + "não se referem a objetos alocados. O tratamento de exceções fornece uma abordagem estruturada e extensível para\n"
                + "detecção e recuperação de erros.");

		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/c#.png"));
		this.setX(8);
		this.setY(13);
		this.setMaxX(13);
		this.setMinX(3);
		this.setMaxY(13);
		this.setMinY(3);
		this.setHrsPorInstante(4);
		this.setVelocidadeTranslacao(1);
		this.setNome("C#");
	}
	
}
