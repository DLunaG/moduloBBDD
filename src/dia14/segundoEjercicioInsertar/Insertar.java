package dia14.segundoEjercicioInsertar;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertar {
    public static void main(String[] args) {

        try{
            //1. Registrarla clase (hará falta haber añadido el fichero JAR en File-> Project Structure -> Libraries
            Class.forName("org.postgresql.Driver");
            System.out.println("Clase encontrada.");
        }catch(ClassNotFoundException e){
            System.out.println("No se encuentra la clase.");
        }

        try{
            //2. Obtener la conexión a la base de datos (hace falta indicar el servidor, base de datos, usuario y contraseña
            //codificados de la forma que requiere JDBC.

            //Objecto Connection: representa la conexion a la base de datos
            //Cadena de conexion JDBC con el tipo de base de datos (postgresql, el servidor "192.168.56.2" y
            // la base de datos geografia
            Connection conexion = java.sql.DriverManager.getConnection("jdbc:postgresql://192.168.56.2/geografia", "censo", "abc");
            System.out.println("Conexión establecida.");
            //Cadena con el codigo sql (es tan solo una cadena, no confundir con la sentencia como objeto)
            String sqlSentencia = "INSERT INTO comunidad_autonoma(codigo, nombre) VALUES ('99', 'Javalandia')";

            //3.Crear un objeto sentencia
            Statement sentencia = conexion.createStatement();

            //4.Utilizar el objeto para ejecutar el SQL que tengo en la variable cadena sql y devolver el nº de filas insertadas
            //en la variable insertadas
            int numInsertos = sentencia.executeUpdate(sqlSentencia);

            //5.Mostrat el nº de filas insertadas
            System.out.println("Se han insertado " + numInsertos + " fila(s).");

        }catch(SQLException e){
            System.out.println("Conexión fallida.");
        }
    }
}
