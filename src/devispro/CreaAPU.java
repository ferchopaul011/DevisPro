/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devispro;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.table.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Crixo
 */
public class CreaAPU extends javax.swing.JFrame {
    
    devispro.APU p1;
     public static DefaultTableModel modelo_equipo;
     public static DefaultTableModel modelo_materiales;
     public static DefaultTableModel modelo_transporte;
     public static DefaultTableModel modelo_mano_de_obre;
    /**
     * Creates new form CreaAPU
     */
    public CreaAPU() {
        initComponents();
        
        //tabla de Equipo en JFrama CrearAPU
        modelo_equipo = new DefaultTableModel();
        String[] equipos= {"DESCRIPCION", "CANTIDAD (A)", "TARIFA (B)", "COSTO HORA (C=A*B)", "RENDIMIENTO (R)", "COSTO (D=C*R)"};
        DefaultTableModel e = new DefaultTableModel(null, equipos);
        jtbEquipo.setModel(e);
        modelo_equipo =(DefaultTableModel) jtbEquipo.getModel();
        jtbEquipo.setModel(modelo_equipo);
        
        //tabla de Materiales en JFrama CrearAPU
        modelo_materiales = new DefaultTableModel();
        String[] materiales= {"DESCRIPCION", "UNIDAD", "CANTIDAD(A)", "P.UNITARIO (B)", "COSTO (C=A*B)"};
        DefaultTableModel m = new DefaultTableModel(null, materiales);
        jtbMaterialesAPU.setModel(m);
        modelo_materiales =(DefaultTableModel) jtbMaterialesAPU.getModel();
        jtbMaterialesAPU.setModel(modelo_materiales);
        
        //tabla de transporte en JFrama CrearAPU
        modelo_transporte = new DefaultTableModel();
        String[] transporte= {"DESCRIPCION", "UNIDAD", "CANTIDAD (A)", "TARIFA (B)", "COSTO (C=A*B)"};
        DefaultTableModel t = new DefaultTableModel(null, transporte);
        jtbTransporte.setModel(t);
        modelo_transporte =(DefaultTableModel) jtbTransporte.getModel();
        jtbTransporte.setModel(modelo_transporte);
        
        //tabla de Mano de Obra en JFrama CrearAPU
        modelo_mano_de_obre = new DefaultTableModel();
        String[] obra= {"DESCRIPCION", "CANTIDAD (A)", "JORNAL/HORA (B)", "COSTO HORA (C=A*B)", "RENDIMIENTO (R)", "COSTO(D=C*R)"};
        DefaultTableModel o = new DefaultTableModel(null, obra);
        jtbManoobra.setModel(o);
        modelo_mano_de_obre =(DefaultTableModel) jtbManoobra.getModel();
        jtbManoobra.setModel(modelo_mano_de_obre);
        
        operacion_materiales();
        operacion_equipos();
        operacion_mano_de_obra();
        operacion_transporte();
    }
    private static void sumsub(){
        double sum=0.0;
        double mat=0.0;
        double equi=0.0;
        double manO=0.0;
        double trans=0.0;
        equi=Double.parseDouble(lblSubM.getText());
        manO=Double.parseDouble(lblSubN.getText());
        mat=Double.parseDouble(lblSubO.getText());
        trans=Double.parseDouble(lblSubP.getText());
        sum=equi+manO+mat+trans+sum;
       // DecimalFormat df= new DecimalFormat("######0.0000");
        //txtTOTCOS.setText(df.format(sum));
        txtTOTCOS.setText(Double.toString(sum));
               
    }
    private void operacion_equipos(){
        //Operacion automatica de tabla equipos        
        jtbEquipo.setModel(operacionEquipos(jtbEquipo.getModel()));
        modelo_equipo.addTableModelListener(new TableModelListener() {
            // para evitar concurrencias
            boolean active = false;

            // evento general
            public void tableChanged(TableModelEvent e) {
                // si no tiene una ejecucion y hemos modificado
                if (!active && e.getType() == TableModelEvent.UPDATE) {
                    active = true;

                    // recogemos el modelo
                    TableModel modelo = modelo_equipo;
                    // y le ponemos el nuevo con los totales calculados

                    jtbEquipo.setModel(operacionEquipos(modelo));
                    active = false;
                }
            }

        });
    }
    
    private void operacion_mano_de_obra(){
        //Operacion automatica de tabla equipos        
        jtbManoobra.setModel(operacionManodeObra(jtbManoobra.getModel()));
        modelo_mano_de_obre.addTableModelListener(new TableModelListener() {
            // para evitar concurrencias
            boolean active = false;

            // evento general
            public void tableChanged(TableModelEvent e) {
                // si no tiene una ejecucion y hemos modificado
                if (!active && e.getType() == TableModelEvent.UPDATE) {
                    active = true;

                    // recogemos el modelo
                    TableModel modelo = modelo_mano_de_obre;
                    // y le ponemos el nuevo con los totales calculados

                    jtbManoobra.setModel(operacionManodeObra(modelo));
                    active = false;
                }
            }

        });
    }
    
    private void operacion_materiales(){
        //Operacion automatica de tabla materiales        
        jtbMaterialesAPU.setModel(operacionMateriales(jtbMaterialesAPU.getModel()));
        modelo_materiales.addTableModelListener(new TableModelListener() {
            // para evitar concurrencias
            boolean active = false;

            // evento general
            public void tableChanged(TableModelEvent e) {
                // si no tiene una ejecucion y hemos modificado
                if (!active && e.getType() == TableModelEvent.UPDATE) {
                    active = true;

                    // recogemos el modelo
                    TableModel modelo = modelo_materiales;
                    // y le ponemos el nuevo con los totales calculados

                    jtbMaterialesAPU.setModel(operacionMateriales(modelo));
                    active = false;
                }
            }

        });
    }
    
    private void operacion_transporte(){
        //Operacion automatica de tabla materiales        
        jtbTransporte.setModel(operacionTransporte(jtbTransporte.getModel()));
        modelo_transporte.addTableModelListener(new TableModelListener() {
            // para evitar concurrencias
            boolean active = false;

            // evento general
            public void tableChanged(TableModelEvent e) {
                // si no tiene una ejecucion y hemos modificado
                if (!active && e.getType() == TableModelEvent.UPDATE) {
                    active = true;

                    // recogemos el modelo
                    TableModel modelo = modelo_transporte;
                    // y le ponemos el nuevo con los totales calculados

                    jtbTransporte.setModel(operacionTransporte(modelo));
                    active = false;
                }
            }

        });
    }
   
    
    private static TableModel operacionEquipos(TableModel datos) {
        for (int x = 0; x < datos.getRowCount(); x++) {
            String valor2 = null;
            Double valor3 = null;
            double sumaEquipo=0.0;
            int cont=0;
            cont= datos.getRowCount();
            
            try {
                valor2 = String.valueOf((Integer.valueOf((String) datos.getValueAt(x, 1)) * (Double.valueOf((String) datos.getValueAt(x, 2)))));
                datos.setValueAt(valor2, x, 3);
                valor3 = Double.valueOf((Double.valueOf((String) datos.getValueAt(x, 3)) * (Double.valueOf((String) datos.getValueAt(x, 4)))));
                DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
                simbolo.setDecimalSeparator('.');
                DecimalFormat nf = new DecimalFormat("#########.##",simbolo);
                String valor4= null;
                valor4 = String.valueOf(nf.format(valor3));
                datos.setValueAt(valor4, x, 5);      
                //para sumar subtotales
                for(int i=0;i<=cont;i++){
                sumaEquipo = sumaEquipo + Double.parseDouble(datos.getValueAt(i, 5).toString());
                lblSubM.setText(Double.toString(sumaEquipo));}
                //sumsub(); 
           
            } catch (Exception e) {
            }
        }

        return datos;
    }
    
    private static TableModel operacionManodeObra(TableModel datos) {
        for (int x = 0; x < datos.getRowCount(); x++) {
            String valor2 = null;
            Double valor3 = null;
            double sumaManoObra=0.0;
            int cont=0;
            cont= datos.getRowCount();
            
            try {
                valor2 = String.valueOf((Integer.valueOf((String) datos.getValueAt(x, 1)) * (Double.valueOf((String) datos.getValueAt(x, 2)))));
                datos.setValueAt(valor2, x, 3);
                valor3 = Double.valueOf((Double.valueOf((String) datos.getValueAt(x, 3)) * (Double.valueOf((String) datos.getValueAt(x, 4)))));
                DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
                simbolo.setDecimalSeparator('.');
                DecimalFormat nf = new DecimalFormat("#########.##",simbolo);
                String valor4= null;
                valor4 = String.valueOf(nf.format(valor3));
                datos.setValueAt(valor4, x, 5);
                //suma de subtotales
                  for(int i=0;i<=cont;i++){
                sumaManoObra = sumaManoObra+ Double.parseDouble(datos.getValueAt(i, 5).toString());
                lblSubN.setText(Double.toString(sumaManoObra));}
                 // sumsub();
      
            } catch (Exception e) {
            }
        }

        return datos;
    }
    
    private static TableModel operacionMateriales(TableModel datos) {
        for (int x = 0; x < datos.getRowCount(); x++) {
            String valor = null;
            double sumaMaterial=0.0;
            int cont=0;
            cont= datos.getRowCount();
            try {
                valor = String.valueOf((Integer.valueOf((String) datos.getValueAt(x, 2)) * (Double.valueOf((String) datos.getValueAt(x, 3)))));
                       //suma de subtotales
                for(int i=0;i<=cont;i++){
                sumaMaterial = sumaMaterial+ Double.parseDouble(datos.getValueAt(i, 4).toString());
                lblSubO.setText(Double.toString(sumaMaterial));}
          //sumsub();
            } catch (Exception e) {
            }
            datos.setValueAt(valor, x, 4);
        }

        return datos;
    }
    
    private static TableModel operacionTransporte(TableModel datos) {
        for (int x = 0; x < datos.getRowCount(); x++) {
            String valor = null;
             double sumaTransporte=0.0;
            int cont=0;
            cont= datos.getRowCount();
            try {
                valor = String.valueOf((Integer.valueOf((String) datos.getValueAt(x, 2)) * (Double.valueOf((String) datos.getValueAt(x, 3)))));
                //suma de subtotales
                for(int i=0;i<=cont;i++){
                sumaTransporte = sumaTransporte+ Double.parseDouble(datos.getValueAt(i, 4).toString());
                lblSubP.setText(Double.toString(sumaTransporte));} 
            //sumsub();
            } catch (Exception e) {
            }
            datos.setValueAt(valor, x, 4);
        }

        return datos;
    }
 

    private void abril_p1(){
        p1 = new devispro.APU();
        JTBAPU.addTab("APU", p1);
        JTBAPU.setSelectedComponent(p1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTBAPU = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jpnFormAPU = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LBLNHojas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombRubro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAddEQ = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblSubM = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAddMO = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbManoobra = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblSubN = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAddMA = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbMaterialesAPU = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        lblSubO = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAddTR = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbTransporte = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lblSubP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtObindi = new javax.swing.JTextField();
        txtutili = new javax.swing.JTextField();
        txtTOTCOS = new javax.swing.JTextField();
        txtIndirec = new javax.swing.JTextField();
        txtUTILIDAD = new javax.swing.JTextField();
        txtCosTotRub = new javax.swing.JTextField();
        txtValorOfert = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbEquipo = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnFormAPU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnFormAPU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("ANÁLISIS DE PRECIOS UNITARIOS");

        jLabel2.setText("RUBRO:");

        jLabel3.setText("HOJA:");

        LBLNHojas.setText("?");

        jLabel4.setText("UNIDAD:");

        jLabel5.setText("DETALLE:");

        jLabel6.setText("EQUIPOS:");

        btnAddEQ.setText("AÑADIR EQ");
        btnAddEQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEQActionPerformed(evt);
            }
        });

        jLabel7.setText("SUBTOTAL (M)");

        lblSubM.setText("0");

        jLabel8.setText("MANO DE OBRA");

        btnAddMO.setText("AÑADIR MO");
        btnAddMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMOActionPerformed(evt);
            }
        });

        jtbManoobra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "CANTIDAD (A)", "JORNAL/HORA (B)", "COSTO HORA (C=A*B)", "RENDIMIENTO (R)", "COSTO(D=C*R)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbManoobra);

        jLabel9.setText("SUBTOTAL (N)");

        lblSubN.setText("0");

        jLabel10.setText("MATERIALES");

        btnAddMA.setText("AÑADIR MA");
        btnAddMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMAActionPerformed(evt);
            }
        });

        jtbMaterialesAPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "UNIDAD", "CANTIDAD (A)", "P.UNITARIO (B)", "COSTO (C=A*B)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtbMaterialesAPU);

        jLabel11.setText("SUBTOTAL (O)");

        lblSubO.setText("0");

        jLabel12.setText("TRANSPORTE");

        btnAddTR.setText("AÑADIR TR");
        btnAddTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTRActionPerformed(evt);
            }
        });

        jtbTransporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "UNIDAD", "CANTIDAD (A)", "TARIFA (B)", "COSTO (C=A*B)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtbTransporte);

        jLabel13.setText("SUBTOTAL (P)");

        lblSubP.setText("0");

        jButton1.setText("NUEVO APU");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("TOTAL COSTOS DIRECTOS (M+N+O+P)");

        jLabel15.setText("INDIRECTOS %");

        jLabel16.setText("UTILIDAD %");

        jLabel17.setText("COSTO TOTAL DEL RUBRO");

        jLabel18.setText("VALOR OFERTADO");

        txtObindi.setToolTipText("AÑADIR DATO");
        txtObindi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtObindiKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObindiKeyTyped(evt);
            }
        });

        txtutili.setToolTipText("AÑADIR DATO");
        txtutili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtutiliActionPerformed(evt);
            }
        });
        txtutili.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtutiliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtutiliKeyTyped(evt);
            }
        });

        txtTOTCOS.setEditable(false);
        txtTOTCOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTOTCOSActionPerformed(evt);
            }
        });

        txtIndirec.setEditable(false);
        txtIndirec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndirecActionPerformed(evt);
            }
        });

        txtUTILIDAD.setEditable(false);

        txtCosTotRub.setEditable(false);

        txtValorOfert.setEditable(false);
        txtValorOfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorOfertActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");

        btnImprimir.setText("IMPRIMIR");

        jtbEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "CANTIDAD (A)", "TARIFA (B)", "COSTO HORA (C=A*B)", "RENDIMIENTO (R)", "COSTO (D=C*R)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jtbEquipo);

        jButton2.setText("calcular");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnFormAPULayout = new javax.swing.GroupLayout(jpnFormAPU);
        jpnFormAPU.setLayout(jpnFormAPULayout);
        jpnFormAPULayout.setHorizontalGroup(
            jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormAPULayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addComponent(txtNombRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFormAPULayout.createSequentialGroup()
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(47, 47, 47)
                                .addComponent(LBLNHojas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1)))
                        .addGap(67, 67, 67))
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddMO)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubM, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubO, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFormAPULayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(69, 69, 69)
                                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtObindi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtutili, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCosTotRub)
                            .addComponent(txtUTILIDAD, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIndirec, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(txtTOTCOS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtValorOfert, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFormAPULayout.createSequentialGroup()
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSubP, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnImprimir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar)))
                        .addGap(56, 56, 56))
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddEQ))
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddMA))
                            .addGroup(jpnFormAPULayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddTR)))
                        .addGap(0, 498, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFormAPULayout.createSequentialGroup()
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFormAPULayout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())))
            .addGroup(jpnFormAPULayout.createSequentialGroup()
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnFormAPULayout.setVerticalGroup(
            jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormAPULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(LBLNHojas))
                .addGap(8, 8, 8)
                .addComponent(txtNombRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(btnAddEQ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSubM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(btnAddMO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblSubN))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(btnAddMA))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnFormAPULayout.createSequentialGroup()
                        .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblSubO))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addComponent(btnAddTR))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblSubP))
                .addGap(39, 39, 39)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTOTCOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtObindi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtutili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUTILIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCosTotRub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtValorOfert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(23, 23, 23)
                .addGroup(jpnFormAPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnImprimir))
                .addGap(31, 31, 31))
        );

        jScrollPane5.setViewportView(jpnFormAPU);

        JTBAPU.addTab("APU 1", jScrollPane5);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTBAPU, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTBAPU, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtutiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtutiliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtutiliActionPerformed

    private void txtIndirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndirecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndirecActionPerformed

    private void txtValorOfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorOfertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorOfertActionPerformed

    private void btnAddEQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEQActionPerformed
        Equipos E= new Equipos();
        //E.setVisible(rootPaneCheckingEnabled);
        
        E.setVisible(true);
    }//GEN-LAST:event_btnAddEQActionPerformed

    private void btnAddMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMOActionPerformed
        MANO_DE_OBRA M=new MANO_DE_OBRA();
        
        M.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnAddMOActionPerformed

    private void btnAddMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMAActionPerformed
        Materiales Ma= new Materiales();
        
        Ma.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnAddMAActionPerformed

    private void btnAddTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTRActionPerformed
        TRANSPORTE T = new TRANSPORTE();
        
        T.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnAddTRActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        abril_p1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTOTCOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTOTCOSActionPerformed
               
    }//GEN-LAST:event_txtTOTCOSActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        double rub=0.0;
        double tot=0.0;
        double util=0.0;
        double indi=0.0;
        try {
            if (txtObindi.getText()!=null || txtutili.getText()!=null) {
             sumsub();
             tot=Double.parseDouble(txtTOTCOS.getText());
             util=Double.parseDouble(txtUTILIDAD.getText());
             indi=Double.parseDouble(txtIndirec.getText());
             rub=tot+util+indi;
             txtCosTotRub.setText(Double.toString(rub));
           txtValorOfert.setText(Double.toString(rub));
             
        }else{
            JOptionPane.showMessageDialog(null, "ingrese la utilidad y un valor agregado mayor a 0");
        }
            
        } catch (Exception e) {
        }
        
       
    }//GEN-LAST:event_jButton2MouseClicked

    private void txtObindiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObindiKeyPressed
   
        double sumsub=0.0;
        double porcen=0.0;
        double por=0.0;
        try {
        sumsub=Double.parseDouble(txtTOTCOS.getText());
        por=Double.parseDouble(txtObindi.getText()); 
        porcen= ((por/100)*sumsub);
        txtIndirec.setText(Double.toString(porcen));
            
        } catch (Exception e) {
            
        }
       
        
    }//GEN-LAST:event_txtObindiKeyPressed

    private void txtObindiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObindiKeyTyped
    char validar=evt.getKeyChar();
        if (Character.isLetter(validar)) {
         evt.consume();
        }
    }//GEN-LAST:event_txtObindiKeyTyped

    private void txtutiliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtutiliKeyTyped
        char validar=evt.getKeyChar();
        if (Character.isLetter(validar)) {
         evt.consume();
        }
    }//GEN-LAST:event_txtutiliKeyTyped

    private void txtutiliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtutiliKeyPressed
         double sumsub=0.0;
        double porcen=0.0;
        double por=0.0;
        try {
        
        sumsub=Double.parseDouble(txtTOTCOS.getText());
        por=Double.parseDouble(txtutili.getText()); 
        porcen= ((por/100)*sumsub);
        txtUTILIDAD.setText(Double.toString(porcen));
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtutiliKeyPressed

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
            java.util.logging.Logger.getLogger(CreaAPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreaAPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreaAPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreaAPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new CreaAPU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTBAPU;
    private javax.swing.JLabel LBLNHojas;
    private javax.swing.JButton btnAddEQ;
    private javax.swing.JButton btnAddMA;
    private javax.swing.JButton btnAddMO;
    private javax.swing.JButton btnAddTR;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jpnFormAPU;
    private javax.swing.JTable jtbEquipo;
    private javax.swing.JTable jtbManoobra;
    private javax.swing.JTable jtbMaterialesAPU;
    private javax.swing.JTable jtbTransporte;
    private static javax.swing.JLabel lblSubM;
    private static javax.swing.JLabel lblSubN;
    private static javax.swing.JLabel lblSubO;
    private static javax.swing.JLabel lblSubP;
    private javax.swing.JTextField txtCosTotRub;
    private javax.swing.JTextField txtIndirec;
    private javax.swing.JTextField txtNombRubro;
    private javax.swing.JTextField txtObindi;
    private static javax.swing.JTextField txtTOTCOS;
    private javax.swing.JTextField txtUTILIDAD;
    private javax.swing.JTextField txtValorOfert;
    private javax.swing.JTextField txtutili;
    // End of variables declaration//GEN-END:variables
}
