package edu.br.ifsp.main;

import java.util.List;

import br.edu.ifsp.controlador.InserePessoaController;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.tela.FramePrincipal;

public class ConexaoInsert {

	public static void main(String[] args)  {
		
			// Criado um modelo
			/*Pessoa pessoa = new Pessoa();
			pessoa.setNome("Jose Alfredo");
			pessoa.setIdade(12);
			
			PessoaDAO dao = new PessoaDAO();
			dao.salvarPessoa(pessoa);
			
			PessoaDAO dao = new PessoaDAO();
			ArrayList<Pessoa> lista = dao.consultarTodos();
			for(Pessoa p : lista) {
				System.out.println(p.getId() + " " + p.getNome() + " " + p.getIdade());
			}*/
		
			//FramePrincipal fp = new FramePrincipal();
			//InserePessoaController ipc = new InserePessoaController(fp);
			//fp.setVisible(true);
			
			PessoaDAO dao = new PessoaDAO();
			
			List<Pessoa> list = dao.consultarTodos();
			
			System.out.println("Consultar Todos: ");
			for(Pessoa p : list) {
				System.out.println(p);
			}

			dao.editarPessoaPorId(3, new Pessoa(3, "Kaique", 20));
			
			System.out.println("Consulta por ID");
			System.out.println(dao.consultarPessoaPorId(3));
									
		
	}

}
