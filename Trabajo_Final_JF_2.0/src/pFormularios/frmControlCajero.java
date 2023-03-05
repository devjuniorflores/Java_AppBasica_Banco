package pFormularios;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frmControlCajero extends JFrame {

	private JPanel contentPane;
	
	DefaultListModel moR=new DefaultListModel();
	
	double saldo=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmControlCajero frame = new frmControlCajero();
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
	public frmControlCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmControlCajero.class.getResource("/pImagenes/bannerApp.png")));
		lblNewLabel.setBounds(16, 11, 750, 104);
		contentPane.add(lblNewLabel);
		
		JButton btnDepositar = new JButton("DEPOSITAR");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moR.clear();
				
				double nuevoSaldo = 0;	
				//Creando la restriccion que solo puede ingresar valores numericos
				while (true) {
					try {
		                nuevoSaldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a depositar"));
		                break;
		            } catch (HeadlessException | NumberFormatException a) {
		                JOptionPane.showMessageDialog(null, "Cadena ingresada, debe ingresar un valor numerico");	
		            }
				}
								
				saldo += nuevoSaldo;
				moR.addElement("Usted ha depositado: " + "S/." + nuevoSaldo);
				
				   
			}
		});
		btnDepositar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDepositar.setBounds(10, 177, 164, 48);
		contentPane.add(btnDepositar);
		
		
		JButton btnRetirar = new JButton("RETIRAR");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moR.clear();
				
				double nuevoSaldo = 0;	
				//Creando la restriccion que solo puede ingresar valores numericos
				while (true) {
					try {
		                nuevoSaldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a retirar"));
		                break;
		            } catch (HeadlessException | NumberFormatException a) {
		                JOptionPane.showMessageDialog(null, "Cadena ingresada, debe ingresar un valor numerico");	
		            }
				}		

				if (nuevoSaldo>saldo) 
					JOptionPane.showMessageDialog(null, "Usted no puede retirar dinero porque no tiene los fondos suficientes");
				else {
					saldo-=nuevoSaldo;
					moR.addElement("Usted ha retirado: " + "S/." + nuevoSaldo);
				}
			}
		});
		
		JButton btnConsulta = new JButton("CONSULTA DE SALDO");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moR.clear();
				moR.addElement("Su saldo actual es: " + "S/." +roundDecimal(saldo,2));
			}
		});
		
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsulta.setBounds(602, 177, 164, 48);
		contentPane.add(btnConsulta);
		btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetirar.setBounds(10, 258, 164, 48);
		contentPane.add(btnRetirar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLogin frmVista = new frmLogin();
				JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros\n         Atte. LMFM COORP.");
				frmVista.setVisible(true);
				setVisible(false);
				
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(602, 258, 164, 48);
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 130, 398, 229);
		contentPane.add(scrollPane);
		
		JList lstR = new JList();
		scrollPane.setViewportView(lstR);
		
		lstR.setModel(moR);
		
		JLabel lblDateTime = new JLabel("");
		lblDateTime.setBounds(602, 330, 164, 40);
	}
	
	private static double roundDecimal(double valorInicial, int numeroDecimales) {
        double  parteEntera = Math.floor(valorInicial);
        valorInicial=(valorInicial-parteEntera)*Math.pow(10, numeroDecimales);
        valorInicial=Math.round(valorInicial);
        valorInicial=(valorInicial/Math.pow(10, numeroDecimales))+parteEntera;
        return valorInicial;
    }
}