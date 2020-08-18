package dia14.tercerEjercicioCCAA.clases;

import dia14.tercerEjercicioCCAA.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Provincia {

    private String codigo;
    private String nombre;
    private String autonomia;

    private boolean valido;
    private int poblacion;


    public Provincia(String codigo) throws SQLException {
        this.codigo = codigo;
        poblacion = calcPoblacion();

        String sql = "SELECT * FROM provincia WHERE código = ?";
        PreparedStatement ps = Main.bdd.conexion.prepareStatement(sql);
        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            nombre = rs.getString("nombre");
            autonomia = rs.getString("autonomía");
            valido = true;
        } else {
            valido = false;
        }


    }

    public int calcPoblacion() throws SQLException {
        int resultado = -1;

        Statement s = Main.bdd.conexion.createStatement();
        String consulta = "SELECT SUM(población) AS totalPoblacion FROM municipio where provincia = '" + this.codigo + "'";
        ResultSet rs = s.executeQuery(consulta);

        rs.next();//para avanzar a la primera (y única) fila de resultados.
        Municipio m = new Municipio();
        m.setPoblacion(rs.getInt("totalPoblacion"));
        resultado = m.getPoblacion();


        return resultado;
    }

    public List<Municipio> getMunicipios() throws SQLException{
        return Main.bdd.municipiosProvincia(this.codigo);
    }

    @Override
    public String toString() {
        return "Provincia: \ncódigo = '" + codigo + '\'' + "\n" +
                "nombre = '" + nombre + '\'' + "\n" +
                "autonomía = '" + autonomia + '\'' + "\n" +
                "población = " + poblacion + "\n";
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public boolean getValido() {
        return valido;
    }
}
