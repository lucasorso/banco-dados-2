package banco_de_dados_2_controller;

import banco_de_dados_2_props.ConexaoProps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static int id;
    private static String caminhoBanco;
    private static String usuario;
    private static String senha;
    
    Conexao (ConexaoProps connProps){
        id = connProps.getIdConexao();
        caminhoBanco = connProps.getCaminhoBanco();
        usuario =  connProps.getUsuario();
        senha = connProps.getSenha();
    }
   
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(caminhoBanco, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Problemas ao conectar no banco de dados" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi configurado corretametne" + e.getMessage());
        }
        return conn;
    }
    
    public String getCaminhoBanco(){
        return caminhoBanco.substring(0, 33);
    }
       
    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append(id).append(" => ");
       builder.append(caminhoBanco.substring(0, 33)).append(" => ");
       builder.append(usuario).append(" => ");
       builder.append(senha);
       return builder.toString();
    }
}