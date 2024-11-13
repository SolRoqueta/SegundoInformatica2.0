package Logica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class compresorFoto {

	 // Método para comprimir el InputStream y devolver un array de bytes comprimido
	public byte[] comprimirBytes(byte[] data) throws IOException {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    
	    try (GZIPOutputStream gZipOs = new GZIPOutputStream(baos)) {
	        gZipOs.write(data); // Escribir directamente el arreglo de bytes en el GZIPOutputStream
	    }

	    return baos.toByteArray();
	}
	
	   public InputStream descomprimirBytesAInputStream(byte[] compressedData) throws IOException {
	        // Crear un InputStream que lea los datos comprimidos
	        ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
	        // Retornar un GZIPInputStream que descomprima los datos al leer
	        return new GZIPInputStream(bais);
	    }
	

}