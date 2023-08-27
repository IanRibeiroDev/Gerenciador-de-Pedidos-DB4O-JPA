package appconsole;

import java.util.List;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Pedido;

public class Deletar {
	protected ObjectContainer manager;
	
	public Deletar() {
		
		try {
			manager = Util.conectarBanco();
			
			//Iremos deletar o pedido 4
			
			//Localizando o pedido número 4
			Query q = manager.query();
			q.constrain(Pedido.class);  				
			q.descend("id").constrain(4);		 
			List<Pedido> resultados = q.execute();
				
			//Se ao menos um resultado for obtido
			if(resultados.size()>0) {
				System.out.println("Excluindo...");
				Pedido p = resultados.get(0); //Obtem o primeiro resultado da consulta
	
				//Obtendo o cliente que fez o pedido
				Cliente c = p.getCliente();
				
				c.delPedido(p); //Removendo o pedido p da lista de pedidos do cliente c
				manager.store(c); //Armazenando alteração
					
				manager.delete(p); //Deletando o pedido do banco
				manager.commit();
				System.out.println("Pedido apagado com sucesso.");
			}
			//Se nenhum resultado for obtido na consulta
			else {
				System.out.println("Pedido não encontrado.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Util.desconectar();
		System.out.println("\nFim do programa !");
	}
	
	public static void main(String[] args) {
		new Deletar();
	}
}
