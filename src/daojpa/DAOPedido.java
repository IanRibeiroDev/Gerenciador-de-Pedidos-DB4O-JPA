// Pedido = Pedido
// Carro = Quentinha
// Cliente = Cliente :O

package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Pedido;

public class DAOPedido  extends DAO<Pedido>{

	public Pedido read (Object chave){
		try{
			int id = (int) chave;
			TypedQuery<Pedido> q = manager.createQuery("select a from Pedido a where a.id = :n ",Pedido.class);
			q.setParameter("n", id);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	public List<Pedido> readAll(){
		TypedQuery<Pedido> q = manager.createQuery("select a from Pedido a LEFT JOIN FETCH a.quentinha  JOIN FETCH a.cliente order by a.id", Pedido.class);
		return  q.getResultList();
	}


	//--------------------------------------------
	//  consultas
	//--------------------------------------------

	public List<Pedido> pedidosNaDataX(String data) {
		TypedQuery<Pedido> q = manager.createQuery("select p from Pedido p where p.data = :x", Pedido.class);
		q.setParameter("x", data);
		return q.getResultList();
	}
	
	public List<Pedido> pedidosDeTamanhoX(String tamanho) {
		TypedQuery<Pedido> q = manager.createQuery("select p from Pedido p where p.tamanho = :x", Pedido.class);
		q.setParameter("x", tamanho);
		return q.getResultList();
	}
}
