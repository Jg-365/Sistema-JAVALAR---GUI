package posicionamento;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.AlunoDAO;
import planetas.Astros;
public class Arquivos{
	//Para leitura de arquivos de entrada:
	private int numeroDeLinhasLidas;
	private int numeroDeLinhasArquivo;
	public static int arquivoAtual;
	public static String[] nomeArquivoAtual = {"AE_10.csv",
										"AE_50.csv",
										"AE_100",
										"AE_500.csv",
										"AE_1000.csv",
										"AE_1500.csv",
										"AE_2000.csv"
										};
	//Enumeração para poder transitar entre files;
	public static ArrayList<Path> listaDeArquivos = new ArrayList<>();
	

	//Array que guarda as linhas em formato de String para cada arquivo lido;
	public static ArrayList<String> arquivoTemp = new ArrayList<>();
	
	//para gravação de arquivos de saída:
	private String arquivoSaida = "PROVA-TECNICAS---PROG-main/Arquivos/saida.txt";
	
	
	public Arquivos() {
		
	listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_10.csv"));
    listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_50.csv"));
    listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_100.csv"));
    listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_500.csv"));
    listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_1000.csv"));
    listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_1500.csv"));
    listaDeArquivos.add(Paths.get("PROVA-TECNICAS---PROG-main/Arquivos/AE_2000.csv"));
    
    setArquivoAtual(6);
    
	}
	
	public void lerNovoArquivo() throws IOException {	
		arquivoTemp.clear();
		
		List<String> linhas = Files.readAllLines(listaDeArquivos.get(arquivoAtual));
		linhas.remove(0);
		
		for(String linha : linhas) {
			arquivoTemp.add(linha);
		}
	}
	
	public void decodificadorDeLinhas(String linha) {
		
		String[] parciais = linha.split(",");
		
		for (int i = 1; i < parciais.length; i++) {
			
		    int temp = Integer.parseInt(parciais[i]);
		    
		    
		    if(i >= 1 && i < 8) {
		    	Astros planetaTemp = Malha.planetas.get(i);
		    	planetaTemp.setInstantes(temp);
		    }
		    else if(i == 8) {
		    	Rodadas.setNumeroDeBugs(temp);
		    }
		    else if(i == 9){
		    	Rodadas.setNumeroDeDevs(temp);
		    }
		    
		}
	}
	
	public void atualizarNumeroDeLinhasLidas() {
		setNumeroDeLinhasLidas(getNumeroDeLinhasLidas()+1);
	}
	
	public void atualizarArquivoAtual(String nome) {
		for(int i = 0; i < nomeArquivoAtual.length;i++) {
			if(nome.equalsIgnoreCase(nomeArquivoAtual[i])) {
				setArquivoAtual(i);
			}
		}
	}
	
	public void escreverNovoArquivo() {
		try {
		AlunoDAO alunos = new AlunoDAO();
		
		File arquivo = new File(arquivoSaida);
		FileWriter fileWriter = new FileWriter(arquivo);
		BufferedWriter escritor = new BufferedWriter(fileWriter);
		
		Rodadas.atualizarEstatisticasGlobais(alunos);
		
		escritor.write("O aluno que mais gerou instantes: " + Rodadas.getUsuarioMaisAtivo()
				+ " - Matricula: " + Rodadas.getMatricula()
				+ "\nPlaneta que mais explodiu: "+ Rodadas.getPlanetaMaisMorto()
				+ "\nPlaneta que fica com mais vida: "+ Rodadas.getPlanetaComMaisVida()
		        + "\nQuadrante que fica com mais bugs: "+ Rodadas.getQuadranteComMaisBugs()
		        + "\nQuadranre que fica com mais devs: "+ Rodadas.getQuadranteComMaisDevs()
		        + "\nNúmero total de instantes analisados pela turma: " + Rodadas.getNumeroTotalDeInstantesAnalisados()
		        + "\n\nVelocidade media total Python: " +Malha.planetas.get(1).getVelocidadeMediaTotal()
		        + "\nVelocidade media total JavaScript: " +Malha.planetas.get(2).getVelocidadeMediaTotal()
		        + "\nVelocidade media total PHP: " +Malha.planetas.get(3).getVelocidadeMediaTotal()
		        + "\nVelocidade media total Ruby On Rails: " +Malha.planetas.get(4).getVelocidadeMediaTotal()
		        + "\nVelocidade media total C#: " +Malha.planetas.get(5).getVelocidadeMediaTotal()
		        + "\nVelocidade media total C++: " +Malha.planetas.get(6).getVelocidadeMediaTotal()
		        + "\nVelocidade media total C: " +Malha.planetas.get(7).getVelocidadeMediaTotal()
		        + "\nNumero total de Devs: " + Rodadas.getNumeroTotalDeDevsAnalisados()
		        + "\nNumero total de Bugs: "+ Rodadas.getNumeroTotalDeBugsAnalisados()
		        + "\nNumero total de Horas: "+ Rodadas.getNumeroTotalDeHorasAnalisadas()
		        + "\nNumero total de Anos: "+ Rodadas.getNumeroTotalDeAnosAnalisados());
				
		escritor.close();
	}
		catch(IOException ex) {
			ex.getStackTrace();
		}
	}
	
	public int getNumeroDeLinhasLidas() {
		return numeroDeLinhasLidas;
	}

	public void setNumeroDeLinhasLidas(int numeroDeLinhas) {
		this.numeroDeLinhasLidas = numeroDeLinhas;
	}

	public static int getArquivoAtual() {
		return arquivoAtual;
	}

	public void setArquivoAtual(int valor) {
		arquivoAtual = valor;
	}

	public int getNumeroDeLinhasArquivo() {
		return numeroDeLinhasArquivo;
	}

	public void setNumeroDeLinhasArquivo(int numeroDeLinhasArquivo) {
		this.numeroDeLinhasArquivo = numeroDeLinhasArquivo;
	}

	public static String getNomeArquivoAtual(int index) {
		return nomeArquivoAtual[index];
	}
	
}
