package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CreatePdf.CreatePdf;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDatosClientes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JButton btnDescargarPDF;
	private JButton btnLimpiar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnSalir;
	private JTextField txtDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDatosClientes dialog = new DlgDatosClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDatosClientes() {
		setTitle("Datos de cliente para proforma");
		setBounds(100, 100, 519, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre(s)");
		lblNombre.setBounds(22, 24, 89, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido(s)");
		lblApellido.setBounds(22, 70, 89, 14);
		contentPanel.add(lblApellido);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(22, 110, 89, 14);
		contentPanel.add(lblDNI);
		
		btnDescargarPDF = new JButton("Descargar PDF");
		btnDescargarPDF.addActionListener(this);
		btnDescargarPDF.setBounds(358, 20, 119, 23);
		contentPanel.add(btnDescargarPDF);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(358, 66, 119, 23);
		contentPanel.add(btnLimpiar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(121, 21, 182, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(121, 67, 182, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(121, 107, 182, 20);
		contentPanel.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(358, 121, 119, 23);
		contentPanel.add(btnSalir);
		
		
		///////
	}	

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDescargarPDF) {
			actionPerformedBtnDescargarPDF(e);
		}
	}
	protected void actionPerformedBtnDescargarPDF(ActionEvent e) {
		CreatePdf.main_PDF();
	}
}
