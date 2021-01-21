package br.edu.ifsp.controlador;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.telas.JanelaConsulta;

public class ExcluirPessoaController {

	private JanelaConsulta tela;
	
	public ExcluirPessoaController(JanelaConsulta fp) {
		this.tela = fp;				
	}	
	
	public void excluirPessoa(int id) {
		
		PessoaDAO dao = new PessoaDAO();
		
		dao.removerPessoaPorId(id);
		
	}
	

}
