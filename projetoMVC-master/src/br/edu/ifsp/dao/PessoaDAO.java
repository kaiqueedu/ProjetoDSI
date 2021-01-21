package br.edu.ifsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.conexao.GerenciadorPool;
import br.edu.ifsp.modelo.Pessoa;

public class PessoaDAO {
	
	public GerenciadorPool con = null;

	public void salvarPessoa(Pessoa pessoa) {
		
		Connection con = null;
		PreparedStatement pStat = null;
		String sql = "insert into pessoa (id, nomecompleto, idade) values (pessoa_seq.nextval, ?, ?)";
		
		try {			
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);			
				
			pStat.setString(1, pessoa.getNome());
			pStat.setInt(2, pessoa.getIdade());			
			pStat.executeUpdate();
			
			System.out.println("Foi inserido com sucesso");
			
		} catch(SQLException e) {
			
			System.out.println("Problema ao inserir uma pessoa");
			e.printStackTrace();
		}	
	}
	
	public List<Pessoa> consultarTodos() {
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		String sql = "select * from pessoa";
		Connection con = null;
		PreparedStatement pStat = null;
		
		try {
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);
			
			ResultSet rs = pStat.executeQuery();
			
			int id = -1;
			String nomeCompleto = "";
			int idade = 0;
			
			while(rs.next()) {
				
				id = rs.getInt("id");
				nomeCompleto = rs.getString("nomecompleto");
				idade = rs.getInt("idade");
				
				listaPessoas.add(new Pessoa(id, nomeCompleto, idade));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return listaPessoas;
	}
	
	public Pessoa consultarPessoaPorId(int id) {
		
		Connection con = null;
		PreparedStatement pStat = null;
		String sql = "select * from pessoa where id = ?";
		Pessoa pessoa = null; 
		
		try {
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);			
			pStat.setInt(1, id);
			ResultSet rs = pStat.executeQuery();
			
			int idP = -1;
			String nomeCompleto = "";
			int idade = 0;
			
			if(rs.next()) {				
				id = rs.getInt("id");
				nomeCompleto = rs.getString("nomecompleto");
				idade = rs.getInt("idade");				
				pessoa = new Pessoa(id, nomeCompleto, idade);
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		}
		
		return pessoa;		
	}
	
	public void consultarPessoaPorNome(String nome) {
		
		Connection con = null;
		PreparedStatement pStat = null;
		String sql = "select * from pessoa nome like %";
		Pessoa pessoa = null; 
		
		
	}
	
	public void editarPessoaPorId(Pessoa pessoa) {
		
		Connection con = null;
		PreparedStatement pStat = null;
		String sql = "update pessoa set nomecompleto = ?, idade = ? where id = ?";
		
		try {
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);	
			
			pStat.setString(1, pessoa.getNome());
			pStat.setInt(2, pessoa.getIdade());
			pStat.setInt(3, pessoa.getId());
			
			pStat.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void removerPessoaPorId(int id) {
		Connection con = null;
		PreparedStatement pStat = null;
		String sql = "delete from pessoa where id = ?";
		
		try {
			con = GerenciadorPool.getInstance().getConnection();
			pStat = con.prepareStatement(sql);	
			pStat.setInt(1, id);
			
			pStat.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
