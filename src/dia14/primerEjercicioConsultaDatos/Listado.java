package dia14.primerEjercicioConsultaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listado {

        public static void main(String[] args) {
            Connection cn;

            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Clase encontrada.");
            }catch(ClassNotFoundException e){
                System.out.println("Clase no encontrada.");
            }

            try {
                cn = java.sql.DriverManager.getConnection("jdbc:postgresql://192.168.56.2/geografia", "censo", "abc");
                //en vez de importar java.sql.DriverManager, hemos puesto la ruta absoluta.

                String consulta = "SELECT * FROM comunidad_autonoma";
                Statement sentencia = cn.createStatement();
                ResultSet filas = sentencia.executeQuery(consulta);
                while(filas.next()){
                    String codigoComunidadAutonoma = filas.getString("codigo");
                    String nombreComunidadAutonoma = filas.getString("nombre");
                    System.out.println("Código: " + codigoComunidadAutonoma +"\n" +
                            "Nombre: " + nombreComunidadAutonoma + "\n");
                }

                System.out.println("Conexión establecida.");
            }catch(SQLException e){
                System.out.println("Error: " + e.toString());
            }



            System.out.println("Programa finalizado.");
        }
    }
