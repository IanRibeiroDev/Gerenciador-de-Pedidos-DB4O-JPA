/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Cliente;

public class DAOCliente extends DAO<Cliente> {

	public Cliente read(Object chave) {
		try {
			int id = (int) chave;
			TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c where c.id=:n", Cliente.class);
			q.setParameter("n", id);
			Cliente p = q.getSingleResult();
			return p;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Cliente> readAll(){
		TypedQuery<Cliente> query = manager.createQuery("select c from Cliente c LEFT JOIN FETCH c.pedidos order by c.id", Cliente.class);
		return  query.getResultList();
	}
	
	// --------------------------------------------
	// consultas
	// --------------------------------------------

	public List<Cliente> consulta2() {
		// cliestes com 3 alugueis
		TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c where size(c.pedidos) =3", Cliente.class);
		return q.getResultList();
	}
	
	public List<Cliente> clientesComMaisDeNPedidos(int n) {		
		TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c where size(c.pedidos) = :x", Cliente.class);
		q.setParameter("x", n);
		return q.getResultList();
	}
	
	public Cliente buscarPorTelefone (String telefone) {
		try {
			TypedQuery<Cliente> q = manager.createQuery("select c from Cliente c where c.telefone = :x", Cliente.class);
			q.setParameter("x", telefone);
			return q.getSingleResult();
			
		} catch(Exception e) {
			return null;
		}
		
	}
		
}
