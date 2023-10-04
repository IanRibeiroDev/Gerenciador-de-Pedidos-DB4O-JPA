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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Quentinha;
import regras_negocio.Fachada;

public class TelaQuentinha {
	private JDialog frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JButton button_1;
	private JButton button_2;
	private JLabel label;
	private JLabel lblDescrio;
	private JLabel lblResultados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 TelaQuentinha tela = new TelaQuentinha();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public  TelaQuentinha() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setModal(true);
		frame.setResizable(false);
		frame.setTitle("Quentinha");
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
		label.setBounds(21, 321, 688, 14);
		frame.getContentPane().add(label);

		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultados.setBounds(31, 191, 431, 14);
		frame.getContentPane().add(lblResultados);

		lblDescrio = new JLabel("Descrição:");
		lblDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(35, 255, 80, 42);
		frame.getContentPane().add(lblDescrio);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(114, 261, 198, 31);
		frame.getContentPane().add(textField);

		button_1 = new JButton("Criar nova quentinha");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().isEmpty()) {
						label.setText("campo vazio");
						return;
					}
					String descricao = textField.getText();
					Fachada.cadastrarQuentinha(descricao);
					label.setText("Quentinha criada: "+ descricao);
					listagem();
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 14));
		button_1.setBounds(519, 258, 176, 37);
		frame.getContentPane().add(button_1);

		button_2 = new JButton("Apagar selecionada");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0){	
						label.setText("nao implementado " );
						int id = (int) table.getValueAt( table.getSelectedRow(), 0);

						Fachada.excluirQuentinha(id);
						label.setText("Quentinha apagada");
						listagem();
					}
					else
						label.setText("Nao selecionada");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 14));
		button_2.setBounds(268, 201, 184, 37);
		frame.getContentPane().add(button_2);
		

		
		JButton button_2_1 = new JButton("Editar selecionada");
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (table.getSelectedRow() >= 0){	
						label.setText("nao implementado " );
						int id = (int) table.getValueAt( table.getSelectedRow(), 0);
						
						if(textField.getText().isEmpty()) {
							label.setText("campo vazio");
							return;
						}
						String novaDescricao = textField.getText();
						Fachada.alterarDescricaoQuentinha(id, novaDescricao);
						label.setText("Quentinha renomeada: "+  novaDescricao);
						textField.setText("");
						listagem();
					}
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
				
			}
		});
		button_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		button_2_1.setBounds(335, 258, 171, 37);
		frame.getContentPane().add(button_2_1);
	}

	public void listagem() {
		try{
			List<Quentinha> lista = Fachada.listarQuentinhas();

			// model armazena todas as linhas e colunas do table
			DefaultTableModel model = new DefaultTableModel();

			//adicionar colunas no model
			model.addColumn("ID");
			model.addColumn("Descrição");
			model.addColumn("Qtd de vezes pedida");
			
		    // Define a tabela como não editável
	        table.setDefaultEditor(Object.class, null);

			//adicionar linhas no model
			for(Quentinha q : lista) {
				model.addRow(new Object[]{q.getId(), q.getDescricao(),q.getVezesPedida()} );
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
