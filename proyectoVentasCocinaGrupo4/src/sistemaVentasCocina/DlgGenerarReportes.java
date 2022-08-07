package sistemaVentasCocina;

import java.awt.BorderLayout;
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
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgGenerarReportes extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoReporte;
	private JComboBox<?> cboTipoDeReporte;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGenerarReportes dialog = new DlgGenerarReportes();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DlgGenerarReportes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgGenerarReportes.class.getResource("/img/reporte.png")));
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Generar reportes");
		setBounds(100, 100, 662, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTipoReporte = new JLabel("Tipo de reporte");
		lblTipoReporte.setBounds(10, 23, 111, 13);
		contentPanel.add(lblTipoReporte);
		
		cboTipoDeReporte = new JComboBox();
		cboTipoDeReporte.addActionListener(this);
		cboTipoDeReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relación a la venta óptima", "Precios en relación al precio promedio", "Promedios, menores y mayores"}));
		cboTipoDeReporte.setBounds(120, 19, 324, 21);
		contentPanel.add(cboTipoDeReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgGenerarReportes.class.getResource("/img/exit2.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(516, 11, 115, 35);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 69, 628, 297);
		contentPanel.add(scrollPane);
		
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		mostrarDatos(0);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboTipoDeReporte) {
			actionPerformedCboTipoReporte(e);
		}
	}
	
	protected void actionPerformedCboTipoReporte(ActionEvent e) {
		/// declaración de variables		
		int tipoReporte;
		
		tipoReporte=cboTipoDeReporte.getSelectedIndex();
				
		mostrarDatos(tipoReporte);
		
	}
	
	private void mostrarDatos(int tipoReporte) {
		//cuotas diarias
		FrmPrincipal.aporteCuotaDiaria0 = (FrmPrincipal.totalImpVendido0 * 100) / FrmPrincipal.cuotaDiaria;
		FrmPrincipal.aporteCuotaDiaria1 = (FrmPrincipal.totalImpVendido1 * 100) / FrmPrincipal.cuotaDiaria;
		FrmPrincipal.aporteCuotaDiaria2 = (FrmPrincipal.totalImpVendido2 * 100) / FrmPrincipal.cuotaDiaria;
		FrmPrincipal.aporteCuotaDiaria3 = (FrmPrincipal.totalImpVendido3 * 100) / FrmPrincipal.cuotaDiaria;
		FrmPrincipal.aporteCuotaDiaria4 = (FrmPrincipal.totalImpVendido4 * 100) / FrmPrincipal.cuotaDiaria;
		
		switch(tipoReporte) {
		case 0:
			txtS.setText("VENTAS POR MODELO\n\n");
			
			imprimir("Modelo		: "+FrmPrincipal.modelo0);
			imprimir("Cantidad de ventas	: "+FrmPrincipal.cantVentas0); ///  
			imprimir("Cantidad de unidades vendidas	: "+FrmPrincipal.cantUniVendidas0);  // ahora si
			imprimir("Importe total vendido	: S/. "+Adicional.df.format(FrmPrincipal.totalImpVendido0));
			imprimir("Aporte a la cuota diaria	: " + Adicional.df.format(FrmPrincipal.aporteCuotaDiaria0)+"%\n");
			
			imprimir("Modelo		: "+FrmPrincipal.modelo1);
			imprimir("Cantidad de ventas	: "+FrmPrincipal.cantVentas1);
			imprimir("Cantidad de unidades vendidas	: "+FrmPrincipal.cantUniVendidas1);
			imprimir("Importe total vendido	: S/. "+Adicional.df.format(FrmPrincipal.totalImpVendido1));
			imprimir("Aporte a la cuota diaria	: " + Adicional.df.format(FrmPrincipal.aporteCuotaDiaria1)+"%\n");
			
			imprimir("Modelo		: "+FrmPrincipal.modelo2);
			imprimir("Cantidad de ventas	: "+FrmPrincipal.cantVentas2);
			imprimir("Cantidad de unidades vendidas	: "+FrmPrincipal.cantUniVendidas2);
			imprimir("Importe total vendido	: S/. "+Adicional.df.format(FrmPrincipal.totalImpVendido2));
			imprimir("Aporte a la cuota diaria	: " + Adicional.df.format(FrmPrincipal.aporteCuotaDiaria2)+"%\n");
			
			imprimir("Modelo		: "+FrmPrincipal.modelo3);
			imprimir("Cantidad de ventas	: "+FrmPrincipal.cantVentas3);
			imprimir("Cantidad de unidades vendidas	: "+FrmPrincipal.cantUniVendidas3);
			imprimir("Importe total vendido	: S/. "+Adicional.df.format(FrmPrincipal.totalImpVendido3));
			imprimir("Aporte a la cuota diaria	: " + Adicional.df.format(FrmPrincipal.aporteCuotaDiaria3)+"%\n");
			
			imprimir("Modelo		: "+FrmPrincipal.modelo4);
			imprimir("Cantidad de ventas	: "+FrmPrincipal.cantVentas4);
			imprimir("Cantidad de unidades vendidas	: "+FrmPrincipal.cantUniVendidas4);
			imprimir("Importe total vendido	: S/. "+Adicional.df.format(FrmPrincipal.totalImpVendido4));
			imprimir("Aporte a la cuota diaria	: " + Adicional.df.format(FrmPrincipal.aporteCuotaDiaria4)+"%\n");
			break;
		case 1:
			txtS.setText("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA\n\n");
			
			imprimir("Modelo			: "+FrmPrincipal.modelo0);
			imprimir("Cantidad de unidades vendidas		: "+relacionCantidadOptima(FrmPrincipal.cantUniVendidas0)+"\n");
			
			imprimir("Modelo			: "+FrmPrincipal.modelo1);
			imprimir("Cantidad de unidades vendidas		: "+relacionCantidadOptima(FrmPrincipal.cantUniVendidas1)+"\n");
			
			imprimir("Modelo			: "+FrmPrincipal.modelo2);
			imprimir("Cantidad de unidades vendidas		: "+relacionCantidadOptima(FrmPrincipal.cantUniVendidas2)+"\n");
			
			imprimir("Modelo			: "+FrmPrincipal.modelo3);
			imprimir("Cantidad de unidades vendidas		: "+relacionCantidadOptima(FrmPrincipal.cantUniVendidas3)+"\n");
			
			imprimir("Modelo			: "+FrmPrincipal.modelo4);
			imprimir("Cantidad de unidades vendidas		: "+relacionCantidadOptima(FrmPrincipal.cantUniVendidas4)+"\n");
			break;
		case 2:
			txtS.setText("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO\n\n");
			
			imprimir("Modelo	: "+FrmPrincipal.modelo0);
			imprimir("Precio	: S/. "+FrmPrincipal.precio0+relacionPromedio(FrmPrincipal.precio0)+"\n");
			
			imprimir("Modelo	: "+FrmPrincipal.modelo1);
			imprimir("Precio	: S/. "+FrmPrincipal.precio1+relacionPromedio(FrmPrincipal.precio1)+"\n");
			
			imprimir("Modelo	: "+FrmPrincipal.modelo2);
			imprimir("Precio	: S/. "+FrmPrincipal.precio2+relacionPromedio(FrmPrincipal.precio2)+"\n");
			
			imprimir("Modelo	: "+FrmPrincipal.modelo3);
			imprimir("Precio	: S/. "+FrmPrincipal.precio3+relacionPromedio(FrmPrincipal.precio3)+"\n");
			
			imprimir("Modelo	: "+FrmPrincipal.modelo4);
			imprimir("Precio	: S/. "+FrmPrincipal.precio4+relacionPromedio(FrmPrincipal.precio4)+"\n");
			break;
		default:
			txtS.setText("PROMEDIOS, MENORES Y MAYORES\n\n");
			
			imprimir("Precio promedio	: S/. "+Adicional.df.format(clasificacionPromedialPrecios(0)));
			imprimir("Precio menor		: S/. "+Adicional.df.format(clasificacionPromedialPrecios(1)));
			imprimir("Precio mayor		: S/. "+Adicional.df.format(clasificacionPromedialPrecios(2))+"\n");
			
			imprimir("Ancho promedio	: "+Adicional.df.format(clasificacionPromedialAnchos(0))+" cm");
			imprimir("Ancho menor		: "+Adicional.df.format(clasificacionPromedialAnchos(1))+" cm");
			imprimir("Ancho mayor		: "+Adicional.df.format(clasificacionPromedialAnchos(2))+" cm"+"\n");
			
			imprimir("Alto promedio		: "+Adicional.df.format(clasificacionPromedialAltos(0))+" cm");
			imprimir("Alto menor		: "+Adicional.df.format(clasificacionPromedialAltos(1))+" cm");
			imprimir("Altoo mayor		: "+Adicional.df.format(clasificacionPromedialAltos(2))+" cm"+"\n");
			
			imprimir("Fondo promedio	: "+Adicional.df.format(clasificacionPromedialFondos(0))+" cm");
			imprimir("Fondo menor		: "+Adicional.df.format(clasificacionPromedialFondos(1))+" cm");
			imprimir("Fondo mayor		: "+Adicional.df.format(clasificacionPromedialFondos(2))+" cm"+"\n");
			
			imprimir("Quemador promedio	: "+ (clasificacionPromedialQuemadores(0))+" quemadores");
			imprimir("Quemador menor	: "+ (clasificacionPromedialQuemadores(1))+" quemadores");
			imprimir("Quemador mayor	: "+ (clasificacionPromedialQuemadores(2))+" quemadores");
			break;
		}
	}

	private String relacionCantidadOptima(int cantUniVendidas) {
		int dif;
		
		if(cantUniVendidas>FrmPrincipal.cantidadOptima)
			dif = cantUniVendidas-FrmPrincipal.cantidadOptima;
		else if(cantUniVendidas<FrmPrincipal.cantidadOptima)
			dif = FrmPrincipal.cantidadOptima-cantUniVendidas;
		else
			dif = 0;
		
		
		if(cantUniVendidas>FrmPrincipal.cantidadOptima)
			return cantUniVendidas+" ("+dif+" más que la cantidad óptima)";
		else if(cantUniVendidas<FrmPrincipal.cantidadOptima)
			return cantUniVendidas+" ("+dif+" menos que la cantidad óptima)";
		else
			return FrmPrincipal.cantidadOptima+" (igual a la cantidad óptima)";
	}		
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	private String relacionPromedio(double precio) {
		double promedio;
		
		promedio=(FrmPrincipal.precio0+FrmPrincipal.precio1+FrmPrincipal.precio2+FrmPrincipal.precio3+FrmPrincipal.precio4)/5;
		
		if(precio>promedio)
			return " (Mayor al promedio)";
		else if(precio<promedio)
			return " (Menor al promedio)";
		else
			return " (Igual al promedio)";
	}
	
	
	//Clasificación promedial según precios y anchos
	// precios
	private double clasificacionPromedialPrecios(int eleccion) {
		double tempNum,promedio,mayor,menor;
		promedio=(FrmPrincipal.precio0+FrmPrincipal.precio1+FrmPrincipal.precio2+FrmPrincipal.precio3+FrmPrincipal.precio4)/5;
		tempNum=promedio;
		
        if(FrmPrincipal.precio0>tempNum){
            tempNum=FrmPrincipal.precio0;        
        }
        if(FrmPrincipal.precio1>tempNum){
            tempNum=FrmPrincipal.precio1;
        }            
        if(FrmPrincipal.precio2>tempNum){
            tempNum=FrmPrincipal.precio2;
        }
        if(FrmPrincipal.precio3>tempNum){
            tempNum=FrmPrincipal.precio3;
        }
        if(FrmPrincipal.precio4>tempNum){
            tempNum=FrmPrincipal.precio4;
        }
        mayor=tempNum;
        
        tempNum=promedio;
        
        if(FrmPrincipal.precio0<tempNum){
            tempNum=FrmPrincipal.precio0;        
        }
        if(FrmPrincipal.precio1<tempNum){
            tempNum=FrmPrincipal.precio1;
        }            
        if(FrmPrincipal.precio2<tempNum){
            tempNum=FrmPrincipal.precio2;
        }
        if(FrmPrincipal.precio3<tempNum){
            tempNum=FrmPrincipal.precio3;
        }
        if(FrmPrincipal.precio4<tempNum){
            tempNum=FrmPrincipal.precio4;
        }
        menor=tempNum;
        
        switch(eleccion) {
        case 0:        	
        	return promedio;
        case 1:
        	return menor;
        case 2:
        	return mayor;
        default:
        	return 0;
        }		
	}
	// anchos
	private double clasificacionPromedialAnchos(int eleccion) {
		double tempNum,promedio,mayor,menor;
		promedio=(FrmPrincipal.ancho0+FrmPrincipal.ancho1+FrmPrincipal.ancho2+FrmPrincipal.ancho3+FrmPrincipal.ancho4)/5;
		tempNum=promedio;
		
        if(FrmPrincipal.ancho0>tempNum){
            tempNum=FrmPrincipal.ancho0;        
        }
        if(FrmPrincipal.ancho1>tempNum){
            tempNum=FrmPrincipal.ancho1;        
        }
        if(FrmPrincipal.ancho2>tempNum){
            tempNum=FrmPrincipal.ancho2;        
        }
        if(FrmPrincipal.ancho3>tempNum){
            tempNum=FrmPrincipal.ancho3;        
        }
        if(FrmPrincipal.ancho4>tempNum){
            tempNum=FrmPrincipal.ancho4;        
        }
        mayor=tempNum;
        
        if(FrmPrincipal.ancho0<tempNum){
            tempNum=FrmPrincipal.ancho0;        
        }
        if(FrmPrincipal.ancho1<tempNum){
            tempNum=FrmPrincipal.ancho1;        
        }
        if(FrmPrincipal.ancho2<tempNum){
            tempNum=FrmPrincipal.ancho2;        
        }
        if(FrmPrincipal.ancho3<tempNum){
            tempNum=FrmPrincipal.ancho3;        
        }
        if(FrmPrincipal.ancho4<tempNum){
            tempNum=FrmPrincipal.ancho4;        
        }
        menor=tempNum;
        
        switch(eleccion) {
        case 0:        	
        	return promedio;
        case 1:
        	return menor;
        case 2:
        	return mayor;
        default:
        	return 0;
        }		
	}
	
	// altos
			private double clasificacionPromedialAltos(int eleccion) {
				double tempNum,promedio,mayor,menor;
				promedio=(FrmPrincipal.alto0+FrmPrincipal.alto1+FrmPrincipal.alto2+FrmPrincipal.alto3+FrmPrincipal.alto4)/5;
				tempNum=promedio;
				
		        if(FrmPrincipal.alto0>tempNum){
		            tempNum=FrmPrincipal.alto0;        
		        }
		        if(FrmPrincipal.alto1>tempNum){
		            tempNum=FrmPrincipal.alto1;        
		        }
		        if(FrmPrincipal.alto2>tempNum){
		            tempNum=FrmPrincipal.alto2;        
		        }
		        if(FrmPrincipal.alto3>tempNum){
		            tempNum=FrmPrincipal.alto3;        
		        }
		        if(FrmPrincipal.alto4>tempNum){
		            tempNum=FrmPrincipal.alto4;        
		        }
		        mayor=tempNum;
		        
		        if(FrmPrincipal.alto0<tempNum){
		            tempNum=FrmPrincipal.alto0;        
		        }
		        if(FrmPrincipal.alto1<tempNum){
		            tempNum=FrmPrincipal.alto1;        
		        }
		        if(FrmPrincipal.alto2<tempNum){
		            tempNum=FrmPrincipal.alto2;        
		        }
		        if(FrmPrincipal.alto3<tempNum){
		            tempNum=FrmPrincipal.alto3;        
		        }
		        if(FrmPrincipal.alto4<tempNum){
		            tempNum=FrmPrincipal.alto4;        
		        }
		        menor=tempNum;
		        
		        switch(eleccion) {
		        case 0:        	
		        	return promedio;
		        case 1:
		        	return menor;
		        case 2:
		        	return mayor;
		        default:
		        	return 0;
		        }		
			}
			
		// fondos
			private double clasificacionPromedialFondos(int eleccion) {
			double tempNum,promedio,mayor,menor;
			promedio=(FrmPrincipal.fondo0+FrmPrincipal.fondo1+FrmPrincipal.fondo2+FrmPrincipal.fondo3+FrmPrincipal.fondo4)/5;
			tempNum=promedio;
						
				if(FrmPrincipal.fondo0>tempNum){
				tempNum=FrmPrincipal.fondo0;        
				}
				if(FrmPrincipal.fondo1>tempNum){
				tempNum=FrmPrincipal.fondo1;        
				}
				if(FrmPrincipal.fondo2>tempNum){
				tempNum=FrmPrincipal.fondo2;        
				}
				if(FrmPrincipal.fondo3>tempNum){
				tempNum=FrmPrincipal.fondo3;        
				}
				if(FrmPrincipal.fondo4>tempNum){
				tempNum=FrmPrincipal.fondo4;        
				}
				mayor=tempNum;
				        
				if(FrmPrincipal.fondo0<tempNum){
				tempNum=FrmPrincipal.fondo0;        
				}
				if(FrmPrincipal.fondo1<tempNum){
				tempNum=FrmPrincipal.fondo1;        
				}
				if(FrmPrincipal.fondo2<tempNum){
				tempNum=FrmPrincipal.fondo2;        
				}
				if(FrmPrincipal.fondo3<tempNum){
				tempNum=FrmPrincipal.fondo3;        
				}
				if(FrmPrincipal.fondo4<tempNum){
				tempNum=FrmPrincipal.fondo4;        
				}
				menor=tempNum;
				        
				switch(eleccion) {
				case 0:        	
					return promedio;
				case 1:
					return menor;
			    case 2:
		        	return mayor;
			    default:
			    	return 0;
			 }		
			}		
			
		// quemadores
			private int clasificacionPromedialQuemadores(int eleccion) {
			int tempNum,promedio,mayor,menor;
			promedio=(FrmPrincipal.quemadores0+FrmPrincipal.quemadores1+FrmPrincipal.quemadores2+FrmPrincipal.quemadores3+FrmPrincipal.quemadores4)/5;
			tempNum=promedio;
								
				if(FrmPrincipal.quemadores0>tempNum){
				tempNum=FrmPrincipal.quemadores0;        
				}
				if(FrmPrincipal.quemadores1>tempNum){
				tempNum=FrmPrincipal.quemadores1;        
				}
				if(FrmPrincipal.quemadores2>tempNum){
				tempNum=FrmPrincipal.quemadores2;        
				}
				if(FrmPrincipal.quemadores3>tempNum){
				tempNum=FrmPrincipal.quemadores3;        
				}
				if(FrmPrincipal.quemadores4>tempNum){
				tempNum=FrmPrincipal.quemadores4;        
				}
				mayor=tempNum;
						        
				if(FrmPrincipal.quemadores0<tempNum){
				tempNum=FrmPrincipal.quemadores0;        
				}
				if(FrmPrincipal.quemadores1<tempNum){
				tempNum=FrmPrincipal.quemadores1;        
				}
				if(FrmPrincipal.quemadores2<tempNum){
				tempNum=FrmPrincipal.quemadores2;        
				}
				if(FrmPrincipal.quemadores3<tempNum){
				tempNum=FrmPrincipal.quemadores3;        
				}
				if(FrmPrincipal.quemadores4<tempNum){
				tempNum=FrmPrincipal.quemadores4;        
				}
				menor=tempNum;
						        
				switch(eleccion) {
				case 0:        	
					return promedio;
				case 1:
					return menor;
			    case 2:
				  	return mayor;
			    default:
			    	return 0;
			 }		
		}		
	
	// imprimir
	public void imprimir(String msj) {
		txtS.append(msj + "\n");
		txtS.getCaret().setDot(0);
	}
	
}
