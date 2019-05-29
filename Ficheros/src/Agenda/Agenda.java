package Agenda;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Agenda {

	private final static String NAME = "prueba.txt";
	private File fichero = new File(NAME);
	Contacto con= new Contacto();
	private final int TOTAL=
			+con.TOTAL_NOMBRE+ 2
			+con.TOTAL_APELLIDO+ 2
			+con.TOTAL_FECHA +2
			+Double.BYTES
			+(con.TOTAL_CORREO_DOMINIO+con.TOTAL_CORREO_LOCAL)+2;
	private RandomAccessFile raf;		

	public Agenda() throws IOException {
		raf = new RandomAccessFile(NAME, "rw");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void anadir(Contacto c) throws IOException {
 
		raf.seek(fichero.length());
		raf.writeUTF(c.getNombre());
		raf.writeUTF(c.getApellido());
		raf.writeUTF(c.getFechaNacimiento());
		raf.writeDouble(c.getSalario());
		raf.writeUTF(c.getCorreo());

	}

	public void mostrar() throws IOException {
	
		raf.seek(0);
		while (raf.getFilePointer() < fichero.length()) {
			System.out.println(raf.readUTF());
			System.out.println(raf.readUTF());
			System.out.println(raf.readUTF());
			System.out.println(raf.readDouble());
			System.out.println(raf.readUTF());
			System.out.println();
		}
	}
	
	

	public Contacto buscar(String nombreBuscar)  throws IOException{
		
		Contacto c;
		raf.seek(0);
		boolean encontrado = false;
		int i = 0;
		while(raf.getFilePointer() < fichero.length() && !encontrado) {
		
			raf.seek(i * TOTAL);

			String nombre = raf.readUTF().trim();
			if(nombre.equals(nombreBuscar)) {
				encontrado = true;
				raf.seek(raf.getFilePointer() - con.TOTAL_NOMBRE - 2);
				c = new Contacto(raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readDouble(), raf.readUTF());
				return c;

			}
			i++;
		}
		
		return null;
	}
	
	public int getTotal() throws IOException {
		int total=0;
		raf.seek(0);
		while (raf.getFilePointer() < fichero.length()) {
			System.out.println(raf.readUTF());
			System.out.println(raf.readUTF());
			System.out.println(raf.readUTF());
			System.out.println(raf.readDouble());
			System.out.println(raf.readUTF());
			System.out.println();
			total++;
		}
		return total;
	}

	
	public void eliminar(String nombreBuscar) throws IOException{
		
		
		buscar(nombreBuscar);
		
		for(int i = getTotal(); i <= 0; i--) { 
			
			
			Contacto temporal = new Contacto(raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readDouble(), raf.readUTF());
			raf.seek(raf.getFilePointer() - TOTAL *i);
			
			raf.writeUTF(temporal.getNombre());
			raf.writeUTF(temporal.getApellido());
			raf.writeUTF(temporal.getFechaNacimiento());
			raf.writeDouble(temporal.getSalario());
			raf.writeUTF(temporal.getCorreo());
			
				
			
		}
		
	}


}
