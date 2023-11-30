package planetas;

import javax.swing.ImageIcon;

public class C extends Astros{
	public C() {
		this.setBiografia("C é uma linguagem de programação compilada de propósito geral, estruturada, imperativa, procedural, padronizada pela Organização\n"
                + "Internacional para Padronização (ISO), criada em 1972 por Dennis Ritchie na empresa AT&T Bell Labs para desenvolvimento do sistema operacional Unix\n"
                + "(originalmente escrito em Assembly).\n"
                + "C é uma das linguagens de programação mais populares e existem poucas arquiteturas para as quais não existem compiladores para C.\n"
                + "C tem influenciado muitas outras linguagens de programação (por exemplo, a linguagem Java), mais notavelmente C++, que originalmente começou\n"
                + "como uma extensão para C.\n"
                + "A linguagem C encontra-se na versão/padrão internacional C17 (ISO/IEC 9899:2018) lançada em junho de 2018, substituindo\n"
                + "a versão C11 (ISO/IEC 9899:2011), disponível em ISO e IEC e com suporte para GCC8 e Clang LLVM6.");

		
		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/C.png"));
		this.setX(8);
		this.setY(15);
		this.setMaxX(15);
		this.setMinX(1);
		this.setMaxY(15);
		this.setMinY(1);
		this.setHrsPorInstante(4);
		this.setVelocidadeTranslacao(10);
		this.setNome("C");
		
	}
}
