package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Billete;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioBillete extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JSpinner spinnerEdad;
	private JSpinner spinnerNumPasajeros;
	private JComboBox comboBillete;
	private final ButtonGroup grupoTipo = new ButtonGroup();
	private JRadioButton rdbIdaVuelta;
	private JRadioButton rdbIda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioBillete frame = new FormularioBillete();
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
	public FormularioBillete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][84.00][grow][]", "[][grow][grow][grow][grow][grow][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 1 1,alignx left");
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtNombre, "cell 2 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx left");
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtApellidos, "cell 2 2,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 1 3");
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setModel(new SpinnerNumberModel(18, 0, 120, 1));
		spinnerEdad.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(spinnerEdad, "cell 2 3,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Billete:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 1 4");
		
		comboBillete = new JComboBox();
		comboBillete.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBillete.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Joven", "3ª Edad"}));
		contentPane.add(comboBillete, "cell 2 4,growx");
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4, "cell 1 5,alignx left");
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtDni, "cell 2 5,growx");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Núm Pasajeros:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_6, "cell 1 6");
		
		spinnerNumPasajeros = new JSpinner();
		spinnerNumPasajeros.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerNumPasajeros.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(spinnerNumPasajeros, "cell 2 6,growx");
		
		JLabel lblNewLabel_5 = new JLabel("Tipo:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5, "cell 1 7");
		
		rdbIda = new JRadioButton("Ida");
		rdbIda.setSelected(true);
		grupoTipo.add(rdbIda);
		rdbIda.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rdbIda, "flowx,cell 2 7");
		
		rdbIdaVuelta = new JRadioButton("Ida y Vuelta");
		grupoTipo.add(rdbIdaVuelta);
		rdbIdaVuelta.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rdbIdaVuelta, "cell 2 7");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 8 2 1,grow");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarBillete();
			}
		});
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnAceptar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		btnLimpiar.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnLimpiar);
	}

	protected void procesarBillete() {
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDni.getText();
		if (nombre==null || nombre.isBlank() ||
			apellidos==null || apellidos.isBlank() ||
			dni==null || dni.isBlank() ) {
			JOptionPane.showMessageDialog(this, 
			"Los campos nombre, apellidos y dni son obligatorios ",
			"Campos Obligatorios", JOptionPane.WARNING_MESSAGE);
		}
		int edad = (int) spinnerEdad.getValue();
		int modalidad = comboBillete.getSelectedIndex()+1;
		int numPasajeros = (int) spinnerNumPasajeros.getValue();
		boolean idaYVuelta = rdbIdaVuelta.isSelected();
		
		Billete b = new Billete(nombre, apellidos, edad, modalidad,
                    dni, numPasajeros, idaYVuelta);
		JOptionPane.showMessageDialog(this, 
		   "El importe total del billete es: "+b.getImporteTotal(),
		   "Importe del billete", JOptionPane.INFORMATION_MESSAGE);
		
	}

	protected void limpiarDatos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		spinnerEdad.setValue(Integer.valueOf(18));
		comboBillete.setSelectedIndex(0);
		txtDni.setText("");
		spinnerNumPasajeros.setValue(Integer.valueOf(1));
		rdbIda.setSelected(true);
	}

}
