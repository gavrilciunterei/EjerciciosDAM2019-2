package Agenda;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	private static void anadir(Agenda ag) throws IOException {

		System.out.println("Nombre: ");
		String nombre = sc.next();
		System.out.println("Apellido: ");
		String apellido = sc.next();
		System.out.println("Fecha Nacimiento: ");
		String fechaNacimiento = sc.next();
		System.out.println("Salario: ");
		double salario = sc.nextDouble();
		System.out.println("Correo: ");
		String correo = sc.next();

		Contacto c = new Contacto(nombre, apellido, fechaNacimiento, salario, correo);
		ag.anadir(c);

	}

	public static void main(String[] args) throws IOException {

		Agenda ag = new Agenda();
		boolean continuar = true;
		while (continuar) {
			System.out.print("(A)Añadir, (M)Mostrar, (B)Buscar, (E)Eliminar,(S)Salir");
			String opcion = sc.nextLine().toUpperCase();
			switch (opcion) {
			case "A":
				anadir(ag);
				break;
			case "M":
				ag.mostrar();
				break;
			case "E":
				System.out.println("Nombre");
				String nombreBuscar= sc.nextLine();
				ag.eliminar(nombreBuscar);
				break;
			case "B":
				System.out.println("Nombre");
				String nombreBuscarr= sc.nextLine();
				System.out.println(ag.buscar(nombreBuscarr));
				break;

			case "S":
				continuar = false;
				break;
			}
		}

	}

}
