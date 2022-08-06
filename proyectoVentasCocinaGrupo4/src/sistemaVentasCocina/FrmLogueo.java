package sistemaVentasCocina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Utils.Adicional;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
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
	private JPasswordField jPassword;
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
		lblUsuario.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/user2.png")));
		lblUsuario.setForeground(new Color(248, 248, 255));
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblUsuario.setBounds(114, 75, 112, 32);
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
		txtUsuario.setBounds(239, 82, 117, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/password.png")));
		lblContrasena.setForeground(new Color(248, 248, 255));
		lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblContrasena.setBounds(83, 134, 146, 32);
		contentPane.add(lblContrasena);

		jPassword = new JPasswordField();
		jPassword.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseMovedJPasword(e);
			}
		});
		jPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedJPasword(e);
			}
		});
		jPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedJPasword(e);
			}
		});
		jPassword.setBounds(239, 142, 117, 23);
		contentPane.add(jPassword);

		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnIngresar.setBounds(98, 203, 117, 29);
		contentPane.add(btnIngresar);

		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 15));
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
		btnSalir.setBounds(251, 203, 105, 29);
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
		lblVer.setBounds(366, 143, 28, 29);
		contentPane.add(lblVer);
		
		lblNover = new JLabel("");
		lblNover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblNover(e);
			}
		});
		lblNover.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/nover.png")));
		lblNover.setBounds(366, 143, 28, 29);
		contentPane.add(lblNover);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/login1.jpeg")));
		lblNewLabel.setBounds(-203, -125, 775, 577);
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
		else if (usuario.equals(String.valueOf(FrmPrincipal.usuario0)) && clave.equals(String.valueOf(FrmPrincipal.clave0))) {
			FrmPrincipal.entradaUser0++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario0);

			FrmPrincipal eje = new FrmPrincipal();
			eje.setVisible(true);
			eje.setLocationRelativeTo(this);

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario1)) && clave.equals(String.valueOf(FrmPrincipal.clave1))) {
			FrmPrincipal.entradaUser1++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario1);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario2)) && clave.equals(String.valueOf(FrmPrincipal.clave2))) {
			FrmPrincipal.entradaUser2++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario2);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario3)) && clave.equals(String.valueOf(FrmPrincipal.clave3))) {
			FrmPrincipal.entradaUser3++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario3);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario4)) && clave.equals(String.valueOf(FrmPrincipal.clave4))) {
			FrmPrincipal.entradaUser4++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario4);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario5)) && clave.equals(String.valueOf(FrmPrincipal.clave5))) {
			FrmPrincipal.entradaUser5++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario5);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario6)) && clave.equals(String.valueOf(FrmPrincipal.clave6))) {
			FrmPrincipal.entradaUser6++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario6);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario7)) && clave.equals(String.valueOf(FrmPrincipal.clave7))) {
			FrmPrincipal.entradaUser7++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario7);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario8)) && clave.equals(String.valueOf(FrmPrincipal.clave8))) {
			FrmPrincipal.entradaUser8++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario8);
			
			// Entrada al sistema
			entrarPrincipal();			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else if (usuario.equals(String.valueOf(FrmPrincipal.usuario9)) && clave.equals(String.valueOf(FrmPrincipal.clave9))) {
			FrmPrincipal.entradaUser9++;
			Adicional.mensajeBienvenido("Bienvenido al sistema, "+FrmPrincipal.usuario9);
			
			// Entrada al sistema
			entrarPrincipal();
			
			// Inhabilitar opciones
			inhabilitarOpciones();

			this.dispose();
		} else {
			Adicional.mensaje("Usuario y/o clave incorrecta");
		}
	}

	private String getClave() {
		return String.valueOf(jPassword.getPassword());
	}

	private String getUsuario() {
		return txtUsuario.getText().trim();
	}
	
	private void entrarPrincipal() {
		FrmPrincipal eje = new FrmPrincipal();
		eje.setVisible(true);
		eje.setLocationRelativeTo(this);
	}
	private void inhabilitarOpciones(){
		FrmPrincipal.mnConfiguracion.setEnabled(false);
		FrmPrincipal.mntmModificarCocina.setEnabled(false);
		FrmPrincipal.mnSeguimiento.setEnabled(false);
	}
	
	//botón salir
	protected void mouseClickedBtnSalir(MouseEvent e) {
		int opcion = Adicional.mensajeConfirmar("¿Desea salir de la aplicación?");
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
		jPassword.setEchoChar((char)0);		
	}
	
	//para que no sea visible la contraseña
	protected void mouseClickedLblNover(MouseEvent e) {
		lblVer.setVisible(true);
		lblNover.setVisible(false);
		jPassword.setEchoChar('*');
	}
	protected void mouseMovedTxtUsuario(MouseEvent e) {
			txtUsuario.setBackground(Color.getHSBColor(44f, 70f, 46f));
		
	}
	protected void mouseExitedTxtUsuario(MouseEvent e) {
		txtUsuario.setBackground(Color.WHITE);
	}
	protected void mouseMovedJPasword(MouseEvent e) {
		jPassword.setBackground(Color.getHSBColor(44f, 70f, 46f));
	}
	protected void mouseExitedJPasword(MouseEvent e) {
		jPassword.setBackground(Color.WHITE);
	}
}
