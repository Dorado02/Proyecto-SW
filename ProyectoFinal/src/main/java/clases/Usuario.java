package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.Contrase�aIncorrectaException;
import excepciones.NivelVacioException;
import excepciones.UbicacionVaciaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioVacioException;
import excepciones.Contrase�aVaciaException;
import superClases.EntidadConNombre;
import utilsDB.UtilsDB;

public class Usuario extends EntidadConNombre{
	private String contrase�a;
	private byte nivel;//Del 1 al 10, 1 mas novato, 10 mas avanzado. 
	//1 principiante,2 y 3 principiante-intermedio, 4,5 intermedio 6-7 intermedio-avanzado  8 y 9 avanzado y nivel 10 Kamenov
	private String UbicacionEntrenamiento;
	private Entrenamiento entrenamiento;
	
	public Usuario(String nombre, String contrase�a, String ubicacionEntrenamiento) throws SQLException, Contrase�aVaciaException, UsuarioVacioException, UbicacionVaciaException {
		super(nombre);
		if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
		if(nombre.isBlank()) {
			throw new UsuarioVacioException("El usuario no puede estar vacio");
		}
		if(ubicacionEntrenamiento.equals("...")) {
			throw new UbicacionVaciaException("Porfavor, selecciona una Ubicacion");
		}


		   Statement query=UtilsDB.conectarBD();
		   if (query.executeUpdate("insert into usuario values('" + nombre + "','" + contrase�a + "',0,'"
					+ UbicacionEntrenamiento + "',null)")> 0) {
			   
			   
		this.contrase�a = contrase�a;
		this.UbicacionEntrenamiento = ubicacionEntrenamiento;
		
		   }else {
				throw new SQLException("No se ha podido insertar el usuario");
			}
			UtilsDB.desconectarBD();
		}
		   
	
	
	public Usuario(String nombre,String contrase�a) throws SQLException, Contrase�aIncorrectaException, UsuarioNoExisteException, UsuarioVacioException, Contrase�aVaciaException{
		super(nombre);
        Statement smt=UtilsDB.conectarBD();

        ResultSet cursor=smt.executeQuery("select * from usuario where nombre='"+

        nombre+"'");
        if(nombre.isBlank()) {
        	throw new UsuarioVacioException("El usuario no puede estar vacio");
        }
        if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}
        if(cursor.next()) {

                this.contrase�a=cursor.getString("contrase�a");

                if(!this.contrase�a.equals(contrase�a)) {

                        UtilsDB.desconectarBD();

                        throw new Contrase�aIncorrectaException("La contrase�a no es correcta");

                }
                
                if(!this.getNombre().equals(nombre)) {
                	 throw new UsuarioNoExisteException("No existe ese nombre de usuario en la BD");
                }
                nombre = cursor.getString("nombre");
                this.nivel=cursor.getByte("nivel");
                this.UbicacionEntrenamiento=cursor.getString("UbicacionEntrenamiento");
                this.entrenamiento=(Entrenamiento) cursor.getClob("Entrenamiento");
                

        }else {

                UtilsDB.desconectarBD();

                throw new UsuarioNoExisteException("No existe ese nombre de usuario en la BD");

        }

        UtilsDB.desconectarBD();

}
	
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public byte getNivel() {
		return nivel;
	}
	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}
	public String getUbicacionEntrenamiento() {
		return UbicacionEntrenamiento;
	}
	public void setUbicacionEntrenamiento(String ubicacionEntrenamiento) {
		UbicacionEntrenamiento = ubicacionEntrenamiento;
	}
	public Entrenamiento getEntrenamiento() {
		return entrenamiento;
	}
	public void setEntrenamiento(Entrenamiento entrenamiento) {
		this.entrenamiento = entrenamiento;
	}
	
	
	
	
	
	
}
