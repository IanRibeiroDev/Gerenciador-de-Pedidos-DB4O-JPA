package appconsole;

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
			Pedido p1 = new Pedido(Util.gerarIdPedido(), c10, q19, "M", "2023-08-25 10:30:00");
			manager.store(p1);
			manager.commit();

			Pedido p2 = new Pedido(Util.gerarIdPedido(), c7, q18, "G", "2023-08-24 14:15:30");
			manager.store(p2);
			manager.commit();

			Pedido p3 = new Pedido(Util.gerarIdPedido(), c15, q8, "P", "2023-08-23 09:20:45");
			manager.store(p3);
			manager.commit();

			Pedido p4 = new Pedido(Util.gerarIdPedido(), c12, q5, "M", "2023-08-22 16:05:15");
			manager.store(p4);
			manager.commit();

			Pedido p5 = new Pedido(Util.gerarIdPedido(), c18, q3, "G", "2023-08-21 11:45:30");
			manager.store(p5);
			manager.commit();

			Pedido p6 = new Pedido(Util.gerarIdPedido(), c20, q10, "P", "2023-08-20 08:30:00");
			manager.store(p6);
			manager.commit();

			Pedido p7 = new Pedido(Util.gerarIdPedido(), c3, q6, "P", "2023-08-19 16:15:45");
			manager.store(p7);
			manager.commit();

			Pedido p8 = new Pedido(Util.gerarIdPedido(), c16, q11, "G", "2023-08-18 12:10:00");
			manager.store(p8);
			manager.commit();

			Pedido p9 = new Pedido(Util.gerarIdPedido(), c19, q4, "M", "2023-08-17 15:30:15");
			manager.store(p9);
			manager.commit();

			Pedido p10 = new Pedido(Util.gerarIdPedido(), c9, q20, "M", "2022-11-10 09:45:30");
			manager.store(p10);
			manager.commit();

			Pedido p11 = new Pedido(Util.gerarIdPedido(), c13, q7, "G", "2023-05-01 10:30:00");
			manager.store(p11);
			manager.commit();

			Pedido p12 = new Pedido(Util.gerarIdPedido(), c1, q17, "P", "2023-05-02 14:15:30");
			manager.store(p12);
			manager.commit();

			Pedido p13 = new Pedido(Util.gerarIdPedido(), c4, q9, "G", "2023-05-03 09:20:45");
			manager.store(p13);
			manager.commit();

			Pedido p14 = new Pedido(Util.gerarIdPedido(), c14, q12, "P", "2023-05-04 16:05:15");
			manager.store(p14);
			manager.commit();

			Pedido p15 = new Pedido(Util.gerarIdPedido(), c8, q14, "G", "2023-05-05 11:45:30");
			manager.store(p15);
			manager.commit();

			Pedido p16 = new Pedido(Util.gerarIdPedido(), c2, q13, "M", "2023-05-06 08:30:00");
			manager.store(p16);
			manager.commit();

			Pedido p17 = new Pedido(Util.gerarIdPedido(), c17, q16, "P", "2023-05-07 16:15:45");
			manager.store(p17);
			manager.commit();

			Pedido p18 = new Pedido(Util.gerarIdPedido(), c20, q15, "G", "2023-05-08 12:10:00");
			manager.store(p18);
			manager.commit();

			Pedido p19 = new Pedido(Util.gerarIdPedido(), c5, q2, "M", "2023-05-09 15:30:15");
			manager.store(p19);
			manager.commit();

			Pedido p20 = new Pedido(Util.gerarIdPedido(), c11, q1, "P", "2023-05-09 09:45:30");
			manager.store(p20);
			manager.commit();
	        
			Pedido p21 = new Pedido(Util.gerarIdPedido(), c6, q20, "P", "2022-11-01 10:30:00");
			manager.store(p21);
			manager.commit();

			Pedido p22 = new Pedido(Util.gerarIdPedido(), c15, q19, "G", "2022-11-02 14:15:30");
			manager.store(p22);
			manager.commit();

			Pedido p23 = new Pedido(Util.gerarIdPedido(), c12, q18, "M", "2022-11-03 09:20:45");
			manager.store(p23);
			manager.commit();

			Pedido p24 = new Pedido(Util.gerarIdPedido(), c18, q17, "M", "2022-11-04 16:05:15");
			manager.store(p24);
			manager.commit();

			Pedido p25 = new Pedido(Util.gerarIdPedido(), c9, q14, "G", "2022-11-05 11:45:30");
			manager.store(p25);
			manager.commit();

			Pedido p26 = new Pedido(Util.gerarIdPedido(), c4, q13, "P", "2022-11-06 08:30:00");
			manager.store(p26);
			manager.commit();

			Pedido p27 = new Pedido(Util.gerarIdPedido(), c17, q16, "M", "2022-11-07 16:15:45");
			manager.store(p27);
			manager.commit();

			Pedido p28 = new Pedido(Util.gerarIdPedido(), c20, q15, "G", "2022-11-08 12:10:00");
			manager.store(p28);
			manager.commit();

			Pedido p29 = new Pedido(Util.gerarIdPedido(), c5, q2, "M", "2022-11-09 15:30:15");
			manager.store(p29);
			manager.commit();

			Pedido p30 = new Pedido(Util.gerarIdPedido(), c11, q1, "P", "2022-11-10 09:45:30");
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
