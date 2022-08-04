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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgConfigurarObsequio extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl1Unidad;
	private JTextField txtObsequio1;
	private JLabel lbl2a5Unidades;
	private JTextField txtObsequio2;
	private JLabel lbl6Unidades;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarObsequio dialog = new DlgConfigurarObsequio();
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
	public DlgConfigurarObsequio() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 385, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lbl1Unidad = new JLabel("1 unidad");
		lbl1Unidad.setBounds(20, 22, 110, 14);
		contentPanel.add(lbl1Unidad);

		txtObsequio1 = new JTextField();
		txtObsequio1.addKeyListener(new TxtObsequio1KeyListener());
		
		txtObsequio1.addMouseListener(new TxtObsequio1MouseListener());
		txtObsequio1.addMouseMotionListener(new TxtObsequio1MouseMotionListener());
		txtObsequio1.setBounds(128, 19, 100, 20);
		contentPanel.add(txtObsequio1);
		txtObsequio1.setColumns(10);

		lbl2a5Unidades = new JLabel("2 a 5 unidades");
		lbl2a5Unidades.setBounds(20, 47, 110, 14);
		contentPanel.add(lbl2a5Unidades);

		txtObsequio2 = new JTextField();
		txtObsequio2.addMouseListener(new TxtObsequio2MouseListener());
		txtObsequio2.addMouseMotionListener(new TxtObsequio2MouseMotionListener());
		txtObsequio2.setBounds(128, 44, 100, 20);
		contentPanel.add(txtObsequio2);
		txtObsequio2.setColumns(10);

		lbl6Unidades = new JLabel("6 a mï¿½s unidades");
		lbl6Unidades.setBounds(20, 72, 110, 14);
		contentPanel.add(lbl6Unidades);

		txtObsequio3 = new JTextField();
		txtObsequio3.addMouseListener(new TxtObsequio3MouseListener());
		txtObsequio3.addMouseMotionListener(new TxtObsequio3MouseMotionListener());
		txtObsequio3.setBounds(128, 69, 100, 20);
		contentPanel.add(txtObsequio3);
		txtObsequio3.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(263, 18, 89, 23);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(263, 43, 89, 23);
		contentPanel.add(btnCancelar);
		mostrar();
	}
	private void mostrar() {
		txtObsequio1.setText("" + FrmPrincipal.obsequio1);
		txtObsequio2.setText("" + FrmPrincipal.obsequio2);
		txtObsequio3.setText("" + FrmPrincipal.obsequio3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		

		String obsequio1, obsequio2, obsequio3;

		obsequio1 = getObsequio1();
		obsequio2 = getObsequio2();
		obsequio3 = getObsequio3();
		
		

		if (obsequio1.equals("") || obsequio2.equals("") || obsequio3.equals("")) {

			Adicional.mensajeFaltaCompletar("Falta completar el campo");

			txtObsequio1.setText(String.valueOf(FrmPrincipal.obsequio1));
			txtObsequio2.setText(String.valueOf(FrmPrincipal.obsequio2));
			txtObsequio3.setText(String.valueOf(FrmPrincipal.obsequio3));

		} else {

			if (FrmPrincipal.obsequio1.equals(obsequio1) && FrmPrincipal.obsequio2.equals(obsequio2)
					&& FrmPrincipal.obsequio3.equals(obsequio3)) {

				dispose();

			} else {

				FrmPrincipal.obsequio1 = obsequio1;
				FrmPrincipal.obsequio2 = obsequio2;
				FrmPrincipal.obsequio3 = obsequio3;

				Adicional.mensajeConfirmacion("Datos guardados correctamente");

				dispose();

			}

		}

	}

	private String getObsequio3() {

		return txtObsequio3.getText().trim();
	}

	private String getObsequio2() {

		return txtObsequio2.getText().trim();
	}

	private String getObsequio1() {
		return txtObsequio1.getText().trim();
	}

	private class TxtObsequio1MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtObsequio1.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtObsequio1MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtObsequio1.setBackground(Color.WHITE);
		}
	}
	private class TxtObsequio2MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtObsequio2.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtObsequio2MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtObsequio2.setBackground(Color.WHITE);
		}
	}
	private class TxtObsequio3MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtObsequio3.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtObsequio3MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtObsequio3.setBackground(Color.WHITE);
		}
	}
	private class TxtObsequio1KeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			boolean numeros = (key >= 97 && key <=122 ) || key >= 48 && key <= 57;
			if (!numeros) {
				e.consume();
			}
			if (key == 10) {
				botonAceptar();
			}
			 {
				
			 }
		
		}

		private void botonAceptar() {
			
		}
	}
}
	
	
		
	
	
