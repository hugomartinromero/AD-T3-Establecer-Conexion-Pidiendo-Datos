package establecerConexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe la ruta de la base de datos.");
		String nombreBaseDatos = sc.nextLine();
		
		File f = new File(nombreBaseDatos);
		
		if (f.exists()) {
			System.out.println("Escribe el usuario.");
			String usuario = sc.nextLine();
			
			System.out.println("Escribe la contraseña.");
			String contrasenia = sc.nextLine();
			
			String url = "jdbc:sqlite:" + nombreBaseDatos;
			try (Connection c = DriverManager.getConnection(url, usuario, contrasenia);) {
				if (c != null) {
					System.out.println("Conexión establecida con éxito.");
				} else {
					System.out.println("Conexión no establecida.");
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		} else {
			System.out.println("No se ha encontrado la base de datos.");
		}
		
		sc.close();
	}
}
