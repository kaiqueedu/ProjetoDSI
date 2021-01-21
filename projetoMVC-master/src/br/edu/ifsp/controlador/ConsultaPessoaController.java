package br.edu.ifsp.controlador;

import javax.swing.JOptionPane;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.telas.JanelaCadastro;
import br.edu.ifsp.telas.JanelaConsulta;

public class ConsultaPessoaController {

	private JanelaConsulta tela;
	private Pessoa modelo;
	
	public ConsultaPessoaController(JanelaConsulta fp) {
		this.tela = fp;				
	}	
	
	public Pessoa buscarId() {
		PessoaDAO dao = new PessoaDAO();
		
		int idBusca = Integer.parseInt(tela.getfIdBusca().getText().toString());
		
		Pessoa p = dao.consultarPessoaPorId(idBusca);				
		
		return p;		
	}
	

}
