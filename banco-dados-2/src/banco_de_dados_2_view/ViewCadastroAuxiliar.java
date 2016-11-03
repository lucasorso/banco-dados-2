/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados_2_view;

import banco_de_dados_2_beans.ObjectsBD;
import banco_de_dados_2_beans.Pessoas;
import banco_de_dados_2_controller.ControleGenerico;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class ViewCadastroAuxiliar extends JFrame {

    private String tipoObjeto;
    private ViewMain viewMain;
    private DefaultTableModel modelo;
    private JTable tabela;
    private String sql = "select * from ";
    private List<ObjectsBD> mList;

    private void criarJtable(List<ObjectsBD> list) {
        modelo = new DefaultTableModel();
        tabela = new JTable(modelo);

        if (tipoObjeto == "pessoas") {
            modelo.addColumn("ID");
            modelo.addColumn("Nome");
            modelo.addColumn("Logradouro");
            modelo.addColumn("Bairro");
            modelo.addColumn("Cidade");
            modelo.addColumn("Estado");
            modelo.addColumn("Pais");

            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(600);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(10000);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(10000);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(10000);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(10000);
            tabela.getColumnModel().getColumn(5).setPreferredWidth(10000);
            tabela.getColumnModel().getColumn(6).setPreferredWidth(10000);

            Pessoas p = new Pessoas();
            for (ObjectsBD pe : list) {
                if (pe instanceof Pessoas) {
                    System.out.println(pe.toString());
                    p = (Pessoas) pe;
                    modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getLogradouro().getNome(),
                        p.getBairro().getNome(), p.getCidade().getNome(), p.getEstado().getNome(),
                        p.getPais().getNome()});
                }
            }
        } else {
            modelo.addColumn("ID");
            modelo.addColumn("Nome");

            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(500);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(10000);

            list.stream().forEach((objects) -> {
                modelo.addRow(new Object[]{objects.getId(), objects.getNome()});
            });
        }
        this.jScrollPane1.setViewportView(tabela);
    }

    private void configuraSQL(String tipoObjeto) {
        switch (tipoObjeto) {
            case "logradouro": {
                sql += "logradouro";
                mList = ControleGenerico.getAll(sql, tipoObjeto);
                criarJtable(mList);
            }
            break;
            case "bairro": {
                sql += "bairro";
                mList = ControleGenerico.getAll(sql, tipoObjeto);
                criarJtable(mList);
            }
            break;
            case "cidade": {
                sql += "cidade";
                mList = ControleGenerico.getAll(sql, tipoObjeto);
                criarJtable(mList);
            }
            break;
            case "estado": {
                sql += "estado";
                mList = ControleGenerico.getAll(sql, tipoObjeto);
                criarJtable(mList);
            }
            break;
            case "pais": {
                sql += "pais";
                mList = ControleGenerico.getAll(sql, tipoObjeto);
                criarJtable(mList);
            }
            break;
            case "pessoas": {
                sql = "SELECT p.*, l.nome AS logradouro, b.nome AS bairro, c.nome AS cidade, e.nome AS estado, pa.nome AS pais \n"
                        + "FROM pessoas AS p \n"
                        + "INNER JOIN logradouro AS l ON p.logradouroIdLogradouro = l.idLogradouro \n"
                        + "INNER JOIN bairro AS b ON p.bairroIdBairro = b.idBairro \n"
                        + "INNER JOIN cidade AS c ON P.cidadeIdCidade = c.idCidade\n"
                        + "INNER JOIN estado AS e ON p.estadoIdEstado = e.idEstado \n"
                        + "INNER JOIN pais AS pa ON p.paisIdPais = pa.idPais";
                mList = ControleGenerico.getAll(sql, tipoObjeto);
                criarJtable(mList);
            }
            break;
        }
    }

    public ViewCadastroAuxiliar(String tipoObjeto, ViewMain mMainView) {
        initComponents();
        this.tipoObjeto = tipoObjeto;
        this.viewMain = mMainView;
        configuraSQL(tipoObjeto);
        campoTextoTabela.setText(tipoObjeto);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        campoTextoTabela = new javax.swing.JTextField();
        botaoOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cadastros Auxiliares");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setText("Tabela");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        campoTextoTabela.setEditable(false);
        campoTextoTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTextoTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(botaoOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoTextoTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoTabelaActionPerformed

    }//GEN-LAST:event_campoTextoTabelaActionPerformed

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        if (tabela.getSelectedRow() != -1) {
            ObjectsBD obj = new ObjectsBD();
            int position = tabela.getSelectedRow();
            obj = mList.get(position);
            viewMain.setSelectObjetct(tipoObjeto, obj);
            dispose();
        } else {
            System.out.println("Nenhum linha selecionada");
            dispose();
        }
    }//GEN-LAST:event_botaoOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JTextField campoTextoTabela;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
