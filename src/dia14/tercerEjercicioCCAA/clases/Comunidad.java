package dia14.tercerEjercicioCCAA.clases;

import dia14.tercerEjercicioCCAA.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Comunidad {

    private String codigo;
    private String nombre;

    public Comunidad(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias(){

        List<Provincia> resultado = new ArrayList<Provincia>();


        return resultado;
    }

    public List<Municipio> getMunicipios(){

        List<Municipio> resultado = new ArrayList<Municipio>();

        try {
            Statement s = Main.conexion.createStatement();
            String sql = "SELECT * FROM municipio M, provincia P" +
                    " WHERE M.provincia = P.código AND P.autonomía = '" + this.codigo + "'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Municipio m = new Municipio("pipi", "caca");
                m.setNombre(rs.getString("nombre"));
                resultado.add(m);
            }
        } catch(SQLException e){
            System.out.println("Error de conexión con SQL.");
        }

        return resultado;
    }
}
