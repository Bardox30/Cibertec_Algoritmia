package sistemaVentasCocina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.Adicional;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrmPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	public static JMenu mnConfiguracion; 
	private JMenu mnNewMenu;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarCocina;
	public static JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocinas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmAcercaDeTienda;

	// VARIABLES GLOBALES PÚBLICAS

	// COCINA 0
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	public static int cantidadVentas0 = 0;
	public static double impTotalVendido0 = 0;
	// COCINA 1
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	public static int cantidadVentas1 = 0;
	public static double impTotalVendido1 = 0;
	// COCINA 2
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	public static int cantidadVentas2 = 0;
	public static double impTotalVendido2 = 0;
	// COCINA 3
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	public static int cantidadVentas3 = 0;
	public static double impTotalVendido3 = 0;
	// COCINA 4
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	public static int cantidadVentas4 = 0;
	public static double impTotalVendido4 = 0;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 30;
	// Cuota diaria
	public static double cuotaDiaria = 75000;
	private JPanel panel;
	private JLabel lblNewLabel;
	// contador general
	public static int contVentGeneral;
	public static double impTotGeneral;

	/// Importe total acumulado
	public static double importeTotalGeneralAcumulado;
	public static double aporteGeneralCuotaDiaria;

	// Cuota diaria acumulada
	public static double cuotaDiariaAcumulada;

	// Número de ventas
	public static int nVentas = 0;

	///////////////////////////////////////////////////////////////////////
	
	/// CANTIDAD DE UNIDADES VENDIDAS, CANTIDAD DE VENTAS REALIZADAS, TOTAL DE IMPORTE VENDIDO, APORTE
	
	public static int cantUniVendidas0 = 0; // cantidad de unidades vendidas
	public static int cantVentas0 = 0; // el número de ventas que hubieron
	public static double totalImpVendido0 = 0; // la suma del importe total de todas las ventas
	public static double aporteCuotaDiaria0;

	public static int cantUniVendidas1 = 0; // cantidad de unidades vendidas
	public static int cantVentas1 = 0; // el número de ventas que hubieron
	public static double totalImpVendido1 = 0; // la suma del importe total de todas las ventas
	public static double aporteCuotaDiaria1;

	public static int cantUniVendidas2 = 0; // cantidad de unidades vendidas
	public static int cantVentas2 = 0; // el número de ventas que hubieron
	public static double totalImpVendido2 = 0; // la suma del importe total de todas las ventas
	public static double aporteCuotaDiaria2;

	public static int cantUniVendidas3 = 0; // cantidad de unidades vendidas
	public static int cantVentas3 = 0; // el número de ventas que hubieron
	public static double totalImpVendido3 = 0; // la suma del importe total de todas las ventas
	public static double aporteCuotaDiaria3;

	public static int cantUniVendidas4 = 0; // cantidad de unidades vendidas
	public static int cantVentas4 = 0; // el número de ventas que hubieron
	public static double totalImpVendido4 = 0; // la suma del importe total de todas las ventas
	public static double aporteCuotaDiaria4;
	private JLabel lblNewLabel_1;

	///////////////////////////////////////////////////////////////////////

	// LISTA DE USUARIOS Y SUS CLAVES
	public static String usuario0="admin";
	public static String usuario1="joel";
	public static String usuario2="giomar";
	public static String usuario3="joseluis";
	public static String usuario4="marcela";
	public static String usuario5="jackeline";
	public static String usuario6="alexia";
	
	public static int clave0=12345678;
	public static int clave1=69420;
	public static int clave2=12345;
	public static int clave3=12345;
	public static int clave4=12345;
	public static int clave5=12345;
	public static int clave6=12345;
	//
	/// USUARIOS ADICIONALES
	public static String usuario7="";
	public static String usuario8="";
	public static String usuario9="";
	
	public static int clave7=0;
	public static int clave8=0;
	public static int clave9=0;
	
	//
	//////////////////////////////////////////////
	// Entrada usuarios
	public static int entradaUser0=0;
	public static int entradaUser1=0;
	public static int entradaUser2=0;
	public static int entradaUser3=0;
	public static int entradaUser4=0;
	public static int entradaUser5=0;
	public static int entradaUser6=0;
	public static int entradaUser7=0;
	public static int entradaUser8=0;
	public static int entradaUser9=0;
	///////////////////////////////////////////
	public static double montoRecaudoUser0;
	public static int cantVentasUser0;
	public static int produVendiUser0;
	
	public static double montoRecaudoUser1;
	public static int cantVentasUser1;
	public static int produVendiUser1;
	
	public static double montoRecaudoUser2;
	public static int cantVentasUser2;
	public static int produVendiUser2;
	
	public static double montoRecaudoUser3;
	public static int cantVentasUser3;
	public static int produVendiUser3;
	
	public static double montoRecaudoUser4;
	public static int cantVentasUser4;
	public static int produVendiUser4;
	
	public static double montoRecaudoUser5;
	public static int cantVentasUser5;
	public static int produVendiUser5;
	
	public static double montoRecaudoUser6;
	public static int cantVentasUser6;
	public static int produVendiUser6;
	
	public static double montoRecaudoUser7;
	public static int cantVentasUser7;
	public static int produVendiUser7;
	
	public static double montoRecaudoUser8;
	public static int cantVentasUser8;
	public static int produVendiUser8;
	
	public static double montoRecaudoUser9;
	public static int cantVentasUser9;
	public static int produVendiUser9;
	
	
	
	//////////////////////////////////////////
	
	private JMenuItem mntmCambiarDeUsuario;
	private JMenu mnSeguimiento;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmProductividad;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					//maximizar la pantalla
					//frame.setExtendedState(MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setResizable(false);
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 600);
		this.setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(47, 79, 79));
		menuBar.setBackground(Color.ORANGE);
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cerrar1.png")));
		mntmSalir.addActionListener(this);
		
		mntmCambiarDeUsuario = new JMenuItem("Cambiar de usuario");
		mntmCambiarDeUsuario.addActionListener(this);
		mnArchivo.add(mntmCambiarDeUsuario);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultarCocina = new JMenuItem("Consultar cocina");
		mntmConsultarCocina.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm1.png")));
		mntmConsultarCocina.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCocina);

		mntmModificarCocina = new JMenuItem("Modificar cocina");
		mntmModificarCocina.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm2.png")));
		mntmModificarCocina.addActionListener(this);
		mnMantenimiento.add(mntmModificarCocina);

		mntmListarCocinas = new JMenuItem("Listar cocinas");
		mntmListarCocinas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm3.png")));
		mntmListarCocinas.addActionListener(this);
		mnMantenimiento.add(mntmListarCocinas);

		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm4.png")));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);

		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm5.png")));
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);

		mnConfiguracion = new JMenu("Configuración");
		menuBar.add(mnConfiguracion);

		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm6.png")));
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);

		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm7.png")));
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);

		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad óptima");
		mntmConfigurarCantidadOptima.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/fmr8.png")));
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);

		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm9.png")));
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);

		mnNewMenu = new JMenu("Ayuda");
		menuBar.add(mnNewMenu);

		mntmAcercaDeTienda = new JMenuItem("Acerca de tienda");
		mntmAcercaDeTienda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/frm10.png")));
		mntmAcercaDeTienda.addActionListener(this);
		mnNewMenu.add(mntmAcercaDeTienda);
		
		mnSeguimiento = new JMenu("Seguimiento");
		menuBar.add(mnSeguimiento);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(this);
		mnSeguimiento.add(mntmUsuarios);
		
		mntmProductividad = new JMenuItem("Productividad");
		mntmProductividad.addActionListener(this);
		mnSeguimiento.add(mntmProductividad);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 884, 535);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cocina5.jpg")));
		lblNewLabel.setBounds(0, 0, 847, 546);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Coldex");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(42, 432, 102, 14);
		panel.add(lblNewLabel_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmProductividad) {
			actionPerformedMntmProductividad(e);
		}
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mntmCambiarDeUsuario) {
			actionPerformedMntmCambiarDeUsuario(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarCocinas) {
			actionPerformedMntmListarCocinas(e);
		}
		if (e.getSource() == mntmModificarCocina) {
			actionPerformedMntmModificarCocina(e);
		}
		if (e.getSource() == mntmConsultarCocina) {
			actionPerformedMntmConsultarCocina(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		// Cerrar aplicación
		System.exit(0);		
	}

	protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
		// Crear un nuevo objeto
		DlgConsultarCocina con = new DlgConsultarCocina();
		// Visibilidad
		con.setVisible(true);
		// Ubicacion de ventana
		con.setLocationRelativeTo(this);

	}

	protected void actionPerformedMntmModificarCocina(ActionEvent e) {
		DlgModificarCocina mod = new DlgModificarCocina();
		mod.setVisible(true);
		mod.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmListarCocinas(ActionEvent e) {
		DlgListarCocina listarCocina = new DlgListarCocina();
		listarCocina.setVisible(true);
		listarCocina.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmVender(ActionEvent e) {
		DlgVentas vender = new DlgVentas();
		vender.setVisible(true);
		vender.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		DlgConfigurarDescuento confDscto = new DlgConfigurarDescuento();
		confDscto.setVisible(true);
		confDscto.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		DlgConfigurarObsequio confObsequio = new DlgConfigurarObsequio();
		confObsequio.setVisible(true);
		confObsequio.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		DlgConfigurarCantidadOptima cantOptima = new DlgConfigurarCantidadOptima();
		cantOptima.setVisible(true);
		cantOptima.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		DlgConfigurarCuotaDiaria confcuotadiaria = new DlgConfigurarCuotaDiaria();
		confcuotadiaria.setVisible(true);
		confcuotadiaria.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		DlgAcercaDeTienda acerca = new DlgAcercaDeTienda();
		acerca.setVisible(true);
		acerca.setLocationRelativeTo(this);
	}

	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DlgGenerarReportes reportes = new DlgGenerarReportes();
		reportes.setVisible(true);
		reportes.setLocationRelativeTo(this);
	}

	public static double caclImporteGeneralAcum() {
		return FrmPrincipal.totalImpVendido0 + FrmPrincipal.totalImpVendido1 + FrmPrincipal.totalImpVendido2
				+ FrmPrincipal.totalImpVendido3 + FrmPrincipal.totalImpVendido4;

	}
	public static double calcCuotaDiariaAcum() {
		return (caclImporteGeneralAcum() * 100) / FrmPrincipal.cuotaDiaria;
	}
	protected void actionPerformedMntmCambiarDeUsuario(ActionEvent e) {
		//INDICAR QUE SE ENTRARÁ DESDE OTRO USUARIO
		Adicional.indicarCambiarUsuario();
		
		//IR A LOGUIN
		FrmLogueo log = new FrmLogueo();
		log.setVisible(true);
		this.dispose();
		
		//FALTA CENTRAR LA VENTANA DE LOGUEO
		/////////////////////////////////////
	}
	protected void actionPerformedMntmUsuarios(ActionEvent e) {
		DlgUsuarios reportes = new DlgUsuarios();
		reportes.setVisible(true);
		reportes.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmProductividad(ActionEvent e) {
		DlgProductividad reportes = new DlgProductividad();
		reportes.setVisible(true);
		reportes.setLocationRelativeTo(this);
	}
}