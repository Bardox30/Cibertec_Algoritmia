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
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class DlgDatosClientes extends JDialog implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JButton btnDescargarPDF;
	private JButton btnBorrar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnCerrar;
	private JTextField txtDNI;
	private JLabel lblObservacion;
	private JTextField txtObservacion;
	private JLabel lblTelefono;
	private JTextField txtTelefono;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgDatosClientes.class.getResource("/img/client.png")));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setTitle("Datos de cliente para venta");
		setBounds(100, 100, 547, 258);
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
		btnDescargarPDF.setIcon(new ImageIcon(DlgDatosClientes.class.getResource("/img/pdf.png")));
		btnDescargarPDF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDescargarPDF.addActionListener(this);
		btnDescargarPDF.setBounds(345, 19, 176, 35);
		contentPanel.add(btnDescargarPDF);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(DlgDatosClientes.class.getResource("/img/limpiar.png")));
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(345, 65, 176, 35);
		contentPanel.add(btnBorrar);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(121, 21, 182, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setBounds(121, 52, 182, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(121, 83, 182, 20);
		contentPanel.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgDatosClientes.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(345, 112, 176, 35);
		contentPanel.add(btnCerrar);
		
		lblObservacion = new JLabel("Observación");
		lblObservacion.setBounds(22, 166, 101, 14);
		contentPanel.add(lblObservacion);
		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(121, 163, 182, 20);
		contentPanel.add(txtObservacion);
		txtObservacion.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(22, 123, 78, 14);
		contentPanel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(121, 120, 182, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		///////
	}	

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnBorrar) {
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
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtApellido) {
			keyTypedTxtApellido(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
		if (e.getSource() == txtDNI) {
			keyTypedTxtDNI(e);
		}
	}
	protected void keyTypedTxtDNI(KeyEvent e) {
		// evitar que se pongan carácteres y solo acepte números
		int key = e.getKeyChar();
		boolean numeros = key>=48 && key <=57;
		if(!numeros) {
			e.consume();
		}
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		int key = e.getKeyChar();
		boolean numeros = (key >= 97 && key <=122 ) || (key >= 65 && key <=90) || (key==32);
		if (!numeros) {
			e.consume();
		}
	}
	protected void keyTypedTxtApellido(KeyEvent e) {
		int key = e.getKeyChar();
		boolean numeros = (key >= 97 && key <=122 ) || (key >= 65 && key <=90);
		if (!numeros) {
			e.consume();
		}
	}
}
