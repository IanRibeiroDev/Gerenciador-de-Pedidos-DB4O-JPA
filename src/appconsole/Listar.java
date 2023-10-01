package appconsole;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;
import regras_negocio.Fachada;

public class Listar {
	public Listar() {
		try {
			Fachada.inicializar();
			
			System.out.println("---Listagem Quentinhas\n");
			
			for(Quentinha quent: Fachada.listarQuentinhas())
				System.out.println(quent);

			System.out.println("\n---Listagem Clientes\n");
	
			for(Cliente cli: Fachada.listarClientes())
				System.out.println(cli);
			
			System.out.println("\n---Listagem Pedidos\n");
	
			for(Pedido ped: Fachada.listarPedidos())
				System.out.println(ped + "\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("Fim da listagem!");
	}
	
	public static void main(String[] args) {
		new Listar();
	}

}
