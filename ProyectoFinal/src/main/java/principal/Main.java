package principal;

import java.sql.SQLException;
import java.sql.Statement;

import clases.Usuario;
import excepciones.Contrase�aIncorrectaException;
import excepciones.UsuarioNoExisteException;
import pantallaLogin.Ventana;
import utilsDB.UtilsDB;


public class Main {

	public static void main(String[] args) {
		
		try {
			Usuario u = new Usuario("Antonio","contrase�a");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (Contrase�aIncorrectaException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
			
	}

}
