package appconsole;

import regras_negocio.Fachada;

public class Deletar {
	public Deletar() {
		
		try {
			Fachada.inicializar();
			
			//Iremos deletar o pedido 4
			Fachada.excluirPedido(4);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("\nFim do programa !");
	}
	
	public static void main(String[] args) {
		new Deletar();
	}
}
