/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Pedido;

public class DAOPedido  extends DAO<Pedido>{

	public Pedido read (Object pk){
		int id = (int) pk;	
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("id").constrain(id);
		List<Pedido> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	//--------------------------------------------
	//  consultas de Aluguel
	//--------------------------------------------


}
