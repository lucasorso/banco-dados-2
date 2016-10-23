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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ControleGenerico {

    public static List<ObjectsBD> getAll(String sql, String tipoObjeto) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
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

    public static void insert(String tipoObjeto, String nome) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into " + tipoObjeto + "(nome) values(?)";
            ps = conn.prepareStatement(sql);

            switch (tipoObjeto) {
                case "logradouro": {
                    ps.setString(1, nome);
                }
                break;
                case "bairro": {
                    ps.setString(1, nome);
                }
                break;
                case "cidade": {
                    ps.setString(1, nome);
                }
                break;
                case "estado": {
                    ps.setString(1, nome);
                }
                break;
                case "pais": {
                    ps.setString(1, nome);
                }
                break;
                case "pessoas": {

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

    public static ObjectsBD select(String tipoObjeto, String nome) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ObjectsBD obj = new ObjectsBD();
        try {
            conn = Conexao.getConnection();
            switch (tipoObjeto) {
                case "logradouro": {
                    ps = conn.prepareStatement("select * from logradouro where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    Logradouro logradouro = new Logradouro();
                    logradouro.setId(rs.getInt(1));
                    logradouro.setNome(rs.getString(2));

                    obj = logradouro;
                }
                break;
                case "bairro": {
                    ps = conn.prepareStatement("select * from bairro where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    Bairro bairro = new Bairro();

                    bairro.setId(rs.getInt(1));
                    bairro.setNome(rs.getString(2));

                    obj = bairro;
                }
                break;
                case "cidade": {
                    ps = conn.prepareStatement("select * from cidade where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    Cidade cidade = new Cidade();

                    cidade.setId(rs.getInt(1));
                    cidade.setNome(rs.getString(2));

                    obj = cidade;
                }
                break;
                case "estado": {
                    ps = conn.prepareStatement("select * from estado where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();

                    Estado estado = new Estado();

                    estado.setId(rs.getInt(1));
                    estado.setNome(rs.getString(2));

                    obj = estado;
                }
                break;
                case "pais": {
                    ps = conn.prepareStatement("select * from pais where nome = ?;");
                    ps.setString(1, nome);
                    rs = ps.executeQuery();
                    
                    Pais pais = new Pais();

                    pais.setId(rs.getInt(1));
                    pais.setNome(rs.getString(2));

                    obj = pais;
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
}
