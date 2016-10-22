/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados_2_controller;

import banco_de_dados_2_beans.ObjectsBD;
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
        
    public static List<ObjectsBD> getAll(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        List<ObjectsBD> mObjectList = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int mId = rs.getInt(1);
                String mNome = rs.getString(2);
                ObjectsBD p = new ObjectsBD();
                p.setId(mId);
                p.setNome(mNome);
                mObjectList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
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
        return mObjectList;
    }
}
