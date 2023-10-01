package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Pedido;

public class DAOPedido  extends DAO<Pedido>{

	public void create(Pedido ped){
		int novoid = super.gerarId();  	//gerar novo id da classe
		ped.setId(novoid);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( ped );
	}
	
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
	//  consultas de Pedido
	//--------------------------------------------

	public List<Pedido> pedidosNaDataX(String data) {
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("data").constrain(data).startsWith(true);
		List<Pedido> resultado = q.execute();
		return resultado;
	}
	
	public List<Pedido> pedidosDeTamanhoX(String tamanho) {
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("tamanho").constrain(tamanho);
		List<Pedido> resultado = q.execute();
		return resultado;
	}
}
