package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ent.Seguridad.SEG_UsuarioEnt;
import com.log.Seguridad.SEG_UsuarioLog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPAssword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(57, 54, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(129, 51, 159, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(57, 98, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPAssword = new JTextField();
		txtPAssword.setBounds(129, 95, 159, 20);
		contentPane.add(txtPAssword);
		txtPAssword.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SEG_UsuarioEnt u = SEG_UsuarioLog.Instancia().VerificarAcceso(
							txtUsuario.getText(), 
							txtPAssword.getText());
					JOptionPane.showMessageDialog(null, 
							"Bienvenido: " + u.getPersona().getNombres(), 
							"Sistema Comercial", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, 
							e.getMessage(), 
							"Sistema Comercial", JOptionPane.WARNING_MESSAGE);					
				}
			}
		});
		btnIngresar.setBounds(122, 133, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(221, 133, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblIngresoASistema = new JLabel("Ingreso a Sistema Comercial");
		lblIngresoASistema.setForeground(Color.BLUE);
		lblIngresoASistema.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngresoASistema.setBounds(116, 11, 227, 14);
		contentPane.add(lblIngresoASistema);
	}
}
