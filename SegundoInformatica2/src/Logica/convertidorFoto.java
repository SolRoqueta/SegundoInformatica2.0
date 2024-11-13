package Logica;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class convertidorFoto {

	   public InputStream convertirFotoAInputStream(String fotoPath) throws IOException {
	        return new FileInputStream(new File(fotoPath));
	    }
	   
	   
	   public ImageIcon convertirInputStreamAFoto(InputStream is) throws IOException {
		   
		   if (is == null) {
		        throw new IOException("El InputStream es nulo.");
		    }
		    
		    BufferedImage bufferedFoto = ImageIO.read(is); // Lee el InputStream como BufferedImage
		    
		    if (bufferedFoto == null) {
		        throw new IOException("El InputStream no contiene una imagen válida.");
		    }
		    
		    return new ImageIcon(bufferedFoto); // Convierte BufferedImage a ImageIcon para Swing
		   
	   }
	   
	   public byte[] convertirInputStreamABytes(InputStream is) throws IOException {
		    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		    int nRead;
		    byte[] data = new byte[16384];
		    while ((nRead = is.read(data, 0, data.length)) != -1) {
		        buffer.write(data, 0, nRead);
		    }
		    return buffer.toByteArray();
		}
	   
	   public InputStream convertirBytesAInputStream(byte[] fotoBytes) {
		    return new ByteArrayInputStream(fotoBytes);
		}
	
	  
}
