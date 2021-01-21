package br.edu.ifsp.controlador;

import javax.swing.JOptionPane;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.telas.JanelaCadastro;

public class InserePessoaController  {

	private JanelaCadastro tela;
	private Pessoa modelo;
	
	public InserePessoaController(JanelaCadastro fp) {
		this.tela = fp;
		modelo = new Pessoa();		
	}	
	
	public void salvarPessoa() {
		
		modelo.setNome(this.tela.getFieldNome().getText());
		modelo.setIdade(Integer.parseInt(this.tela.getFieldIdade().getText()));
	
		PessoaDAO dao = new PessoaDAO();
		dao.salvarPessoa(modelo);	
		JOptionPane.showMessageDialog(null, "Pessoa inserida com Sucesso");
	}
	

}
