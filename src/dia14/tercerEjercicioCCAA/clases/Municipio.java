package dia14.tercerEjercicioCCAA.clases;

import dia14.tercerEjercicioCCAA.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Municipio {

    private String provincia;
    private String codigo;
    private String nombre;
    private int poblacion;
    private float superficie;
    private float latitud;
    private float longitud;
    private boolean valido;

    public Municipio(){

    }

    //Constructor Municipio a partir de su código de provincia y su código de municipio.
    public Municipio(String codigoProvincia, String codigoMunicipio){
        provincia = codigoProvincia;
        codigo = codigoMunicipio;

        try {
            Statement s = Main.conexion.createStatement();
            String sql = "SELECT * FROM municipio WHERE código = ? AND provincia = ?";
            PreparedStatement ps = Main.conexion.prepareStatement(sql);
            ps.setString(1, this.codigo);
            ps.setString(2, this.provincia);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                this.nombre = rs.getString("nombre");
                this.poblacion = rs.getInt("población");
                this.superficie = rs.getFloat("superficie");
                this.latitud = rs.getFloat("latitud");
                this.longitud = rs.getFloat("longitud");
                valido = true;
            }else{
                valido = false;
            }

        }catch(SQLException e){
            System.out.println("SQL Error: " + e.toString());
        }
    }

    //Getters y setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public boolean getValido() {
        return valido;
    }

    //Método toString

    @Override
    public String toString() {
        return  "provincia = '" + provincia + '\'' + "\n" +
                "codigo = '" + codigo + '\'' + "\n" +
                "nombre = '" + nombre + '\'' + "\n" +
                "poblacion = " + poblacion + "\n" +
                "superficie = " + superficie + "\n" +
                "latitud = " + latitud + "\n" +
                "longitud = " + longitud + "\n";
    }
}
