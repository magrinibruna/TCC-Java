package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class DisciplinaDAO {
	
Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	//envia as informações pro banco
	ResultSet rs;
	//pega as informações
	Disciplina objDisciplina;
	//representa a tabela 	
	
	public int CadastrarDisciplina(Disciplina objDisciplina) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Disciplina(nome_Disc, Serie, id_Curso)" +
		"VALUES ( ?, ?, ?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			//o st vai enviar por meio da conexão o valor do SQL
			
			st.setString(1, objDisciplina.getNomeDisciplina());
			st.setInt(2, objDisciplina.getSerieDisciplina());
			st.setInt(3, objDisciplina.getCursoDisciplina());
			
			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
			}
			
			conexao.close();
			st.close();
			return resultado;
			
		} catch (Exception e) {
			try {
				if (conexao != null) {
					conexao.rollback();
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();	
			}
			e.printStackTrace();		
		}
		
		return resultado;
	}	
	
	public boolean BuscarDisciplinaNomeValidacao(String nome, int serie, int curso) {
		String SQL = "select * from tb_Disciplina where nome_Disc = ? and Serie = ? and id_Curso = ?";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			st.setInt(2, serie);
			st.setInt(3, curso);
			rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Disciplina BuscarDisciplinaNome(String nome, int serie) {
		String SQL = "SELECT * FROM tb_Disciplina WHERE Nome_Disc = ? AND Serie = ?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			st.setInt(2, serie);
			
			rs = st.executeQuery();
			if (rs.next()) {
				//se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1, executando o if	
				
				objDisciplina = new Disciplina();
				
				objDisciplina.setIdDisciplina(rs.getInt(1));
				objDisciplina.setNomeDisciplina(rs.getString(3));
				objDisciplina.setSerieDisciplina(rs.getInt(4));
				objDisciplina.setCursoDisciplina(rs.getInt(5));
							
			} else {
					
				JOptionPane.showMessageDialog(null, "Disciplina não encontrado");
				return null;
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return objDisciplina;
	}
	
	
	public Vector<Disciplina> carregarComboDisciplina() {

		// CRIA UM VETOR DE REGISTROS(classe Vector) E OS ALOCA E UM OBJETO.
		Vector<Disciplina> disciplina = new Vector<Disciplina>();

		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			String SQL = "SELECT * FROM tb_Disciplina ORDER BY Nome_Disc";
			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();

			while (rs.next()) {
				
				Disciplina objDisciplina = new Disciplina();
				objDisciplina.setIdDisciplina(rs.getInt(1));
				objDisciplina.setNomeDisciplina(rs.getString(3));
				objDisciplina.setSerieDisciplina(rs.getInt(4));
				disciplina.add(objDisciplina);

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return disciplina;

	}
	
	public List<Disciplina> ConsultarDisciplina(){
		
		List<Disciplina> listDisciplina = new ArrayList<>();
		
		try {
			
			st = conexao.prepareStatement("select * from TabelaDisciplina where status = 1");
			rs = st.executeQuery();
			
			while(rs.next()) {
				objDisciplina = new Disciplina();
				objDisciplina.setIdDisciplina(rs.getInt(1));
				objDisciplina.setNomeDisciplina(rs.getString(2));
				objDisciplina.setNomeSerie(rs.getString(3));
				objDisciplina.setNomeCurso(rs.getString(4));
				objDisciplina.setIdAno(rs.getString(5));
				listDisciplina.add(objDisciplina);
			}
			rs.close();
			st.close();
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return listDisciplina;
		
	}
	
public List<Disciplina> ConsultarDisciplinaExcluido(){
		
		List<Disciplina> listDisciplina = new ArrayList<>();
		
		try {
			
			st = conexao.prepareStatement("select * from TabelaDisciplina where status = 0");
			rs = st.executeQuery();
			
			while(rs.next()) {
				objDisciplina = new Disciplina();
				objDisciplina.setIdDisciplina(rs.getInt(1));
				objDisciplina.setNomeDisciplina(rs.getString(2));
				objDisciplina.setNomeSerie(rs.getString(3));
				objDisciplina.setNomeCurso(rs.getString(4));
				objDisciplina.setIdAno(rs.getString(5));
				listDisciplina.add(objDisciplina);
			}
			rs.close();
			st.close();
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return listDisciplina;
		
	}
	
	public void AlterarDisciplina(Disciplina objDisciplina) {
		String SQL = "UPDATE tb_Disciplina set nome_disc = ?, serie = ?, id_Curso = ? WHERE id_Disc = ?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, objDisciplina.getNomeDisciplina());
			st.setInt(2, objDisciplina.getSerieDisciplina());
			st.setInt(3, objDisciplina.getCursoDisciplina());
			st.setInt(4, objDisciplina.getIdDisciplina());
			
			int resultado = 0;
			resultado = st.executeUpdate();
			
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "Disciplina alterada com sucesso");
			}
			
			conexao.close();
			st.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void ExcluirDisciplina(int codigo) {
		String SQL = "UPDATE tb_Disciplina set Status_Curso = 0 WHERE id_Disc = ?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);

			int resultado = 0;
			resultado = st.executeUpdate();
			
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "Disciplina excluida com sucesso");
			}
			
			conexao.close();
			st.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	public void RecuperarDisciplina(int codigo) {
		String SQL = "UPDATE tb_Disciplina set Status_Curso = 1 WHERE id_Disc = ?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);

			int resultado = 0;
			resultado = st.executeUpdate();
			
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "Disciplina recuperada com sucesso");
			}
			
			conexao.close();
			st.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public boolean DisciplinaCodigoValidacao(int codigo) {
		String SQL = "select * from tb_Atribuicao where id_disc = ?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);
			rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			conexao.close();
			st.close();
		} catch (Exception e) {
			System.out.println("erro na validação disciplina: " + e);
		}
		
		return false;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
