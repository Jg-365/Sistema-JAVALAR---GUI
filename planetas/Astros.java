package planetas;
import javax.swing.ImageIcon;

public abstract class  Astros{
	
    //STATUS
	private String nome;
    private String biografia;
    private boolean vivo_morto;
    private int bugsColididos;
    private int devsColididos;
    
    //QUANTIFICAÇÃO DE DADOS DAO
    private long numeroDeExplosoes;
    private long vidaTotal;
    private long velocidadeMediaTotal;
    
    //POSIÇÃO
    private int x;
    private int y;
    private int max_x;
    private int min_x;
    private int max_y;
    private int min_y;
    private int deslocamento;
    private int deslocamento_total;
    
    //DADOS DE MOVIMENTO
    private float anos_javaLar;
    private int anos_totais;
    private int instantes;
    private int instantesTotais;
    private int velocidade_translacao;
    private float hrs_por_instante;
    private float horas;
    private int horasTotais;
    private int velocidadeMedia;
    
    //VISUALIZAÇÃO
    private ImageIcon imagem;

    //construtores/get-set:
    public Astros() {
    }
    
    
    //status
    public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public int getVelocidadeTranslacao() {
        return velocidade_translacao;
    }

    public void setVelocidadeTranslacao(int velocidade_translacao) {
        this.velocidade_translacao = velocidade_translacao;
    }

    public float getHorasPorInstante() {
        return hrs_por_instante;
    }

    public void setHrsPorInstante(float tempo_de_rotacao) {
        this.hrs_por_instante = tempo_de_rotacao;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getBugsColididos() {
		return bugsColididos;
	}


	public void setBugsColididos(int bugsColididos) {
		this.bugsColididos = bugsColididos;
	}


	public int getDevsColididos() {
		return devsColididos;
	}


	public void setDevsColididos(int devsColididos) {
		this.devsColididos = devsColididos;
	}
    
	public ImageIcon getImagem() {
		return imagem;
	}

	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}

	public int getVelocidadeMedia() {
		return velocidadeMedia;
	}
	
	public void setVelocidadeMedia(int velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
    
	
    
    //posicionamento e movimentação
    public boolean isVivoMorto() {
        return vivo_morto;
    }

    public void setVivoMorto(boolean vivo_morto) {
        this.vivo_morto = vivo_morto;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMaxX() {
        return max_x;
    }

    public void setMaxX(int max_x) {
        this.max_x = max_x;
    }

    public int getMinX() {
        return min_x;
    }

    public void setMinX(int min_x) {
        this.min_x = min_x;
    }

    public int getMaxY() {
        return max_y;
    }

    public void setMaxY(int max_y) {
        this.max_y = max_y;
    }

    public int getMinY() {
        return min_y;
    }

    public void setMinY(int min_y) {
        this.min_y = min_y;
    }
    
    public int getDeslocamento() {
    	return deslocamento;
    }
    
    public void setDeslocamento(int deslocamento) {
    	this.deslocamento = deslocamento;
    }
    
    public int getDeslocamentoTotal() {
    	return deslocamento_total;
    }
    
    public void setDeslocamentoTotal(int deslocamento_total) {
    	this.deslocamento_total = deslocamento_total;
    }
    public float getAnosJavaLar() {
    	return anos_javaLar;
    }
    
    public void setAnosJavaLar(float anos_javaLar) {
    	this.anos_javaLar = anos_javaLar;
    }
  
    public int getAnosTotais() {
        return anos_totais;
    }

    public void setAnosTotais(int anos_totais) {
        this.anos_totais = anos_totais;
    }
   
	public int getInstantesPlaneta() {
		return instantes;
	}

	public void setInstantes(int instantes) {
		this.instantes = instantes;
	}

	public int getInstantesTotais() {
		return instantesTotais;
	}

	public void setInstantesTotais(int instantesTotais) {
		this.instantesTotais = instantesTotais;
	}
    
    
    
    //metodos de funcionalidade
    
    public int mover(int velocidade_translacao) {
    	int deslocamento = velocidade_translacao * getInstantesPlaneta();
    	return deslocamento;
    }
    
    public void acelerar() {
    	setVelocidadeTranslacao(getVelocidadeTranslacao()+1);
    }
    public void desacelerar() {
    	setVelocidadeTranslacao(getVelocidadeTranslacao()-1);
    }


	public float getHoras() {
		return horas;
	}


	public void setHoras(float horas) {
		this.horas = horas;
	}


	public int getHorasTotais() {
		return horasTotais;
	}


	public void setHorasTotais(int horasTotais) {
		this.horasTotais = horasTotais;
	}


	public long getNumeroDeExplosoes() {
		return numeroDeExplosoes;
	}


	public void setNumeroDeExplosoes(long numeroDeExplosoes) {
		this.numeroDeExplosoes = numeroDeExplosoes;
	}


	public long getVidaTotal() {
		return vidaTotal;
	}


	public void setVidaTotal(long vidaTotal) {
		this.vidaTotal = vidaTotal;
	}


	public long getVelocidadeMediaTotal() {
		return velocidadeMediaTotal;
	}


	public void setVelocidadeMediaTotal(long velocidadeMediaTotal) {
		this.velocidadeMediaTotal = velocidadeMediaTotal;
	}
    
    
}
