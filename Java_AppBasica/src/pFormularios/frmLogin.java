package pFormularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.PasswordAuthentication;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	
	//Definir el arreglo de usuarios y claves
	String[] user= {"Jflores","Mruiz","Dlopez","Lmerino","Mtorres"};
	String key[]= {"1234567_JF","1234567_MR","1234567_DL","1234567_LM","1234567_MT"};
	String[] nameUser = {"Junior","Micaela","Daniel","Leodan","Manuel"};
	
	int contar = 1; //Contar cuantas veces coloca la clase el usuario

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
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setIcon(new ImageIcon(frmLogin.class.getResource("/pImagenes/fondoApp.png")));
		lblNewLabel.setBounds(95, 51, 250, 197);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			//Creando la restriccion que solo puede ingresar caracteres alfabeticos
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			        e.consume();
			    }   

			}
		});
		txtUser.setDisabledTextColor(Color.WHITE);
		txtUser.setSelectedTextColor(Color.WHITE);
		txtUser.setSelectionColor(Color.WHITE);
		txtUser.setBackground(new Color(255, 255, 255));
		txtUser.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), new Color(255, 215, 0), new Color(255, 215, 0), new Color(255, 215, 0)), "USUARIO", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		txtUser.setBounds(69, 273, 295, 72);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			//Creando la restriccion que solo puede ingresar hasta 10 caracteres
			public void keyTyped(KeyEvent e) {
				 if(txtPassword.getText().length() >= 10)
				    {
				        e.consume();
				    }
			}
		});
		txtPassword.setBackground(new Color(255, 255, 255));
		txtPassword.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), new Color(255, 215, 0), new Color(255, 215, 0), new Color(255, 215, 0)), "CLAVE", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		txtPassword.setBounds(69, 356, 295, 72);
		contentPane.add(txtPassword);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBackground(new Color(255, 255, 255));
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreUsuario = "";
				String usuario= txtUser.getText();
				String contra = txtPassword.getText();
				String acceso = "false";
				
				for(int i=0; i<user.length; i++) {
					if (user[i].equals(usuario) && key[i].equals(contra)) {{
						nombreUsuario = nameUser[i];
						acceso = "true";
						break;		
						}
					}
				}
				
				if(acceso.equals("true")) {
				frmControlCajero frmVista = new frmControlCajero();
				frmVista.setVisible(true);
				JOptionPane.showMessageDialog(null,"Bienvenido(a) " + nombreUsuario+ ", encantados de volverte a ver");
				setVisible(false);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Error en el acceso, le quedan " + (3-contar) + " intentos");
					contar++;
					}
				
				if(contar==4) {
					JOptionPane.showMessageDialog(null, "Intentos máximos alcanzado");
					System.exit(0);
				}
			}
		});
		btnAcceder.setBounds(69, 458, 295, 51);
		contentPane.add(btnAcceder);
		
		JLabel lblForget = new JLabel("Forgot your password");
		lblForget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUserHelp frmVista = new frmUserHelp();
				frmVista.setVisible(true);
				setVisible(false);
			}
		});
		
		lblForget.setBackground(new Color(0, 0, 0));
		lblForget.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblForget.setHorizontalAlignment(SwingConstants.CENTER);
		lblForget.setForeground(new Color(0, 0, 0));
		lblForget.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblForget.setBounds(69, 533, 295, 34);
		contentPane.add(lblForget);
		
	}
}