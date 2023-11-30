package modificadores;

public class Aluno {
	
    private String matricula;
    private String nome;
    private String nomeArquivo;
    private int[] bugsPorPlaneta;
    private int[] devsPorPlaneta;
    private int[] velocidadeMediaTranslacao;
    private int[] diasPorPlaneta;
    private int[] anosPorPlaneta;
    private int[] bugsPorQuadrante;
    private int[] devsPorQuadrante;

    public Aluno(String matricula, String nome, String nomeArquivo, int[] bugsPorPlaneta,
                 int[] devsPorPlaneta, int[] velocidadeMediaTranslacao,
                 int[] diasPorPlaneta, int[] anosPorPlaneta, int[] bugsPorQuadrante, int[] devsPorQuadrante) {
        this.matricula = matricula;
        this.nome = nome;
        this.nomeArquivo = nomeArquivo;
        this.bugsPorPlaneta = bugsPorPlaneta;
        this.devsPorPlaneta = devsPorPlaneta;
        this.velocidadeMediaTranslacao = velocidadeMediaTranslacao;
        this.diasPorPlaneta = diasPorPlaneta;
        this.anosPorPlaneta = anosPorPlaneta;
        this.bugsPorQuadrante = bugsPorQuadrante;
        this.devsPorQuadrante = devsPorQuadrante;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public int[] getBugsPorPlaneta() {
        return bugsPorPlaneta;
    }

    public int[] getDevsPorPlaneta() {
        return devsPorPlaneta;
    }

    public int[] getVelocidadeMediaTranslacao() {
        return velocidadeMediaTranslacao;
    }

    public int[] getDiasPorPlaneta() {
        return diasPorPlaneta;
    }

    public int[] getAnosPorPlaneta() {
        return anosPorPlaneta;
    }

    public int[] getBugsPorQuadrante() {
        return bugsPorQuadrante;
    }

    public int[] getDevsPorQuadrante() {
        return devsPorQuadrante;
    }

}