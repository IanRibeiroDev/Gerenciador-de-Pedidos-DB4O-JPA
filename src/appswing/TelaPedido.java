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
import javax.swing.JPanel;

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
	private JLabel lblResultados;
	private JSpinner spinner;
	private JSpinner spinner_1;
	

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
		frame.setFont(new Font("Arial", Font.PLAIN, 12));
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
				lblResultados.setText("selecionado="+ (int) table.getValueAt( table.getSelectedRow(), 0));
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
		label.setBounds(12, 355, 688, 14);
		frame.getContentPane().add(label);

		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultados.setBounds(31, 201, 431, 14);
		frame.getContentPane().add(lblResultados);

		lblIdDoCliente = new JLabel("Id do Cliente:");
		lblIdDoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdDoCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdDoCliente.setBounds(47, 263, 114, 26);
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
					String tamanho = textField_2.getText().toUpperCase();
					
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
		button_1.setFont(new Font("Arial", Font.PLAIN, 14));
		button_1.setBounds(384, 309, 179, 37);
		frame.getContentPane().add(button_1);

		lblQuent = new JLabel("Id Quentinha:");
		lblQuent.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuent.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuent.setBounds(235, 258, 101, 36);
		frame.getContentPane().add(lblQuent);

		btnApagarPedido = new JButton("Apagar pedido selecionado");
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
		btnApagarPedido.setFont(new Font("Arial", Font.PLAIN, 14));
		btnApagarPedido.setBounds(255, 213, 251, 36);
		frame.getContentPane().add(btnApagarPedido);


		textField_2 = new JTextField();
		textField_2.setBounds(560, 266, 82, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(47, 308, 1, 16);
		frame.getContentPane().add(textPane);

		lblTamanho = new JLabel("Tamanho (P,M ou G):");
		lblTamanho.setFont(new Font("Arial", Font.BOLD, 14));
		lblTamanho.setBounds(406, 268, 189, 16);
		frame.getContentPane().add(lblTamanho);
		
		spinner = new JSpinner();
		spinner.setBounds(150, 265, 45, 26);
		frame.getContentPane().add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(333, 265, 40, 25);
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
					label.setText("Não selecionado");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		button_1_1.setBounds(160, 310, 179, 35);
		frame.getContentPane().add(button_1_1);
	}

	public void listagem() {
		try{
			List<Pedido> lista = Fachada.listarPedidos();


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
			for(Pedido ped : lista) {
				model.addRow(new Object[]{ped.getId(),ped.getData(),ped.getQuentinha().getId() + " : " + ped.getQuentinha().getDescricao(),ped.getTamanho(),ped.getCliente().getId() + " : " + ped.getCliente().getNome()} );
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
