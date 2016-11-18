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

public enum ConexaoProps {
    
    /*CONEXAO_BANCO_1(1,"jdbc:mysql://localhost:3306/ly?rewriteBatchedStatements=true&relaxAutoCommit=true", "root", ""),
    CONEXAO_BANCO_2(2,"jdbc:mysql://localhost:3306/ly1?rewriteBatchedStatements=true&relaxAutoCommit=true", "root", ""),
    CONEXAO_BANCO_3(3,"jdbc:mysql://localhost:3306/ly2?rewriteBatchedStatements=true&relaxAutoCommit=true", "root", "");
    */
    
    CONEXAO_BANCO_1(1,"jdbc:mysql://localhost:3306/ly?rewriteBatchedStatements=true&relaxAutoCommit=true", "root", "123"),
    CONEXAO_BANCO_2(2,"jdbc:mysql://172.16.82.5:3306/ly2?rewriteBatchedStatements=true&relaxAutoCommit=true", "cont12", "123"),
    CONEXAO_BANCO_3(3,"jdbc:mysql://172.16.82.4:3306/ly?rewriteBatchedStatements=true&relaxAutoCommit=true", "cont12", "comp2");
    
    public final int idConexao;
    private final String caminhoBanco;
    private final String usuario;
    private final String senha;
    
    private ConexaoProps(int idConexao, String caminhoBanco, String usuario, String senha) {
        this.idConexao = idConexao;
        this.caminhoBanco = caminhoBanco;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public static ConexaoProps getConexaoProps(int id){
        for (ConexaoProps conexaoProps : values()){
            if (conexaoProps.idConexao == id){
                return conexaoProps;
            }
        }
        return CONEXAO_BANCO_1;
    }

    public int getIdConexao() {
        return idConexao;
    }

    public String getCaminhoBanco() {
        return caminhoBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append(idConexao).append(" => ");
       builder.append(caminhoBanco.substring(0, 33)).append(" => ");
       builder.append(usuario).append(" => ");
       builder.append(senha);
       return builder.toString();
    }
}