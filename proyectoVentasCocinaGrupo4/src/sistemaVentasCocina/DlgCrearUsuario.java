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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgCrearUsuario extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JTextField txtUsuario;
	private JButton btnCrearNuevoUsuario;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	private String nuevoUsuarioNombre;
	private String nuevoUsuarioClave;
	private JPasswordField jPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCrearUsuario dialog = new DlgCrearUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCrearUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCrearUsuario.class.getResource("/img/client.png")));
		setTitle("Creación de nuevos usuarios");
		setBounds(100, 100, 503, 284);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 14, 107, 14);
		contentPanel.add(lblUsuario);
		
		lblClave = new JLabel("Clave");
		lblClave.setBounds(10, 51, 107, 14);
		contentPanel.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(84, 11, 144, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
		btnCrearNuevoUsuario.setIcon(new ImageIcon(DlgCrearUsuario.class.getResource("/img/createuser2.png")));
		btnCrearNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearNuevoUsuario.addActionListener(this);
		btnCrearNuevoUsuario.setBounds(264, 7, 213, 35);
		contentPanel.add(btnCrearNuevoUsuario);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgCrearUsuario.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(264, 57, 213, 35);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 114, 467, 108);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		jPassword = new JPasswordField();
		jPassword.setBounds(84, 48, 144, 22);
		contentPanel.add(jPassword);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnCrearNuevoUsuario) {
			actionPerformedBtnCrearNuevoUsuario(e);
		}
	}
	protected void actionPerformedBtnCrearNuevoUsuario(ActionEvent e) {
		
		if(FrmPrincipal.nUsuarios<9) {
			crearUsuario();
			exportarDatos();
			mostrarDatos();
		} else {
			JOptionPane.showMessageDialog(null, "No es posible crear más usuarios, alcanzaste el límite máximo.", "Sistema", 0);
		}		
	}
	private void crearUsuario() {
		nuevoUsuarioNombre=getUsuario();
		nuevoUsuarioClave=getClave();
		
	}

	private String getClave() {
		return String.valueOf(jPassword.getPassword());
	}

	private String getUsuario() {
		return txtUsuario.getText();
	}

	private void exportarDatos() {
		FrmPrincipal.nUsuarios++;
				
		Adicional.getUsuario(FrmPrincipal.nUsuarios, nuevoUsuarioNombre, nuevoUsuarioClave);
		
	}
	
	private void mostrarDatos() {
		txtS.setText("");
		imprimir("USUARIO NUEVO CREADO\n");
		imprimir("Usuario: "+nuevoUsuarioNombre);
		imprimir("Contraseña: "+nuevoUsuarioClave);
	}

	private void imprimir(String msj) {
		txtS.append(msj+"\n");
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
