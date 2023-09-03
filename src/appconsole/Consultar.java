package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;

public class Consultar {
	protected ObjectContainer manager;
	
	public Consultar() {
		try {
			manager = Util.conectarBanco();
			
			//Pedidos feitos no dia 09/05/2023
			Query q1 = manager.query();
			q1.constrain(Pedido.class);
			q1.descend("data").constrain("2023-05-09").startsWith(true);
			List<Pedido> resultado1 = q1.execute();
			
			System.out.println("Pedidos feitos no dia 09/05/2023:\n");
			
			for(Pedido p : resultado1) {
				System.out.println(p);
			}
			
			//Quentinhas pedidas pelo cliente Matheus Rodrigues
			Query q2 = manager.query();
			q2.constrain(Quentinha.class);
			q2.descend("pedidos").descend("cliente").descend("nome").constrain("Matheus Rodrigues");
			
			List<Quentinha> resultado2 = q2.execute();
			
			System.out.println("\n\nQuentinhas pedidas pelo cliente Matheus Rodrigues:\n");
			
			for(Quentinha q : resultado2) {
				System.out.println(q);
			}

			System.out.println("\n\nClientes com mais de 1 pedido: \n");

			Query q = manager.query();
			q.constrain(Cliente.class);
			q.constrain( new Filtro1() );
			List<Cliente> resultados = q.execute();
			
			for(Cliente cl : resultados)
				System.out.println("Cliente: " + cl.getNome() + " | Total de pedidos: " + cl.getListaPedidos().size());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Util.desconectar();
		System.out.println("\nFim das consultas!");
	}

	
	public static void main(String[] args) {
		new Consultar();
	}

	//classe interna
	class Filtro1 implements Evaluation {
		public void evaluate(Candidate candidate) {
			Cliente cl = (Cliente) candidate.getObject();
			if(cl.getListaPedidos().size()> 1) 
				candidate.include(true); 
			else		
				candidate.include(false);
		}
	}
}