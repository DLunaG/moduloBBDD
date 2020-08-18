package dia14.tercerEjercicioCCAA.clases;

import dia14.tercerEjercicioCCAA.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Provincia {

    private String codigo;
    private String nombre;
    private int poblacion;


    public Provincia(String codigo){
        this.codigo = codigo;
        nombre = calcNombre();
        poblacion = calcPoblacion();
    }

    public List<Municipio> getMunicipios(){

        List<Municipio> resultado = new ArrayList<Municipio>();

        try {
            Statement s = Main.conexion.createStatement();
            String sql = "SELECT * FROM municipio WHERE provincia = '" + this.codigo + "'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Municipio m = new Municipio();
                m.setNombre(rs.getString("nombre"));
                resultado.add(m);
            }
        }catch(SQLException e ){
            System.out.println("SQL error: " + e.toString());
        }
        return resultado;
    }

    public String calcNombre(){
        String resultado = "";
        try {
            Statement s = Main.conexion.createStatement();
            String sql = "SELECT nombre FROM provincia WHERE código = '" + this.codigo + "'";
            ResultSet rs = s.executeQuery(sql);

            if(rs.next()) {
                resultado = rs.getString("nombre");
            }else{
                resultado = "código erroneo";
            }

        }catch(SQLException e ){
            System.out.println("SQL error: " + e.toString());
        }
        return resultado;


    }

    public int calcPoblacion(){
        int resultado =-1;

        try {
            Statement s = Main.conexion.createStatement();
            String consulta = "SELECT SUM(población) AS totalPoblacion FROM municipio where provincia = '" + this.codigo + "'";
            ResultSet rs = s.executeQuery(consulta);

            rs.next();//para avanzar a la primera (y única) fila de resultados.
            Municipio m = new Municipio();
            m.setPoblacion(rs.getInt("totalPoblacion"));
            resultado = m.getPoblacion();

        }catch (SQLException e){
            System.out.println("SQL Error: " + e.toString());

        }
        return resultado;
    }



    //getters
    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }
}
