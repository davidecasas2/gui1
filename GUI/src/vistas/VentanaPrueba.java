package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
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
	public VentanaPrueba() {
		setTitle("Suma de dos números");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero1 = new JLabel("Número 1:");
		lblNumero1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNumero1.setBounds(55, 30, 76, 24);
		contentPane.add(lblNumero1);
		
		txtNumero1 = new JTextField();
		txtNumero1.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNumero1.setBounds(138, 36, 214, 18);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		JLabel lblNumero2 = new JLabel("Número 2:");
		lblNumero2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNumero2.setBounds(55, 62, 85, 24);
		contentPane.add(lblNumero2);
		
		txtNumero2 = new JTextField();
		txtNumero2.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(138, 68, 214, 18);
		contentPane.add(txtNumero2);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumar();
			}
		});
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAceptar.setBounds(165, 148, 105, 33);
		contentPane.add(btnAceptar);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblResultado.setBounds(55, 109, 297, 24);
		contentPane.add(lblResultado);
		
		this.getRootPane().setDefaultButton(btnAceptar);

	}

	protected void sumar() {
		int num, num2; 
		
		try {
			num = Integer.parseInt(txtNumero1.getText());
			num2 =Integer.parseInt(txtNumero2.getText());
			
			int res = num+num2;
			lblResultado.setText("La suma es: "+res);
		} catch(NumberFormatException e ) {
			JOptionPane.showMessageDialog(this, 
					"Introduzca un número válido", 
					"Número incorrecto",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
}
