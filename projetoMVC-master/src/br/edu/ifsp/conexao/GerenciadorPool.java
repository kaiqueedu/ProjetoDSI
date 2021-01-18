package br.edu.ifsp.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class GerenciadorPool {

private BasicDataSource ds;
	
	private static GerenciadorPool instance;
	
	public static GerenciadorPool getInstance() {
		if (instance == null){
			instance = new GerenciadorPool();
		}
		return instance;
	}
	
	private GerenciadorPool() {
		ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("DSI_2020");
		ds.setPassword("root");
	}

	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
}
