package appconsole;

import regras_negocio.Fachada;

public class Alterar {
	public Alterar() {
		try {
			Fachada.inicializar();
			
			//Iremos alterar a quentinha do pedido número 1 para a quentinha numero 3
			System.out.println("Alterando pedido(ID: 1), cliente quer mudar a quentinha .....\n");
			
			System.out.println("Pedido antes da alteracao: " + Fachada.localizarPedido(1) + "\n");
			Fachada.alterarQuentinhaPedido(1, 3);
			System.out.println("Pedido depois da alteracao: " + Fachada.localizarPedido(1) + "\n");
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("\nFim do programa !");
	}
	
	public static void main(String[] args) {
		new Alterar();
	
	}

}
