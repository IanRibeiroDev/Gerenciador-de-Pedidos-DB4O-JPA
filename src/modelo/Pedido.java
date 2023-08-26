package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Quentinha quentinha;
	private String tamanho;
	private String data;

	public Pedido(int id, Cliente cliente, Quentinha quentinha, String tamanho, LocalDateTime data) {
		this.id = id;
		this.cliente = cliente;
		this.quentinha = quentinha;
		this.tamanho = tamanho;

		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = data.format(formatoData);
		this.data = dataFormatada;

		this.criarRelacionamento(cliente, quentinha);
	}

	private void criarRelacionamento(Cliente cliente, Quentinha quentinha) {
		cliente.addPedido(this);
		quentinha.addPedido(this);
	}

	public Quentinha getQuentinha() {
		return quentinha;
	}

	public void setQuentinha(Quentinha quentinha) {
		this.quentinha.delPedido(this); // Remove relacionamento da quentinha antiga
		this.quentinha = quentinha; // Adiciona nova quentinha
		this.quentinha.addPedido(this); // Adiciona relacionamento na nova quentinha
	}

	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String novoTamanho) {
		this.tamanho = novoTamanho;
	}

	public String getData() {
		return data;
	}

	public String toString() {
		return "Pedido: " + id + ", Tamanho: " + tamanho + ", Data: " + data + "\nCliente " + cliente.getId()
				+ " de nome " + cliente.getNome() + " pediu quentinha " + quentinha.getId() + " de descricao "
				+ quentinha.getDescricao() + ".";
	}
}
