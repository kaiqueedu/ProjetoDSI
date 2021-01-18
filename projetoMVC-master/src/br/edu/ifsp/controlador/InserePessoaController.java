package br.edu.ifsp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.tela.FramePrincipal;

public class InserePessoaController implements ActionListener {

	private FramePrincipal tela;
	private Pessoa modelo;
	
	public InserePessoaController(FramePrincipal fp) {
		this.tela = fp;
		modelo = new Pessoa();
		this.tela.getBtnSalvarPessoa().addActionListener(this);
		this.tela.getBtnLimpar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.tela.getBtnSalvarPessoa()) {
			
			modelo.setNome(this.tela.getTfNomeCompleto().getText());
			modelo.setIdade(Integer.parseInt(this.tela.getTfIdade().getText()));
		
			PessoaDAO dao = new PessoaDAO();
			dao.salvarPessoa(modelo);
		
			JOptionPane.showMessageDialog(null, "Pessoa inserida com Sucesso");
			
		} else if(e.getSource() == this.tela.getBtnLimpar()) {
			
			this.tela.getTfNomeCompleto().setText("");
			this.tela.getTfIdade().setText("");
		}
	}

}
