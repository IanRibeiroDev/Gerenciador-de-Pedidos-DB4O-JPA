package appswing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

import regras_negocio.Fachada;

public class TelaPrincipal {
	private JFrame frame;
	private JMenu mnQuentinha;
	private JMenu mnCliente;
	private JMenu mnPedido;
	private JMenu mnConsulta;
	private JLabel lblSistemaDeQuentinhas;
	
	



	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPrincipal window = new TelaPrincipal();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
		frame.setTitle("Quentinha - cliente: "+ Fachada.logado.getNome());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(254, 221, 171));
		frame.setResizable(false);
		frame.setTitle("Restaurante");
		frame.setBounds(100, 100, 450, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblSistemaDeQuentinhas = new JLabel("");
		lblSistemaDeQuentinhas.setFont(new Font("Arial", Font.PLAIN, 26));
		lblSistemaDeQuentinhas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDeQuentinhas.setText("Inicializando...");
		lblSistemaDeQuentinhas.setBounds(10, 53, 426, 188);
		//label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		ImageIcon imagem = new ImageIcon(getClass().getResource("/img/almoco.png"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(lblSistemaDeQuentinhas.getWidth(),lblSistemaDeQuentinhas.getHeight(), Image.SCALE_DEFAULT));//		label.setIcon(fotos);
		lblSistemaDeQuentinhas.setIcon(imagem);
		frame.getContentPane().add(lblSistemaDeQuentinhas);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnQuentinha = new JMenu("Quentinha");
		mnQuentinha.setFont(new Font("Arial", Font.PLAIN, 12));
		mnQuentinha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaQuentinha tela = new TelaQuentinha();
			}
		});
		menuBar.add(mnQuentinha);

		mnCliente = new JMenu("Cliente");
		mnCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCliente tela = new TelaCliente();
			}
		});
		menuBar.add(mnCliente);
		
		mnPedido = new JMenu("Pedido");
		mnPedido.setFont(new Font("Arial", Font.PLAIN, 12));
		mnPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPedido tela = new TelaPedido();
			}
		});
		menuBar.add(mnPedido);
		
		mnConsulta = new JMenu("Consultas");
		mnConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaConsulta tela = new TelaConsulta();
			}
		});
		menuBar.add(mnConsulta);
	}
}
