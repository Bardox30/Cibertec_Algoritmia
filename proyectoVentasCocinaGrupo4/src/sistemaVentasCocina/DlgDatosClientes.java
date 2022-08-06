package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CreatePdf.CreatePdf;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDatosClientes extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JLabel lblObservacion;
	private JTextField txtObservacion;

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
		setBounds(100, 100, 519, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre(s)");
		lblNombre.setBounds(22, 24, 89, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido(s)");
		lblApellido.setBounds(22, 55, 89, 14);
		contentPanel.add(lblApellido);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(22, 86, 89, 14);
		contentPanel.add(lblDNI);
		
		btnDescargarPDF = new JButton("Descargar PDF");
		btnDescargarPDF.addActionListener(this);
		btnDescargarPDF.setBounds(358, 20, 119, 23);
		contentPanel.add(btnDescargarPDF);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(358, 66, 119, 23);
		contentPanel.add(btnLimpiar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(121, 21, 182, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(121, 52, 182, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(121, 83, 182, 20);
		contentPanel.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(358, 117, 119, 23);
		contentPanel.add(btnSalir);
		
		lblObservacion = new JLabel("Observación");
		lblObservacion.setBounds(22, 117, 101, 14);
		contentPanel.add(lblObservacion);
		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(121, 114, 182, 20);
		contentPanel.add(txtObservacion);
		txtObservacion.setColumns(10);
		
		
		///////
	}	

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnDescargarPDF) {
			actionPerformedBtnDescargarPDF(e);
		}
	}
	protected void actionPerformedBtnDescargarPDF(ActionEvent e) {
		FrmPrincipal.nombres=getNombreCliente();
		FrmPrincipal.apellidos=getApellidoCliente();
		FrmPrincipal.dni=getDNI();
		FrmPrincipal.observacion=getObservacion();
		
		mostrarDatos();
	}
	
	private String getObservacion() {
		return txtObservacion.getText();
	}

	private String getDNI() {
		return txtDNI.getText();
	}

	private String getApellidoCliente() {
		return txtApellido.getText();
	}

	private String getNombreCliente() {
		return txtNombre.getText();
	}

	private void mostrarDatos() {
		String username = FrmPrincipal.usernameSistema;
		int nVentaPDF=FrmPrincipal.numVentaPDF+1;
		String ruta = "C:\\Users\\"+username+"\\Documents\\Monto-Total-N"+nVentaPDF+".pdf";
		String mensaje = "Su proforma ha sido exportada exitosamente.\nLa ruta en la que se encuentra guardado el archivo es la siguiente: "+ruta;
		JOptionPane.showMessageDialog(this, mensaje, "Sistema",0);
		
		CreatePdf.main_PDF();
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtObservacion.setText("");
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
}
