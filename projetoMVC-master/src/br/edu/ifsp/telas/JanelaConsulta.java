package br.edu.ifsp.telas;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifsp.controlador.ConsultaPessoaController;
import br.edu.ifsp.controlador.EditarPessoaController;
import br.edu.ifsp.controlador.ExcluirPessoaController;
import br.edu.ifsp.modelo.Pessoa;

public class JanelaConsulta extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	
	private JLabel labelIdBusca;
	private JTextField fIdBusca;
	
	
	private JLabel labelNome;
	private JTextField fieldNome;
	
	private JLabel labelIdade;
	private JTextField fieldIdade;
	
	private JButton btnBuscar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	
	private Integer id;
	
	public JanelaConsulta() {
		super("Janela de Cadastro",true,true,true,true);
		criarComponentes();
        configurarJanela();
	}
	
	private void criarComponentes() {
		panel = new JPanel();		
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Inserção de produtos"));
		panel.setLayout(null);		
		
		labelIdBusca = new JLabel("Id");
		labelIdBusca.setBounds(31, 33, 46, 14);		
		
		fIdBusca = new JTextField();
		fIdBusca.setBounds(60, 29, 40, 20);	
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(31, 78, 46, 14);		
		
		fieldNome = new JTextField(18);
		fieldNome.setBounds(80, 75, 238, 20);		
		
		labelIdade = new JLabel("Idade");
		labelIdade.setBounds(31, 109, 46, 14);
		
		fieldIdade = new JTextField(2);	
		fieldIdade.setBounds(80, 106, 46, 20);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(170, 29, 205, 20);
		btnBuscar.addActionListener(this::buscarListener);		
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(351, 74, 89, 23);
		btnEditar.addActionListener(this::editarListener);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(447, 74, 89, 23);
		btnExcluir.addActionListener(this::excluirListener);
		
		btnSalvar = new JButton("salvar");
		btnSalvar.setBounds(31, 152, 89, 23);
		btnSalvar.addActionListener(this::salvarListener);
		
		fieldNome.setEditable(false);
		fieldIdade.setEditable(false);	
		
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);	
		btnSalvar.setEnabled(false);	
		
		panel.add(labelIdBusca);
		panel.add(fIdBusca);	
		panel.add(labelNome);
		panel.add(fieldNome);
		panel.add(labelIdade);
		panel.add(fieldIdade);
		panel.add(fieldIdade);	
		panel.add(btnBuscar);
		panel.add(btnEditar);
		panel.add(btnExcluir);
		panel.add(btnSalvar);
		
		add(panel);
		
	}
	
	private void configurarJanela() {
		setVisible(true);
		setSize(610,285);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void buscarListener(ActionEvent e) {
		
		if(fIdBusca.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Preencha os campos para a pesquisa");
			return;
		}
		ConsultaPessoaController cp = new ConsultaPessoaController(this);
		Pessoa p = cp.buscarId();
		if(p == null) {
			JOptionPane.showMessageDialog(this, "Id não inválido");
			return;
		}
		carregaBusca(p);
		
	}	
	
	private void editarListener(ActionEvent e) {		
		fieldNome.setEditable(true);
		fieldIdade.setEditable(true);
	}
	
	private void salvarListener(ActionEvent e) {
		
		if(fieldNome.getText().isBlank() || fieldIdade.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}
		EditarPessoaController ec = new EditarPessoaController(this);
		ec.editarPessoa();
		JOptionPane.showMessageDialog(this, "Registro alterado");
		resetaCampos();
		
	}
	
	private void excluirListener(ActionEvent e) {
		ExcluirPessoaController ec = new ExcluirPessoaController(this);
		if(id != null) {
			ec.excluirPessoa(id);
		}
		JOptionPane.showMessageDialog(this, "Registro excluído");
		
		resetaCampos();		
	}
	
	private void carregaBusca(Pessoa p) {
		fieldNome.setText(p.getNome());
		fieldIdade.setText(""+p.getIdade());
		setId(p.getId());
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);	
		btnSalvar.setEnabled(true);		
	}
	
	private void resetaCampos() {
		fieldNome.setText("");
		fieldIdade.setText("");
		
		fieldNome.setEditable(false);
		fieldIdade.setEditable(false);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);	
		btnSalvar.setEnabled(false);	
	}
	
	//Getters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLabelIdBusca() {
		return labelIdBusca;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public JLabel getLabelIdade() {
		return labelIdade;
	}

	public JTextField getfIdBusca() {
		return fIdBusca;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldIdade() {
		return fieldIdade;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	
}
