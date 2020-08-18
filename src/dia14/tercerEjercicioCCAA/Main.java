package dia14.tercerEjercicioCCAA;

import dia14.tercerEjercicioCCAA.clases.*;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static BaseDeDatos bdd = new BaseDeDatos();

    public static void main(String[] args) {


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
        try {
            bdd.conectarBD();

            /*Provincia p = new Provincia("50");
            if (p.getValido()) {
                System.out.println(p.toString());
            } else {
                System.out.println("Código de Provincia no encontrado.");
            }


            Municipio m = new Municipio("50", "297");
            if (m.getValido()) {
                System.out.println(m.toString());
            } else {
                System.out.println("Código de municipio y/o provincia erróneo/s.");
            } */

            //CONEXIÓN CON LA CLASE BASEDEDATOS

            Provincia p = new Provincia("50");
            List<Municipio> municipiosProv = p.getMunicipios();
            if (municipiosProv == null){
                System.out.println("Código de Provincia inexistente.");
            }else{
                for (int i = 0; i < municipiosProv.size() ; i++) {
                    System.out.println(municipiosProv.get(i));
                }
            }

            Comunidad c = new Comunidad("02");
            List<Municipio> municipiosCom = c.getMunicipios();
            if(municipiosCom == null){
                System.out.println("Código de comunidad autónoma inexistente.");
            }else{
                for (int i = 0; i < municipiosCom.size() ; i++) {
                    System.out.println(municipiosCom.get(i));
                }
            }

        }catch(SQLException e){
            System.out.println("SQL Error: " + e.toString());
        }catch(ClassNotFoundException e) {
        System.out.println("No se encuentra la clase " + e.toString());
        }
    }




}
