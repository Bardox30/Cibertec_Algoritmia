package CreatePdf;

import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;  
public class CreatePdf  
{  
	public static void main_PDF()  
	{  		
		//created PDF document instance   
		Document doc = new Document();
		String username = System.getProperty("user.name");
		
		try  
		{  
			//generate a PDF at the specified location  
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\"+username+"\\Documents\\Datos-usuario-Windows.pdf"));  
			System.out.println("Motivation PDF created.");  
			//opens the PDF  
			doc.open();
			//adds paragraph to the PDF file 
			doc.add(new Paragraph("Datos de persona\n\n"));
			//doc.add(new Paragraph("Nombres y apellidos: "+FrmProgramaPDF.nombre+" "+FrmProgramaPDF.apellido+"\n"));
			//doc.add(new Paragraph("Profesion: "+FrmProgramaPDF.profesion));
			doc.add(new Paragraph("Nombre de usuario de Windows 10: "+username));
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