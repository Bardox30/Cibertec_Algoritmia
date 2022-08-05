package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DlgConfigurarCuotaDiaria extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCuotaDiaria;
	private JTextField txtCuotaDiariaEsperada;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
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
	public DlgConfigurarCuotaDiaria() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConfigurarCuotaDiaria.class.getResource("/img/cuota.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setModal(true);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 458, 138);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCuotaDiaria = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiaria.setBounds(10, 26, 163, 14);
		contentPanel.add(lblCuotaDiaria);

		txtCuotaDiariaEsperada = new JTextField();
		txtCuotaDiariaEsperada.addMouseListener(new TxtCuotaDiariaEsperadaMouseListener());
		txtCuotaDiariaEsperada.addMouseMotionListener(new TxtCuotaDiariaEsperadaMouseMotionListener());

		txtCuotaDiariaEsperada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtCuotaDiariaEsperada(e);
			}
		});
		txtCuotaDiariaEsperada.setBounds(177, 23, 111, 20);
		contentPanel.add(txtCuotaDiariaEsperada);
		txtCuotaDiariaEsperada.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgConfigurarCuotaDiaria.class.getResource("/img/guardar.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(313, 10, 115, 35);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(DlgConfigurarCuotaDiaria.class.getResource("/img/exit2.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		btnCancelar.setBounds(313, 53, 115, 35);
		contentPanel.add(btnCancelar);

		txtCuotaDiariaEsperada.setText("" + FrmPrincipal.cuotaDiaria);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		botonAceptar();
	}

	private void botonAceptar() {
		try {
			double cuotaDiaria = Double.parseDouble(txtCuotaDiariaEsperada.getText().trim());
			// Validacion
			if (cuotaDiaria <= 0) {
				Adicional.mensajeAlerta("Ingresar valores mayores a 0");
				txtCuotaDiariaEsperada.setText(String.valueOf(Adicional.df.format(FrmPrincipal.cuotaDiaria)));
				return;
			} else if (txtCuotaDiariaEsperada.getText().length() > 7) {
				Adicional.mensajeLimite("Solo se permite hasta 7 cifras");
				txtCuotaDiariaEsperada.setText(String.valueOf(Adicional.df.format(FrmPrincipal.cuotaDiaria)));
				return;
			} else {
				// Ventana de confirmaci0n
				FrmPrincipal.cuotaDiaria = cuotaDiaria;
				Adicional.mensajeConfirmacion("Datos guardados correctamente");

			}
			dispose();
		} catch (NumberFormatException e1) {
			Adicional.mensajeInformativo("Ingresar valores numÃ©ricos");
			txtCuotaDiariaEsperada.setText(String.valueOf(Adicional.df.format(FrmPrincipal.cuotaDiaria)));
			return;
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		// Cerrar ventana
		dispose();
	}

	public void keyTyped(KeyEvent e) {
		keyTypedTxtCuotaDiariaEsperada(e);
	}

	protected void keyTypedTxtCuotaDiariaEsperada(KeyEvent e) {
		int key = e.getKeyChar();
		boolean numeros = (key >= 48 && key <= 57) || key == 46;
		if (!numeros) {
			e.consume();
		}
		if (key == 10) {
			botonAceptar();
		}
	}

	private class TxtCuotaDiariaEsperadaMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtCuotaDiariaEsperada.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}

	private class TxtCuotaDiariaEsperadaMouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtCuotaDiariaEsperada.setBackground(Color.WHITE);
		}
	}
	
}
