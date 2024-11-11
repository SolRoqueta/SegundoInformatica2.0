package Logica;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class convertidorFoto {

	public static byte[] convertirFotoABytes(String fotoPath) throws IOException {
		
		 BufferedImage bufferedFoto = ImageIO.read(new File(fotoPath)); //Lee la imagen de la ruta especificada (fotoPath)
		 ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Se crea el baos (Flujo de salida) el cual almacena los bytes de la foto
		 ImageIO.write(bufferedFoto, "jpg", baos); //Guarda la foto en el baos como jpg
		 return baos.toByteArray(); //Devuelve la foto en formato de bytes
		
	}
	
	public static Image obtenerFotoDesdeBytes(byte[] imageBytes) throws IOException {
		
		 ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes); //Se crea el bais (Flujo de entrada) el cual lee los datos del array de bytes
		 BufferedImage bufferedFoto = ImageIO.read(bais); //Lee el flujo de bytes guardado en el bais
		 return new ImageIcon(bufferedFoto).getImage(); //Retorna la imagen en un formato que Swing pueda usar
		 
	}
	
}
