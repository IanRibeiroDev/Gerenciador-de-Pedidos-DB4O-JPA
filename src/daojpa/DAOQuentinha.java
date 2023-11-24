

package daojpa;

import java.util.List;

import com.db4o.query.Query;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Quentinha;

public class DAOQuentinha extends DAO<Quentinha>{

	public Quentinha read (Object chave){
		try{
			int id = (int) chave;
			TypedQuery<Quentinha> q = manager.createQuery("select q from Quentinha q where q.id=:id",Quentinha.class);
			q.setParameter("id", id);
			Quentinha c =  q.getSingleResult();
			return c;
		}catch(NoResultException e){
			return null;
		}
	}

	public List<Quentinha> readAll(){
		TypedQuery<Quentinha> query = manager.createQuery("select q from Quentinha q LEFT JOIN FETCH q.pedidos order by q.id", Quentinha.class);
		return  query.getResultList();
	}
	
	public List<Quentinha> quentinhasPedidasMaisDeNVezes(int n){
		TypedQuery<Quentinha> q = manager.createQuery("select q from Quentinha q where size(q.pedidos) > :x", Quentinha.class);
		q.setParameter("x", n);
		return q.getResultList();
	}
	
	public Quentinha buscarPorDescricao (String descricao) {	
		TypedQuery<Quentinha> q = manager.createQuery("select q from Quentinha q where q.descricao = :x", Quentinha.class);
		q.setParameter("x", descricao);
		return q.getSingleResult();
	}
	
}

