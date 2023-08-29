package appconsole;

import java.util.List;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Pedido;
import modelo.Quentinha;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar() {
		try {
			manager = Util.conectarBanco();
			
			//Iremos alterar a quentinha do pedido número 1
			
			//Localizando o pedido número 1
			Query q = manager.query();
			q.constrain(Pedido.class);  		
			q.descend("id").constrain(1);		 
			List<Pedido> resultados = q.execute(); 
			
			//Se ao menos um resultado for obtido, vamos alterar a opção de quentinha do pedido
			if(resultados.size()>0) {
				System.out.println("Alterando pedido, cliente quer mudar a quentinha .....");
				
				Pedido p = resultados.get(0);
				System.out.println("");
				System.out.println("Antes de alterar, a quentinha é: " + p.getQuentinha());
				System.out.println("");
				
				//Obtendo o objeto quentinha que queremos colocar no pedido, vamos colocar a quentinha de id 3
				Query q2 = manager.query();
				q2.constrain(Quentinha.class);
				q2.descend("id").constrain(3);
				List<Quentinha> resultadosQuentinha = q2.execute();
				
				if(resultadosQuentinha.size()>0) {
					Quentinha novaQuentinha = resultadosQuentinha.get(0);	
					Quentinha quentinhaAntiga = p.getQuentinha();
					p.setQuentinha(novaQuentinha);
					
					//Atualizando o pedido e quentinha antiga no banco
					manager.store(p);
					manager.store(quentinhaAntiga);
					manager.commit();
				
					System.out.println("");
					System.out.println("Quentinha alterada para " + p.getQuentinha() + ".");

				}
				//Se nenhum resultado for obtido na consulta da opção de quentinha
				else {
					System.out.println("Opção de quentinha inválida.");
				}
			}
			
			//Se nenhum resultado for obtido na consulta de pedido
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
		new Alterar();
	
	}

}
