package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class DlgAcercaDeTienda extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JSeparator separator;
	private JLabel lblAutores;
	private JLabel lblGiomar;
	private JLabel lblJacki;
	private JLabel lblAlexia;
	private JLabel lblJose;
	private JLabel lblMarcela;
	private JButton btnNewButton;
	private JLabel lblJoel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAcercaDeTienda dialog = new DlgAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaDeTienda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAcercaDeTienda.class.getResource("/img/tienda2.png")));
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 397);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setBounds(149, 11, 137, 46);
		lblTienda.setFont(new Font("Arial Black", Font.BOLD, 22));
		contentPanel.add(lblTienda);
		
		separator = new JSeparator();
		separator.setBounds(10, 68, 414, 2);
		contentPanel.add(separator);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAutores.setBounds(149, 81, 102, 33);
		contentPanel.add(lblAutores);
		
		lblGiomar = new JLabel("Giomar Ramirez Pinto (coordinador)");
		lblGiomar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiomar.setToolTipText("");
		lblGiomar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiomar.setBounds(20, 111, 414, 33);
		contentPanel.add(lblGiomar);
		
		lblJacki = new JLabel("Jackeline Garay Cajo");
		lblJacki.setToolTipText("");
		lblJacki.setHorizontalAlignment(SwingConstants.CENTER);
		lblJacki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJacki.setBounds(10, 140, 414, 33);
		contentPanel.add(lblJacki);
		
		lblAlexia = new JLabel("Alexia Peralta Utrilla");
		lblAlexia.setToolTipText("");
		lblAlexia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlexia.setBounds(10, 171, 414, 33);
		contentPanel.add(lblAlexia);
		
		lblJose = new JLabel("Jose Lopez Alvarez");
		lblJose.setToolTipText("");
		lblJose.setHorizontalAlignment(SwingConstants.CENTER);
		lblJose.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJose.setBounds(10, 205, 414, 33);
		contentPanel.add(lblJose);
		
		lblMarcela = new JLabel("Marcela Blanco Ruiz");
		lblMarcela.setToolTipText("");
		lblMarcela.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcela.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarcela.setBounds(10, 235, 414, 33);
		contentPanel.add(lblMarcela);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/exit2.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(162, 312, 115, 35);
		contentPanel.add(btnNewButton);
		
		lblJoel = new JLabel("Joel Ayllón Lara");
		lblJoel.setToolTipText("");
		lblJoel.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJoel.setBounds(10, 269, 414, 33);
		contentPanel.add(lblJoel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose(); 
	}
}
