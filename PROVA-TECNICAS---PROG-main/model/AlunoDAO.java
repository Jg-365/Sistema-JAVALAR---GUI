package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modificadores.Aluno;

public class AlunoDAO{
	
	private Aluno extrairAlunoDoResultSet(ResultSet dados) throws SQLException {
	    String matricula = dados.getString("matricula");
	    String nome = dados.getString("nome");
	    String nomeArquivo = dados.getString("nome_arquivo");

	    int[] bugsPorPlaneta = {
	            dados.getInt("bug_python"),
	            dados.getInt("bug_javascript"),
	            dados.getInt("bug_ruby"),
	            dados.getInt("bug_php"),
	            dados.getInt("bug_csharp"),
	            dados.getInt("bug_cmais"),
	            dados.getInt("bug_c")
	    };

	    int[] devsPorPlaneta = {
	            dados.getInt("dev_python"),
	            dados.getInt("dev_javascript"),
	            dados.getInt("dev_ruby"),
	            dados.getInt("dev_php"),
	            dados.getInt("dev_csharp"),
	            dados.getInt("dev_cmais"),
	            dados.getInt("dev_c")
	    };


	    int[] velocidadeMediaTranslacao = {
	            dados.getInt("v_python"),
	            dados.getInt("v_javascript"),
	            dados.getInt("v_ruby"),
	            dados.getInt("v_php"),
	            dados.getInt("v_csharp"),
	            dados.getInt("v_cmais"),
	            dados.getInt("v_c")
	    };

	    int[] diasPorPlaneta = {
	            dados.getInt("d_python"),
	            dados.getInt("d_javascript"),
	            dados.getInt("d_ruby"),
	            dados.getInt("d_php"),
	            dados.getInt("d_csharp"),
	            dados.getInt("d_cmais"),
	            dados.getInt("d_c")
	    };

	    int[] anosPorPlaneta = {
	            dados.getInt("a_python"),
	            dados.getInt("a_javascript"),
	            dados.getInt("a_ruby"),
	            dados.getInt("a_php"),
	            dados.getInt("a_csharp"),
	            dados.getInt("a_cmais"),
	            dados.getInt("a_c")
	    };

	    int[] bugsPorQuadrante = {
	            dados.getInt("bug_q1"),
	            dados.getInt("bug_q2"),
	            dados.getInt("bug_q3"),
	            dados.getInt("bug_q4")
	    };

	    int[] devsPorQuadrante = {
	            dados.getInt("dev_q1"),
	            dados.getInt("dev_q2"),
	            dados.getInt("dev_q3"),
	            dados.getInt("dev_q4")
	    };

	    return new Aluno(matricula, nome, nomeArquivo, bugsPorPlaneta, devsPorPlaneta,
                velocidadeMediaTranslacao, diasPorPlaneta, anosPorPlaneta,
                bugsPorQuadrante, devsPorQuadrante);
	}
	
	public ArrayList<Aluno> selecionarTodasSimulacoes() {
			ArrayList<Aluno> simulacoes = new ArrayList<Aluno>();
			
			try {
				Connection conexao = new Conexão().getConexao();
				
				String query = "select * from javalar";
				ResultSet dados = conexao.prepareStatement(query).
				executeQuery();
				
				while(dados.next()) {
					Aluno a = extrairAlunoDoResultSet(dados);
					simulacoes.add(a);
				}
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		return simulacoes;
	}
	
	public static void inserirAluno(Aluno aluno) {
		try {
			Connection conexao = new Conexão().getConexao();
			
			String query = "INSERT INTO javalar (matricula, nome, nome_arquivo, " +
                    "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, " +
                    "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, " +
                    "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, " +
                    "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, " +
                    "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, " +
                    "bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = conexao.prepareStatement(query);
			
			preparedStatement.setString(1, aluno.getMatricula());
			preparedStatement.setString(2, aluno.getNome());
			preparedStatement.setString(3, aluno.getNomeArquivo());
			
		    // Configurar os valores inteiros
			for (int i = 0; i < 7; i++) {
			    preparedStatement.setInt(4 + i, aluno.getBugsPorPlaneta()[i]);
			    preparedStatement.setInt(11 + i, aluno.getDevsPorPlaneta()[i]);
			    preparedStatement.setInt(18 + i, aluno.getDevsPorPlaneta()[i]);
			    preparedStatement.setInt(25+ i, aluno.getDiasPorPlaneta()[i]);
			    preparedStatement.setInt(32 + i, aluno.getAnosPorPlaneta()[i]);
			}
			
			for (int i = 0; i < 4; i++) {
			    preparedStatement.setInt(39 + i, aluno.getBugsPorQuadrante()[i]);
			    preparedStatement.setInt(43 + i, aluno.getDevsPorQuadrante()[i]);
			}

	        // Executar a atualização
	        preparedStatement.executeUpdate();
	        
	        // Fechar a conexão e o PreparedStatement
	        preparedStatement.close();
	        conexao.close();
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}
	}
}
