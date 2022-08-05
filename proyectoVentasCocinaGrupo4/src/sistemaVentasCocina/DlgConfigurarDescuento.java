package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DlgConfigurarDescuento extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JButton btnCancelar;
	private JButton btnAceptar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarDescuento dialog = new DlgConfigurarDescuento();
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
	public DlgConfigurarDescuento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConfigurarDescuento.class.getResource("/img/descuento.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setModal(true);
		setResizable(false);
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 166);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPorcentaje1 = new JLabel("1 a 5 unidades");
			lblPorcentaje1.setBounds(10, 10, 109, 13);
			contentPanel.add(lblPorcentaje1);
		}
		{
			JLabel lblPorcentaje2 = new JLabel("6 a 10 unidades");
			lblPorcentaje2.setBounds(10, 33, 109, 13);
			contentPanel.add(lblPorcentaje2);
		}
		{
			JLabel lblPorcentaje3 = new JLabel("11 a 15 unidades");
			lblPorcentaje3.setBounds(10, 56, 109, 13);
			contentPanel.add(lblPorcentaje3);
		}
		{
			JLabel lblPorcentaje4 = new JLabel("Más de 15 unidades");
			lblPorcentaje4.setBounds(10, 82, 148, 13);
			contentPanel.add(lblPorcentaje4);
		}
		{
			txtPorcentaje1 = new JTextField();
			txtPorcentaje1.addKeyListener(new TxtPorcentaje1KeyListener());
			txtPorcentaje1.addMouseListener(new TxtPorcentaje1MouseListener());
			txtPorcentaje1.addMouseMotionListener(new TxtPorcentaje1MouseMotionListener());
			txtPorcentaje1.setBounds(129, 7, 96, 19);
			contentPanel.add(txtPorcentaje1);
			txtPorcentaje1.setColumns(10);
		}
		{
			txtPorcentaje2 = new JTextField();
			txtPorcentaje2.addKeyListener(new TxtPorcentaje2KeyListener());
			txtPorcentaje2.addMouseListener(new TxtPorcentaje2MouseListener());
			txtPorcentaje2.addMouseMotionListener(new TxtPorcentaje2MouseMotionListener());
			txtPorcentaje2.setBounds(129, 30, 96, 19);
			contentPanel.add(txtPorcentaje2);
			txtPorcentaje2.setColumns(10);
		}
		{
			txtPorcentaje3 = new JTextField();
			txtPorcentaje3.addKeyListener(new TxtPorcentaje3KeyListener());
			txtPorcentaje3.addMouseListener(new TxtPorcentaje3MouseListener());
			txtPorcentaje3.addMouseMotionListener(new TxtPorcentaje3MouseMotionListener());
			txtPorcentaje3.setBounds(129, 53, 96, 19);
			contentPanel.add(txtPorcentaje3);
			txtPorcentaje3.setColumns(10);
		}
		{
			txtPorcentaje4 = new JTextField();
			txtPorcentaje4.addKeyListener(new TxtPorcentaje4KeyListener());
			txtPorcentaje4.addMouseListener(new TxtPorcentaje4MouseListener());
			txtPorcentaje4.addMouseMotionListener(new TxtPorcentaje4MouseMotionListener());
			txtPorcentaje4.setBounds(129, 79, 96, 19);
			contentPanel.add(txtPorcentaje4);
			txtPorcentaje4.setColumns(10);
		}
		{
			JLabel lblPorcentaje = new JLabel("%");
			lblPorcentaje.setBounds(235, 10, 45, 13);
			contentPanel.add(lblPorcentaje);
		}
		{
			JLabel lblPorcentaje = new JLabel("%");
			lblPorcentaje.setBounds(235, 33, 45, 13);
			contentPanel.add(lblPorcentaje);
		}
		{
			JLabel lblPorcentaje = new JLabel("%");
			lblPorcentaje.setBounds(235, 56, 45, 13);
			contentPanel.add(lblPorcentaje);
		}
		{
			JLabel lblPorcentaje = new JLabel("%");
			lblPorcentaje.setBounds(235, 82, 45, 13);
			contentPanel.add(lblPorcentaje);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon(DlgConfigurarDescuento.class.getResource("/img/guardar.png")));
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(302, 10, 115, 35);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon(DlgConfigurarDescuento.class.getResource("/img/exit2.png")));
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(302, 56, 115, 35);
			contentPanel.add(btnCancelar);
			
			txtPorcentaje1.setText("" + FrmPrincipal.porcentaje1);
			txtPorcentaje2.setText("" + FrmPrincipal.porcentaje2);
			txtPorcentaje3.setText("" + FrmPrincipal.porcentaje3);
			txtPorcentaje4.setText("" + FrmPrincipal.porcentaje4);
			
		}
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
		botonAceptar();
	}
	
	private void botonAceptar() {			
		
		//entrada de datos
		double porcentaje1 = 0, porcentaje2 = 0, porcentaje3 = 0, porcentaje4 = 0;

		try {

			porcentaje1 = getPorcentaje1();
			porcentaje2 = getPorcentaje2();
			porcentaje3 = getPorcentaje3();
			porcentaje4 = getPorcentaje4();

			if (porcentaje1 < 0 || porcentaje2 < 0 || porcentaje2 < 0 || porcentaje2 < 0) {

				Adicional.mensajeAlerta("Ingresar valores mayores o igual a 0");

				txtPorcentaje1.setText(String.valueOf(FrmPrincipal.porcentaje1));
				txtPorcentaje2.setText(String.valueOf(FrmPrincipal.porcentaje2));
				txtPorcentaje3.setText(String.valueOf(FrmPrincipal.porcentaje3));
				txtPorcentaje4.setText(String.valueOf(FrmPrincipal.porcentaje4));

			} else {

				if (FrmPrincipal.porcentaje1 != porcentaje1 || FrmPrincipal.porcentaje2 != porcentaje2
						|| FrmPrincipal.porcentaje3 != porcentaje3 || FrmPrincipal.porcentaje4 != porcentaje4) {
					
					FrmPrincipal.porcentaje1 = porcentaje1;
					FrmPrincipal.porcentaje2 = porcentaje2;
					FrmPrincipal.porcentaje3 = porcentaje3;
					FrmPrincipal.porcentaje4 = porcentaje4;

					Adicional.mensajeConfirmacion("Datos guardados correctamente");

					dispose();

				} else {

					dispose();
				}
			}

		} catch (NumberFormatException e1) {

			Adicional.mensajeInformativo("Ingresar valores numéricos");

			txtPorcentaje1.setText(String.valueOf(FrmPrincipal.porcentaje1));
			txtPorcentaje2.setText(String.valueOf(FrmPrincipal.porcentaje2));
			txtPorcentaje3.setText(String.valueOf(FrmPrincipal.porcentaje3));
			txtPorcentaje4.setText(String.valueOf(FrmPrincipal.porcentaje4));
		}
	}
	

	private double getPorcentaje4() {		
		return Double.parseDouble(txtPorcentaje4.getText().trim());
	}

	private double getPorcentaje3() {		
		return Double.parseDouble(txtPorcentaje3.getText().trim());
	}

	private double getPorcentaje2() {	
		return Double.parseDouble(txtPorcentaje2.getText().trim());
	}

	private double getPorcentaje1() {		
		return Double.parseDouble(txtPorcentaje1.getText().trim());
	}
	
	private class TxtPorcentaje1MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtPorcentaje1.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtPorcentaje1MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtPorcentaje1.setBackground(Color.WHITE);
		}
		
	}
	private class TxtPorcentaje2MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtPorcentaje2.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtPorcentaje2MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtPorcentaje2.setBackground(Color.WHITE);
		}
	}
	private class TxtPorcentaje3MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtPorcentaje3.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtPorcentaje3MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtPorcentaje3.setBackground(Color.WHITE);
		}
	}
	private class TxtPorcentaje4MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			txtPorcentaje4.setBackground(Color.getHSBColor(64f, 64f, 64f));
		}
	}
	private class TxtPorcentaje4MouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			txtPorcentaje4.setBackground(Color.WHITE);
		}
	}
	private class TxtPorcentaje1KeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			boolean numeros = (key >= 48 && key <= 57) || key == 46;
			if (!numeros) {
				e.consume();
			}
			if (key == 10) {
				botonAceptar();
			}
		}
	}
	private class TxtPorcentaje2KeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			boolean numeros = (key >=48 && key <= 57) || key == 46;
			if (!numeros) {
				e.consume();
			}
			if (key ==10) {
				botonAceptar();
			}
		}
	}
	private class TxtPorcentaje3KeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			boolean numeros = (key >=48 && key <= 57) || key == 46;
			if (!numeros) {
				e.consume();
			}
			if (key ==10) {
				botonAceptar();
			}			
		}
	}
	private class TxtPorcentaje4KeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			boolean numeros = (key >=48 && key <= 57) || key == 46;
			if (!numeros) {
				e.consume();
			}
			if (key ==10) {
				botonAceptar();
			}
		}
	}
	
}
