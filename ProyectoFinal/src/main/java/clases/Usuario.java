package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.Contrase�aIncorrectaException;
import excepciones.NivelVacioException;
import excepciones.UsuarioNoExisteException;
import excepciones.Contrase�aVaciaException;
import superClases.EntidadConNombre;
import utilsDB.UtilsDB;

public class Usuario extends EntidadConNombre{
	private String contrase�a;
	private byte nivel;//Del 1 al 10, 1 mas novato, 10 mas avanzado. 
	//1 principiante,2 y 3 principiante-intermedio, 4,5 intermedio 6-7 intermedio-avanzado  8 y 9 avanzado y nivel 10 Kamenov
	private String UbicacionEntrenamiento;
	private Entrenamiento entrenamiento;
	
	public Usuario(String nombre, String contrase�a, byte nivel, String ubicacionEntrenamiento,
			Entrenamiento entrenamiento) throws SQLException, Contrase�aVaciaException, NivelVacioException {
		super(nombre);
		if (contrase�a.isBlank()) {
			throw new Contrase�aVaciaException("La contrase�a no puede estar vacia.");
		}

		if (nivel==0) {
			throw new NivelVacioException("El nivel no puede estar vacio");
		}

		   Statement query=UtilsDB.conectarBD();
		   if (query.executeUpdate("insert into usuario values('" + nombre + "','" + contrase�a + "'," + nivel + ",'"
					+ UbicacionEntrenamiento + "','"+entrenamiento+"')")> 0) {
		this.contrase�a = contrase�a;
		this.nivel = nivel;
		this.UbicacionEntrenamiento = ubicacionEntrenamiento;
		this.entrenamiento = entrenamiento;
		   }else {
				throw new SQLException("No se ha podido insertar el usuario");
			}
			UtilsDB.desconectarBD();
		}
		   
	
	
	public Usuario(String nombre,String contrase�a) throws SQLException, Contrase�aIncorrectaException, UsuarioNoExisteException{
		super(nombre);
        Statement smt=UtilsDB.conectarBD();

        ResultSet cursor=smt.executeQuery("select * from usuario where nombre='"+

        nombre+"'");

        if(cursor.next()) {

                this.contrase�a=cursor.getString("contrasena");

                if(!this.contrase�a.equals(contrase�a)) {

                        UtilsDB.desconectarBD();

                        throw new Contrase�aIncorrectaException("La contrase�a no es correcta");

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
