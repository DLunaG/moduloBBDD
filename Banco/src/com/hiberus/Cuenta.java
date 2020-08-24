package com.hiberus;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cuenta {
    Conexion c = new Conexion();
    Scanner sc = new Scanner(System.in);

    private int id;
    private String account;
    private float saldo;

    public Cuenta(int id, String account, float saldo) {
        this.id = id;
        this.account = account;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void crearCuenta () throws SQLException, ClassNotFoundException {

        Statement st = c.conex();

        System.out.println("¿Cuál es la cuenta?");
        this.account = sc.next();

        System.out.println("¿Cuál es el apellido?");
        this.saldo = sc.nextFloat();

        String sentenciaSql = "INSERT INTO Cuenta (account, saldo) VALUES ('" + this.account + "', '" + this.saldo + "');";
        int rs = st.executeUpdate(sentenciaSql);

        System.out.println("Se ha creado la cuenta: " + this.account + "con  " + this.saldo + "saldo. ");


    }
}
