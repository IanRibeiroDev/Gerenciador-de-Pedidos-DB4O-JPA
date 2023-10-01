package regras_negocio;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOCliente;
import daodb4o.DAOPedido;
import daodb4o.DAOQuentinha;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;

public class Fachada {
	private Fachada() {}

	private static DAOQuentinha daoquentinha = new DAOQuentinha();  
	private static DAOPedido daopedido = new DAOPedido(); 
	private static DAOCliente daocliente = new DAOCliente();  

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}


	public static Quentinha cadastrarQuentinha(String descricao) throws Exception {
		DAO.begin();
		Quentinha quen = daoquentinha.buscarPorDescricao(descricao);
		if(quen!=null) 
			throw new Exception ("Quentinha ja cadastrada!");
		
		quen = new Quentinha(descricao);
		daoquentinha.create(quen);
		DAO.commit();
		return quen;
	}

	public static Pedido cadastrarPedido(int idCliente, int idQuentinha, String tamanho, String data) throws Exception{
		DAO.begin();
		Quentinha quen =  daoquentinha.read(idQuentinha);
		if(quen==null) 
			throw new Exception ("Quentinha inexistente!");

		Cliente cli = daocliente.read(idCliente);
		if(cli==null) 
			throw new Exception ("Cliente inexistente!");

		Pedido ped = new Pedido(cli, quen, tamanho, data);
		daopedido.create(ped);
		daoquentinha.update(quen);
		daocliente.update(cli);
		DAO.commit();
		return ped;
	}

	public static void excluirPedido(int id) throws Exception{
		DAO.begin();
		Pedido ped =  daopedido.read(id);
		if(ped==null) 
			throw new Exception ("Pedido inexistente!");

		Cliente cli = ped.getCliente();
		Quentinha quen = ped.getQuentinha();
		cli.delPedido(ped);
		quen.delPedido(ped);
		
		daocliente.update(cli);
		daoquentinha.update(quen);
		daopedido.delete(ped);
		DAO.commit();
	}

	public static void excluirQuentinha(int id) throws Exception{
		DAO.begin();
		Quentinha quen = daoquentinha.read(id);
		if(quen==null) 
			throw new Exception ("Quentinha inexistente!");

		daoquentinha.delete(quen);
		DAO.commit();
	}

	public static Cliente cadastrarCliente(String nome, String telefone) throws Exception{
		DAO.begin();
		Cliente cli = daocliente.buscarPorTelefone(telefone);
		if (cli!=null)
			throw new Exception("Cliente ja cadastrado!");
		
		cli = new Cliente(nome, telefone);

		daocliente.create(cli);
		DAO.commit();
		return cli;
	}
	
	public static void excluirCliente(String id) throws Exception{
		DAO.begin();
		Cliente cli = daocliente.read(id);
		if(cli==null) 
			throw new Exception ("Cliente inexistente!");

		daocliente.delete(cli);;
		DAO.commit();
	}

	public static List<Cliente>  listarClientes(){
		DAO.begin();
		List<Cliente> resultados =  daocliente.readAll();
		DAO.commit();
		return resultados;
	} 

	public static List<Quentinha>  listarQuentinhas(){
		DAO.begin();
		List<Quentinha> resultados =  daoquentinha.readAll();
		DAO.commit();
		return resultados;
	}

	public static List<Pedido> listarPedidos(){
		DAO.begin();
		List<Pedido> resultados =  daopedido.readAll();
		DAO.commit();
		return resultados;
	}

	public static List<Cliente> clientesComMaisDeNPedidos(int n){	
		DAO.begin();
		List<Cliente> resultados =  daocliente.clientesComMaisDeNPedidos(n);
		DAO.commit();
		return resultados;
	}
	
	public static List<Quentinha> consultarQuentinhasPedidas(int idCliente){	
		DAO.begin();
		List<Quentinha> resultados =  daocliente.consultarQuentinhasPedidas(idCliente);
		DAO.commit();
		return resultados;
	}

	public static List<Quentinha> quentinhasPedidasMaisDeNVezes(int n){	
		DAO.begin();
		List<Quentinha> resultados =  daoquentinha.quentinhasPedidasMaisDeNVezes(n);
		DAO.commit();
		return resultados;
	}

	public static List<Pedido> pedidosNaDataX(String data){	
		DAO.begin();
		List<Pedido> resultados =  daopedido.pedidosNaDataX(data);
		DAO.commit();
		return resultados;
	}
	
	public static List<Pedido> pedidosDeTamanhoX(String tamanho){
		DAO.begin();
		List<Pedido> resultados =  daopedido.pedidosDeTamanhoX(tamanho);
		DAO.commit();
		return resultados;
	}

	public static Quentinha localizarQuentinha(int id){
		return daoquentinha.read(id);
	}
	
	public static Cliente localizarCliente(int id){
		return daocliente.read(id);
	}
	
	public static Pedido localizarPedido(int id){
		return daopedido.read(id);
	}
}