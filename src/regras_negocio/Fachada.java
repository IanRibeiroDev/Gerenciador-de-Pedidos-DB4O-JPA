package regras_negocio;

import java.util.ArrayList;
import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOCliente;
import daodb4o.DAOPedido;
import daodb4o.DAOQuentinha;
import daodb4o.DAOUsuario;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;
import modelo.Usuario;

public class Fachada {
	private Fachada() {}

	private static DAOQuentinha daoquentinha = new DAOQuentinha();  
	private static DAOPedido daopedido = new DAOPedido(); 
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOUsuario daousuario = new DAOUsuario(); 
	public static Usuario logado;	//contem o objeto Usuario logado em TelaLogin.java

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
			throw new Exception ("Quentinha com descricao identica ja esta cadastrada no banco!");
		
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
			throw new Exception("Telefone associado a outro cliente! Informe um telefone ainda nao cadastrado.");
		
		cli = new Cliente(nome, telefone);

		daocliente.create(cli);
		DAO.commit();
		return cli;
	}
	
	public static void excluirCliente(int id) throws Exception{
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
	
	public static List<Quentinha> consultarQuentinhasPedidasPorCliente(int idCliente) throws Exception{	
		DAO.begin();
		Cliente cli =  daocliente.read(idCliente);
		if(cli==null)
			throw new Exception ("Cliente inexistente!");
		
		List<Pedido> pedidos = cli.getListaPedidos();
		List<Quentinha> quentinhasPedidas = new ArrayList<>();
		
		for(Pedido ped : pedidos)
			if(!quentinhasPedidas.contains(ped.getQuentinha()))
				quentinhasPedidas.add(ped.getQuentinha());
		
		DAO.commit();
		return quentinhasPedidas;
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
	
	//Alterar nome e telefone -- Cliente
	//Alterar descricao -- Quentinha
	//Alterar quentinha e tamanho -- Pedido
	
	public static Cliente alterarNomeCliente(int id, String novoNome) throws Exception {
		DAO.begin();
		Cliente cli =  daocliente.read(id);
		if(cli==null)
			throw new Exception ("Cliente inexistente!");
		
		cli.setNome(novoNome);
		daocliente.update(cli);
		DAO.commit();
		return cli;
	}
	
	public static Cliente alterarTelefoneCliente(int id, String novoTelefone) throws Exception {
		DAO.begin();
		Cliente cli =  daocliente.read(id);
		if(cli==null)
			throw new Exception ("Cliente inexistente!");
		
		Cliente telefone = daocliente.buscarPorTelefone(novoTelefone);
		if(telefone!=null)
			throw new Exception("Telefone associado a outro cliente! Informe um telefone ainda nao cadastrado.");
		
		cli.setTelefone(novoTelefone);
		daocliente.update(cli);
		DAO.commit();
		return cli;
	}
	
	public static Quentinha alterarDescricaoQuentinha(int id, String novaDescricao) throws Exception {
		DAO.begin();
		Quentinha quen = daoquentinha.read(id);
		if(quen==null)
			throw new Exception ("Quentinha inexistente!");
		
		Quentinha descricao = daoquentinha.buscarPorDescricao(novaDescricao);
		if(descricao!=null)
			throw new Exception ("Quentinha com descricao identica ja esta cadastrada no banco!");
		
		quen.setDescricao(novaDescricao);
		daoquentinha.update(quen);
		DAO.commit();
		return quen;
	}
	
	public static Pedido alterarTamanhoPedido(int id, String novoTamanho) throws Exception {
		DAO.begin();
		Pedido ped = daopedido.read(id);
		if(ped==null)
			throw new Exception ("Pedido inexistente!");
		
		ped.setTamanho(novoTamanho);
		daopedido.update(ped);
		DAO.commit();
		return ped;
	}
	
	public static Pedido alterarQuentinhaPedido(int idPedido, int idNovaQuentinha) throws Exception {
		DAO.begin();
		Pedido ped = daopedido.read(idPedido);
		if(ped==null)
			throw new Exception ("Pedido inexistente!");
		
		Quentinha novaQuen = daoquentinha.read(idNovaQuentinha);
		if(novaQuen==null)
			throw new Exception ("Quentinha inexistente!");
		
		Quentinha antigaQuen = ped.getQuentinha();
		ped.setQuentinha(novaQuen);
		daopedido.update(ped);
		daoquentinha.update(antigaQuen);
		DAO.commit();
		return ped;
	}
	
	//------------------Usuario------------------------------------
	public static Usuario cadastrarUsuario(String nome, String senha) throws Exception{
		DAO.begin();
		Usuario usu = daousuario.read(nome);
		if (usu!=null)
			throw new Exception("Usuario ja cadastrado:" + nome);
		usu = new Usuario(nome, senha);

		daousuario.create(usu);
		DAO.commit();
		return usu;
	}
	public static Usuario localizarUsuario(String nome, String senha) {
		Usuario usu = daousuario.read(nome);
		if (usu==null)
			return null;
		if (! usu.getSenha().equals(senha))
			return null;
		return usu;
	}
	
}