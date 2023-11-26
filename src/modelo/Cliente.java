package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String telefone;
	@OneToMany(mappedBy = "cliente", cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.LAZY)
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {};
	
	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String novoTelefone) {
		this.telefone = novoTelefone;
	}

	// Retorna um pedido especifico ao inves de toda lista de pedido
	// Caso o pedido nao exista, retorna nulo
	public Pedido getPedido(int id) {
		for (Pedido p : pedidos) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	//Retorna o array pedidos
	public List<Pedido> getListaPedidos() {
		return pedidos;
	}

	// Adiciona o pedido apenas se ele ainda nao se encontrava na lista
	public void addPedido(Pedido pedido) {
		if (!pedidos.contains(pedido)) {
			pedidos.add(pedido);
		}
	}

	// Remove o pedido apenas se ele estiver na lista
	public void delPedido(Pedido pedido) {
		if (pedidos.contains(pedido)) {
			pedidos.remove(pedido);
		}
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Cliente: " + id + ", Nome: " + nome + ", Telefone: " + telefone + ", Total pedidos: " + pedidos.size();
	}
}
