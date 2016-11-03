/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados_2_controller;

import banco_de_dados_2_beans.Bairro;
import banco_de_dados_2_beans.Cidade;
import banco_de_dados_2_beans.Estado;
import banco_de_dados_2_beans.Logradouro;
import banco_de_dados_2_beans.ObjectsBD;
import banco_de_dados_2_beans.Pais;
import banco_de_dados_2_beans.Pessoas;
import banco_de_dados_2_props.ConexaoProps;
import banco_de_dados_2_view.ViewMain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lucas
 */
public class ControleGenerico {

    public static List<ObjectsBD> getAll(String sql, String tipoObjeto) {

        Random generator = new Random();
        int conexaoAleatorio = generator.nextInt(2) + 1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexao connection = new Conexao(ConexaoProps.getConexaoProps(conexaoAleatorio));
        
        ViewMain.conexao1.setText(ConexaoProps.getConexaoProps(conexaoAleatorio).getCaminhoBanco() + " " + ConexaoProps.getConexaoProps(conexaoAleatorio).getUsuario());

        List<ObjectsBD> mObjectList = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            switch (tipoObjeto) {
                case "logradouro": {
                    while (rs.next()) {
                        int mId = rs.getInt(1);
                        String mNome = rs.getString(2);
                        Logradouro p = new Logradouro();
                        p.setId(mId);
                        p.setNome(mNome);
                        mObjectList.add(p);
                    }
                }
                break;
                case "bairro": {
                    while (rs.next()) {
                        int mId = rs.getInt(1);
                        String mNome = rs.getString(2);
                        Bairro p = new Bairro();
                        p.setId(mId);
                        p.setNome(mNome);
                        mObjectList.add(p);
                    }
                }
                break;
                case "cidade": {
                    while (rs.next()) {
                        int mId = rs.getInt(1);
                        String mNome = rs.getString(2);
                        Cidade p = new Cidade();
                        p.setId(mId);
                        p.setNome(mNome);
                        mObjectList.add(p);
                    }
                }
                break;
                case "estado": {
                    while (rs.next()) {
                        int mId = rs.getInt(1);
                        String mNome = rs.getString(2);
                        Estado p = new Estado();
                        p.setId(mId);
                        p.setNome(mNome);
                        mObjectList.add(p);
                    }
                }
                break;
                case "pais": {
                    while (rs.next()) {
                        int mId = rs.getInt(1);
                        String mNome = rs.getString(2);
                        Pais p = new Pais();
                        p.setId(mId);
                        p.setNome(mNome);
                        mObjectList.add(p);
                    }
                }
                break;
                case "pessoas": {
                    while (rs.next()) {

                        Pessoas mPessoas = new Pessoas();
                        Logradouro mLogradouro = new Logradouro();
                        Bairro mBairro = new Bairro();
                        Cidade mCidade = new Cidade();
                        Estado mEstado = new Estado();
                        Pais mPais = new Pais();

                        mPessoas.setId(rs.getInt(1));
                        mPessoas.setNome(rs.getString(2));
                        mLogradouro.setId(rs.getInt(3));
                        mBairro.setId(rs.getInt(4));
                        mCidade.setId(rs.getInt(5));
                        mEstado.setId(rs.getInt(6));
                        mPais.setId(rs.getInt(7));
                        mLogradouro.setNome(rs.getString(8));
                        mBairro.setNome(rs.getString(9));
                        mCidade.setNome(rs.getString(10));
                        mEstado.setNome(rs.getString(11));
                        mPais.setNome(rs.getString(12));

                        mPessoas.setLogradouro(mLogradouro);
                        mPessoas.setBairro(mBairro);
                        mPessoas.setCidade(mCidade);
                        mPessoas.setEstado(mEstado);
                        mPessoas.setPais(mPais);

                        mObjectList.add(mPessoas);
                    }
                }
                break;
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(ViewMain.dialog, "Verifique conexão com o banco de dados", "Atenão", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return mObjectList;
    }

    public static void insert(String tipoObjeto, String nome, Pessoas pessoa) {
        Random generator = new Random();
        int conexaoAleatorio = generator.nextInt(2) + 1;
        Connection conn = null;
        ViewMain.ProgressBarConexao.setValue(0);
        ViewMain.ProgressBarConexao.setMaximum(3);
        int progress = 0;
        /*For com a quantidade de valores*/
        for (ConexaoProps c : ConexaoProps.values()) {
            /*Vai entrar no if caso valor seja igual ao recebido como parâmetro, 
            caso contrário fara as outras conexões*/
            if (c.idConexao == conexaoAleatorio) {
                Conexao connection = new Conexao(ConexaoProps.getConexaoProps(conexaoAleatorio));
                conn = Conexao.getConnection();

            }
            Conexao connection = new Conexao(ConexaoProps.getConexaoProps(c.idConexao));
            conn = Conexao.getConnection();

            // update progress bar
            SwingUtilities.invokeLater(new Runnable() {
                private int progress = c.ordinal() + 1;

                @Override
                public void run() {
                    ViewMain.ProgressBarConexao.setValue(this.progress);
                }
            });
            
            if (c.ordinal() == 0 ){
                ViewMain.conexao1.setText(c.getCaminhoBanco() + " " +c.getUsuario());
            }
            if (c.ordinal() == 1 ){
                ViewMain.conexao2.setText(c.getCaminhoBanco() + " " +c.getUsuario());
            }
            if (c.ordinal() == 2 ){
                ViewMain.conexao3.setText(c.getCaminhoBanco() + " " +c.getUsuario());
            }

            PreparedStatement ps = null;
            try {
                switch (tipoObjeto) {
                    case "logradouro": {
                        String sql = "insert into " + tipoObjeto + "(nome) values(?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nome);
                    }
                    break;
                    case "bairro": {
                        String sql = "insert into " + tipoObjeto + "(nome) values(?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nome);
                    }
                    break;
                    case "cidade": {
                        String sql = "insert into " + tipoObjeto + "(nome) values(?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nome);
                    }
                    break;
                    case "estado": {
                        String sql = "insert into " + tipoObjeto + "(nome) values(?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nome);
                    }
                    break;
                    case "pais": {
                        String sql = "insert into " + tipoObjeto + "(nome) values(?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nome);
                    }
                    break;
                    case "pessoas": {
                        String sql = "insert into pessoas (nome, logradouroIdLogradouro, bairroIdBairro, cidadeIdCidade, estadoIdEstado, paisIdPais) values(?,?,?,?,?,?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, pessoa.getNome());
                        ps.setInt(2, pessoa.getLogradouro().getId());
                        ps.setInt(3, pessoa.getBairro().getId());
                        ps.setInt(4, pessoa.getCidade().getId());
                        ps.setInt(5, pessoa.getEstado().getId());
                        ps.setInt(6, pessoa.getPais().getId());
                    }
                    break;
                }
                ps.execute();
                conn.commit();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());

                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }

            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
            }
        }
    }

    public static ObjectsBD select(String tipoObjeto, String nome) {

        Random generator = new Random();
        int conexaoAleatorio = generator.nextInt(2) + 1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexao connection = new Conexao(ConexaoProps.getConexaoProps(conexaoAleatorio));
        
        

        ObjectsBD obj = new ObjectsBD();
        try {
            conn = Conexao.getConnection();
            switch (tipoObjeto) {
                case "logradouro": {
                    ps = conn.prepareStatement("select * from logradouro where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int codigo = rs.getInt(1);
                        String nomeL = rs.getString(2);

                        Logradouro logradouro = new Logradouro();
                        logradouro.setId(codigo);
                        logradouro.setNome(nomeL);

                        obj = logradouro;
                    }
                }
                break;
                case "bairro": {
                    ps = conn.prepareStatement("select * from bairro where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int codigo = rs.getInt(1);
                        String nomeB = rs.getString(2);

                        Bairro bairro = new Bairro();

                        bairro.setId(codigo);
                        bairro.setNome(nomeB);

                        obj = bairro;
                    }

                }
                break;
                case "cidade": {
                    ps = conn.prepareStatement("select * from cidade where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int codigo = rs.getInt(1);
                        String nomeC = rs.getString(2);

                        Cidade cidade = new Cidade();

                        cidade.setId(codigo);
                        cidade.setNome(nomeC);

                        obj = cidade;
                    }
                }
                break;
                case "estado": {
                    ps = conn.prepareStatement("select * from estado where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int codigo = rs.getInt(1);
                        String nomeE = rs.getString(2);

                        Estado estado = new Estado();

                        estado.setId(codigo);
                        estado.setNome(nomeE);

                        obj = estado;
                    }

                }
                break;
                case "pais": {
                    ps = conn.prepareStatement("select * from pais where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int codigo = rs.getInt(1);
                        String nomeP = rs.getString(2);

                        Pais pais = new Pais();

                        pais.setId(rs.getInt(1));
                        pais.setNome(rs.getString(2));

                        obj = pais;
                    }
                }
                break;
                case "pessoas": {
                    System.out.println("Not now");
                }
                break;
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return obj;
    }

    public static void delete(Pessoas pessoa) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from pessoas where id_pessoas = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getId());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public static void update(Pessoas pessoa) {

        Random generator = new Random();
        int conexaoAleatorio = generator.nextInt(2) + 1;
        Connection conn = null;

        ViewMain.ProgressBarConexao.setValue(0);
        ViewMain.ProgressBarConexao.setMaximum(3);
        int progress = 0;
        /*For com a quantidade de valores*/
        for (ConexaoProps c : ConexaoProps.values()) {
            /*Vai entrar no if caso valor seja igual ao recebido como parâmetro, 
            caso contrário fara as outras conexões*/
            if (c.idConexao == conexaoAleatorio) {
                Conexao connection = new Conexao(ConexaoProps.getConexaoProps(conexaoAleatorio));
                conn = Conexao.getConnection();

            }
            Conexao connection = new Conexao(ConexaoProps.getConexaoProps(c.idConexao));
            conn = Conexao.getConnection();

            // update progress bar
            SwingUtilities.invokeLater(new Runnable() {
                private int progress = c.ordinal() + 1;

                @Override
                public void run() {
                    ViewMain.ProgressBarConexao.setValue(this.progress);
                }
            });

            PreparedStatement ps = null;
            try {
                String sql = "update pessoas set nome = ?,cpf = ?,rg = ?,sexo = ?,rua = ?,cidade = ?,cep = ?,estado = ? where id_pessoas = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, pessoa.getNome());
                // ps.setString(2, pessoa.getCpf());
                // ps.setString(3, pessoa.getRg());
                //// ps.setString(4, pessoa.getSexo());
                // ps.setString(5, pessoa.getRua());
                // ps.setString(6, pessoa.getCidade());
                // ps.setString(7, pessoa.getCep());
                //ps.setString(8, pessoa.getEstado());
                ps.setInt(9, pessoa.getId());
                ps.execute();
                conn.commit();
            } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());

                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }

            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
            }
        }
    }
}
