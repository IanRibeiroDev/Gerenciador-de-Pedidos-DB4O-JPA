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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Quentinha;
import regras_negocio.Fachada;

public class TelaCliente {
	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCadastrarCliente;
	private JButton button_2;
	private JLabel label;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblResultados;

	private JButton button_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente tela = new TelaCliente();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCliente() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.setModal(true);
		frame.setResizable(false);
		frame.setTitle("Cliente");
		frame.setBounds(100, 100, 729, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Fachada.inicializar();
				listagem();
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
		table.setBackground(new Color(209, 254, 214));
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
		label.setBounds(47, 315, 688, 14);
		frame.getContentPane().add(label);

		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultados.setBounds(31, 196, 431, 14);
		frame.getContentPane().add(lblResultados);

		lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(21, 274, 71, 14);
		frame.getContentPane().add(lblNome);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(68, 264, 195, 34);
		frame.getContentPane().add(textField);

		btnCadastrarCliente = new JButton("Cadastrar cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
						label.setText("Campo vazio");
						return;
					}
	
					String nome = textField.getText();
					String telefone = textField_1.getText().replaceAll("[^0-9]", "");
					if (telefone.length()<8) {
						label.setText("O telefone precisa ter pelo menos 8 dígitos.");
						return;
					}
					
					Fachada.cadastrarCliente(nome, telefone);
					textField.setText("");
					textField_1.setText("");
					label.setText("Ciente cadastrado: "+ nome);
					listagem();
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrarCliente.setBounds(526, 264, 169, 34);
		frame.getContentPane().add(btnCadastrarCliente);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefone.setBounds(273, 274, 125, 14);
		frame.getContentPane().add(lblTelefone);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(348, 264, 168, 34);
		frame.getContentPane().add(textField_1);

		button_2 = new JButton("Excluir cliente");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0){	
						int id = (int) table.getValueAt( table.getSelectedRow(), 0);
						
						Fachada.excluirCliente(id);
						label.setText("Cliente excluído");
						textField.setText("");
						textField_1.setText("");
						listagem();
					}
					else
						label.setText("Nao selecionado");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 12));
		button_2.setBounds(345, 220, 171, 34);
		frame.getContentPane().add(button_2);

		button_3 = new JButton("Exibir pedidos de cliente selecionado");
		button_3.setFont(new Font("Arial", Font.PLAIN, 12));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0){	
						int id = (int) table.getValueAt( table.getSelectedRow(), 0);
						
						Cliente cliente = Fachada.localizarCliente(id);

						if(cliente !=  null) {
							String texto= "";
							if(cliente.getListaPedidos().size()==0)
								texto = "Nao possui pedidos";
							else {
								List<Quentinha> quentinhasPedidas = Fachada.consultarQuentinhasPedidasPorCliente(id);
								
								for  (Quentinha quentinha : quentinhasPedidas) {
						                texto += "ID do Pedido: " + quentinha.getId() + "\n";
						                texto += "Descrição: " + quentinha.getDescricao()+ "\n";
						                texto += "\n";
						            }	
							}
							
							JOptionPane.showMessageDialog(frame, texto);
						}
					}
				}
				catch(Exception erro) {
					label.setText(erro.getMessage());
				}
			}
		});
		button_3.setBounds(68, 220, 267, 34);
		frame.getContentPane().add(button_3);
		
		JButton btnAlterarCliente = new JButton("Alterar cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0) {
						int idCliente = (int) table.getValueAt( table.getSelectedRow(), 0);
						
						String nome = textField.getText();
						String telefone = textField_1.getText().replaceAll("[^0-9]", "");;
						
						
						//Caso em que tanto o telefone quandoo nome serão alterados
						if(nome != "" && telefone != "") {				
							if (telefone.length()<8) {
								label.setText("O telefone precisa ter pelo menos 8 dígitos.");
								return;
							}
							
							Fachada.alterarNomeCliente(idCliente, nome);
							Fachada.alterarTelefoneCliente(idCliente, telefone);
							textField.setText("");
							textField_1.setText("");
							label.setText("Cliente alterado");
							listagem();
						}
						
						//Apenas nome será alterado
						if(nome != "") {
							Fachada.alterarNomeCliente(idCliente, nome);
							textField.setText("");
							label.setText("Cliente alterado");
							listagem();
						}
						
						//Apenas telefone será alterado
						if(telefone != "") {				
							if (telefone.length()<8) {
								label.setText("O telefone precisa ter pelo menos 8 dígitos.");
								return;
							}
							Fachada.alterarTelefoneCliente(idCliente, telefone);
							textField_1.setText("");
							label.setText("Cliente alterado");
							listagem();
						}
						
						if(nome == "" && telefone == "") {
							label.setText("Nada definido para alterar");
							return;
						}		
				}
				else
					label.setText("Nao selecionado");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		btnAlterarCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterarCliente.setBounds(525, 220, 170, 35);
		frame.getContentPane().add(btnAlterarCliente);
	}

	public void listagem() {
		try{
			List<Cliente> lista = Fachada.listarClientes();

			// model armazena todas as linhas e colunas do table
			DefaultTableModel model = new DefaultTableModel();

			//adicionar colunas no model
			model.addColumn("CPF");
			model.addColumn("Nome");
			model.addColumn("Telefone");
			
		    // Define a tabela como não editável
	        table.setDefaultEditor(Object.class, null);

			//adicionar linhas no model
			for(Cliente cli : lista) {
				model.addRow(new Object[]{cli.getId(), cli.getNome(),cli.getTelefone()} );
			}

			//atualizar model no table (visualizacao)
			table.setModel(model);

			lblResultados.setText("resultados: "+lista.size()+ " objetos");
		}
		catch(Exception erro){
			label.setText(erro.getMessage());
		}
	}
}
