package appswing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Usuario;
import regras_negocio.Fachada;

public class TelaLogin {

	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_2;
	private JButton btnEntrar;
	private final JButton btnCadastrar = new JButton("Cadastrar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.setTitle("Login");
		frame.setBounds(100, 100, 248, 215);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Fachada.inicializar();
				if(Fachada.localizarUsuario("adm", "1234")== null) {
					try {
						Fachada.cadastrarUsuario("adm", "1234");
						label_2.setText("Usuario adm cadastrado");
					}
					catch(Exception ex) {
						label_2.setText("Nao conseguiu criar usuario");
					}
				}
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Fachada.finalizar();
			}
		});

		label = new JLabel("Usuário");
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(10, 33, 66, 14);
		frame.getContentPane().add(label);
		label_1 = new JLabel("Senha");
		label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(10, 65, 46, 14);
		frame.getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(86, 30, 138, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(86, 62, 138, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		label_2 = new JLabel("");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(24, 151, 198, 14);
		frame.getContentPane().add(label_2);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String senha = textField_1.getText();

				Usuario usu = Fachada.localizarUsuario(nome,senha);

				if(usu!=null) {
					Fachada.logado = usu;
					TelaPrincipal tela = new TelaPrincipal();
					frame.dispose();
				}
				else {
					label_2.setText("Usuario ou senha incorreto");
				}
			}});
		btnEntrar.setBounds(10, 96, 100, 23);
		frame.getContentPane().add(btnEntrar);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
	
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String senha = textField_1.getText();
				if(Fachada.localizarUsuario(nome,senha)!=null) {
					label_2.setText("Usuario já cadastrado");
				}
				else
					try {
						Fachada.cadastrarUsuario(nome, senha);
						label_2.setText("Usuario " + nome +" cadastrado");
					}
					catch(Exception ex) {
						label_2.setText("Nao conseguiu criar usuario");
					}
			}
		});
		btnCadastrar.setBounds(116, 96, 108, 23);
		frame.getContentPane().add(btnCadastrar);
	}
}
