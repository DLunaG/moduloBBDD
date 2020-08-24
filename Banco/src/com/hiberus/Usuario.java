package com.hiberus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Usuario {
    Conexion c = new Conexion();
    Scanner sc = new Scanner(System.in);

    private int id;
    private String nombre;
    private String apellido;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void crearUsuario () throws SQLException, ClassNotFoundException {

        Statement st = c.conex();

        System.out.println("¿Cuál es el nombre?");
        this.nombre = sc.next();

        System.out.println("¿Cuál es el apellido?");
        this.apellido = sc.next();

        String sentenciaSql = "INSERT INTO Usuario (nombre, apellido) VALUES ('" + this.nombre + "', '" + this.apellido + "');";
        int rs = st.executeUpdate(sentenciaSql);

        System.out.println("Se ha creado el usuario: " + this.nombre + " " + this.apellido);


    }
    public void borrarUsuario () throws SQLException, ClassNotFoundException {

    }
}
