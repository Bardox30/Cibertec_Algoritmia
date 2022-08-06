package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class DlgConsultarCocina extends JDialog implements ActionListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultarCocina dialog = new DlgConsultarCocina();
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
	public DlgConsultarCocina() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultarCocina.class.getResource("/img/consultar1.png")));
		setForeground(Color.GREEN);
		setTitle("Consultar cocina");
		setBounds(100, 100, 459, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 24, 49, 14);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(96, 20, 149, 22);
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
		lblFondo.setBounds(10, 124, 76, 14);
		contentPanel.add(lblFondo);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 149, 76, 14);
		contentPanel.add(lblQuemadores);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(96, 46, 149, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(96, 71, 149, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setBounds(96, 96, 149, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setBounds(96, 121, 149, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setEditable(false);
		txtQuemadores.setBounds(96, 146, 149, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgConsultarCocina.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(311, 14, 112, 35);
		contentPanel.add(btnCerrar);
		mostrar();
	}
	
	private void mostrar() {
		txtPrecio.setText("" +FrmPrincipal.precio0);
		txtAncho.setText("" +FrmPrincipal.ancho0);
		txtAlto.setText("" +FrmPrincipal.alto0);
		txtFondo.setText("" +FrmPrincipal.fondo0);
		txtQuemadores.setText("" +FrmPrincipal.quemadores0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		//cerrar ventanas dependientes o secundarias
		dispose();
		
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		//declaracion de variables
		int modelo;
		//obtener el valor de la seleccion del cbo
		modelo = getModelo();
		
		//mostrar los datos segun sea el caso (modelo a elegir)
		mostrarDatosCbo(modelo);
	}

	private void mostrarDatosCbo(int modelo) {
		switch (modelo) {
		case 0: //Mabe EMP6120PG0
			txtPrecio.setText("" +FrmPrincipal.precio0);
			txtAncho.setText("" +FrmPrincipal.ancho0);
			txtAlto.setText("" +FrmPrincipal.alto0);
			txtFondo.setText("" +FrmPrincipal.fondo0);
			txtQuemadores.setText("" +FrmPrincipal.quemadores0);
			break;
		case 1: //Indurama Parma
			txtPrecio.setText("" +FrmPrincipal.precio1);
			txtAncho.setText("" +FrmPrincipal.ancho1);
			txtAlto.setText("" +FrmPrincipal.alto1);
			txtFondo.setText("" +FrmPrincipal.fondo1);
			txtQuemadores.setText("" +FrmPrincipal.quemadores1);
			break;
		case 2: //Sole COSOL027
			txtPrecio.setText("" +FrmPrincipal.precio2);
			txtAncho.setText("" +FrmPrincipal.ancho2);
			txtAlto.setText("" +FrmPrincipal.alto2);
			txtFondo.setText("" +FrmPrincipal.fondo2);
			txtQuemadores.setText("" +FrmPrincipal.quemadores2);
			break;
		case 3: //Coldex CX602
			txtPrecio.setText("" +FrmPrincipal.precio3);
			txtAncho.setText("" +FrmPrincipal.ancho3);
			txtAlto.setText("" +FrmPrincipal.alto3);
			txtFondo.setText("" +FrmPrincipal.fondo3);
			txtQuemadores.setText("" +FrmPrincipal.quemadores3);
			break;
		default: //Reco Dakota
			txtPrecio.setText("" +FrmPrincipal.precio4);
			txtAncho.setText("" +FrmPrincipal.ancho4);
			txtAlto.setText("" +FrmPrincipal.alto4);
			txtFondo.setText("" +FrmPrincipal.fondo4);
			txtQuemadores.setText("" +FrmPrincipal.quemadores4);
			break;			
		}		
	}

	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}
}