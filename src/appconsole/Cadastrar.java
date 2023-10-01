package appconsole;

import regras_negocio.Fachada;

public class Cadastrar {
	public Cadastrar() {
		try {
			Fachada.inicializar();
			System.out.println("cadastrando...\n");

			// Criando objetos
			// Quentinhas
			Fachada.cadastrarQuentinha("Feijao Preto, Arroz Branco, Salada Crua, Frango");
			Fachada.cadastrarQuentinha("Feijao Carioca, Arroz Integral, Salada de Tomate, Carne de Porco");
			Fachada.cadastrarQuentinha("Feijao Mulatinho, Arroz de Brócolis, Salada de Alface, Peixe");
			Fachada.cadastrarQuentinha("Feijao Vermelho, Arroz de Couve, Salada de Rúcula, Frango");
			Fachada.cadastrarQuentinha("Feijao Branco, Arroz de Cenoura, Salada de Beterraba, Carne de Boi");
			Fachada.cadastrarQuentinha("Feijao Roxinho, Arroz de Abobrinha, Salada de Pepino, Frango");
			Fachada.cadastrarQuentinha("Feijao Mungo, Arroz Selvagem, Salada de Espinafre, Carne de Frango");
			Fachada.cadastrarQuentinha("Feijao Azuki, Arroz Basmati, Salada de Cenoura, Peixe");
			Fachada.cadastrarQuentinha("Feijao Branco, Arroz Integral, Salada de Alface, Carne de Porco");
			Fachada.cadastrarQuentinha("Feijao Carioca, Arroz de Brócolis, Salada de Tomate, Frango");
			Fachada.cadastrarQuentinha("Feijao Roxinho, Arroz de Couve-Flor, Salada de Rúcula, Carne de Boi");
			Fachada.cadastrarQuentinha("Feijao Preto, Arroz de Abobrinha, Salada de Pepino, Peixe");
			Fachada.cadastrarQuentinha("Feijao Vermelho, Arroz Basmati, Salada de Espinafre, Frango");
			Fachada.cadastrarQuentinha("Feijao Mungo, Arroz Integral, Salada de Beterraba, Carne de Frango");
			Fachada.cadastrarQuentinha("Feijao Azuki, Arroz Selvagem, Salada de Cenoura, Peixe");
			Fachada.cadastrarQuentinha("Feijao Branco, Arroz de Brócolis, Salada de Tomate, Carne de Porco");
			Fachada.cadastrarQuentinha("Feijao Carioca, Arroz de Couve, Salada de Rúcula, Frango");
			Fachada.cadastrarQuentinha("Feijao Preto, Arroz de Abobrinha, Salada de Alface, Carne de Boi");
			Fachada.cadastrarQuentinha("Feijao Vermelho, Arroz Basmati, Salada de Pepino, Peixe");
			Fachada.cadastrarQuentinha("Feijao Azuki, Arroz Basmati, Salada de Rúcula, Carne de Porco");


			// Clientes
			Fachada.cadastrarCliente("George Lima", "83986660754");
			Fachada.cadastrarCliente("Maria Santos", "83991234567");
			Fachada.cadastrarCliente("Rafaela Souza", "83987765432");
			Fachada.cadastrarCliente("João Oliveira", "83983321098");
			Fachada.cadastrarCliente("Fernanda Silva", "83984561230");
			Fachada.cadastrarCliente("Carlos Pereira", "83988887755");
			Fachada.cadastrarCliente("Isabela Rodrigues", "83989966543");
			Fachada.cadastrarCliente("Lucas Alves", "83982233445");
			Fachada.cadastrarCliente("Amanda Sousa", "83986665544");
			Fachada.cadastrarCliente("Pedro Costa", "83981122334");
			Fachada.cadastrarCliente("Larissa Mendes", "83987766556");
			Fachada.cadastrarCliente("Miguel Ferreira", "83989988766");
			Fachada.cadastrarCliente("Ana Cardoso", "83984433221");
			Fachada.cadastrarCliente("Gustavo Santos", "83986660998");
			Fachada.cadastrarCliente("Sophia Lima", "83985554433");
			Fachada.cadastrarCliente("Enzo Souza", "83987765234");
			Fachada.cadastrarCliente("Luiza Oliveira", "83983321789");
			Fachada.cadastrarCliente("Arthur Silva", "83989963210");
			Fachada.cadastrarCliente("Laura Pereira", "83981123456");
			Fachada.cadastrarCliente("Matheus Rodrigues", "83982222987");


			// Pedido
			Fachada.cadastrarPedido(10, 19, "M", "2023-08-25 10:30:00");
			Fachada.cadastrarPedido(7, 18, "G", "2023-08-24 14:15:30");
			Fachada.cadastrarPedido(15, 8, "P", "2023-08-23 09:20:45");
			Fachada.cadastrarPedido(12, 5, "M", "2023-08-22 16:05:15");
			Fachada.cadastrarPedido(18, 3, "G", "2023-08-21 11:45:30");
			Fachada.cadastrarPedido(20, 10, "P", "2023-08-20 08:30:00");
			Fachada.cadastrarPedido(3, 6, "P", "2023-08-19 16:15:45");
			Fachada.cadastrarPedido(16, 11, "G", "2023-08-18 12:10:00");
			Fachada.cadastrarPedido(19, 4, "M", "2023-08-17 15:30:15");
			Fachada.cadastrarPedido(9, 20, "M", "2022-11-10 09:45:30");
			Fachada.cadastrarPedido(13, 7, "G", "2023-05-01 10:30:00");
			Fachada.cadastrarPedido(1, 17, "P", "2023-05-02 14:15:30");
			Fachada.cadastrarPedido(4, 9, "G", "2023-05-03 09:20:45");
			Fachada.cadastrarPedido(14, 12, "P", "2023-05-04 16:05:15");
			Fachada.cadastrarPedido(8, 14, "G", "2023-05-05 11:45:30");
			Fachada.cadastrarPedido(2, 13, "M", "2023-05-06 08:30:00");
			Fachada.cadastrarPedido(17, 16, "P", "2023-05-07 16:15:45");
			Fachada.cadastrarPedido(20, 15, "G", "2023-05-08 12:10:00");
			Fachada.cadastrarPedido(5, 2, "M", "2023-05-09 15:30:15");
			Fachada.cadastrarPedido(11, 1, "P", "2023-05-09 09:45:30");
			Fachada.cadastrarPedido(6, 20, "P", "2022-11-01 10:30:00");
			Fachada.cadastrarPedido(15, 19, "G", "2022-11-02 14:15:30");
			Fachada.cadastrarPedido(12, 18, "M", "2022-11-03 09:20:45");
			Fachada.cadastrarPedido(18, 17, "M", "2022-11-04 16:05:15");
			Fachada.cadastrarPedido(9, 14, "G", "2022-11-05 11:45:30");
			Fachada.cadastrarPedido(4, 13, "P", "2022-11-06 08:30:00");
			Fachada.cadastrarPedido(17, 16, "M", "2022-11-07 16:15:45");
			Fachada.cadastrarPedido(20, 15, "G", "2022-11-08 12:10:00");
			Fachada.cadastrarPedido(5, 2, "M", "2022-11-09 15:30:15");
			Fachada.cadastrarPedido(11, 1, "P", "2022-11-10 09:45:30");

	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("cadastrados com sucesso!");
	}

	public static void main(String args[]) {
		new Cadastrar();
	}
}
