import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PruebaBasicaFicheros {

	public static void main(String[] args) throws IOException {

	// Clase File

		File f = new File("prueba.txt");

		if (f.exists()) {
			System.out.println("Nombre del archivo " + f.getName());
			System.out.println("Ruta " + f.getPath());
			System.out.println("Ruta absoluta" + f.getAbsolutePath());
			System.out.println("Tamano " + f.length());
		} else {
			f.createNewFile();
		}
		
		
	// Clase PrintWriter
		//Archivo sin existir
		
		File fichero = new File("prueba2.txt");
		PrintWriter pw = new PrintWriter(fichero); 
		
		pw.println("Hola que tal");
		pw.close();
		
		//Archivo existente
		
		File fichero2 = new File("prueba3.txt");
		FileWriter fw2 = new FileWriter(fichero2, true);
		PrintWriter pw2 = new PrintWriter(fw2); 
		
		pw2.print("Buenas \n");
		pw2.close();
		fw2.close();
		
		
	//LEER con Clase Scanner
		
		File fichero3 = new File("prueba3.txt");
		
		Scanner sc = new Scanner(fichero3);
		
		String pruebaTexto = sc.nextLine();
		System.out.println(pruebaTexto);
		
		sc.close();
		
	
	
	//LEER CON BufferReader
	
		FileReader fichero4 = new FileReader("prueba3.txt");
		BufferedReader lector = new BufferedReader(fichero4);
		
		String pruebaTexto2 = lector.readLine();
		System.out.println(pruebaTexto2);
	
	}
}
