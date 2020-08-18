package dia14.tercerEjercicioCCAA.clases;

import dia14.tercerEjercicioCCAA.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    public Connection conexion = null;

    public void conectarBD() throws SQLException, ClassNotFoundException{

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://192.168.56.2/geografia";
        String usuario = "censo";
        String clave = "abc";
        conexion = DriverManager.getConnection(url, usuario, clave);

    }

    private String comunidad;
    private String provincia;
    private String municipio;

    //Método que devuelve una lista de los municipios de una provincia dada.
    //Devolverá NULL si la provincia dada no existe.
    public List<Municipio> municipiosProvincia(String codigoProvincia) throws SQLException{

        provincia = codigoProvincia;
        List<Municipio> resultado = new ArrayList<>();

        String sql = "SELECT * FROM municipio WHERE provincia = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, codigoProvincia);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            do{
                String codigoMunicipio = rs.getString("código");
                Municipio m = new Municipio(codigoProvincia, codigoMunicipio);
                resultado.add(m);
            }while(rs.next());

        }else{
            resultado = null;

        }
        return resultado;
    }

    //Método que devuelve una lista de los municipios de la comunidad autónoma dada
    //Devuelve null si el código no se halla.
    public List<Municipio> municipiosComunidad(String codigoComunidad) throws SQLException{

        this.comunidad = codigoComunidad;
        List<Municipio> resultado = new ArrayList<>();

        String sql = "SELECT M.código AS muninum, P.código AS provnum FROM municipio M, provincia P" +
                " WHERE M.provincia = P.código AND P.autonomía = ? ORDER BY M.nombre";
        PreparedStatement ps = Main.bdd.conexion.prepareStatement(sql);
        ps.setString(1, codigoComunidad);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            do {
                String codigoMunicipio = rs.getString("muninum");
                String codigoProvincia = rs.getString("provnum");
                Municipio m = new Municipio(codigoProvincia,codigoMunicipio );
                resultado.add(m);
            } while (rs.next());
        }else{
            resultado = null;
        }

        return resultado;
    }

}
