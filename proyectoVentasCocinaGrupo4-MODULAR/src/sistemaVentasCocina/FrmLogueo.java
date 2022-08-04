package sistemaVentasCocina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;

public class FrmLogueo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6788270500177990388L;
	private static final ActionEvent ActionEvent = null;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasena;
	private JPasswordField jPasword;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JLabel lblVer;
	private JLabel lblNover;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogueo frame = new FrmLogueo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.lblNover.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogueo() {
		setBackground(new Color(0, 0, 0));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 328);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblUsuario.setBounds(116, 53, 112, 21);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedTxtUsuario(e);
			}
		});
		txtUsuario.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseMovedTxtUsuario(e);
			}
		});
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtUsuario.setBounds(238, 53, 105, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setForeground(new Color(0, 0, 0));
		lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblContrasena.setBounds(116, 98, 112, 22);
		contentPane.add(lblContrasena);

		jPasword = new JPasswordField();
		jPasword.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseMovedJPasword(e);
			}
		});
		jPasword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedJPasword(e);
			}
		});
		jPasword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedJPasword(e);
			}
		});
		jPasword.setBounds(238, 101, 105, 23);
		contentPane.add(jPasword);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnIngresar.setBounds(116, 149, 89, 29);
		contentPane.add(btnIngresar);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedBtnSalir(e);
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformed(e);
			}
		});
		btnSalir.setBounds(248, 149, 89, 29);
		contentPane.add(btnSalir);
		
		lblVer = new JLabel("");
		lblVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblVer(e);
			}
		});
		lblVer.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/ver (1).png")));
		lblVer.setHorizontalAlignment(SwingConstants.LEFT);
		lblVer.setBounds(366, 95, 28, 29);
		contentPane.add(lblVer);
		
		lblNover = new JLabel("");
		lblNover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblNover(e);
			}
		});
		lblNover.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/nover.png")));
		lblNover.setBounds(366, 91, 28, 29);
		contentPane.add(lblNover);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/logeo1.jpg")));
		lblNewLabel.setBounds(0, -20, 423, 348);
		contentPane.add(lblNewLabel);
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		
		// Declaracion de variables
		String usuario, clave;
		// Obtener los datos ingresados en la GUI
		usuario = getUsuario();
		clave = getClave();		

		// Validación
		if (usuario.isEmpty() || clave.isEmpty()) {
			Adicional.mensajeAlerta("Algún campo está vacio.");
		} 
		// Entrada de usuarios
		else if (usuario.equals("admin") && clave.equals("123")) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");

			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario1)) && clave.equals(String.valueOf(FrmPrincipal.clave1))) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");
			
			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);
			
			// Inhabilitar opciones
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			FrmPrincipal.mntmModificarCocina.setEnabled(false);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario2)) && clave.equals(String.valueOf(FrmPrincipal.clave2))) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");
			
			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);
			
			// Inhabilitar opciones
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			FrmPrincipal.mntmModificarCocina.setEnabled(false);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario3)) && clave.equals(String.valueOf(FrmPrincipal.clave3))) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");
			
			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);
			
			// Inhabilitar opciones
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			FrmPrincipal.mntmModificarCocina.setEnabled(false);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario4)) && clave.equals(String.valueOf(FrmPrincipal.clave4))) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");
			
			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);
			
			// Inhabilitar opciones
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			FrmPrincipal.mntmModificarCocina.setEnabled(false);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario5)) && clave.equals(String.valueOf(FrmPrincipal.clave5))) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");
			
			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);
			
			// Inhabilitar opciones
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			FrmPrincipal.mntmModificarCocina.setEnabled(false);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario6)) && clave.equals(String.valueOf(FrmPrincipal.clave6))) {
			Adicional.mensajeBienvenido("Bienvenido al sistema");
			
			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);
			
			// Inhabilitar opciones
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			FrmPrincipal.mntmModificarCocina.setEnabled(false);

			this.dispose();
		} else {
			Adicional.mensaje("Usuario y/o clave incorrecta");
		}

	}
	
	///// esto verificar después si sirve o se elimina
	private void mensaje(String msj) {
		Adicional.mensaje(msj);
	}
	

	private String getClave() {
		return String.valueOf(jPasword.getPassword());
	}

	private String getUsuario() {
		return txtUsuario.getText().trim();
	}
	
	//botón salir
	protected void mouseClickedBtnSalir(MouseEvent e) {
		int opcion = Adicional.mensajeConfirmar("¿Desea realmente salir de la aplicación?");
		if (opcion == 0) {
			dispose();
		}

	}
	protected void keyTypedJPasword(KeyEvent e) {
		int key = e.getKeyChar();
		if (key == 10) {
			actionPerformedBtnIngresar(ActionEvent );
		}		 
	}
	
	//para poder ver la contraseña
	protected void mouseClickedLblVer(MouseEvent e) {
		lblVer.setVisible(false);
		lblNover.setVisible(true);
		jPasword.setEchoChar((char)0);		
	}
	
	//para que no sea visible la contraseña
	protected void mouseClickedLblNover(MouseEvent e) {
		lblVer.setVisible(true);
		lblNover.setVisible(false);
		jPasword.setEchoChar('*');
	}
	protected void mouseMovedTxtUsuario(MouseEvent e) {
			txtUsuario.setBackground(Color.getHSBColor(44f, 70f, 46f));
		
	}
	protected void mouseExitedTxtUsuario(MouseEvent e) {
		txtUsuario.setBackground(Color.WHITE);
	}
	protected void mouseMovedJPasword(MouseEvent e) {
		jPasword.setBackground(Color.getHSBColor(44f, 70f, 46f));
	}
	protected void mouseExitedJPasword(MouseEvent e) {
		jPasword.setBackground(Color.WHITE);
	}
}