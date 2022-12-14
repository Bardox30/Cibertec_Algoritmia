package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class DlgUsuarios extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnListarUsuarios;
	private JButton btnCrearNuevoUsuario;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUsuarios dialog = new DlgUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgUsuarios.class.getResource("/img/user1.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Usuarios");
		setBounds(100, 100, 472, 342);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAcciones = new JLabel("Acciones");
			lblAcciones.setBounds(10, 11, 72, 14);
			contentPanel.add(lblAcciones);
		}
		
		btnListarUsuarios = new JButton("Listar usuarios");
		btnListarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarUsuarios.setIcon(new ImageIcon(DlgUsuarios.class.getResource("/img/listar2.png")));
		btnListarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarUsuarios.addActionListener(this);
		btnListarUsuarios.setBounds(74, 7, 156, 35);
		contentPanel.add(btnListarUsuarios);
		
		btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
		btnCrearNuevoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevoUsuario.setIcon(new ImageIcon(DlgUsuarios.class.getResource("/img/createuser.png")));
		btnCrearNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearNuevoUsuario.addActionListener(this);
		btnCrearNuevoUsuario.setBounds(240, 7, 194, 35);
		contentPanel.add(btnCrearNuevoUsuario);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 48, 424, 202);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar.setIcon(new ImageIcon(DlgUsuarios.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(159, 261, 108, 35);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnCrearNuevoUsuario) {
			actionPerformedBtnCrearNuevoUsuario(e);
		}
		if (e.getSource() == btnListarUsuarios) {
			actionPerformedBtnListarUsuarios(e);
		}
	}
	protected void actionPerformedBtnListarUsuarios(ActionEvent e) {		
		mostrarResultados();
	}

	private void mostrarResultados() {
		txtS.setText("");		
		
		imprimir("DATOS DE TODOS LOS USUARIOS\n");
		
		imprimir("Admnistrador del sistema: "+FrmPrincipal.usuario0+"\n");
		
		imprimir("Usuario N??1	: "+FrmPrincipal.usuario1);
		imprimir("Contrase??a N??1: "+FrmPrincipal.clave1+"\n");
		
		imprimir("Usuario N??2	: "+FrmPrincipal.usuario2);
		imprimir("Contrase??a N??2: "+FrmPrincipal.clave2+"\n");
		
		imprimir("Usuario N??3	: "+FrmPrincipal.usuario3);
		imprimir("Contrase??a N??3: "+FrmPrincipal.clave3+"\n");
		
		imprimir("Usuario N??4	: "+FrmPrincipal.usuario4);
		imprimir("Contrase??a N??4: "+FrmPrincipal.clave4+"\n");
		
		imprimir("Usuario N??5	: "+FrmPrincipal.usuario5);
		imprimir("Contrase??a N??5: "+FrmPrincipal.clave5+"\n");
		
		imprimir("Usuario N??6	: "+FrmPrincipal.usuario6);
		imprimir("Contrase??a N??6: "+FrmPrincipal.clave6+"\n");
		
		imprimir("Usuario N??7	: "+FrmPrincipal.usuario7);
		imprimir("Contrase??a N??7: "+FrmPrincipal.clave7+"\n");
		
		imprimir("Usuario N??8	: "+FrmPrincipal.usuario8);
		imprimir("Contrase??a N??8: "+FrmPrincipal.clave8+"\n");
		
		imprimir("Usuario N??9	: "+FrmPrincipal.usuario9);
		imprimir("Contrase??a N??9: "+FrmPrincipal.clave9+"\n");
	}

	private void imprimir(String msj) {
		txtS.getCaret().setDot(0);
		txtS.append(msj+"\n");		
	}
	protected void actionPerformedBtnCrearNuevoUsuario(ActionEvent e) {
		if(FrmPrincipal.nUsuarios<9) {
			DlgCrearUsuario registro = new DlgCrearUsuario();
			registro.setVisible(true);
			registro.setLocationRelativeTo(this);
		} else {
			JOptionPane.showMessageDialog(null, "No es posible crear m??s usuarios, alcanzaste el l??mite m??ximo.", "Sistema", 0);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
}
