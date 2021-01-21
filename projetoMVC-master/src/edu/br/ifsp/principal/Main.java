package edu.br.ifsp.principal;

import br.edu.ifsp.telas.JanelaPrincipal;

public class Main {

	public static void main(String[] args)  {	
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new JanelaPrincipal();
            }
        });									
	
	}
	
}
