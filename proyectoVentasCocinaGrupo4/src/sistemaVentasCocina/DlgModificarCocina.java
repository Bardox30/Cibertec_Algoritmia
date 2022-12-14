package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgModificarCocina extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox<?> cboModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblQuemadores;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JButton btnGrabar;

	// Varias globales
	private double precio = 0.0, ancho = 0.0, alto = 0.0, fondo = 0.0;
	private int quemadores = 0, modelo, opcion;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModificarCocina dialog = new DlgModificarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DlgModificarCocina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgModificarCocina.class.getResource("/img/modificar.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setForeground(Color.GREEN);
		setTitle("Modificar cocina");
		setBounds(100, 100, 471, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 24, 49, 14);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(96, 20, 137, 22);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 49, 76, 14);
		contentPanel.add(lblPrecio);

		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 74, 76, 14);
		contentPanel.add(lblAncho);

		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 99, 76, 14);
		contentPanel.add(lblAlto);

		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 124, 96, 14);
		contentPanel.add(lblFondo);

		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 149, 76, 14);
		contentPanel.add(lblQuemadores);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(96, 46, 137, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setBounds(96, 71, 137, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);

		txtAlto = new JTextField();
		txtAlto.setBounds(96, 96, 137, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);

		txtFondo = new JTextField();
		txtFondo.setBounds(96, 121, 137, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);

		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(96, 146, 137, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgModificarCocina.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(320, 70, 119, 35);
		contentPanel.add(btnCerrar);

		// mostrar datos de modelo 0
		txtPrecio.setText("" + FrmPrincipal.precio0);
		txtAncho.setText("" + FrmPrincipal.ancho0);
		txtAlto.setText("" + FrmPrincipal.alto0);
		txtFondo.setText("" + FrmPrincipal.fondo0);
		txtQuemadores.setText("" + FrmPrincipal.quemadores0);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(DlgModificarCocina.class.getResource("/img/guardar.png")));
		btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(320, 20, 119, 35);
		contentPanel.add(btnGrabar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedComboBox(ActionEvent e) {
		// Declaracion de variables
		// Obtener el valor de la seleccion del cbo
		modelo = getModelo();

		// Mostrar los datos segun sea el caso (modelo a elegir)
		mostrarDatosCbo(modelo);

	}

	private void mostrarDatosCbo(int modelo) {
		switch (modelo) {
		case 0: // Mabe EMP6120PG0
			mostrarCbo0();
			break;
		case 1: // Indurama Parma
			mostrarCbo1();
			break;
		case 2: // Sole COSOL027
			mostrarCbo2();
			break;
		case 3: // Coldex CX602
			mostrarCbo3();
			break;
		default: // Reco Dakota
			mostrarCbo4();

		}
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		//Proceso de calculo
		try {

			precio = getPrecio();
			ancho = getAncho();
			alto = getAlto();
			fondo = getFondo();
			quemadores = getQuemadores();
			modelo = getModelo();

			if (precio <= 0 || ancho <= 0 || alto <= 0 || fondo <= 0 || quemadores <= 0) {

				Adicional.mensajeAlerta("Ingresar valores mayores a 0");
				///mostrar los datos del modelo 0
				mostrarCbo0();

			}else {
				opcion = Adicional.mensajeConfirmar("Seguro de modificar??");
			
				dispose();	
				
				// ventana de confirmacion
				
				if (opcion == 0) { // SI

					// asignar nuevos valores a las variables globales segun el modelo seleccionado
					switch (modelo) {
					case 0:
						exportarCbo0();
						break;
					case 1:
						exportarCbo1();
						break;
					case 2:
						exportarCbo2();
						break;
					case 3:
						exportarCbo3();
						break;
					default:
						exportarCbo4();
						break;
					}
				}

			}
		} catch (NumberFormatException e2) {
			
			Adicional.mensajeInformativo("Ingresar valores num??ricos");
			
			///mostrar los datos del modelo 0
			mostrarCbo0();

			modelo = getModelo();
			
			switch (modelo) {
			case 0:
				exportarCbo0();
				break;
			case 1:
				exportarCbo1();
				break;
			case 2:
				exportarCbo2();
				break;
			case 3:
				exportarCbo3();
				break;
			default:
				exportarCbo4();
				break;
			}
		}
	}

	
	// MOSTRAR CBOs
	private void mostrarCbo4() {
		txtPrecio.setText("" + FrmPrincipal.precio4);
		txtAncho.setText("" + FrmPrincipal.ancho4);
		txtAlto.setText("" + FrmPrincipal.alto4);
		txtFondo.setText("" + FrmPrincipal.fondo4);
		txtQuemadores.setText("" + FrmPrincipal.quemadores4);
	}
	
	private void mostrarCbo3() {
		txtPrecio.setText("" + FrmPrincipal.precio3);
		txtAncho.setText("" + FrmPrincipal.ancho3);
		txtAlto.setText("" + FrmPrincipal.alto3);
		txtFondo.setText("" + FrmPrincipal.fondo3);
		txtQuemadores.setText("" + FrmPrincipal.quemadores3);
	}
	
	private void mostrarCbo2() {
		txtPrecio.setText("" + FrmPrincipal.precio2);
		txtAncho.setText("" + FrmPrincipal.ancho2);
		txtAlto.setText("" + FrmPrincipal.alto2);
		txtFondo.setText("" + FrmPrincipal.fondo2);
		txtQuemadores.setText("" + FrmPrincipal.quemadores2);
	}
	
	private void mostrarCbo1() {
		txtPrecio.setText("" + FrmPrincipal.precio1);
		txtAncho.setText("" + FrmPrincipal.ancho1);
		txtAlto.setText("" + FrmPrincipal.alto1);
		txtFondo.setText("" + FrmPrincipal.fondo1);
		txtQuemadores.setText("" + FrmPrincipal.quemadores1);
	}
	
	private void mostrarCbo0() {
		cboModelo.getSelectedIndex();
		txtPrecio.setText("" + FrmPrincipal.precio0);
		txtAncho.setText("" + FrmPrincipal.ancho0);
		txtAlto.setText("" + FrmPrincipal.alto0);
		txtFondo.setText("" + FrmPrincipal.fondo0);
		txtQuemadores.setText("" + FrmPrincipal.quemadores0);
	}

	
	/// EXPORTAR CBOs
	private void exportarCbo4() {
		FrmPrincipal.precio4 = Double.parseDouble(txtPrecio.getText());
		FrmPrincipal.ancho4 = Double.parseDouble(txtAncho.getText());
		FrmPrincipal.alto4 = Double.parseDouble(txtAlto.getText());
		FrmPrincipal.fondo4 = Double.parseDouble(txtFondo.getText());
		FrmPrincipal.quemadores4 = Integer.parseInt(txtQuemadores.getText());
	}
	
	private void exportarCbo3() {
		FrmPrincipal.precio3 = Double.parseDouble(txtPrecio.getText());
		FrmPrincipal.ancho3 = Double.parseDouble(txtAncho.getText());
		FrmPrincipal.alto3 = Double.parseDouble(txtAlto.getText());
		FrmPrincipal.fondo3 = Double.parseDouble(txtFondo.getText());
		FrmPrincipal.quemadores3 = Integer.parseInt(txtQuemadores.getText());
	}
	
	private void exportarCbo2() {
		FrmPrincipal.precio2 = Double.parseDouble(txtPrecio.getText());
		FrmPrincipal.ancho2 = Double.parseDouble(txtAncho.getText());
		FrmPrincipal.alto2 = Double.parseDouble(txtAlto.getText());
		FrmPrincipal.fondo2 = Double.parseDouble(txtFondo.getText());
		FrmPrincipal.quemadores2 = Integer.parseInt(txtQuemadores.getText());
	}
	
	private void exportarCbo1() {
		FrmPrincipal.precio1 = Double.parseDouble(txtPrecio.getText());
		FrmPrincipal.ancho1 = Double.parseDouble(txtAncho.getText());
		FrmPrincipal.alto1 = Double.parseDouble(txtAlto.getText());
		FrmPrincipal.fondo1 = Double.parseDouble(txtFondo.getText());
		FrmPrincipal.quemadores1 = Integer.parseInt(txtQuemadores.getText());
	}

	private void exportarCbo0() {
		txtPrecio.setText("" + FrmPrincipal.precio0);
		txtAncho.setText("" + FrmPrincipal.ancho0);
		txtAlto.setText("" + FrmPrincipal.alto0);
		txtFondo.setText("" + FrmPrincipal.fondo0);
		txtQuemadores.setText("" + FrmPrincipal.quemadores0);
	}
	
	private int getModelo() {
		
		return cboModelo.getSelectedIndex();
	}

	private int getQuemadores() {
		return Integer.parseInt(txtQuemadores.getText().trim());
	}

	private double getFondo() {
		
		return Double.parseDouble(txtFondo.getText().trim());
	}

	private double getAlto() {
		
		return Double.parseDouble(txtAlto.getText().trim());
	}

	private double getAncho() {
		
		return Double.parseDouble(txtAncho.getText().trim());
	}

	private double getPrecio() {
	
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	
}
