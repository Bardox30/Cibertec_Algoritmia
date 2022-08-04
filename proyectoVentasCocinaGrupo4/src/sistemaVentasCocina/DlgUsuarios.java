package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUsuarios extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnListarUsuarios;
	private JButton btnCrearNuevoUsuario;
	private JTextArea txtS;
	private JScrollPane scrollPane;

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
		setTitle("Usuarios");
		setBounds(100, 100, 450, 300);
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
		btnListarUsuarios.addActionListener(this);
		btnListarUsuarios.setBounds(97, 7, 117, 23);
		contentPanel.add(btnListarUsuarios);
		
		btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
		btnCrearNuevoUsuario.setBounds(246, 7, 140, 23);
		contentPanel.add(btnCrearNuevoUsuario);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 48, 414, 202);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListarUsuarios) {
			actionPerformedBtnListarUsuarios(e);
		}
	}
	protected void actionPerformedBtnListarUsuarios(ActionEvent e) {
		txtS.setText("");
		txtS.append("");
	}
}
