package Utils;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import sistemaVentasCocina.FrmPrincipal;

public class Adicional {	

	public static void getUsuario(int numUser, String usuario, String clave) {	
		switch(numUser) {
		case 7:
			FrmPrincipal.usuario7=usuario;
			FrmPrincipal.clave7=clave;
			break;			
		case 8:
			FrmPrincipal.usuario8=usuario;
			FrmPrincipal.clave8=clave;
			break;
		case 9:
			FrmPrincipal.usuario9=usuario;
			FrmPrincipal.clave9=clave;
			break;
		default:
			break;
		}	
	}
	
	public static void indicarCambiarUsuario() {
		if(FrmPrincipal.entradaUser0==1)
			FrmPrincipal.entradaUser0=0;
		if(FrmPrincipal.entradaUser1==1)
			FrmPrincipal.entradaUser1=0;
		if(FrmPrincipal.entradaUser2==1)
			FrmPrincipal.entradaUser2=0;
		if(FrmPrincipal.entradaUser3==1)
			FrmPrincipal.entradaUser3=0;
		if(FrmPrincipal.entradaUser4==1)
			FrmPrincipal.entradaUser4=0;
		if(FrmPrincipal.entradaUser5==1)
			FrmPrincipal.entradaUser5=0;
		if(FrmPrincipal.entradaUser6==1)
			FrmPrincipal.entradaUser6=0;
		if(FrmPrincipal.entradaUser7==1)
			FrmPrincipal.entradaUser7=0;
		if(FrmPrincipal.entradaUser8==1)
			FrmPrincipal.entradaUser8=0;
		if(FrmPrincipal.entradaUser9==1)
			FrmPrincipal.entradaUser9=0;
	}
	
	public static void ventasUsuarios(int numUser, double impPag, int cant) {	
		switch(numUser) {
		case 0:
			FrmPrincipal.montoRecaudoUser0+=impPag;
			FrmPrincipal.cantVentasUser0++;
			FrmPrincipal.produVendiUser0+=cant;
			break;			
		case 1:
			FrmPrincipal.montoRecaudoUser1+=impPag;
			FrmPrincipal.cantVentasUser1++;
			FrmPrincipal.produVendiUser1+=cant;
			break;
		case 2:
			FrmPrincipal.montoRecaudoUser2+=impPag;
			FrmPrincipal.cantVentasUser2++;
			FrmPrincipal.produVendiUser2+=cant;
			break;
		case 3:
			FrmPrincipal.montoRecaudoUser3+=impPag;
			FrmPrincipal.cantVentasUser3++;
			FrmPrincipal.produVendiUser3+=cant;
			break;
		case 4:
			FrmPrincipal.montoRecaudoUser4+=impPag;
			FrmPrincipal.cantVentasUser4++;
			FrmPrincipal.produVendiUser4+=cant;
			break;
		case 5:
			FrmPrincipal.montoRecaudoUser5+=impPag;
			FrmPrincipal.cantVentasUser5++;
			FrmPrincipal.produVendiUser5+=cant;
			break;
		case 6:
			FrmPrincipal.montoRecaudoUser6+=impPag;
			FrmPrincipal.cantVentasUser6++;
			FrmPrincipal.produVendiUser6+=cant;
			break;
		case 7:
			FrmPrincipal.montoRecaudoUser7+=impPag;
			FrmPrincipal.cantVentasUser7++;
			FrmPrincipal.produVendiUser7+=cant;
			break;
		case 8:
			FrmPrincipal.montoRecaudoUser8+=impPag;
			FrmPrincipal.cantVentasUser8++;
			FrmPrincipal.produVendiUser8+=cant;
			break;
		case 9:
			FrmPrincipal.montoRecaudoUser9+=impPag;
			FrmPrincipal.cantVentasUser9++;
			FrmPrincipal.produVendiUser9+=cant;
			break;
		}	
	}
	
	
	
	// CONTROLAR DECIMALES
	public static DecimalFormat df = new DecimalFormat("0.00");

	// NOMBRES DE MÉTODOS DE MENSAJE PARA ALERTAS
	public static void mensajeAlerta(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/alerta2.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);
	}
	

	public static int mensajeConfirmar( String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/confirma.png");
		return JOptionPane.showConfirmDialog(null, msj, "Sistema",
				JOptionPane.YES_NO_OPTION,0,icon);
	}
	
	public static void mensajeBienvenido(String msj) {

		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/bienvenido.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);
	}

	public static void mensajeInformativo(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/alerta3.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);
	}
	
	public static void mensajeLimite(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/parar.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);	
	}
	
	public static void mensajeConfirmacion(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/confirma.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);
	}
	
	public static void mensajeFaltaCompletar(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/falta.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}
	
	public static void mensajeSeguroDeModificar(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/modificar.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);
	}
	
	public static void mensajeAcumulador(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/subida.png");
		JOptionPane.showMessageDialog(null, msj, "Avance de ventas", 0, icon);
	}
	
	public static void mensajeExportar(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4/src/img/exportar.png");
		JOptionPane.showMessageDialog(null, msj, "Exportar Datos", 0, icon);
	}


	// Mensaje de error
	public static void mensaje(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0);
	}
	
}
