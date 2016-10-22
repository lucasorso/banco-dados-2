package banco_de_dados_2_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ly", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problemas ao conectar no banco de dados");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("O driver não foi configurado corretametne");
        }
        return conn;
    }
}
