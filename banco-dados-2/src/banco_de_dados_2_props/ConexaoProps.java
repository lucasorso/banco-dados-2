/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados_2_props;

/**
 *
 * @author Lucas
 */
public class ConexaoProps {
    
    private String[] conexoes = {"jdbc:mysql://localhost:3306/ly", "jdbc:mysql://localhost:3306/ly1", "jdbc:mysql://localhost:3306/ly2"};

    public String[] getConexoes() {
        return conexoes;
    }
    
  }
