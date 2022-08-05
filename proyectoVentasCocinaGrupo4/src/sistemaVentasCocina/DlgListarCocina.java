package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgListarCocina extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarCocina dialog = new DlgListarCocina();
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
	public DlgListarCocina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgListarCocina.class.getResource("/img/listar1.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setModal(true);
		setTitle("Listado de cocinas");
		setBounds(100, 100, 503, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 469, 389);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgListarCocina.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(119, 410, 115, 35);
		contentPanel.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon(DlgListarCocina.class.getResource("/img/listar1.png")));
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListar.addActionListener(this);
		btnListar.setBounds(253, 410, 115, 35);
		contentPanel.add(btnListar);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		//Cerrar ventana dependientes o secundarias
		dispose();
		
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("\n  LISTADO DE COCINAS " + "\n");
		imprimirCocina(FrmPrincipal.modelo0, FrmPrincipal.precio0, FrmPrincipal.ancho0, FrmPrincipal.alto0, FrmPrincipal.fondo0, FrmPrincipal.quemadores0);
		imprimirCocina(FrmPrincipal.modelo1, FrmPrincipal.precio1, FrmPrincipal.ancho1, FrmPrincipal.alto1, FrmPrincipal.fondo1, FrmPrincipal.quemadores1);
		imprimirCocina(FrmPrincipal.modelo2, FrmPrincipal.precio2, FrmPrincipal.ancho2, FrmPrincipal.alto2, FrmPrincipal.fondo2, FrmPrincipal.quemadores2);
		imprimirCocina(FrmPrincipal.modelo3, FrmPrincipal.precio3, FrmPrincipal.ancho3, FrmPrincipal.alto3, FrmPrincipal.fondo3, FrmPrincipal.quemadores3);
		imprimirCocina(FrmPrincipal.modelo4, FrmPrincipal.precio4, FrmPrincipal.ancho4, FrmPrincipal.alto4, FrmPrincipal.fondo4, FrmPrincipal.quemadores4);
		
		
		}
		

		public void imprimirCocina(String modelo, double precio, double ancho, double alto, double fondo, int quemadores) {
			
			txtS.append("\n");
			imprimir("Modelo 	: " + modelo); 
			imprimir("Precio 	: S/ " + Adicional.df.format(precio));
			imprimir("Ancho 	: " + ancho + " cm");
			imprimir("Alto 	: " + alto + " cm");
			imprimir("Fondo 	: " + fondo + " cm");
			imprimir("Quemadores 	: " + quemadores);	

		}
	
	private void imprimir(String cad) {
		txtS.append(cad + "\n");
		//Scrollpane
		txtS.getCaret().setDot(0);
	}
}


