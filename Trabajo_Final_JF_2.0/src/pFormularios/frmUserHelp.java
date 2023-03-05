package pFormularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmUserHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUserHelp frame = new frmUserHelp();
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
	public frmUserHelp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 653, 458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(25, 321, 94, 71);
		lblNewLabel.setIcon(new ImageIcon(frmUserHelp.class.getResource("/pImagenes/fondoApp1.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(frmUserHelp.class.getResource("/pImagenes/userHelp.png")));
		lblNewLabel_1.setBounds(25, 39, 603, 271);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lo sentimos, estamos en proceso de mejora de nuestra app");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(144, 330, 484, 48);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin frmVista = new frmLogin();
				frmVista.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(278, 416, 114, 31);
		panel.add(btnNewButton);
	}
}
