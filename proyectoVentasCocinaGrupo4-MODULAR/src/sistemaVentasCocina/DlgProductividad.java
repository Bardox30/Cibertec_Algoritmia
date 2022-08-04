package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgProductividad extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblProceso;
	private JComboBox cboProcesos;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	
	
	private int tipoProceso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProductividad dialog = new DlgProductividad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProductividad() {
		setTitle("Productividad");
		setBounds(100, 100, 508, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblProceso = new JLabel("Proceso");
		lblProceso.setBounds(10, 11, 87, 14);
		contentPanel.add(lblProceso);
		
		cboProcesos = new JComboBox();
		cboProcesos.addActionListener(this);
		cboProcesos.setModel(new DefaultComboBoxModel(new String[] {"Inventario de ventas", "Gráfico de estadísticas", "Stock"}));
		cboProcesos.setBounds(107, 7, 194, 22);
		contentPanel.add(cboProcesos);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 52, 472, 412);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboProcesos) {
			actionPerformedCboProcesos(e);
		}
	}
	protected void actionPerformedCboProcesos(ActionEvent e) {
		tipoProceso=cboProcesos.getSelectedIndex();
		
		switch(tipoProceso) {
		case 0:
			txtS.setText("");
			imprimir("VENTAS REALIZADAS POR USUARIOS\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario0);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser0));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser0);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser0+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario1);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser1));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser1);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser1+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario2);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser2));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser2);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser2+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario3);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser3));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser3);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser3+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario4);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser4));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser4);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser4+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario5);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser5));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser5);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser5+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario6);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser6));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser6);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser6+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario7);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser7));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser7);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser7+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario8);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser8));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser8);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser8+"\n");
			
			imprimir("Usuario: "+FrmPrincipal.usuario9);
			imprimir("Monto vendido: S/. "+Adicional.df.format(FrmPrincipal.montoRecaudoUser9));
			imprimir("Cantidad de ventas realizadas: "+FrmPrincipal.cantVentasUser9);
			imprimir("Cantidad de productos vendidos: "+FrmPrincipal.produVendiUser9+"\n");
			break;
		case 1:
			txtS.setText("");
			imprimir("FALTA RELLENAR");
			break;
		}		
	}

	private void imprimir(String msj) {
		txtS.append(msj+"\n");		
	}
}