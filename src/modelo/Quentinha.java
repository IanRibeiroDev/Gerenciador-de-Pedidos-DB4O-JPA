package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Quentinha {
	@Id
	private int id;
	private String descricao;
	@OneToMany(mappedBy = "quentinha", cascade={CascadeType.PERSIST, CascadeType.MERGE}, 
			fetch = FetchType.LAZY)
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Quentinha() {};
	
	public Quentinha(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
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

	public int getVezesPedida() {
		return pedidos.size();
	}
	
	//Retorna o array pedidos
	public List<Pedido> getListaPedidos() {
		return pedidos;
	}
	
	public String toString() {
		return "Quentinha: " + id + ", Descricao: (" + descricao + "), Vezes pedida: " + pedidos.size();
	}
}
