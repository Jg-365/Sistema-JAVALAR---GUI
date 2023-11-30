package posicionamento;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import model.AlunoDAO;
import modificadores.Aluno;
import modificadores.Bugs;
import modificadores.Devs;
import modificadores.Quadrantes;
import planetas.Astros;
public class Rodadas {
	
	private static int planetasMortos;
	private static int instantes_totais;
	private static int numeroPlanetasMortos;

	public static ArrayList<Astros> explodidos = new ArrayList<>();
	
	private static int bug_q1;
	private static int bug_q2;
	private static int bug_q3;
	private static int bug_q4;
	
	private static int dev_q1;
	private static int dev_q2;
	private static int dev_q3;
	private static int dev_q4;
	
	private static int numeroDeDevs;
	private static int numeroDeBugs;
	private static int numTotalDeDevs;
	private static int numTotalDeBugs;
			
	private static ImageIcon explosion = new ImageIcon("C:/Users/Dr José Clerton/Downloads/PROVA-TECNICAS---PROG-main/PROVA-TECNICAS---PROG-main/visualização/Icones/explosion-icon-21.png");
	
	private static String usuarioMaisAtivo;
	private static String matricula;
	private static String planetaMaisMorto;
	private static String planetaComMaisVida;
	private static String quadranteComMaisDevs;
	private static String quadranteComMaisBugs;
	private static long numeroTotalDeInstantesAnalisados;
    private static long numeroTotalDeBugsAnalisados;
    private static long numeroTotalDeDevsAnalisados;
    private static long numeroTotalDeHorasAnalisadas;
    private static long numeroTotalDeAnosAnalisados;
	
	public Rodadas() {
	}
	
	
	//GETTERS E SETTERS
	public static void setInstantesTotais(int valor) {
		instantes_totais = valor;
	}
	
	public static int getInstantesTotais() {
		return instantes_totais;
	}
	
	
	public static void setNumeroDeBugs(int valor) {
		numeroDeBugs = valor;
	}
	
	public static int getNumeroDeBugs() {
		return numeroDeBugs;
	}
	
	public static void setNumeroDeDevs(int valor) {
		numeroDeDevs = valor;
	}
	
	public static int getNumeroDeDevs() {
		return numeroDeDevs;
	}

	public static int getNumTotalDeDevs() {
		return numTotalDeDevs;
	}

	public static void setNumTotalDeDevs(int numTotalDeDevs) {
		Rodadas.numTotalDeDevs = numTotalDeDevs;
	}

	public static int getNumTotalDeBugs() {
		return numTotalDeBugs;
	}

	public static void setNumTotalDeBugs(int numTotalDeBugs) {
		Rodadas.numTotalDeBugs = numTotalDeBugs;
	}

	public static int getPlanetasMortos() {
		return planetasMortos;
	}

	public static void setPlanetasMortos(int planetasMortos) {
		Rodadas.planetasMortos = planetasMortos;
	}

	public static ImageIcon getImagem() {
		return explosion;
	}

	public static int getNumeroPlanetasMortos() {
		return numeroPlanetasMortos;
	}

	public static void setNumeroPlanetasMortos(int numeroPlanetasMortos) {
		Rodadas.numeroPlanetasMortos = numeroPlanetasMortos;
	}
	
	public static int getBug_q1() {
		return bug_q1;
	}

	public static void setBug_q1(int bug_q1) {
		Rodadas.bug_q1 = bug_q1;
	}

	public static int getBug_q2() {
		return bug_q2;
	}

	public static void setBug_q2(int bug_q2) {
		Rodadas.bug_q2 = bug_q2;
	}

	public static int getBug_q3() {
		return bug_q3;
	}

	public static void setBug_q3(int bug_q3) {
		Rodadas.bug_q3 = bug_q3;
	}

	public static int getBug_q4() {
		return bug_q4;
	}

	public static void setBug_q4(int bug_q4) {
		Rodadas.bug_q4 = bug_q4;
	}

	public static int getDev_q1() {
		return dev_q1;
	}

	public static void setDev_q1(int dev_q1) {
		Rodadas.dev_q1 = dev_q1;
	}

	public static int getDev_q2() {
		return dev_q2;
	}

	public static void setDev_q2(int dev_q2) {
		Rodadas.dev_q2 = dev_q2;
	}

	public static int getDev_q3() {
		return dev_q3;
	}

	public static void setDev_q3(int dev_q3) {
		Rodadas.dev_q3 = dev_q3;
	}

	public static int getDev_q4() {
		return dev_q4;
	}

	public static void setDev_q4(int dev_q4) {
		Rodadas.dev_q4 = dev_q4;
	}
	
	
	//ATUALIZAÇÃO DE INFORMAÇÕES
	public static void atualizarInstantesTotaisPlanetas() {
		for(int i = 1; i < 8;i++) {
			Malha.planetas.get(i).setInstantesTotais(Malha.planetas.get(i).getInstantesTotais() + Malha.planetas.get(i).getInstantesPlaneta());
		}
	}
	
	public static void teste() {
		for(Astros planetas : Malha.planetas) {
			System.out.printf("Velocidade Media %s - %d\n", planetas.getNome(),planetas.getVelocidadeMedia());
		}
	}	
	
	public static void atualizarVelocidadeMedia(Astros planeta) {
            if(!planeta.getNome().equalsIgnoreCase("java")) {
                float velocidadeMedia = (float)planeta.getDeslocamentoTotal() / (float)planeta.getInstantesTotais();
                int velocidadeArredondada = (int)Math.round(velocidadeMedia);
                planeta.setVelocidadeMedia(velocidadeArredondada);
        }
    }
	
	public static void atualizarNumeroDeBugsPorQuadrante() {
		int q1=getBug_q1(), q2=getBug_q2(), q3=getBug_q3(), q4=getBug_q4();
		for(Bugs bug : Malha.bugs) {
			if(bug.getAtivoInativo()==true) {
			if(bug.getPosX()>8 && bug.getPosY() > 8) {
				bug.setQuadrante(Quadrantes.QUADRANTE_1);
				q1++;			}
			else if(bug.getPosX()<8 && bug.getPosY()>8) {
				bug.setQuadrante(Quadrantes.QUADRANTE_2);
				q2++;			}
			else if(bug.getPosX()>8 && bug.getPosY()<8) {
				bug.setQuadrante(Quadrantes.QUADRANTE_3);
				q3++;			}
			else if(bug.getPosX()<8 && bug.getPosY()<8){
				bug.setQuadrante(Quadrantes.QUADRANTE_4);
				q4++;			}
			}
		}
		setBug_q1(q1-getBug_q1());
		setBug_q2(q2-getBug_q2());
		setBug_q3(q3-getBug_q3());
		setBug_q4(q4-getBug_q4());
	}
	
	public static void atualizarNumeroDeDevsPorQuadrante() {
		int q1=getDev_q1(), q2=getDev_q2(), q3=getDev_q3(), q4=getDev_q4();
		for(Devs dev: Malha.devs) {
			if(dev.getAtivoInativo()==true) {
			if(dev.getPosX()>8 && dev.getPosY() > 8) {
			dev.setQuadrante(Quadrantes.QUADRANTE_1);
			q1++;
			}
			else if(dev.getPosX()<8 && dev.getPosY()>8) {
				dev.setQuadrante(Quadrantes.QUADRANTE_2);
			q2++;
			}
			else if(dev.getPosX()>8 && dev.getPosY()<8) {
				dev.setQuadrante(Quadrantes.QUADRANTE_3);
			q3++;	
			}
			else if(dev.getPosX()<8 && dev.getPosY()<8) {
				dev.setQuadrante(Quadrantes.QUADRANTE_4);
			q4++;	
			}
			}
		}
		setDev_q1(q1-getDev_q1());
		setDev_q2(q2-getDev_q2());
		setDev_q3(q3-getDev_q3());
		setDev_q4(q4-getDev_q4());
	}
	
	public static void atualizarInstantesTotalGeral(int temp) {
		setInstantesTotais(getInstantesTotais()+temp);
	}
	
	public static void atualizarHorasTotais(Astros planeta) {
            int horasTotais = Math.round(planeta.getHorasTotais() + planeta.getHoras());
            planeta.setHorasTotais(horasTotais);
        }
	
	 public static void atualizarHoras(Astros planeta) {    
	            float horas = planeta.getHorasPorInstante() * planeta.getInstantesPlaneta();
	            if(planeta.isVivoMorto()==true) {
	                planeta.setHoras(horas);
	            }
	            else {
	                planeta.setHoras(0);
	            }
	        }
	    
	public static void zerarStatsIndependentes() {
		for(Astros planeta : Malha.planetas) {
			planeta.setDevsColididos(0);
			planeta.setBugsColididos(0);
			planeta.setAnosTotais(0);
			planeta.setDeslocamentoTotal(0);
			planeta.setVelocidadeMedia(0);
			setBug_q1(0);
			setBug_q2(0);
			setBug_q3(0);
			setBug_q4(0);
			setDev_q1(0);
			setDev_q2(0);
			setDev_q3(0);
			setDev_q4(0);
		}
	}

    public static void calcularAnos(Astros planeta) {        
        
         int orbita=1;
         if(!planeta.getNome().equalsIgnoreCase("java")) {
        	int eixoX = planeta.getMaxX() - planeta.getMinX();
            int eixoY = planeta.getMaxY() - planeta.getMinY();
            orbita = 2 * eixoX + 2 * eixoY;
         }
                float anos =  (float)planeta.getDeslocamento() / (float)orbita;
           
                // Arredonda antes de atualizar na classe Astros
                planeta.setAnosJavaLar(anos);
            }
        

    public static void calcularAnosTotais(Astros planeta) {
            int anosTotais = Math.round(planeta.getAnosTotais()+ planeta.getAnosJavaLar());
            planeta.setAnosTotais(anosTotais);
    }
    
    public static void atualizarInfos() {
    for(Astros planeta : Malha.planetas) {    
    	atualizarVelocidadeMedia(planeta);
    	calcularAnos(planeta);
    	calcularAnosTotais(planeta);
    	atualizarHoras(planeta);
    	atualizarHorasTotais(planeta);
    }
	atualizarNumeroDeBugsPorQuadrante();
	atualizarNumeroDeDevsPorQuadrante();
    }
   
	public static String getUsuarioMaisAtivo() {
		return usuarioMaisAtivo;
	}
	
	
	public static void atualizarEstatisticasGlobais(AlunoDAO aluno) {
	    ArrayList<Aluno> listaAlunos = new ArrayList<>(aluno.selecionarTodasSimulacoes());

	    long numeroTotalInstantesGerados = 0;
	    long maiorNumeroDeExplosoes = 0;
	    String planetaMaisExplodido = "";
	    
	    long maiorQuantidadeDeVida = 0;
	    String planetaComMaisVida = "";
	    
	    long[] bugsPorQuadranteTotal = {0, 0, 0, 0};
	    long maiorNumeroBugs = 0;
	    String quadranteMaiorBugs = "";
	    
	    long[] devsPorQuadranteTotal = {0, 0, 0, 0};
	    long maiorNumeroDeDevs = 0;
	    String quadranteMaiorDevs = "";
	    
	    long[] horasPorPlanetaTotal = new long[7];
	    long[] anosPorPlanetaTotal = new long[7];
	    
	    long totalDeHoras = 0;
	    long totalDeAnos = 0;

	    for (Aluno alunos : listaAlunos) {
	        // Lógica para atualizarPlanetaMaisExplodido
	        int[] bugsPorPlaneta = alunos.getBugsPorPlaneta();
	        int[] devsPorPlaneta = alunos.getDevsPorPlaneta();

	        numeroTotalInstantesGerados += 1;
	        for (int i = 0; i < 7; i++) {
	            if (bugsPorPlaneta[i] - devsPorPlaneta[i] == Malha.planetas.get(i + 1).getVelocidadeTranslacao()) {
	                Malha.planetas.get(i + 1).setNumeroDeExplosoes(Malha.planetas.get(i + 1).getNumeroDeExplosoes() + 1);
	            }
	        }

	        // Lógica para atualizarVidaTotal
	        int[] velocidadeMediaPorPlaneta = alunos.getVelocidadeMediaTranslacao();
	        for (int i = 0; i < 7; i++) {
	            Malha.planetas.get(i + 1).setVidaTotal(Malha.planetas.get(i + 1).getVidaTotal() + velocidadeMediaPorPlaneta[i]);
	        }

	        // Lógica para atualizarBugPorQuadranteTotal
	        int[] bugsPorQuadrante = alunos.getBugsPorQuadrante();
	        for (int i = 0; i < 4; i++) {
	            bugsPorQuadranteTotal[i] += bugsPorQuadrante[i];
	        }

	        // Lógica para atualizardDevPorQuadranteTotal
	        int[] devsPorQuadrante = alunos.getDevsPorQuadrante();
	        for (int i = 0; i < 4; i++) {
	            devsPorQuadranteTotal[i] += devsPorQuadrante[i];
	        }

	        // Lógica para atualizarHorasEAnos
	        int[] horasPorPlaneta = alunos.getDiasPorPlaneta();
	        int[] anosPorPlaneta = alunos.getAnosPorPlaneta();
	        for (int i = 0; i < 7; i++) {
	            horasPorPlanetaTotal[i] += horasPorPlaneta[i];
	            anosPorPlanetaTotal[i] += anosPorPlaneta[i];
	        }
	    }

	    // Lógica para encontrar planetaMaisExplodido
	    for (int i = 1; i < 8; i++) {
	        if (Malha.planetas.get(i).getNumeroDeExplosoes() > maiorNumeroDeExplosoes) {
	            planetaMaisExplodido = Malha.planetas.get(i).getNome();
	            maiorNumeroDeExplosoes = Malha.planetas.get(i).getNumeroDeExplosoes();
	        }
	    }

	    // Lógica para encontrar planetaComMaisVida
	    for (int i = 1; i < 8; i++) {
	        if (Malha.planetas.get(i).getVidaTotal() > maiorQuantidadeDeVida) {
	            planetaComMaisVida = Malha.planetas.get(i).getNome();
	            maiorQuantidadeDeVida = Malha.planetas.get(i).getVidaTotal();
	            Malha.planetas.get(i).setVelocidadeMediaTotal(Malha.planetas.get(i).getVidaTotal() / numeroTotalInstantesGerados);
	        }
	    }

	    // Lógica para encontrar quadranteMaiorBugs
	    for (int i = 0; i < 4; i++) {
	        if (bugsPorQuadranteTotal[i] > maiorNumeroBugs) {
	            maiorNumeroBugs = bugsPorQuadranteTotal[i];
	            quadranteMaiorBugs = "Quadrante " + (i + 1);
	        }
	    }

	    // Lógica para encontrar quadranteMaiorDevs
	    for (int i = 0; i < 4; i++) {
	        if (devsPorQuadranteTotal[i] > maiorNumeroDeDevs) {
	            maiorNumeroDeDevs = devsPorQuadranteTotal[i];
	            quadranteMaiorDevs = "Quadrante " + (i + 1);
	        }
	    }

	    // Lógica para calcular totalDeHoras e totalDeAnos
	    for (int i = 0; i < 7; i++) {
	        totalDeHoras += horasPorPlanetaTotal[i];
	        totalDeAnos += anosPorPlanetaTotal[i];
	    }

	    // Agora você pode usar as variáveis calculadas conforme necessário ou defini-las como campos da classe
	    setUsuarioMaisAtivo(listaAlunos.get(0).getNome());
	    setMatricula(listaAlunos.get(0).getMatricula());
	    setNumeroTotalDeInstantesAnalisados(numeroTotalInstantesGerados);
	    setPlanetaMaisMorto(planetaMaisExplodido);
	    setPlanetaComMaisVida(planetaComMaisVida);
	    setNumeroTotalDeBugs(maiorNumeroBugs);
	    setQuadranteComMaisBugs(quadranteMaiorBugs);
	    setNumeroTotalDeDevsAnalisados(maiorNumeroDeDevs);
	    setQuadranteComMaisDevs(quadranteMaiorDevs);
	    setNumeroTotalDeHorasAnalisadas(totalDeHoras);
	    setNumeroTotalDeAnosAnalisados(totalDeAnos);
	}


	
	public static void setUsuarioMaisAtivo(String usuarioMaisAtivo) {
		Rodadas.usuarioMaisAtivo = usuarioMaisAtivo;
	}


	public static String getMatricula() {
		return matricula;
	}


	public static void setMatricula(String matricula) {
		Rodadas.matricula = matricula;
	}


	public static String getPlanetaMaisMorto() {
		return planetaMaisMorto;
	}


	public static void setPlanetaMaisMorto(String planetaMaisMorto) {
		Rodadas.planetaMaisMorto = planetaMaisMorto;
	}


	public static String getPlanetaComMaisVida() {
		return planetaComMaisVida;
	}


	public static void setPlanetaComMaisVida(String planetaComMaisVida) {
		Rodadas.planetaComMaisVida = planetaComMaisVida;
	}


	public static String getQuadranteComMaisDevs() {
		return quadranteComMaisDevs;
	}


	public static void setQuadranteComMaisDevs(String quadranteComMaisDevs) {
		Rodadas.quadranteComMaisDevs = quadranteComMaisDevs;
	}


	public static String getQuadranteComMaisBugs() {
		return quadranteComMaisBugs;
	}


	public static void setQuadranteComMaisBugs(String quadranteComMaisBugs) {
		Rodadas.quadranteComMaisBugs = quadranteComMaisBugs;
	}


	public static long getNumeroTotalDeInstantesAnalisados() {
		return numeroTotalDeInstantesAnalisados;
	}


	public static void setNumeroTotalDeInstantesAnalisados(long numeroTotalDeInstantesAnalisados) {
		Rodadas.numeroTotalDeInstantesAnalisados = numeroTotalDeInstantesAnalisados;
	}


	public static long getNumeroTotalDeBugsAnalisados() {
		return numeroTotalDeBugsAnalisados;
	}


	public static void setNumeroTotalDeBugs(long numeroTotalDeBugsAnalisados) {
		Rodadas.numeroTotalDeBugsAnalisados = numeroTotalDeBugsAnalisados;
	}


	public static long getNumeroTotalDeDevsAnalisados() {
		return numeroTotalDeDevsAnalisados;
	}


	public static void setNumeroTotalDeDevsAnalisados(long numeroTotalDeDevsAnalisados) {
		Rodadas.numeroTotalDeDevsAnalisados = numeroTotalDeDevsAnalisados;
	}


	public static long getNumeroTotalDeHorasAnalisadas() {
		return numeroTotalDeHorasAnalisadas;
	}


	public static void setNumeroTotalDeHorasAnalisadas(long numeroTotalDeHorasAnalisadas) {
		Rodadas.numeroTotalDeHorasAnalisadas = numeroTotalDeHorasAnalisadas;
	}


	public static long getNumeroTotalDeAnosAnalisados() {
		return numeroTotalDeAnosAnalisados;
	}


	public static void setNumeroTotalDeAnosAnalisados(long numeroTotalDeAnosAnalisados) {
		Rodadas.numeroTotalDeAnosAnalisados = numeroTotalDeAnosAnalisados;
	}
}
