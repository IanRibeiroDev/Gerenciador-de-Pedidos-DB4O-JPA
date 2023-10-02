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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Pedido;
import regras_negocio.Fachada;

public class TelaPedido {
	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_2;
	private JButton button_1;
	private JButton btnApagarPedido;
	private JLabel label;
	private JLabel lblIdDoCliente;
	private JLabel lblQuent;
	private JLabel lblTamanho;
	private JLabel label_6;
	private JSpinner spinner;
	private JSpinner spinner_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedido tela = new TelaPedido();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPedido() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setModal(true);
		frame.setResizable(false);
		frame.setTitle("Pedido");
		frame.setBounds(100, 100, 729, 419);
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
				label_6.setText("selecionado="+ (int) table.getValueAt( table.getSelectedRow(), 0));
			}
		});
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(new Color(144, 238, 144));
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
		label.setBounds(12, 355, 688, 14);
		frame.getContentPane().add(label);

		label_6 = new JLabel("resultados:");
		label_6.setBounds(21, 190, 431, 14);
		frame.getContentPane().add(label_6);

		lblIdDoCliente = new JLabel("Id do Cliente:");
		lblIdDoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdDoCliente.setBounds(56, 269, 89, 14);
		frame.getContentPane().add(lblIdDoCliente);

		button_1 = new JButton("Criar novo pedido");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if((int)spinner.getValue() == 0 || (int)spinner_1.getValue() == 0 || textField_2.getText().isEmpty()) {
						label.setText("Campo vazio");
						return;
					}
					
					if (!textField_2.getText().toUpperCase().equals("P") && !textField_2.getText().toUpperCase().equals("M") && !textField_2.getText().toUpperCase().equals("G")) {
					    label.setText("Tamanho precisa ser P, M ou G");
					    return;
					}
					int idCliente = (int)spinner.getValue();
					int idQuentinha = (int)spinner_1.getValue();
					String tamanho = textField_2.getText();
					
			        // Obtém a data e hora atual
			        LocalDateTime dateTime = LocalDateTime.now();
			        // Cria um formato de data e hora
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
			        // Converte a data e hora em uma string usando o formato
			        String dataHoraFormatada = dateTime.format(formatter);

					Fachada.cadastrarPedido(idCliente, idQuentinha, tamanho, dataHoraFormatada);
					label.setText("Pedido cadastrado");
					listagem();
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(379, 322, 153, 23);
		frame.getContentPane().add(button_1);

		lblQuent = new JLabel("Id Quentinha:");
		lblQuent.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuent.setBounds(200, 269, 101, 14);
		frame.getContentPane().add(lblQuent);

		btnApagarPedido = new JButton("Apagar pedido");
		btnApagarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0) {	
						int idPedido = (int) table.getValueAt( table.getSelectedRow(), 0);

						Fachada.excluirPedido(idPedido);
						label.setText("Pedido deletado");
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
		btnApagarPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnApagarPedido.setBounds(259, 214, 206, 23);
		frame.getContentPane().add(btnApagarPedido);


		textField_2 = new JTextField();
		textField_2.setBounds(459, 257, 130, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(47, 308, 1, 16);
		frame.getContentPane().add(textPane);

		lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTamanho.setBounds(392, 268, 89, 16);
		frame.getContentPane().add(lblTamanho);
		
		spinner = new JSpinner();
		spinner.setBounds(145, 268, 30, 20);
		frame.getContentPane().add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(296, 268, 30, 20);
		frame.getContentPane().add(spinner_1);
		
		JButton button_1_1 = new JButton("Alterar pedido");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0) {
						int idPedido = (int) table.getValueAt( table.getSelectedRow(), 0);
						
						//Caso em que tanto o tamanho quando a quentinha serão alterados
						if((int)spinner_1.getValue() != 0 && !textField_2.getText().isEmpty()) {				
							if (!textField_2.getText().toUpperCase().equals("P") && !textField_2.getText().toUpperCase().equals("M") && !textField_2.getText().toUpperCase().equals("G")) {
								 label.setText("Tamanho precisa ser P, M ou G");  
								 return;
							}
							int idQuentinha = (int)spinner_1.getValue();
							String tamanho = textField_2.getText().toUpperCase();
							
							Fachada.alterarQuentinhaPedido(idPedido, idQuentinha);
							Fachada.alterarTamanhoPedido(idPedido, tamanho);
							label.setText("Pedido alterado");
							listagem();
						}
						
						//Apenas quentinha será alterada
						if((int)spinner_1.getValue() != 0) {
							int idQuentinha = (int)spinner_1.getValue();
							Fachada.alterarQuentinhaPedido(idPedido, idQuentinha);
							label.setText("Pedido alterado");
							listagem();
						}
						
						//Apenas tamanho será alterado
						if(!textField_2.getText().isEmpty()) {				
							if (!textField_2.getText().toUpperCase().equals("P") && !textField_2.getText().toUpperCase().equals("M") && !textField_2.getText().toUpperCase().equals("G")) {
								 label.setText("Tamanho precisa ser P, M ou G");  
								 return;
							}	
							String tamanho = textField_2.getText().toUpperCase();
							Fachada.alterarTamanhoPedido(idPedido, tamanho);	
							label.setText("Pedido alterado");
							listagem();
						}
						
						if((int)spinner_1.getValue() == 0 && textField_2.getText().isEmpty()) {
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
		button_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1_1.setBounds(173, 322, 153, 23);
		frame.getContentPane().add(button_1_1);
	}

	public void listagem() {
		try{
			//ler os carros do banco
			List<Pedido> lista = Fachada.listarPedidos();

			// o model armazena todas as linhas e colunas do table
			DefaultTableModel model = new DefaultTableModel();

			//adicionar colunas no model
			model.addColumn("ID");
			model.addColumn("Data");
			model.addColumn("Quentinha");
			model.addColumn("Tamanho");
			model.addColumn("Cliente");
			
		    // Define a tabela como não editável
	        table.setDefaultEditor(Object.class, null);

			//adicionar linhas no model
			for(Pedido pedido : lista) {
				model.addRow(new Object[]{pedido.getId(),pedido.getData(),pedido.getQuentinha(),pedido.getTamanho(),pedido.getCliente()});
			}

			//atualizar model no table (visualizacao)
			table.setModel(model);

			label_6.setText("resultados: "+lista.size()+ " objetos");
		}
		catch(Exception erro){
			label.setText(erro.getMessage());
		}
	}
}
