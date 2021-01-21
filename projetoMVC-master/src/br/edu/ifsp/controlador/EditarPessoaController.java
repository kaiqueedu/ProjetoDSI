package br.edu.ifsp.controlador;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.telas.JanelaConsulta;

public class EditarPessoaController {

	private JanelaConsulta tela;
	
	public EditarPessoaController(JanelaConsulta fp) {
		this.tela = fp;				
	}	
	
	public void editarPessoa() {
		
		PessoaDAO dao = new PessoaDAO();
		String novoNome = tela.getFieldNome().getText().toString();
		int novaIdade = Integer.parseInt( tela.getFieldIdade().getText().toString());
		int id = tela.getId();
		
		Pessoa pessoa = new Pessoa(id, novoNome, novaIdade);
		dao.editarPessoaPorId(pessoa);
		
	}
	

}
