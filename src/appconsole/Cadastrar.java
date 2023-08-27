package appconsole;

import java.time.LocalDateTime;

import com.db4o.ObjectContainer;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;

public class Cadastrar {
	protected ObjectContainer manager;

	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("cadastrando...\n");

			// Criando objetos
			// Quentinhas
			Quentinha q1 = new Quentinha(Util.gerarIdQuentinha(), "Feijao Preto, Arroz Branco, Salada Crua, Frango");
			manager.store(q1);
			manager.commit();

			Quentinha q2 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Carioca, Arroz Integral, Salada de Tomate, Carne de Porco");
			manager.store(q2);
			manager.commit();

			Quentinha q3 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Mulatinho, Arroz de Brócolis, Salada de Alface, Peixe");
			manager.store(q3);
			manager.commit();

			Quentinha q4 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Vermelho, Arroz de Couve, Salada de Rúcula, Frango");
			manager.store(q4);
			manager.commit();

			Quentinha q5 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Branco, Arroz de Cenoura, Salada de Beterraba, Carne de Boi");
			manager.store(q5);
			manager.commit();

			Quentinha q6 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Roxinho, Arroz de Abobrinha, Salada de Pepino, Frango");
			manager.store(q6);
			manager.commit();

			Quentinha q7 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Mungo, Arroz Selvagem, Salada de Espinafre, Carne de Frango");
			manager.store(q7);
			manager.commit();

			Quentinha q8 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Azuki, Arroz Basmati, Salada de Cenoura, Peixe");
			manager.store(q8);
			manager.commit();

			Quentinha q9 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Branco, Arroz Integral, Salada de Alface, Carne de Porco");
			manager.store(q9);
			manager.commit();

			Quentinha q10 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Carioca, Arroz de Brócolis, Salada de Tomate, Frango");
			manager.store(q10);
			manager.commit();

			Quentinha q11 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Roxinho, Arroz de Couve-Flor, Salada de Rúcula, Carne de Boi");
			manager.store(q11);
			manager.commit();

			Quentinha q12 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Preto, Arroz de Abobrinha, Salada de Pepino, Peixe");
			manager.store(q12);
			manager.commit();

			Quentinha q13 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Vermelho, Arroz Basmati, Salada de Espinafre, Frango");
			manager.store(q13);
			manager.commit();

			Quentinha q14 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Mungo, Arroz Integral, Salada de Beterraba, Carne de Frango");
			manager.store(q14);
			manager.commit();

			Quentinha q15 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Azuki, Arroz Selvagem, Salada de Cenoura, Peixe");
			manager.store(q15);
			manager.commit();

			Quentinha q16 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Branco, Arroz de Brócolis, Salada de Tomate, Carne de Porco");
			manager.store(q16);
			manager.commit();

			Quentinha q17 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Carioca, Arroz de Couve, Salada de Rúcula, Frango");
			manager.store(q17);
			manager.commit();

			Quentinha q18 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Preto, Arroz de Abobrinha, Salada de Alface, Carne de Boi");
			manager.store(q18);
			manager.commit();

			Quentinha q19 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Vermelho, Arroz Basmati, Salada de Pepino, Peixe");
			manager.store(q19);
			manager.commit();

			Quentinha q20 = new Quentinha(Util.gerarIdQuentinha(),
					"Feijao Mungo, Arroz Selvagem, Salada de Espinafre, Carne de Frango");
			manager.store(q20);
			manager.commit();

			// Clientes
			Cliente c1 = new Cliente(Util.gerarIdCliente(), "George Lima", "83986660754");
			manager.store(c1);
			manager.commit();

			Cliente c2 = new Cliente(Util.gerarIdCliente(), "Maria Santos", "83991234567");
			manager.store(c2);
			manager.commit();

			Cliente c3 = new Cliente(Util.gerarIdCliente(), "Rafaela Souza", "83987765432");
			manager.store(c3);
			manager.commit();

			Cliente c4 = new Cliente(Util.gerarIdCliente(), "João Oliveira", "83983321098");
			manager.store(c4);
			manager.commit();

			Cliente c5 = new Cliente(Util.gerarIdCliente(), "Fernanda Silva", "83984561230");
			manager.store(c5);
			manager.commit();

			Cliente c6 = new Cliente(Util.gerarIdCliente(), "Carlos Pereira", "83988887755");
			manager.store(c6);
			manager.commit();

			Cliente c7 = new Cliente(Util.gerarIdCliente(), "Isabela Rodrigues", "83989966543");
			manager.store(c7);
			manager.commit();

			Cliente c8 = new Cliente(Util.gerarIdCliente(), "Lucas Alves", "83982233445");
			manager.store(c8);
			manager.commit();

			Cliente c9 = new Cliente(Util.gerarIdCliente(), "Amanda Sousa", "83986665544");
			manager.store(c9);
			manager.commit();

			Cliente c10 = new Cliente(Util.gerarIdCliente(), "Pedro Costa", "83981122334");
			manager.store(c10);
			manager.commit();

			Cliente c11 = new Cliente(Util.gerarIdCliente(), "Larissa Mendes", "83987766556");
			manager.store(c11);
			manager.commit();

			Cliente c12 = new Cliente(Util.gerarIdCliente(), "Miguel Ferreira", "83989988766");
			manager.store(c12);
			manager.commit();

			Cliente c13 = new Cliente(Util.gerarIdCliente(), "Ana Cardoso", "83984433221");
			manager.store(c13);
			manager.commit();

			Cliente c14 = new Cliente(Util.gerarIdCliente(), "Gustavo Santos", "83986660998");
			manager.store(c14);
			manager.commit();

			Cliente c15 = new Cliente(Util.gerarIdCliente(), "Sophia Lima", "83985554433");
			manager.store(c15);
			manager.commit();

			Cliente c16 = new Cliente(Util.gerarIdCliente(), "Enzo Souza", "83987765432");
			manager.store(c16);
			manager.commit();

			Cliente c17 = new Cliente(Util.gerarIdCliente(), "Luiza Oliveira", "83983321789");
			manager.store(c17);
			manager.commit();

			Cliente c18 = new Cliente(Util.gerarIdCliente(), "Arthur Silva", "83989963210");
			manager.store(c18);
			manager.commit();

			Cliente c19 = new Cliente(Util.gerarIdCliente(), "Laura Pereira", "83981123456");
			manager.store(c19);
			manager.commit();

			Cliente c20 = new Cliente(Util.gerarIdCliente(), "Matheus Rodrigues", "83982222987");
			manager.store(c20);
			manager.commit();

			// Pedido
			Pedido p1 = new Pedido(Util.gerarIdPedido(), c10, q19, "M", LocalDateTime.parse("2023-08-25T10:30:00"));
	        manager.store(p1);
	        manager.commit();

	        Pedido p2 = new Pedido(Util.gerarIdPedido(), c7, q18, "G", LocalDateTime.parse("2023-08-24T14:15:30"));
	        manager.store(p2);
	        manager.commit();

	        Pedido p3 = new Pedido(Util.gerarIdPedido(), c15, q8, "P", LocalDateTime.parse("2023-08-23T09:20:45"));
	        manager.store(p3);
	        manager.commit();

	        Pedido p4 = new Pedido(Util.gerarIdPedido(), c12, q5, "M", LocalDateTime.parse("2023-08-22T16:05:15"));
	        manager.store(p4);
	        manager.commit();

	        Pedido p5 = new Pedido(Util.gerarIdPedido(), c18, q3, "G", LocalDateTime.parse("2023-08-21T11:45:30"));
	        manager.store(p5);
	        manager.commit();

	        Pedido p6 = new Pedido(Util.gerarIdPedido(), c20, q10, "P", LocalDateTime.parse("2023-08-20T08:30:00"));
	        manager.store(p6);
	        manager.commit();

	        Pedido p7 = new Pedido(Util.gerarIdPedido(), c3, q6, "P", LocalDateTime.parse("2023-08-19T16:15:45"));
	        manager.store(p7);
	        manager.commit();

	        Pedido p8 = new Pedido(Util.gerarIdPedido(), c16, q11, "G", LocalDateTime.parse("2023-08-18T12:10:00"));
	        manager.store(p8);
	        manager.commit();

	        Pedido p9 = new Pedido(Util.gerarIdPedido(), c19, q4, "M", LocalDateTime.parse("2023-08-17T15:30:15"));
	        manager.store(p9);
	        manager.commit();

	        Pedido p10 = new Pedido(Util.gerarIdPedido(), c9, q20, "M", LocalDateTime.parse("2023-08-16T09:45:30"));
	        manager.store(p10);
	        manager.commit();

	        Pedido p11 = new Pedido(Util.gerarIdPedido(), c13, q7, "G", LocalDateTime.parse("2023-05-01T10:30:00"));
	        manager.store(p11);
	        manager.commit();

	        Pedido p12 = new Pedido(Util.gerarIdPedido(), c1, q17, "P", LocalDateTime.parse("2023-05-02T14:15:30"));
	        manager.store(p12);
	        manager.commit();

	        Pedido p13 = new Pedido(Util.gerarIdPedido(), c4, q9, "G", LocalDateTime.parse("2023-05-03T09:20:45"));
	        manager.store(p13);
	        manager.commit();

	        Pedido p14 = new Pedido(Util.gerarIdPedido(), c14, q12, "P", LocalDateTime.parse("2023-05-04T16:05:15"));
	        manager.store(p14);
	        manager.commit();

	        Pedido p15 = new Pedido(Util.gerarIdPedido(), c8, q14, "G", LocalDateTime.parse("2023-05-05T11:45:30"));
	        manager.store(p15);
	        manager.commit();

	        Pedido p16 = new Pedido(Util.gerarIdPedido(), c2, q13, "M", LocalDateTime.parse("2023-05-06T08:30:00"));
	        manager.store(p16);
	        manager.commit();

	        Pedido p17 = new Pedido(Util.gerarIdPedido(), c17, q16, "P", LocalDateTime.parse("2023-05-07T16:15:45"));
	        manager.store(p17);
	        manager.commit();

	        Pedido p18 = new Pedido(Util.gerarIdPedido(), c20, q15, "G", LocalDateTime.parse("2023-05-08T12:10:00"));
	        manager.store(p18);
	        manager.commit();

	        Pedido p19 = new Pedido(Util.gerarIdPedido(), c5, q2, "M", LocalDateTime.parse("2023-05-09T15:30:15"));
	        manager.store(p19);
	        manager.commit();

	        Pedido p20 = new Pedido(Util.gerarIdPedido(), c11, q1, "P", LocalDateTime.parse("2023-05-09T09:45:30"));
	        manager.store(p20);
	        manager.commit();
	        
	        Pedido p21 = new Pedido(Util.gerarIdPedido(), c6, q20, "P", LocalDateTime.parse("2022-11-01T10:30:00"));
	        manager.store(p21);
	        manager.commit();

	        Pedido p22 = new Pedido(Util.gerarIdPedido(), c15, q19, "G", LocalDateTime.parse("2022-11-02T14:15:30"));
	        manager.store(p22);
	        manager.commit();

	        Pedido p23 = new Pedido(Util.gerarIdPedido(), c12, q18, "M", LocalDateTime.parse("2022-11-03T09:20:45"));
	        manager.store(p23);
	        manager.commit();

	        Pedido p24 = new Pedido(Util.gerarIdPedido(), c18, q17, "M", LocalDateTime.parse("2022-11-04T16:05:15"));
	        manager.store(p24);
	        manager.commit();

	        Pedido p25 = new Pedido(Util.gerarIdPedido(), c9, q14, "G", LocalDateTime.parse("2022-11-05T11:45:30"));
	        manager.store(p25);
	        manager.commit();

	        Pedido p26 = new Pedido(Util.gerarIdPedido(), c4, q13, "P", LocalDateTime.parse("2022-11-06T08:30:00"));
	        manager.store(p26);
	        manager.commit();

	        Pedido p27 = new Pedido(Util.gerarIdPedido(), c17, q16, "M", LocalDateTime.parse("2022-11-07T16:15:45"));
	        manager.store(p27);
	        manager.commit();

	        Pedido p28 = new Pedido(Util.gerarIdPedido(), c20, q15, "G", LocalDateTime.parse("2022-11-08T12:10:00"));
	        manager.store(p28);
	        manager.commit();

	        Pedido p29 = new Pedido(Util.gerarIdPedido(), c5, q2, "M", LocalDateTime.parse("2022-11-09T15:30:15"));
	        manager.store(p29);
	        manager.commit();

	        Pedido p30 = new Pedido(Util.gerarIdPedido(), c11, q1, "P", LocalDateTime.parse("2022-11-10T09:45:30"));
	        manager.store(p30);
	        manager.commit();
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Util.desconectar();
		System.out.println("cadastrados com sucesso!");
	}

	public static void main(String args[]) {
		new Cadastrar();
	}
}
