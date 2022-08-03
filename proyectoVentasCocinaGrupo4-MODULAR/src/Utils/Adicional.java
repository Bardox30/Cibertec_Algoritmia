package Utils;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import sistemaVentasCocina.DlgModificarCocina;
import sistemaVentasCocina.DlgVentas;

public class Adicional {
	
	// CONTROLAR DECIMALES
	public static DecimalFormat df = new DecimalFormat("0.00");

	// NOMBRES DE MÉTODOS DE MENSAJE PARA ALERTAS
	public static void mensajeAlerta(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/alerta2.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}
	

	public static int mensajeConfirmar( String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/confirma.png");
		return JOptionPane.showConfirmDialog(null, msj, "Sistema",
				JOptionPane.YES_NO_OPTION,0,icon);
	}
	
	public static void mensajeBienvenido(String msj) {

		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/bienvenido.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}

	public static void mensajeInformativo(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/alerta3.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}
	
	public static void mensajeLimite(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/parar.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);	
	}
	
	public static void mensajeConfirmacion(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/confirma.png");
		JOptionPane.showMessageDialog(null, msj, "Sistema", 0, icon);
	}
	
	public static void mensajeFaltaCompletar(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/falta.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}
	
	public static void mensajeSeguroDeModificar(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/modificar.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}
	
	public static void mensajeAcumulador(String msj) {
		ImageIcon icon = new ImageIcon("../proyectoVentasCocinaGrupo4-MODULAR/src/img/subida.png");
		JOptionPane.showMessageDialog(null, msj, "Error", 0, icon);
	}


	// Mensaje de error
	public static void mensaje(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Error", 0);
	}
	
}
