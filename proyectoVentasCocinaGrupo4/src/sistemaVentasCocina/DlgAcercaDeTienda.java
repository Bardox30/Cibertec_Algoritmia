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
	private JLabel lblAlexiaFoto;
	private JLabel lblJoelFoto;
	private JLabel lblGiomaruFoto;
	private JLabel lblJoseFoto;
	private JLabel lblJackelineFoto;
	private JLabel lblMarcelaFoto;
	private JLabel lblNewLabel_6;

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
		setBounds(100, 100, 724, 638);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setBounds(240, 0, 137, 46);
		lblTienda.setFont(new Font("Arial Black", Font.BOLD, 22));
		contentPanel.add(lblTienda);
		
		separator = new JSeparator();
		separator.setBounds(10, 68, 688, 2);
		contentPanel.add(separator);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAutores.setBounds(275, 39, 102, 33);
		contentPanel.add(lblAutores);
		
		lblGiomar = new JLabel("Giomar Ramirez Pinto");
		lblGiomar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiomar.setToolTipText("");
		lblGiomar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiomar.setBounds(-62, 299, 324, 33);
		contentPanel.add(lblGiomar);
		
		lblJacki = new JLabel("Jackeline Garay Cajo");
		lblJacki.setToolTipText("");
		lblJacki.setHorizontalAlignment(SwingConstants.CENTER);
		lblJacki.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJacki.setBounds(463, 68, 245, 33);
		contentPanel.add(lblJacki);
		
		lblAlexia = new JLabel("Alexia Peralta Utrilla");
		lblAlexia.setToolTipText("");
		lblAlexia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlexia.setBounds(-54, 68, 316, 33);
		contentPanel.add(lblAlexia);
		
		lblJose = new JLabel("José López Álvarez");
		lblJose.setToolTipText("");
		lblJose.setHorizontalAlignment(SwingConstants.CENTER);
		lblJose.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJose.setBounds(182, 299, 316, 33);
		contentPanel.add(lblJose);
		
		lblMarcela = new JLabel("Marcela Blanco Ruiz");
		lblMarcela.setToolTipText("");
		lblMarcela.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcela.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarcela.setBounds(462, 299, 256, 33);
		contentPanel.add(lblMarcela);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/exit2.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(264, 553, 178, 35);
		contentPanel.add(btnNewButton);
		
		lblJoel = new JLabel("Joel Ayllón Lara");
		lblJoel.setToolTipText("");
		lblJoel.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJoel.setBounds(174, 68, 324, 33);
		contentPanel.add(lblJoel);
		
		lblAlexiaFoto = new JLabel("New label");
		lblAlexiaFoto.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/alexia_chiquita.jpg")));
		lblAlexiaFoto.setBounds(26, 95, 152, 180);
		contentPanel.add(lblAlexiaFoto);
		
		lblJoelFoto = new JLabel("");
		lblJoelFoto.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/joel_chiquito.jpg")));
		lblJoelFoto.setBounds(265, 81, 152, 208);
		contentPanel.add(lblJoelFoto);
		
		lblGiomaruFoto = new JLabel("");
		lblGiomaruFoto.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/giomar_chiquito.jpg")));
		lblGiomaruFoto.setBounds(26, 340, 152, 186);
		contentPanel.add(lblGiomaruFoto);
		
		lblJoseFoto = new JLabel("");
		lblJoseFoto.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/joseluis_chiquito.jpg")));
		lblJoseFoto.setBounds(271, 339, 146, 188);
		contentPanel.add(lblJoseFoto);
		
		lblJackelineFoto = new JLabel("");
		lblJackelineFoto.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/jacky_chiquita.jpg")));
		lblJackelineFoto.setBounds(519, 95, 152, 180);
		contentPanel.add(lblJackelineFoto);
		
		lblMarcelaFoto = new JLabel("New label");
		lblMarcelaFoto.setIcon(new ImageIcon(DlgAcercaDeTienda.class.getResource("/img/marcela_chiquita.jpg")));
		lblMarcelaFoto.setBounds(519, 343, 152, 174);
		contentPanel.add(lblMarcelaFoto);
		
		lblNewLabel_6 = new JLabel("Coordinador");
		lblNewLabel_6.setBounds(62, 535, 76, 14);
		contentPanel.add(lblNewLabel_6);
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
