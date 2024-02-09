package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model;
import java.sql.*;
public class DbAccess {

    private static DbAccess instance;

    public static DbAccess getInstance() {
        if (instance == null) instance = new DbAccess();
        return instance;
    }
    private Connection con;
    public DbAccess() {

        //TODO generate everything you need for db connection
        String url = "jdbc:mysql://localhost:6603/query_playground";
        String username = "root";
        String password = "helloworld";

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successfully to db");
        } catch (Exception se){
            System.err.println(se.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }

    // créer une méthode publique qui retourne un connecteur à la base de données
}
