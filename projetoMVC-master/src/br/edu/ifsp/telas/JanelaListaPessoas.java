package br.edu.ifsp.telas;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import br.edu.ifsp.controlador.ConsultaPessoaController;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;

public class JanelaListaPessoas extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	
	private JButton buttonBuscar;
	
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	
	private List<Pessoa> pessoas;
		 
	public JanelaListaPessoas() {
		super("Janela de Cadastro",true,true,true,true);
		criarComponentes();
        configurarJanela();
        carregarLista();
	}
	
	private void criarComponentes() {
		panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Listagem de produtos"));
        
        model = new DefaultTableModel();
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        
        JTableHeader header = table.getTableHeader();
        
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Idade");
        
        scroll = new JScrollPane();
        scroll.setViewportView(table);

        Dimension d = table.getPreferredSize();
		scroll.setPreferredSize(new Dimension(scroll.getPreferredSize().width, table.getRowHeight()*20 + header.getPreferredSize().height));
        
		buttonBuscar = new JButton("Atualizar");
        buttonBuscar.addActionListener(this);
		
		panel.add(buttonBuscar);
        panel.add(scroll);		
		
		add(panel);
		
	}
	
	private void configurarJanela() {
		setVisible(true);
		pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//remove o conteudo da tela e atualiza
		int totalLista = model.getRowCount();
		if(model.getRowCount() >= 0) {
			for(int i = 0; i < totalLista; i++) {
				model.removeRow(0);
			}
		}
		carregarLista();		
	}
	
	private void carregarLista() {
		PessoaDAO dao = new PessoaDAO();
		pessoas = dao.consultarTodos();
		for(Pessoa p : pessoas) {			
			model.addRow(new Object[] {p.getId(), p.getNome(), p.getIdade()});
		}
	}	
	
}
