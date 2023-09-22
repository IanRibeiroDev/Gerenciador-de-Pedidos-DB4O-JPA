/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package daodb4o;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;


import modelo.Cliente;
import modelo.Quentinha;

public class DAOCliente extends DAO<Cliente>{

	public Cliente read (Object pk){
		int id = (int) pk;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("id").constrain(pk);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	
	public List<Quentinha> consultarQuentinhas(int pk) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("pedidos");
		
		List<Quentinha> resultado = q.execute();
		
		System.out.println("\n\nQuentinhas pedidas pelo cliente Matheus Rodrigues:\n");
		
		return resultado;
	}
	
	public List<Cliente> clientesComNPedidos(int n) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.constrain( new Filtro1(n) );
		List<Cliente> resultados = q.execute();
		return resultados;
	}
	
	//classe interna
	class Filtro1 implements Evaluation {
		private int n;
		public Filtro1(int n) {
			this.n = n;
		}
		public void evaluate(Candidate candidate) {
			Cliente cl = (Cliente) candidate.getObject();
			if(cl.getListaPedidos().size()> n) 
				candidate.include(true); 
			else		
				candidate.include(false);
		}
	}
}

