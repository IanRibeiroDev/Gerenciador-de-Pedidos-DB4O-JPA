package appconsole;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;
import regras_negocio.Fachada;

public class Consultar {
	public Consultar() {
		try {
			Fachada.inicializar();
			
			//Pedidos feitos no dia 09/05/2023
			System.out.println("Pedidos feitos no dia 09/05/2023:\n");
			
			for(Pedido p : Fachada.pedidosNaDataX("2023-05-09")) {
				System.out.println(p + "\n");
			}
			
			
			//Pedidos de tamanho M
			System.out.println("\nPedidos de tamanho M:\n");
			
			for(Pedido p : Fachada.pedidosDeTamanhoX("M")) {
				System.out.println(p + "\n");
			}
			
			
			//Quentinhas pedidas pelo cliente Matheus Rodrigues(ID: 20)
			System.out.println("\nQuentinhas pedidas pelo cliente Matheus Rodrigues(ID: 20):\n");
			
			for(Quentinha q : Fachada.consultarQuentinhasPedidasPorCliente(20)) {
				System.out.println(q);
			}

			
			//Clientes com mais de 1 pedido
			System.out.println("\n\nClientes com mais de 1 pedido: \n");
			
			for(Cliente cl : Fachada.clientesComMaisDeNPedidos(1))
				System.out.println("Cliente: " + cl.getNome() + " | Total de pedidos: " + cl.getListaPedidos().size());
			
			
			//Quentinhas pedidas mais de 1 vez
			System.out.println("\n\nQuentinhas pedidas mais de 1 vez: \n");
			
			for(Quentinha quen : Fachada.quentinhasPedidasMaisDeNVezes(1))
				System.out.println(quen);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("\nFim das consultas!");
	}

	
	public static void main(String[] args) {
		new Consultar();
	}
}