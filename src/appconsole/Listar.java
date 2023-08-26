package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;

public class Listar {
	protected ObjectContainer manager;
	
	public Listar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("---Listagem Quentinhas\n");
			Query q = manager.query();
			q.constrain(Quentinha.class);  				
			List<Quentinha> resultadosQuentinha = q.execute();
			for(Quentinha quent: resultadosQuentinha)
				System.out.println(quent);

			System.out.println("\n---Listagem Clientes\n");
			q = manager.query();
			q.constrain(Cliente.class);  				
			List<Cliente> resultadosCliente = q.execute();
			for(Cliente cli: resultadosCliente)
				System.out.println(cli);
			
			System.out.println("\n---Listagem Pedidos\n");
			q = manager.query();
			q.constrain(Pedido.class);  				
			List<Pedido> resultadosPedido = q.execute();
			for(Pedido ped: resultadosPedido)
				System.out.println(ped + "\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Util.desconectar();
		System.out.println("Fim da listagem!");
	}
	
	public static void main(String[] args) {
		new Listar();
	}

}
