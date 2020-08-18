package dia14.tercerEjercicioCCAA;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import dia14.tercerEjercicioCCAA.clases.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static Connection conexion = null;

    public static void conectarBD(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.56.2/geografia";
            String usuario = "censo";
            String clave = "abc";
            conexion = DriverManager.getConnection(url, usuario, clave);
        }catch(ClassNotFoundException e) {
            System.out.println("No se encuentra la clase " + e.toString());
        }catch(SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        }
    }

    public static void main(String[] args) {

        conectarBD();

        //Establecer conexión con la base de datos geografia.


        /*Comunidad c = new Comunidad("02", "Aragón");
        List<Municipio> municipios = c.getMunicipios();

        if(municipios.isEmpty()){
            System.out.println("No tiene provincias.");
        }else{
            System.out.println("Lista de municipios: ");
            for (int i = 0; i < municipios.size(); i++) {
                Municipio m = municipios.get(i);
                System.out.println(m.getNombre());
            }
        }*/

        /*Provincia p = new Provincia("50", "Zaragoza");
        List<Municipio> municipios = p.getMunicipios();
        System.out.println("Lista de Municipios de " + p.getNombre() + ": ");
        for (int i = 0; i < municipios.size() ; i++) {
            Municipio m = municipios.get(i);
            System.out.println(m.getNombre());
        }*/

        Provincia p = new Provincia("44");
        int poblacionTotal = p.getPoblacion();

        System.out.println("Población total de la provincia de " + p.getNombre() + ": " +poblacionTotal);

        Municipio m = new Municipio("50", "297");
        if(m.getValido()) {
            System.out.println(m.toString());
        }else{
            System.out.println("Código de municipio y/o provincia erróneo/s.");
        }
    }




}
