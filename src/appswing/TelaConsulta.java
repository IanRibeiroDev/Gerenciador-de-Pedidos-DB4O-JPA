/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */
package appswing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.db4o.ObjectContainer;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;
import regras_negocio.Fachada;

public class TelaConsulta {
	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button;
	private JLabel label;
	private JLabel lblResultados;

	private ObjectContainer manager;
	private JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta tela = new TelaConsulta();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsulta() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setResizable(false);
		frame.setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setModal(true);
		frame.setTitle("Consulta");
		frame.setBounds(100, 100, 729, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Fachada.inicializar();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 43, 674, 148);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblResultados.setText("selecionado="+ (String) table.getValueAt( table.getSelectedRow(), 0));
			}
		});
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(new Color(204, 204, 255));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		label = new JLabel("");		//label de mensagem
		label.setForeground(Color.BLUE);
		label.setBounds(21, 321, 688, 14);
		frame.getContentPane().add(label);

		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultados.setBounds(31, 201, 431, 14);
		frame.getContentPane().add(lblResultados);

		button = new JButton("Consultar");
		button.setFont(new Font("Arial", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				if(index<0)
					lblResultados.setText("Consulta nao selecionada");
				else
					switch(index) {
					case 0:
						try {
							int nPedidos = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero: "));							
							List<Cliente> resultado1 = Fachada.clientesComMaisDeNPedidos(nPedidos);
							listagemCliente(resultado1);
							break;		
						} catch (NumberFormatException e1) {
						    lblResultados.setText("Digite apenas números");
						    break;
						} catch (Exception e1) {
						    lblResultados.setText(e1.getMessage());
						    break;
						}
					case 1: 
						try {
							int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Cliente: "));
							List<Quentinha> resultado2;
							resultado2 = Fachada.consultarQuentinhasPedidasPorCliente(idCliente);
							listagemQuentinhas(resultado2);
							break;
						} catch (NumberFormatException e1) {
						    lblResultados.setText("Digite apenas números");
						    break;
						} catch (Exception e1) {
						    lblResultados.setText(e1.getMessage());
						    break;
						}
					case 2: 
						try {
							int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero: "));
							List<Quentinha> resultado3 = Fachada.quentinhasPedidasMaisDeNVezes(numero);
							listagemQuentinhas(resultado3);
							break;
						} catch (NumberFormatException e1) {
						    lblResultados.setText("Digite apenas números");
						    break;
						} catch (Exception e1) {
						    lblResultados.setText(e1.getMessage());
						    break;
						}
					case 3:
						try {
							String data = JOptionPane.showInputDialog("Digite a data (AAAA-MM-DD):");
							List<Pedido> resultado4 = Fachada.pedidosNaDataX(data);
							listagemPedidos(resultado4);
							break;
						} catch (Exception e1) {
							lblResultados.setText(e1.getMessage());
							break;
						}
					case 4: 
						try {
							String tamanho = JOptionPane.showInputDialog("Digite o tamanho: ").toUpperCase();
							List<Pedido> resultado5 = Fachada.pedidosDeTamanhoX(tamanho);
							listagemPedidos(resultado5);
							break;
						} catch (Exception e1) {
							lblResultados.setText(e1.getMessage());
							break;
						}
					}
			}
		});
		button.setBounds(544, 10, 151, 23);
		frame.getContentPane().add(button);
		

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setToolTipText("selecione a consulta");
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Clientes com mais de N pedidos", "Quentinhas pedidas por determinado cliente", "Quentinhas pedidas mais de N vezes","Pedidos feitos em uma data","Pedidos de um tamanho"}));
		comboBox.setBounds(21, 10, 513, 22);
		frame.getContentPane().add(comboBox);
	}
	
	public void listagemCliente(List<Cliente> lista) {
		try{
			// model armazena todas as linhas e colunas do table
			DefaultTableModel model = new DefaultTableModel();

			//adicionar colunas no model
			model.addColumn("Id Cliente");
			model.addColumn("Nome");
			model.addColumn("Telefone");

			//adicionar linhas no model
			for(Cliente cli : lista) {
				model.addRow(new Object[]{cli.getId(),cli.getNome(),cli.getTelefone()} );
			}
			//atualizar model no table (visualizacao)
			table.setModel(model);

			lblResultados.setText("resultados: "+lista.size()+ " objetos");
		}
		catch(Exception erro){
			label.setText(erro.getMessage());
		}
	}
	
	public void listagemQuentinhas(List<Quentinha> lista) {
		try{
			// model armazena todas as linhas e colunas do table
			DefaultTableModel model = new DefaultTableModel();

			//adicionar colunas no model
			model.addColumn("Id Quentinha");
			model.addColumn("Descrição");
			model.addColumn("N vezes pedida");

			//adicionar linhas no model
			for(Quentinha que : lista) {
				model.addRow(new Object[]{que.getId(),que.getDescricao(),que.getVezesPedida()});
			}
			//atualizar model no table (visualizacao)
			table.setModel(model);

			lblResultados.setText("Resultados: "+lista.size()+ " objetos");
		}
		catch(Exception erro){
			label.setText(erro.getMessage());
		}
	}
	
	public void listagemPedidos(List<Pedido> lista) {
		try{
			// o model armazena todas as linhas e colunas do table
			DefaultTableModel model = new DefaultTableModel();

			//adicionar colunas no model
			model.addColumn("ID");
			//model.addColumn("Cliente");
			//pedido.getCliente().getNome(),
			model.addColumn("Quentinha-Descrição");
			model.addColumn("Data");

			//adicionar linhas no model
			for(Pedido pedido : lista) {
				model.addRow(new Object[] {pedido.getId(), pedido.getQuentinha(),pedido.getData() });
			}
			//atualizar model no table (visualizacao)
			table.setModel(model);

			lblResultados.setText("Resultados: "+lista.size()+ " objetos");
		}
		catch(Exception erro){
			label.setText(erro.getMessage());
		}
	}


}
