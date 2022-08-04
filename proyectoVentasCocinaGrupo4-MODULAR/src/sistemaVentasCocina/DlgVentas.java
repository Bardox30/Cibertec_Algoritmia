package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DlgVentas extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<?> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JTextArea txtS;
	// DECLARACI�N DE VARIABLES GLOBALES
	private int modelo;
	private int cant;
	private double precio;

	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVentas dialog = new DlgVentas();
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
	public DlgVentas() {
		setTitle("Vender");
		setBounds(100, 100, 450, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setBounds(10, 24, 81, 14);
			contentPanel.add(lblNewLabel);
		}

		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] { FrmPrincipal.modelo0, FrmPrincipal.modelo1,
				FrmPrincipal.modelo2, FrmPrincipal.modelo3, FrmPrincipal.modelo4

		}));
		cboModelo.addActionListener(this);
		cboModelo.setBounds(89, 20, 150, 22);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 49, 81, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.addActionListener(this);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(89, 46, 150, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 74, 81, 14);
		contentPanel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(89, 71, 150, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(337, 20, 89, 23);
		contentPanel.add(btnVender);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(337, 49, 89, 23);
		contentPanel.add(btnCerrar);

		txtS = new JTextArea();
		txtS.setBounds(10, 99, 416, 187);
		contentPanel.add(txtS);
		// mostrar los datos del modelo 0
		txtPrecio.setText("" + FrmPrincipal.precio0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == txtPrecio) {
			actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}

	protected void actionPerformedCboModelo(ActionEvent e) {
		// Obtener el valor de selección del cbo
		modelo = getModelo();

		// Mostrar los datos según sea el caso (modelo a elegir)
		mostrarDatosCbo();
	}

	private void mostrarDatosCbo() {
		switch (modelo) {
		case 0:
			txtPrecio.setText("" + FrmPrincipal.precio0);
			break;
		case 1:
			txtPrecio.setText("" + FrmPrincipal.precio1);
			break;
		case 2:
			txtPrecio.setText("" + FrmPrincipal.precio2);
			break;
		case 3:
			txtPrecio.setText("" + FrmPrincipal.precio3);
			break;
		default:
			txtPrecio.setText("" + FrmPrincipal.precio4);
			break;
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnVender(ActionEvent e) {
		/// DECLARACIÓN DE VARIABLES
		double impComp, impDsct, impPag;
		String obs;

		// Obtener el valor seleccionado del cbo
		modelo = getModelo();

		try {
			cant = Integer.parseInt(txtCantidad.getText());
			// Validación
			if (cant <= 0) {
				Adicional.mensajeAlerta("Ingresar valores mayores a 0");
				txtCantidad.setText("");
				txtS.setText("");
				cboModelo.setSelectedIndex(0);
				txtCantidad.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			Adicional.mensajeInformativo("Ingresar valores numéricos");
			txtCantidad.setText("");
			txtS.setText("");
			cboModelo.setSelectedIndex(0);
			txtCantidad.requestFocus();
			return;
		}

		// ventana de configuración
		int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro de vender?", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) { // yes
			// Proceso de cálculo
			// importe de compra
			impComp = getImpComp(cant);

			// Importe de descuento
			impDsct = calcImpDsct(impComp);

			// precio
			precio = getPrecio(modelo);

			// Importe de pago
			impPag = getImpPag(impComp, impDsct);

			// obsequio
			obs = getObs(cant);

			// Exportar datos para contabilidad
			exportarDatos(impPag);

			// mostrar datos
			mostrarDatos(precio, impComp, impDsct, impPag, obs);
			// Numero de ventas
			numeroVentas();
		}
	}

	private void exportarDatos(double impPag) {
		// Nro de ventas general
		FrmPrincipal.nVentas++;
		// Exportar al sistema para contabilidad
		switch (modelo) {
		case 0:
			FrmPrincipal.cantUniVendidas0 += cant;
			FrmPrincipal.totalImpVendido0 += impPag;
			FrmPrincipal.cantVentas0++;
			break;
		case 1:
			FrmPrincipal.cantUniVendidas1 += cant;
			FrmPrincipal.totalImpVendido1 += impPag;
			FrmPrincipal.cantVentas1++;
			break;
		case 2:
			FrmPrincipal.cantUniVendidas2 += cant;
			FrmPrincipal.totalImpVendido2 += impPag;
			FrmPrincipal.cantVentas2++;
			break;
		case 3:
			FrmPrincipal.cantUniVendidas3 += cant;
			FrmPrincipal.totalImpVendido3 += impPag;
			FrmPrincipal.cantVentas3++;
			break;
		default:
			FrmPrincipal.cantUniVendidas4 += cant;
			FrmPrincipal.totalImpVendido4 += impPag;
			FrmPrincipal.cantVentas4++;
			break;
		}

	}

	private void numeroVentas() {

		if (FrmPrincipal.nVentas % 5 == 0) {
			String mensaje = "Venta Nro. " + FrmPrincipal.nVentas + "\nImporte total acumulado : S/. "
					+ Adicional.df.format(FrmPrincipal.caclImporteGeneralAcum()) + "\nPorcentaje de la cuota diaria : "
					+ Adicional.df.format(FrmPrincipal.calcCuotaDiariaAcum()) + "%";
			Adicional.mensajeAcumulador(mensaje);
		}
	}

	private void mostrarDatos(double precio2, double impComp, double impDsct, double impPag, String obs) {
		switch (modelo) {
		case 0:
			txtS.setText("BOLETA DE VENTA\n\n");
			imprimir("Modelo		: " + FrmPrincipal.modelo0);
			imprimir("Precio		: S/. " + Adicional.df.format(precio));
			imprimir("Cantidad		: " + cant);
			imprimir("Importe de compra	: S/. " + Adicional.df.format(impComp));
			imprimir("Importe de descuento	: S/. " + Adicional.df.format(impDsct));
			imprimir("Importe de pago	: S/. " + Adicional.df.format(impPag));
			imprimir("Obsequio		: " + obs);
			break;
		case 1:
			txtS.setText("BOLETA DE VENTA\n\n");
			imprimir("Modelo		: " + FrmPrincipal.modelo1);
			imprimir("Precio		: S/. " + Adicional.df.format(precio));
			imprimir("Cantidad		: " + cant);
			imprimir("Importe de compra	: S/. " + Adicional.df.format(impComp));
			imprimir("Importe de descuento	: S/. " + Adicional.df.format(impDsct));
			imprimir("Importe de pago	: S/. " + Adicional.df.format(impPag));
			imprimir("Obsequio		: " + obs);
			break;
		case 2:
			txtS.setText("BOLETA DE VENTA\n\n");
			imprimir("Modelo		: " + FrmPrincipal.modelo2);
			imprimir("Precio		: S/. " + Adicional.df.format(precio));
			imprimir("Cantidad		: " + cant + "\n");
			imprimir("Importe de compra	: S/. " + Adicional.df.format(impComp));
			imprimir("Importe de descuento	: S/. " + Adicional.df.format(impDsct));
			imprimir("Importe de pago	: S/. " + Adicional.df.format(impPag));
			imprimir("Obsequio		: " + obs);
			break;
		case 3:
			txtS.setText("BOLETA DE VENTA\n\n");
			imprimir("Modelo		: " + FrmPrincipal.modelo3);
			imprimir("Precio		: S/. " + Adicional.df.format(precio));
			imprimir("Cantidad		: " + cant);
			imprimir("Importe de compra	: S/. " + Adicional.df.format(impComp));
			imprimir("Importe de descuento	: S/. " + Adicional.df.format(impDsct));
			imprimir("Importe de pago	: S/. " + Adicional.df.format(impPag));
			imprimir("Obsequio		: " + obs);
			break;
		default:
			txtS.setText("BOLETA DE VENTA\n\n");
			imprimir("Modelo		: " + FrmPrincipal.modelo4);
			imprimir("Precio		: S/. " + Adicional.df.format(precio));
			imprimir("Cantidad		: " + cant);
			imprimir("Importe de compra	: S/. " + Adicional.df.format(impComp));
			imprimir("Importe de descuento	: S/. " + Adicional.df.format(impDsct));
			imprimir("Importe de pago	: S/. " + Adicional.df.format(impPag));
			imprimir("Obsequio		: " + obs);
			break;
		}

	}

	private double calcImpDsct(double impComp) {
		if (cant <= 5)
			return porceReal(FrmPrincipal.porcentaje1) * impComp;
		else if (cant <= 10)
			return porceReal(FrmPrincipal.porcentaje2) * impComp;
		else if (cant <= 15)
			return porceReal(FrmPrincipal.porcentaje3) * impComp;
		else
			return porceReal(FrmPrincipal.porcentaje4) * impComp;
	}

	private double getPrecio(int modelo) {
		switch (modelo) {
		case 0:
			return FrmPrincipal.precio0;
		case 1:
			return FrmPrincipal.precio1;
		case 2:
			return FrmPrincipal.precio2;
		case 3:
			return FrmPrincipal.precio3;
		default:
			return FrmPrincipal.precio4;
		}
	}

	private String getObs(int cant) {
		if (cant <= 1)
			return FrmPrincipal.obsequio1;
		else if (cant <= 5)
			return FrmPrincipal.obsequio2;
		else
			return FrmPrincipal.obsequio3;
	}

	private double getImpPag(double impComp, double impDsct) {
		return impComp - impDsct;
	}

	private double getImpComp(int cant) {
		switch (modelo) {
		case 0:
			return cant * FrmPrincipal.precio0;
		case 1:
			return cant * FrmPrincipal.precio1;
		case 2:
			return cant * FrmPrincipal.precio2;
		case 3:
			return cant * FrmPrincipal.precio3;
		default:
			return cant * FrmPrincipal.precio4;
		}
	}

	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}

	// GET IMPORTE DE DESCUENTO
	private double porceReal(double porcentaje) {
		return porcentaje / 100;
	}

	// imprimir
	public void imprimir(String msj) {
		txtS.append(msj + "\n");
	}
}