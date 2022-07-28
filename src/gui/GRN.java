/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.GRNReport;
import model.MySQL;
import model.Test;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author poojithairosha
 */
public class GRN extends javax.swing.JPanel {
    
    DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * Creates new form GRN
     */
    public GRN() {
        initComponents();

        // Custom Methods
        loadPaymentMethods();
        loadGrns();
    }
    
    public void updateTotal() {
        double total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            total += Double.parseDouble(jTable1.getValueAt(i, 9).toString());
        }
        jTextField10.setText(String.valueOf(total));
    }
    
    public void clearFields() {
        // Product
        jTextField3.setText("None");
        jTextField4.setText("None");
        jTextField5.setText("None");
        jTextField6.setText("None");
        // Price and Qty
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }
    
    public void loadPaymentMethods() {
        try {
            ResultSet paymentTypeRs = MySQL.search("SELECT * FROM `payment_type`");
            
            Vector v = new Vector();
            v.add("Select");
            
            while (paymentTypeRs.next()) {
                v.add(paymentTypeRs.getString("name"));
            }
            
            DefaultComboBoxModel dcbm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcbm);
            
        } catch (Exception e) {
        }
    }
    
    public void loadGrns() {
        try {
            ResultSet grn_rs = MySQL.search("SELECT * FROM `grn` INNER JOIN `grn_payment` ON `grn_payment`.`grn_id` = `grn`.`id` INNER JOIN `supplier` ON `grn`.`supplier_id` = supplier.`id` INNER JOIN `payment_type` ON `grn_payment`.`payment_type_id` = `payment_type`.`id`");
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);
            
            while (grn_rs.next()) {
                Vector v = new Vector();
                v.add(grn_rs.getString("grn.id"));
                v.add(grn_rs.getString("supplier.name"));
                v.add(grn_rs.getString("grn.date_time"));
                v.add(grn_rs.getString("payment_type.name"));

                // Calculate Total Price
                double price = Double.parseDouble(grn_rs.getString("grn_payment.payment")) - Double.parseDouble(grn_rs.getString("grn_payment.balance"));
                
                v.add(price);
                v.add(grn_rs.getString("grn_payment.payment"));
                v.add(grn_rs.getString("grn_payment.balance"));
                dtm.addRow(v);
            }
            
            jTable2.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void searchGrns(String text) {
        try {
            ResultSet grn_rs = MySQL.search("SELECT * FROM `grn` INNER JOIN `grn_payment` ON `grn_payment`.`grn_id` = `grn`.`id` INNER JOIN `supplier` ON `grn`.`supplier_id` = supplier.`id` INNER JOIN `payment_type` ON `grn_payment`.`payment_type_id` = `payment_type`.`id` WHERE `grn`.`date_time` LIKE '%" + text + "%'");
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);
            
            while (grn_rs.next()) {
                Vector v = new Vector();
                v.add(grn_rs.getString("grn.id"));
                v.add(grn_rs.getString("supplier.name"));
                v.add(grn_rs.getString("grn.date_time"));
                v.add(grn_rs.getString("payment_type.name"));

                // Calculate Total Price
                double price = Double.parseDouble(grn_rs.getString("grn_payment.payment")) - Double.parseDouble(grn_rs.getString("grn_payment.balance"));
                
                v.add(price);
                v.add(grn_rs.getString("grn_payment.payment"));
                v.add(grn_rs.getString("grn_payment.balance"));
                dtm.addRow(v);
            }
            
            jTable2.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(38, 121, 219));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/grn 48.png"))); // NOI18N
        jLabel1.setText("Good Received Note");
        jLabel1.setIconTextGap(15);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Supplier ID");

        jLabel6.setText("Supplier Name");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Select Supplier");

        jButton1.setBackground(new java.awt.Color(255, 190, 0));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setText("SELECT SUPPLIER");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextField1.setEditable(false);
        jTextField1.setText("None");

        jTextField2.setEditable(false);
        jTextField2.setText("None");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Select Product");

        jLabel7.setText("Product ID");

        jLabel8.setText("Product Name");

        jTextField3.setEditable(false);
        jTextField3.setText("None");

        jTextField4.setEditable(false);
        jTextField4.setText("None");

        jLabel9.setText("Brand");

        jTextField5.setEditable(false);
        jTextField5.setText("None");

        jTextField6.setEditable(false);
        jTextField6.setText("None");

        jLabel10.setText("Category");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel17.setText("Add GRN");

        jButton2.setBackground(new java.awt.Color(255, 190, 0));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton2.setText("SELECT PRODUCT");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Quantity");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel12.setText("Buying Price");

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jLabel13.setText("Selling Price");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel14.setText("Manufacture Date");

        jLabel15.setText("Expire Date");

        jScrollPane1.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Category", "Brand", "Quantity", "Buying Price", "Selling Price", "MFD", "EXD", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel16.setText("Grand Total");

        jTextField10.setEditable(false);
        jTextField10.setText("0.00");

        jLabel18.setText("Payment");

        jTextField11.setEditable(false);
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jLabel19.setText("Payment Method");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel20.setText("Balance");

        jTextField12.setEditable(false);
        jTextField12.setText("0.00");
        jTextField12.setDoubleBuffered(true);

        jButton3.setBackground(new java.awt.Color(38, 121, 219));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-checkout-50.png"))); // NOI18N
        jButton3.setText("CHEKOUT");
        jButton3.setBorderPainted(false);
        jButton3.setIconTextGap(15);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11)
                    .addComponent(jTextField10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField12))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        jButton4.setBackground(new java.awt.Color(38, 121, 219));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-add-30 (1).png"))); // NOI18N
        jButton4.setText("Add to GRN");
        jButton4.setBorderPainted(false);
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jTextField4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(jTextField6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField9)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDateChooser1, jDateChooser2, jTextField7, jTextField8, jTextField9});

        jTabbedPane1.addTab("Add a GRN", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel21.setText("View GRNs");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Supplier Name", "Date Time", "Payment Method", "Price", "Payment", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton5.setBackground(new java.awt.Color(255, 190, 0));
        jButton5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-refresh-30.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Search GRN :");

        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jDateChooser3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser3PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("View GRNs", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SelectProduct sp = new SelectProduct((JFrame) SwingUtilities.getWindowAncestor(this), true);
        sp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SelectSupplier ss = new SelectSupplier((JFrame) SwingUtilities.getWindowAncestor(this), true);
        ss.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String supplierId = jTextField1.getText();
        String productId = jTextField3.getText();
        String qty = jTextField7.getText();
        String buyingPrice = jTextField8.getText();
        String sellingPrice = jTextField9.getText();
        Date mfd = jDateChooser1.getDate();
        Date exd = jDateChooser2.getDate();
        
        if (supplierId.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select a supplier", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (productId.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select a product", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("[1-9][0-9]*").matcher(qty).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*]))").matcher(buyingPrice).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid buying price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*]))").matcher(sellingPrice).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid selling price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (Double.parseDouble(buyingPrice) >= Double.parseDouble(sellingPrice)) {
            JOptionPane.showMessageDialog(this, "Invalid buying and selling price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mfd == null) {
            JOptionPane.showMessageDialog(this, "Invalid manufature date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mfd.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid manufature date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (exd == null) {
            JOptionPane.showMessageDialog(this, "Invalid expire date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (exd.before(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid expire date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean isFound = false;
            int foundRow = -1;
            
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String id = jTable1.getValueAt(i, 0).toString();
                
                if (id.equals(productId)) {
                    isFound = true;
                    foundRow = i;
                    break;
                }
            }
            
            if (isFound) {
                int option = JOptionPane.showConfirmDialog(this, "This product is already added to the grn. Do you want to update the quantity?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    int currentQty = Integer.parseInt(jTable1.getValueAt(foundRow, 4).toString());
                    int newQty = currentQty + Integer.parseInt(qty);
                    
                    jTable1.setValueAt(newQty, foundRow, 4);
                    jTable1.setValueAt(buyingPrice, foundRow, 5);
                    
                    double newItemTotal = newQty * Double.parseDouble(buyingPrice);
                    jTable1.setValueAt(newItemTotal, foundRow, 9);
                    
                    updateTotal();
                }
                clearFields();
            } else {
                Vector v = new Vector();
                v.add(productId);
                v.add(jTextField4.getText());
                v.add(jTextField6.getText());
                v.add(jTextField5.getText());
                
                v.add(qty);
                v.add(buyingPrice);
                v.add(sellingPrice);
                v.add(sdf.format(mfd));
                v.add(sdf.format(exd));
                
                double itemTotal = Integer.parseInt(qty) * Double.parseDouble(buyingPrice);
                v.add(df.format(itemTotal));
                
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.addRow(v);
                jTable1.setModel(dtm);
                
                updateTotal();
                clearFields();
                JOptionPane.showMessageDialog(this, "Product added to the GRN", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            
            int option = JOptionPane.showConfirmDialog(this, "Do you want to remove this product from grn", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
            if (option == JOptionPane.YES_OPTION) {
                int selectedRow = jTable1.getSelectedRow();
                dtm.removeRow(selectedRow);
                updateTotal();
                JOptionPane.showMessageDialog(this, "Selected grn tem removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        String qty = jTextField7.getText();
        String text = qty + evt.getKeyChar();
        
        if (!Pattern.compile("[1-9][0-9]*").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
        String price = jTextField8.getText();
        String text = price + evt.getKeyChar();
        
        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
        String price = jTextField9.getText();
        String text = price + evt.getKeyChar();
        
        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
        String price = jTextField11.getText();
        String text = price + evt.getKeyChar();
        
        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String text = jComboBox1.getSelectedItem().toString();
        if (text.equals("Select")) {
            jTextField11.setEditable(false);
        } else {
            jTextField11.setEditable(true);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String payment = jTextField11.getText();
        String paymentMethod = jComboBox1.getSelectedItem().toString();
        
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add products ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (paymentMethod.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a payment method", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("(0)|([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*]))").matcher(payment).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid payment", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            // GRN INSERT
            String supplierId = jTextField1.getText();
            String currentDate = sdf2.format(new Date());
            
            String uniqueId = UUID.randomUUID().toString();
            String userId = SignIn.userId;
            
            MySQL.iud("INSERT INTO `grn`(`date_time`,`supplier_id`, `user_id`,`unique_id`) VALUES ('" + currentDate + "', '" + supplierId + "', '" + userId + "', '" + uniqueId + "')");
            // GRN INSERT

            try {
                // GRN PAYMENT ITEM
                ResultSet grnRs = MySQL.search("SELECT * FROM `grn` WHERE `unique_id` ='" + uniqueId + "'");
                grnRs.next();
                String grnId = grnRs.getString("id");
                
                String balance = jTextField12.getText();
                
                ResultSet paymentTypeRs = MySQL.search("SELECT * FROM `payment_type` WHERE `name` = '" + paymentMethod + "'");
                paymentTypeRs.next();
                String paymentTypeId = paymentTypeRs.getString("id");
                
                MySQL.iud("INSERT INTO `grn_payment`(`payment`,`balance`,`payment_type_id`,`grn_id`) VALUES ('" + payment + "', '" + balance + "', '" + paymentTypeId + "', '" + grnId + "')");
                // GRN PAYMENT ITEM

                Vector v = new Vector();

                // GRN ITEM INSERT & STOCK INSERT OR UPDATE
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String productId = jTable1.getValueAt(i, 0).toString();
                    String quantity = jTable1.getValueAt(i, 4).toString();
                    String buyingPrice = jTable1.getValueAt(i, 5).toString();
                    String sellingPrice = jTable1.getValueAt(i, 6).toString();
                    String total = jTable1.getValueAt(i, 9).toString();
                    String mfd = jTable1.getValueAt(i, 7).toString();
                    String exd = jTable1.getValueAt(i, 8).toString();
                    String productName = jTable1.getValueAt(i, 1).toString();
                    String category = jTable1.getValueAt(i, 2).toString();
                    String brand = jTable1.getValueAt(i, 3).toString();
                    
                    v.add(new GRNReport(productId, productName, buyingPrice, quantity, total));

                    // STOCK
                    ResultSet stockRs = MySQL.search("SELECT * FROM `stock` WHERE `product_id` = '" + productId + "' AND `selling_price`='" + sellingPrice + "' AND `mfd` = '" + mfd + "' AND `exd` = '" + exd + "' ");
                    
                    {
                        String stockId;
                        
                        if (stockRs.next()) {
                            // UDATE
                            stockId = stockRs.getString("id");
                            String stockQty = stockRs.getString("quantity");
                            
                            int updatedQty = Integer.parseInt(stockQty) + +Integer.parseInt(quantity);
                            MySQL.iud("UPDATE `stock` SET `quantity`='" + updatedQty + "' WHERE `id`='" + stockId + "'");
                        } else {
                            // INSERT
                            MySQL.iud("INSERT INTO `stock`(`product_id`, `quantity`, `selling_price`, `mfd`,`exd`) VALUES ('" + productId + "', '" + quantity + "', '" + sellingPrice + "', '" + mfd + "', '" + exd + "') ");
                            
                            ResultSet stockRs2 = MySQL.search("SELECT * FROM `stock` WHERE `product_id` = '" + productId + "' AND `selling_price`='" + sellingPrice + "' AND `mfd` = '" + mfd + "' AND `exd` = '" + exd + "' ");
                            stockRs2.next();
                            stockId = stockRs2.getString("id");
                        }
                        
                        MySQL.iud("INSERT INTO `grn_item`(`quantity`,`buying_price`,`stock_id`,`grn_id`) VALUES ('" + quantity + "', '" + buyingPrice + "', '" + stockId + "', '" + grnId + "')");
                    }
                    // STOCK
                }

                // PRINT GRN 
                InputStream report = GRN.class.getResourceAsStream("/reports/sp_grn.jasper");

                // Parameters
                HashMap parameters = new HashMap();
                parameters.put("Parameter1", grnId);
                
                ResultSet supplierRs = MySQL.search("SELECT * FROM `supplier` INNER JOIN `company_branch` ON `supplier`.`company_branch_id` = `company_branch`.`id` INNER JOIN `company` ON `company_branch`.`company_id` = `company`.`id` WHERE `supplier`.`id` = '" + supplierId + "'");
                supplierRs.next();
                
                parameters.put("Parameter2", jTextField10.getText());// Total
                parameters.put("Parameter3", jTextField11.getText());// Payment
                parameters.put("Parameter4", jTextField12.getText());// Balance
                parameters.put("Parameter5", supplierRs.getString("supplier.name"));// S name
                parameters.put("Parameter6", supplierRs.getString("supplier.email"));// S Email
                parameters.put("Parameter7", supplierRs.getString("supplier.contact_no"));// S Contact No

                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(v);
                
                clearFields();
                
                jTextField1.setText("None");
                jTextField2.setText("None");
                jTextField10.setText("0.00");
                jTextField11.setText("");
                jTextField11.setEnabled(false);
                jTextField12.setText("0.00");
                jTextField12.setBackground(new Color(242, 242, 242));
                jComboBox1.setSelectedIndex(0);
                
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);
                
                JOptionPane.showMessageDialog(this, "New GRN created", "Success", JOptionPane.INFORMATION_MESSAGE);
                JasperPrint jp = JasperFillManager.fillReport(report, parameters, dataSource);
                JasperViewer.viewReport(jp, false);
                // GRN ITEM INSERT & STOCK INSERT OR UPDATE

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
        if (jTextField11.getText().isEmpty()) {
            jTextField12.setText("0.00");
            jTextField12.setForeground(Color.BLACK);
            
        } else {
            
            String total = jTextField10.getText();
            String payment = jTextField11.getText();
            
            double balance = Double.parseDouble(payment) - Double.parseDouble(total);
            
            if (balance < 0) {
                jTextField12.setBackground(Color.RED);
            } else {
                jTextField12.setBackground(Color.GREEN);
            }
            
            jTextField12.setText(String.valueOf(df.format(balance)));
        }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        loadGrns();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable2.getSelectedRow();
            if (selectedRow != -1) {
                String grnId = jTable2.getValueAt(selectedRow, 0).toString();
                
                try {
                    ResultSet grnRs = MySQL.search("SELECT * FROM `grn` INNER JOIN `grn_item` ON `grn`.`id` = `grn_item`.`grn_id` INNER JOIN `stock` ON `grn_item`.stock_id = stock.id INNER JOIN `product` ON `stock`.product_id  = product.id INNER JOIN `category` ON product.category_id = category.id INNER JOIN `brand` ON product.brand_id = brand.id WHERE `grn`.id = '" + grnId + "'");
                    
                    Vector v = new Vector();
                    while (grnRs.next()) {
                        
                        String productId = grnRs.getString("product.id");
                        String productName = grnRs.getString("product.name");
                        String category = grnRs.getString("category.name");
                        String brand = grnRs.getString("brand.name");
                        String quantity = grnRs.getString("grn_item.quantity");
                        double total = Double.parseDouble(grnRs.getString("grn_item.buying_price")) * Integer.parseInt(grnRs.getString("grn_item.quantity"));
                        v.add(new GRNReport(productId, productName, grnRs.getString("grn_item.buying_price"), quantity, String.valueOf(total)));
                        
                    }
                    
                    ResultSet grnRs2 = MySQL.search("SELECT * FROM `grn` INNER JOIN `grn_payment` ON `grn`.`id` = `grn_payment`.`grn_id` INNER JOIN `supplier` ON `grn`.supplier_id = supplier.id INNER JOIN `company_branch` ON `company_branch`.id = supplier.company_branch_id INNER JOIN `company` ON `company_branch`.`company_id` = `company`.`id` WHERE `grn`.id = '" + grnId + "'");
                    
                    if (grnRs2.next()) {
                        HashMap parameters = new HashMap();
                        parameters.put("Parameter1", grnId);
                        double total = Double.parseDouble(grnRs2.getString("grn_payment.payment")) - Double.parseDouble(grnRs2.getString("grn_payment.balance"));
                        parameters.put("Parameter2", df.format(total));// Total
                        parameters.put("Parameter3", df.format(Double.parseDouble(grnRs2.getString("grn_payment.payment"))));// Payment
                        parameters.put("Parameter4", df.format(Double.parseDouble(grnRs2.getString("grn_payment.balance"))));// Balance
                        parameters.put("Parameter5", grnRs2.getString("supplier.name"));// S Name
                        parameters.put("Parameter6", grnRs2.getString("supplier.email"));// S Email
                        parameters.put("Parameter7", grnRs2.getString("supplier.contact_no"));// S Contact No

                        InputStream report = GRN.class.getResourceAsStream("/reports/sp_grn.jasper");
                        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(v);
                        
                        JasperPrint jp = JasperFillManager.fillReport(report, parameters, dataSource);
                        JasperViewer.viewReport(jp, false);
                        
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jDateChooser3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser3PropertyChange
        // TODO add your handling code here:
        if (jDateChooser3.getDate() != null) {
            Date date = jDateChooser3.getDate();
            if (date == null) {
                loadGrns();
            } else {
                searchGrns(sdf.format(date));
            }
        }
    }//GEN-LAST:event_jDateChooser3PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
