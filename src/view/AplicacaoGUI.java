package view;

import javax.swing.JOptionPane;

import controller.Cliente;
import controller.Fachada;

public class AplicacaoGUI {
	
	private static Fachada fachada = Fachada.getInstancia();
	
	public static void main(String[] args) {
		int opcao = 0;
		while(opcao != 5){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Opção 1 - Inserir;"+
					"\nOpção 2 - Consultar Cliente;"+
					"\nOpção 3 - Alterar Cliente;"+
					"\nOpção 4 - Excluir Cliente;"+
					"\nOpção 5 - Sair"));
			switch(opcao){
			case 1://adicionar cliente
				String nome = JOptionPane.showInputDialog("Informe o nome: ");
				String end = JOptionPane.showInputDialog("Informe o endereço: ");
				String cidade = JOptionPane.showInputDialog("Informe a cidade: ");
				String uf = JOptionPane.showInputDialog("Informe o estado: ");
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setEndereco(end);
				cliente.setCidade(cidade);
				cliente.setUf(uf);
				try{
					fachada.salvarCliente(cliente);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			
			case 2://consultar cliente
				String strID = JOptionPane.showInputDialog("Informe o ID do cliente: ");
				try{
					Cliente cliente2 = fachada.consultarCliente(Integer.parseInt(strID));
					if(cliente2 != null){
						JOptionPane.showMessageDialog(null, cliente2.getNome());
					}else{
						JOptionPane.showMessageDialog(null, "Cliente não encontrado! ");
					}
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			
			case 3://alterar cliente
				String strID2 = JOptionPane.showInputDialog("Informe o ID do cliente: ");
				String nome2 = JOptionPane.showInputDialog("Informe o nome: ");
				String end2 = JOptionPane.showInputDialog("Informe o endereço: ");
				String cidade2 = JOptionPane.showInputDialog("Informe a cidade: ");
				String uf2 = JOptionPane.showInputDialog("Informe o estado: ");
				
				Cliente cliente3 = new Cliente();
				cliente3.setId(Integer.parseInt(strID2));
				cliente3.setNome(nome2);
				cliente3.setEndereco(end2);
				cliente3.setCidade(cidade2);
				cliente3.setUf(uf2);
				
				try{
					fachada.alterarCliente(cliente3);
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 4://excluir cliente
				String strID3 = JOptionPane.showInputDialog("Informe o id do cliente: ");
				try{
					fachada.excluirCliente(Integer.parseInt(strID3));
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			}
		}
	}

}
