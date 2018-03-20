/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devispro;

import static devispro.Conexion.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crixo
 */
public class MANO_DE_OBRA extends javax.swing.JFrame {
DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form MANO_DE_OBRA
     */
    public MANO_DE_OBRA() {
        initComponents();
        mostrar();
    }
     private void mostrar(){
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet rs = Conexion.getTable("select * from mano_de_obra");
        modelo.setColumnIdentifiers(new Object[]{"cod","descripción","sueldo_unificado","salario_minimo","decimo_tercero",
        "decimo_cuarto","aporte_patronal","fondo_reserva","t_ganado_anual","jornal_r_dia","cost_h_hora","alimento","transporte",
        "costo_h_final"});
        try {
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("cod"),rs.getString("descripción"),rs.getDouble("sueldo_unificado"),rs.getDouble("salario_minimo"),
                rs.getDouble("decimo_tercero"),rs.getDouble("decimo_cuarto"),rs.getDouble("aporte_patronal"),rs.getDouble("fondo_reserva"),
                rs.getDouble("t_ganado_anual"),rs.getDouble("jornal_r_dia"),rs.getDouble("cost_h_hora"),rs.getDouble("alimento"),
                rs.getDouble("transporte"),rs.getDouble("costo_h_final")});
            }
            jtbManoOb.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnaddlista = new javax.swing.JButton();
        btnquitlista = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbManoOb = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbAddManoOb = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LISTA DE MANO DE OBRA");

        jLabel2.setText("BUSCAR:");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        btnaddlista.setText(">");
        btnaddlista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddlistaMouseClicked(evt);
            }
        });

        btnquitlista.setText("<");
        btnquitlista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnquitlistaMouseClicked(evt);
            }
        });

        jButton3.setText("AÑADIR");

        jtbManoOb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cod", "descripcion", "sueldo_unificado", "salario_minimo", "decimo_tercero", "decimo_cuarto", "aporte_patronal", "fondo_reserva", "t_ganado_anual", "jornal_r_dia", "jornal_h_hora", "alimentol", "transporte", "costo_h_final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtbManoOb);

        jtbAddManoOb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "descripción", "Sueldo_unificado", "Salario_minimo", "Decimo_tercero", "decimo_cuarto", "aporte_patronal", "fondo_reserva", "t_ganado_anual", "jornal_r_dia", "costo_h_hora", "alimento", "transporte", "costo_h_final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jtbAddManoOb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                                .addComponent(jScrollPane5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnquitlista)
                            .addComponent(btnaddlista))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnaddlista)
                .addGap(16, 16, 16)
                .addComponent(btnquitlista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
           String[] Mano_obra= {"cod","descripción","sueldo_unificado","salario_minimo","decimo_tercero",
        "decimo_cuarto","aporte_patronal","fondo_reserva","t_ganado_anual","jornal_r_dia","cost_h_hora","alimento","transporte",
        "costo_h_final"};
       //String[] Registro= new String[50];
       
       String sql = "Select * from mano_de_obra where cod like '%"+txtbuscar.getText()+"%'"
               +"or descripción like '%"+txtbuscar.getText()+"%'";
              
        DefaultTableModel modelo = new DefaultTableModel(null, Mano_obra);
        Connection conn = getConnection();
        //Connection conect = conn.conexion();
        try {
            Statement st = (Statement) conn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()){
                modelo.addRow(new Object[]{rs.getInt("cod"),rs.getString("descripción"),rs.getDouble("sueldo_unificado"),rs.getDouble("salario_minimo"),
                rs.getDouble("decimo_tercero"),rs.getDouble("decimo_cuarto"),rs.getDouble("aporte_patronal"),rs.getDouble("fondo_reserva"),
                rs.getDouble("t_ganado_anual"),rs.getDouble("jornal_r_dia"),rs.getDouble("cost_h_hora"),rs.getDouble("alimento"),
                rs.getDouble("transporte"),rs.getDouble("costo_h_final")});
            }
            jtbManoOb.setModel(modelo);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void btnaddlistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddlistaMouseClicked
     String descripcion=""; 
     Double sueldo_unificado=0.0;
     Double Salario_minimo=0.0;
     Double decimo_tercero=0.0;
     Double decimo_cuarto=0.0;
     Double aporte_patronal=0.0;
     Double fondo_reserva=0.0;
     Double t_ganado_anual=0.0;
     Double jornal_r_dia=0.0;
     Double cost_h_hora=0.0;
     Double alimento=0.0;
     Double transporte=0.0;
     Double costo_h_final=0.0;
        if(jtbManoOb.getSelectedRow()!=-1){
            
            int col =jtbManoOb.getSelectedRow();
         descripcion=jtbManoOb.getModel().getValueAt(col, 1).toString();
         sueldo_unificado=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 2).toString());
         Salario_minimo=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 3).toString());
         decimo_tercero=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 4).toString());
         decimo_cuarto=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 5).toString());
         aporte_patronal=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 6).toString());
         fondo_reserva=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 7).toString());
         t_ganado_anual=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 8).toString());
         jornal_r_dia=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 9).toString());
         cost_h_hora=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 10).toString());
         alimento=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 11).toString());
         transporte=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 12).toString());
         costo_h_final=Double.parseDouble(jtbManoOb.getModel().getValueAt(col, 13).toString());
         DefaultTableModel AM = (DefaultTableModel)jtbAddManoOb.getModel();
        // String code2=Integer.toString(code);
         String SueldoU=String.valueOf(descripcion);
         String SalarioM=String.valueOf(sueldo_unificado);
         String decimoT=String.valueOf(decimo_tercero);
         String decimoC=String.valueOf(decimo_cuarto);
         String aporteP=String.valueOf(aporte_patronal);
         String fondoR=String.valueOf(fondo_reserva);
         String tGanadoA=String.valueOf(t_ganado_anual);
         String jornalRD=String.valueOf(jornal_r_dia);
         String costoH=String.valueOf(cost_h_hora);
         String alimen=String.valueOf(alimento);
         String transp=String.valueOf(transporte);
         String costoHF=String.valueOf(costo_h_final);
         String FilMat[] = {SueldoU,SalarioM,decimoT,decimoC,aporteP,fondoR,tGanadoA,jornalRD,costoH,alimen,transp,costoHF};
         AM.addRow(FilMat);
     }
    }//GEN-LAST:event_btnaddlistaMouseClicked

    private void btnquitlistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnquitlistaMouseClicked
        if( jtbAddManoOb.getSelectedRow()!=-1){
            
            try {
                int  elim= jtbAddManoOb.getSelectedRow();
             DefaultTableModel ELt = (DefaultTableModel)jtbAddManoOb.getModel();
                //eliminar = (int)ELt.getValueAt(elim, 0);
                ELt.removeRow(elim);
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_btnquitlistaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MANO_DE_OBRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MANO_DE_OBRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MANO_DE_OBRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANO_DE_OBRA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MANO_DE_OBRA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddlista;
    private javax.swing.JButton btnquitlista;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jtbAddManoOb;
    private javax.swing.JTable jtbManoOb;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
