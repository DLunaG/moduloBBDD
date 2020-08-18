package dia14.tercerEjercicioCCAA.clases;

import dia14.tercerEjercicioCCAA.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Comunidad {

    private String codigo;
    private String nombre;

    public Comunidad(String codigo){
        this.codigo = codigo;

    }

    public List<Provincia> getProvincias(){

        List<Provincia> resultado = new ArrayList<Provincia>();

        return resultado;
    }

    public List<Municipio> getMunicipios() throws SQLException{

        return Main.bdd.municipiosComunidad(codigo);
    }
}
