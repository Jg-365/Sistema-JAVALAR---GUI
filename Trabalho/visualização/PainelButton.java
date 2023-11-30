package visualização;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.AlunoDAO;
import modificadores.Aluno;
import posicionamento.Arquivos;
import posicionamento.Malha;
import posicionamento.Rodadas;

public class PainelButton extends JPanel {	
	PainelMalha visual;
	Malha malha;
	Arquivos arquivos;
	AlunoDAO alunos;
	
	ImageIcon imagemPlay = new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/play.png");
	ImageIcon next = new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/next.png");
	ImageIcon relatorio = new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/relatório.png");
	ImageIcon upload = new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/upload.png");
	ImageIcon folder = new ImageIcon("PROVA-TECNICAS---PROG-main/visualização/Icones/folder.png");

	
	Botao botao1 = new Botao("");
	Botao botao2 = new Botao("");
	Botao botao3 = new Botao("");
	Botao botao4 = new Botao("");
	Botao botao5 = new Botao("");
	
	JComboBox<String> listaDeOpcoes = new JComboBox<>(Arquivos.nomeArquivoAtual);
	JTextArea areaDeTexto = new JTextArea();
    JScrollPane barraDeRolagem = new JScrollPane(areaDeTexto);
    
	public PainelButton(PainelMalha visual, Malha malha, Arquivos arquivos) {
		
		this.arquivos = arquivos;
		this.malha = malha;
		this.visual = visual;
		
		setLayout(null);
		setBackground(Color.black);
		
		botao1.setBounds(30, 15, 45, 45);
		botao1.setIcon(next);
	
		listaDeOpcoes.setBounds(95, 15, 90, 45);
		listaDeOpcoes.setBackground(Color.green);
		listaDeOpcoes.setForeground(Color.black);
		listaDeOpcoes.setFont(new Font("courier new", Font.BOLD,12));
		
		botao2.setBounds(185, 15, 45,45);
		botao2.setIcon(redimensionar(imagemPlay));
		
		botao3.setBounds(250, 15, 45, 45);
		botao3.setIcon(relatorio);
		
		botao4.setBounds(310, 15, 45, 45);
		botao4.setIcon(upload);
		
		botao5.setBounds(370, 15, 45, 45);
		botao5.setIcon(folder);
		
		add(botao1);
		add(listaDeOpcoes);
		add(botao2);
		add(botao3);
		add(botao4);
		add(botao5);

        barraDeRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        barraDeRolagem.setBounds(30, 80, 385, 465);
        add(barraDeRolagem);
        
		barraDeRolagem.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		barraDeRolagem.setBackground(Color.BLACK);
		
		areaDeTexto.setBackground(Color.BLACK);
		areaDeTexto.setForeground(Color.green);
		areaDeTexto.setBorder(BorderFactory.createEmptyBorder(15,15, 3, 3));
		areaDeTexto.setFont(new Font("courier new", Font.BOLD, 14));
		
		botao1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Rodadas.getNumeroPlanetasMortos()==7) {
					JOptionPane.showMessageDialog(null,
							"Aviso! Você zerou a simulação, recomece para simular novamente.",
							"Todos os planetas explodiram!",
							JOptionPane.INFORMATION_MESSAGE
							);
				}
				else {
				if(Arquivos.arquivoTemp.size()-1 > arquivos.getNumeroDeLinhasLidas()) {	
					arquivos.decodificadorDeLinhas(Arquivos.arquivoTemp.get(arquivos.getNumeroDeLinhasLidas()));
					Rodadas.atualizarInstantesTotaisPlanetas();
					visual.modificar();
				    Rodadas.atualizarInfos();
					arquivos.atualizarNumeroDeLinhasLidas();
				}
				else if(arquivos.getNumeroDeLinhasLidas()==0) {
					JOptionPane.showMessageDialog(null,
							"Aviso! Você precisa carregar o arquivo para começar a simulação.",
							"Arquivo não selecionado!",
							JOptionPane.WARNING_MESSAGE
							);
				}
				else {
					JOptionPane.showMessageDialog(null,
							"Aviso! O número de linhas foi esgotado, leia um novo arquivo para continuar.",
							"Número de linhas esgotado",
							JOptionPane.WARNING_MESSAGE
							);
					}
				}
			}
		});
		
		botao2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		        	arquivos.atualizarArquivoAtual(listaDeOpcoes.getSelectedItem().toString());
		        	arquivos.lerNovoArquivo();
		        	Rodadas.zerarStatsIndependentes();
		        	JOptionPane.showMessageDialog(null,
							"Arquivo '"+ Arquivos.getNomeArquivoAtual(Arquivos.getArquivoAtual()) +"' carregado com sucesso!",
							"Carregamento de arquivo.",
							JOptionPane.INFORMATION_MESSAGE
							);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null,
		                    "Erro ao ler o novo arquivo: " + ex.getMessage(),
		                    "Erro de leitura de arquivo",
		                    JOptionPane.ERROR_MESSAGE
		            );
		        }
		    }
		});
		
		botao3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaDeLogin(arquivos);
			}
		});
		
		botao4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mostrarInformacoesAlunos(); 
		        JOptionPane.showMessageDialog(null,
	                    "Lista de alunos carregada com sucesso.",
	                    "Carregamento de dados.",
	                    JOptionPane.INFORMATION_MESSAGE
	                    
				);
			}
		});
		
		botao5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				arquivos.escreverNovoArquivo();
				
				JOptionPane.showMessageDialog(null,
	                    "Arquivo de saída gerado com sucesso!",
	                    "Upload de arquivo de saída.",
	                    JOptionPane.INFORMATION_MESSAGE
	                    
				);
			}
		});
	}
	
	 public ImageIcon redimensionar(ImageIcon imagem) {
	            Image img = imagem.getImage();
	            Image novaImagem = img.getScaledInstance(45,45, Image.SCALE_SMOOTH);
	            return new ImageIcon(novaImagem);
	 }
	 
	 private void mostrarInformacoesAlunos() {
	        areaDeTexto.setText("");

	        AlunoDAO alunoDAO = new AlunoDAO();
	        ArrayList<Aluno> alunos = alunoDAO.selecionarTodasSimulacoes();

	        for (Aluno aluno : alunos) {
	            String informacoesAluno = formatarInformacoesAluno(aluno);
	            areaDeTexto.append(informacoesAluno + "\n\n"
	            		+ "------------------------------------------------------------------------------------------------\n\n\n");
	        }
	    }
	 
	 private String formatarInformacoesAluno(Aluno aluno) {
		    StringBuilder informacoes = new StringBuilder();

		    informacoes.append("Matrícula: ").append(aluno.getMatricula()).append("\n");
		    informacoes.append("Nome: ").append(aluno.getNome()).append("\n");
		    informacoes.append("Nome do Arquivo: ").append(aluno.getNomeArquivo()).append("\n");

		    informacoes.append("Bugs por Planeta: ").append(appendArrayToStringBuilder(aluno.getBugsPorPlaneta())).append("\n");
		    informacoes.append("Devs por Planeta: ").append(appendArrayToStringBuilder(aluno.getDevsPorPlaneta())).append("\n");
		    informacoes.append("Velocidade Média de Translação por Planeta: ").append(appendArrayToStringBuilder(aluno.getVelocidadeMediaTranslacao())).append("\n");
		    informacoes.append("Dias por Planeta: ").append(appendArrayToStringBuilder(aluno.getDiasPorPlaneta())).append("\n");
		    informacoes.append("Anos por Planeta: ").append(appendArrayToStringBuilder(aluno.getAnosPorPlaneta())).append("\n");
		    informacoes.append("Bugs por Quadrante: ").append(appendArrayToStringBuilder(aluno.getBugsPorQuadrante())).append("\n");
		    informacoes.append("Devs por Quadrante: ").append(appendArrayToStringBuilder(aluno.getDevsPorQuadrante())).append("\n");

		    return informacoes.toString();
		}


	 private String appendArrayToStringBuilder(int[] array) {
		    StringBuilder arrayString = new StringBuilder("[");
		    for (int i = 0; i < array.length; i++) {
		        arrayString.append(array[i]);
		        if (i < array.length - 1) {
		            arrayString.append(", ");
		        }
		    }
		    arrayString.append("]");
		    return arrayString.toString();
		}
}
