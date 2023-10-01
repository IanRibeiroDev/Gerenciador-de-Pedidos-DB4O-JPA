package daodb4o;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Quentinha;

public class DAOQuentinha extends DAO<Quentinha>{

	public void create(Quentinha quen){
		int novoid = super.gerarId();  	//gerar novo id da classe
		quen.setId(novoid);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( quen );
	}
	
	public Quentinha read (Object pk){
		int id = (int) pk;	
		Query q = manager.query();
		q.constrain(Quentinha.class);
		q.descend("id").constrain(id);
		List<Quentinha> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public Quentinha buscarPorDescricao (String descricao) {	
		Query q = manager.query();
		q.constrain(Quentinha.class);
		q.descend("descricao").constrain(descricao);
		List<Quentinha> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	//--------------------------------------------
	//  consultas de Quentinha
	//--------------------------------------------
	
	public List<Quentinha> quentinhasPedidasMaisDeNVezes(int n){
		Query q = manager.query();
		q.constrain(Quentinha.class);
		q.constrain(new Filtro(n));
		return q.execute();
	}

	
	//classe interna
	class Filtro implements Evaluation {
		private int n;
		public Filtro(int n) {
			this.n = n;
		}
		public void evaluate(Candidate candidate) {
			Quentinha quen = (Quentinha) candidate.getObject();
			if(quen.getVezesPedida()> n) 
				candidate.include(true); 
			else		
				candidate.include(false);
		}
	}

}
