package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DlgConfigurarCantidadOptima extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCantidadOptima;
	private JTextField txtCantidadOptima;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarCantidadOptima dialog = new DlgConfigurarCantidadOptima();
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
	public DlgConfigurarCantidadOptima() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConfigurarCantidadOptima.class.getResource("/img/optima1.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Configurar cantidad Optima");
		setBounds(100, 100, 470, 137);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCantidadOptima = new JLabel("Cantidad Optima de unidades vendidas:");
		lblCantidadOptima.setBounds(10, 23, 234, 13);
		contentPanel.add(lblCantidadOptima);

		txtCantidadOptima = new JTextField();
		txtCantidadOptima.addMouseListener(new TxtCantidadOptimaMouseListener());
		txtCantidadOptima.addMouseMotionListener(new TxtCantidadOptimaMouseMotionListener());
		txtCantidadOptima.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtCantidadOptima(e);
			}
		});
		txtCantidadOptima.setBounds(243, 20, 51, 19);
		contentPanel.add(txtCantidadOptima);
		txtCantidadOptima.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgConfigurarCantidadOptima.class.getResource("/img/guardar.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(331, 10, 115, 35);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DlgConfigurarCantidadOptima.class.getResource("/img/exit2.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		btnCancelar.setBounds(331, 53, 115, 35);
		contentPanel.add(btnCancelar);
		// Mostrar datos de la cantidad ??ptima
		txtCantidadOptima.setText("" + FrmPrincipal.cantidadOptima);
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		botonAceptar();
	}
		int opcion, cantidad;
		
		private void botonAceptar() {
		
			try {
				int cantidad = Integer.parseInt(txtCantidadOptima.getText());
				if (cantidad <= 0) {
					Adicional.mensajeAlerta("Ingresar valores mayores a 0");
					return;
				}
			} catch (NumberFormatException e1) {
				Adicional.mensajeInformativo("Ingresar valores numericos");
				return;
			}
			int opcion = JOptionPane.showConfirmDialog(this, "??Esta seguro de modificar?", "Sistema",
				JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				FrmPrincipal.cantidadOptima = Integer.parseInt(txtCantidadOptima.getText());
				dispose();			
			}
		}
	
	protected void keyTypedTxtCantidadOptima(KeyEvent e) {
		int key = e.getKeyChar();
		boolean numeros = key >= 48 && key <= 57;
		if (!numeros) {
			e.consume();
		}
		if (key == 10) {
			botonAceptar();
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	private class TxtCantidadOptimaMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtCantidadOptima.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtCantidadOptimaMouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtCantidadOptima.setBackground(Color.WHITE);
		}
	}
}
