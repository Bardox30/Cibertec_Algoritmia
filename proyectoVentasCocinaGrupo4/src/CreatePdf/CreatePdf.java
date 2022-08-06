package CreatePdf;

import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;

import sistemaVentasCocina.FrmPrincipal;  
public class CreatePdf  
{  
	public static void main_PDF()  
	{  		
		//created PDF document instance   
		Document doc = new Document();
		String username = FrmPrincipal.usernameSistema;
		FrmPrincipal.numVentaPDF++;
		int nVenta=FrmPrincipal.numVentaPDF;
		try  
		{  
			//generate a PDF at the specified location  
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\"+username+"\\Documents\\Monto-Total-N"+nVenta+".pdf"));  
			System.out.println("Motivation PDF created.");  
			//opens the PDF  
			doc.open();
			//adds paragraph to the PDF file 
			doc.add(new Paragraph("DATOS DE CLIENTE\n\n"));
			doc.add(new Paragraph("Nombres y apellidos: "+FrmPrincipal.nombres+" "+FrmPrincipal.apellidos+"\n"));
			doc.add(new Paragraph("DNI: "+FrmPrincipal.dni+"\n"));
			
			doc.add(new Paragraph("Monto total de venta actual	: S/."+FrmPrincipal.montoVentaCliente+"\n"));
			doc.add(new Paragraph("Cantidad de venta actual	: S/."+FrmPrincipal.cantVentaCliente+"\n"));
			doc.add(new Paragraph("Modelo escogido		: "+FrmPrincipal.modeloCliente+"\n"));
			doc.add(new Paragraph("Obsequio para el cliente		: S/."+FrmPrincipal.obsCliente+"\n"));
			
			//close the PDF file  
			doc.close();  
			//closes the writer  
			writer.close();  
		}   
		catch (DocumentException e)  
		{  
			e.printStackTrace();  
		}   
		catch (FileNotFoundException e)  
		{  
			e.printStackTrace();  
		}  
	}  
}  