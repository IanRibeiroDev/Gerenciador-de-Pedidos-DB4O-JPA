package daodb4o;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{

	public void create(Cliente cli){
		int novoid = super.gerarId();  	//gerar novo id da classe
		cli.setId(novoid);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( cli );
	}
	
	public Cliente read (Object pk){
		int id = (int) pk;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("id").constrain(id);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public Cliente buscarPorTelefone (String telefone) {	
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("telefone").constrain(telefone);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	//--------------------------------------------
	//  consultas
	//--------------------------------------------
	
	public List<Cliente> clientesComMaisDeNPedidos(int n) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.constrain( new Filtro1(n) );
		List<Cliente> resultado = q.execute();
		return resultado;
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

