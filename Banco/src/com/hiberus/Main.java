package com.hiberus;



import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Conexion conex = new Conexion();


        System.out.println("Bienvenido.");

        Usuario pepa = new Usuario();
        try {
            pepa.crearUsuario();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
