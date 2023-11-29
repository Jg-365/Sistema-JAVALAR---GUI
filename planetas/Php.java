package planetas;

import javax.swing.ImageIcon;

public class  Php extends Astros {
	public Php() {
		this.setBiografia("PHP (um acrônimo recursivo para \"PHP: Hypertext Preprocessor\", originalmente Personal Home Page) é uma linguagem interpretada livre,\n"
                + "usada originalmente apenas para o desenvolvimento de aplicações presentes e atuantes no lado do servidor, capazes de gerar\n"
                + "conteúdo dinâmico na World Wide Web. Figura entre as primeiras linguagens passíveis de inserção em documentos HTML, dispensando\n"
                + "em muitos casos o uso de arquivos externos para eventuais processamentos de dados. O código é interpretado no lado do servidor\n"
                + "pelo módulo PHP, que também gera a página web a ser visualizada no lado do cliente. A linguagem evoluiu, passou a oferecer funcionalidades\n"
                + "em linha de comando, e além disso, ganhou características adicionais, que possibilitaram usos adicionais do PHP, não relacionados a web sites.\n"
                + "É possível instalar o PHP na maioria dos sistemas operacionais, gratuitamente. Concorrente direto da tecnologia ASP pertencente à Microsoft,\n"
                + "o PHP é utilizado em aplicações como o MediaWiki, Facebook, Drupal, Joomla!, WordPress, Magento e o Oscommerce.");

		this.setVivoMorto(true);
		this.setImagem(new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/php.png"));
		this.setX(8);
		this.setY(12);
		this.setMaxX(12);
		this.setMinX(4);
		this.setMaxY(12);
		this.setMinY(4);
		this.setHrsPorInstante(60);
		this.setVelocidadeTranslacao(2);
		this.setNome("Php");

	}
}

