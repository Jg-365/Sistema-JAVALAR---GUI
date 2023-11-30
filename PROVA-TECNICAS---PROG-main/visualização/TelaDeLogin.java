package visualização;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.AlunoDAO;
import modificadores.Aluno;
import posicionamento.Arquivos;
import posicionamento.Malha;
import posicionamento.Rodadas;

public class TelaDeLogin extends JFrame{
	JTextField campo1 = new JTextField();
	JTextField campo2 = new JTextField();
	
	JLabel usuario = new JLabel("Usuário:");
	JLabel matricula = new JLabel("Matricula:");
	
	JButton botaoRegistro = new JButton("Registrar");
	
	Arquivos arquivo;
	
	public TelaDeLogin(Arquivos arquivo) {
		
		this.arquivo = arquivo;
		
		setLayout(null);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); 
            }
        });

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(300,250));
		setLocationRelativeTo(null);
		setTitle("Registro");
		
		usuario.setBounds(50, 25, 100, 25);
		matricula.setBounds(50, 95, 100, 25);
		
		campo1.setBounds(50, 55, 180, 25);
		campo1.setBackground(Color.white);
		campo1.setFont(new Font("arial",Font.BOLD,14));
		
		campo1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				campo2.requestFocus();
			}
		});
		
		campo2.setBounds(50, 125, 180, 25);
		campo2.setBackground(Color.white);
		campo2.setFont(new Font("arial",Font.BOLD,14));
		
		campo2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoRegistro.doClick();
			}
		});
		
		botaoRegistro.setBounds(90, 168, 100, 25);
		
		add(campo1);
		add(campo2);
		
		add(usuario);
		add(matricula);
		add(botaoRegistro);
		
		botaoRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = campo1.getText();
				String matricula = campo2.getText();
				int[]  bugsPorPlaneta = new int[7];
				int[]  devsPorPlaneta = new int[7];
				int[]  velocidadeMediaTranslacao = new int[7];
				int[]  diasPorPlaneta = new int[7];
				int[]  anosPorPlaneta = new int[7];
				
				int[]  bugsPorQuadrante = {Rodadas.getBug_q1(),
						Rodadas.getBug_q2(),
						Rodadas.getBug_q3(),
						Rodadas.getBug_q4()
						};
				int[]  devsPorQuadrante = {Rodadas.getDev_q1(),
						Rodadas.getDev_q2(),
						Rodadas.getDev_q3(),
						Rodadas.getDev_q4()
						};
				
				for (int i = 1; i <= 7; i++) {
		            bugsPorPlaneta[i-1] = Malha.planetas.get(i).getBugsColididos();
		            devsPorPlaneta[i-1] = Malha.planetas.get(i).getDevsColididos();
		            velocidadeMediaTranslacao[i-1] = Malha.planetas.get(i).getVelocidadeMedia();
		            diasPorPlaneta[i-1] = Malha.planetas.get(i).getInstantesTotais();
		            anosPorPlaneta[i-1] = Malha.planetas.get(i).getAnosTotais();
		            // Adicione outras informações conforme necessário
				}
				
			
				
				Aluno myAluno = new Aluno(matricula, usuario, Arquivos.getNomeArquivoAtual(Arquivos.arquivoAtual) , bugsPorPlaneta, devsPorPlaneta,
		                velocidadeMediaTranslacao, diasPorPlaneta, anosPorPlaneta,
		                bugsPorQuadrante, devsPorQuadrante);
				
						AlunoDAO.inserirAluno(myAluno);
						
				JOptionPane.showMessageDialog(null, 
						"Cadastrado com sucesso!",
						"Cadastro.",
						JOptionPane.INFORMATION_MESSAGE
						);
				setVisible(false);
			}
		});
		setVisible(true);
	}
	
}
