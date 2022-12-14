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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.InvoiceReport;
import model.MySQL;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author poojithairosha
 */
public class Invoice extends javax.swing.JPanel {

    DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form Invoice
     */
    public Invoice() {
        initComponents();

        // Custom Code
        loadPaymentMethods();
        loadInvoices();
    }

    public void loadInvoices() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            ResultSet rs = MySQL.search("SELECT * FROM `invoice` INNER JOIN `user` ON `invoice`.`user_id` = `user`.`id` INNER JOIN `invoice_payment` ON `invoice_payment`.`invoice_id` = `invoice`.`id` INNER JOIN `payment_type` ON `invoice_payment`.`payment_type_id` = `payment_type`.`id`");
            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getString("invoice.id"));
                v.add(rs.getString("user.name"));
                v.add(rs.getString("invoice.date_time"));
                v.add(rs.getString("payment_type.name"));
                double total = Double.parseDouble(rs.getString("invoice_payment.payment")) - Double.parseDouble(rs.getString("invoice_payment.balance"));
                v.add(total);
                v.add(rs.getString("invoice_payment.payment"));
                v.add(rs.getString("invoice_payment.balance"));

                dtm.addRow(v);
            }

            jTable2.setModel(dtm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTotal() {
        double total = 0.00;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            total += Double.parseDouble(jTable1.getValueAt(i, 9).toString());
        }

        jTextField12.setText(df.format(total));
    }

    public void loadPaymentMethods() {
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `payment_type`");
            Vector v = new Vector();

            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            DefaultComboBoxModel dcbm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcbm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearFields() {
        jTextField1.setText("");
        jTextField3.setText("None");
        jTextField4.setText("None");
        jTextField5.setText("None");
        jTextField6.setText("None");
        jTextField7.setText("None");
        jTextField8.setText("None");
        jTextField9.setText("None");
        jTextField10.setText("None");
    }

    public void searchInvoice(String text) {
        try {
            ResultSet invoice_rs = MySQL.search("SELECT * FROM `invoice` INNER JOIN `user` ON `invoice`.`user_id` = `user`.`id` INNER JOIN `invoice_payment` ON `invoice_payment`.`invoice_id` = `invoice`.`id` INNER JOIN `payment_type` ON `invoice_payment`.`payment_type_id` = `payment_type`.`id` WHERE `invoice`.`date_time` LIKE '%" + text + "%'");
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (invoice_rs.next()) {
                Vector v = new Vector();

                v.add(invoice_rs.getString("invoice.id"));
                v.add(invoice_rs.getString("user.name"));
                v.add(invoice_rs.getString("invoice.date_time"));
                v.add(invoice_rs.getString("payment_type.name"));
                double total = Double.parseDouble(invoice_rs.getString("invoice_payment.payment")) - Double.parseDouble(invoice_rs.getString("invoice_payment.balance"));
                v.add(total);
                v.add(invoice_rs.getString("invoice_payment.payment"));
                v.add(invoice_rs.getString("invoice_payment.balance"));

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Stock ID", "Product ID", "Brand", "Name", "Quantity", "Selling Price", "MFD", "EXD", "Total"
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add to Invoice"));

        jLabel1.setText("Quantity");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(38, 121, 219));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-add-30 (1).png"))); // NOI18N
        jButton1.setText("Add to INVOICE");
        jButton1.setBorderPainted(false);
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                        .addComponent(jTextField1)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Product", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jTextField6.setEditable(false);
        jTextField6.setText("None");

        jTextField7.setEditable(false);
        jTextField7.setText("None");

        jLabel7.setText("Product ID");

        jTextField4.setEditable(false);
        jTextField4.setText("None");

        jLabel13.setText("EXD");

        jLabel9.setText("Brand");

        jLabel11.setText("Stock ID");

        jLabel8.setText("Product Name");

        jTextField5.setEditable(false);
        jTextField5.setText("None");

        jTextField10.setEditable(false);
        jTextField10.setText("None");

        jTextField8.setEditable(false);
        jTextField8.setText("None");

        jLabel10.setText("Category");

        jLabel12.setText("MFD");

        jTextField3.setEditable(false);
        jTextField3.setText("None");

        jButton2.setBackground(new java.awt.Color(255, 190, 0));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton2.setText("SELECT PRODUCT");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Price");

        jTextField9.setEditable(false);
        jTextField9.setText("None");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4))))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField10)))
                        .addGap(2, 2, 2)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5)
                        .addComponent(jLabel10)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel16.setText("Grand Total");

        jTextField12.setEditable(false);
        jTextField12.setText("0.00");

        jLabel18.setText("Payment");

        jTextField13.setEditable(false);
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });

        jLabel19.setText("Payment Method");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel20.setText("Balance");

        jTextField14.setEditable(false);
        jTextField14.setText("0.00");
        jTextField14.setDoubleBuffered(true);

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
                    .addComponent(jTextField13)
                    .addComponent(jTextField12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField14))
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
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel17.setText("Add Invoice");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jSeparator2))
                        .addGap(20, 20, 20))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2});

        jTabbedPane1.addTab("Add a Invoice", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel21.setText("View Invoices");

        jLabel3.setText("Search Invoice :");

        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jDateChooser3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser3PropertyChange(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 190, 0));
        jButton5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-refresh-30.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice ID", "User Added", "Date & Time", "Payment Method", "Total", "Payment", "Change"
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1114, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("View Invoices", jPanel5);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 121, 219));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/invoice 48.png"))); // NOI18N
        jLabel2.setText("INVOICE");
        jLabel2.setIconTextGap(15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTabbedPane1))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SelectStock ss = new SelectStock((JFrame) SwingUtilities.getWindowAncestor(this), true);
        ss.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        String qty = jTextField1.getText();
        String text = qty + evt.getKeyChar();

        if (!Pattern.compile("[1-9][0-9]*").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        // TODO add your handling code here:
        String price = jTextField13.getText();
        String text = price + evt.getKeyChar();

        if (!Pattern.compile("(0|0[.]|0[.][0-9]{0,2})|([1-9][0-9]*[.]?[0-9]{0,2})").matcher(text).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String stockId = jTextField7.getText();
        String productId = jTextField3.getText();
        String productName = jTextField4.getText();
        String brand = jTextField5.getText();
        String price = jTextField10.getText();
        String exd = jTextField8.getText();
        String mfd = jTextField9.getText();
        String category = jTextField6.getText();
        String quantity = jTextField1.getText();

        if (stockId.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select a stock", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("[1-9][0-9]*").matcher(quantity).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // Check for available quantity
                ResultSet stockRs = MySQL.search("SELECT * FROM `stock` WHERE `id` = '" + stockId + "'");
                stockRs.next();

                String availableQuantity = stockRs.getString("quantity");

                if (Integer.parseInt(availableQuantity) < Integer.parseInt(quantity)) {
                    JOptionPane.showMessageDialog(this, "Quantity out of stock", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    // Find Same Product in Table
                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                    boolean isFound = false;
                    int foundRow = -1;

                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        String sId = jTable1.getValueAt(i, 1).toString();

                        if (sId.equals(stockId)) {
                            isFound = true;
                            foundRow = i;
                            break;
                        }
                    }

                    if (isFound) {
                        int confirmation = JOptionPane.showConfirmDialog(this, "This product is already added. Do you want to update?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                        if (confirmation == JOptionPane.YES_OPTION) {
                            int currentQuantity = Integer.parseInt(jTable1.getValueAt(foundRow, 5).toString());
                            int newQuantity = Integer.parseInt(quantity) + currentQuantity;

                            if (Integer.parseInt(availableQuantity) < newQuantity) {
                                JOptionPane.showMessageDialog(this, "Quantity out of stock", "Warning", JOptionPane.WARNING_MESSAGE);
                            } else {
                                jTable1.setValueAt(String.valueOf(newQuantity), foundRow, 5);

                                double newTotal = Double.parseDouble(price) * newQuantity;
                                jTable1.setValueAt(String.valueOf(df.format(newTotal)), foundRow, 9);

                                // Update Total
                                updateTotal();
                            }
                        }
                    } else {
                        Vector v = new Vector();
                        v.add(category);
                        v.add(stockId);
                        v.add(productId);
                        v.add(brand);
                        v.add(productName);
                        v.add(quantity);
                        v.add(price);
                        v.add(mfd);
                        v.add(exd);

                        double total = Double.parseDouble(price) * Integer.parseInt(quantity);
                        v.add(df.format(total));

                        dtm.addRow(v);
                        jTable1.setModel(dtm);

                        updateTotal();
                        clearFields();

                        JOptionPane.showMessageDialog(this, "Product added to the INVOICE", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "No Item Selected", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Do you want to remove this item?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {

                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                    dtm.removeRow(selectedRow);
                    updateTotal();
                    jTextField12.setText("0.00");
                    jComboBox1.setSelectedIndex(0);
                    jTextField13.setText("");
                    jTextField13.setEditable(false);
                    jTextField14.setText("0.00");

                    JOptionPane.showMessageDialog(this, "Invoice item removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String text = jComboBox1.getSelectedItem().toString();
        if (!text.equals("Select")) {
            jTextField13.setEditable(true);
        } else {
            jTextField13.setEditable(false);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:

        if (jTextField13.getText().isEmpty()) {
            jTextField14.setText("0.00");
            jTextField14.setBackground(Color.WHITE);

        } else {
            String total = jTextField12.getText();
            String payment = jTextField13.getText();

            double balance = Double.parseDouble(payment) - Double.parseDouble(total);

            if (balance < 0) {
                jTextField14.setBackground(Color.RED);
            } else {
                jTextField14.setBackground(Color.GREEN);
            }

            jTextField14.setText(df.format(balance));
        }
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String payment = jTextField13.getText();
        String paymentMethod = jComboBox1.getSelectedItem().toString();

        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add products ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (paymentMethod.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a payment method", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("(0)|([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*]))").matcher(payment).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid payment", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // Invoice Insert
                String uniqueId = UUID.randomUUID().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDateTime = sdf.format(new Date());

                MySQL.iud("INSERT INTO `invoice`(`date_time`, `user_id`, `customer_id`,`unique_id`) VALUES ('" + currentDateTime + "', '" + SignIn.userId + "', '0', '" + uniqueId + "')");
                // Invoice Insert

                // Invoice Payment Insert
                ResultSet rs = MySQL.search("SELECT * FROM `invoice` WHERE `unique_id`='" + uniqueId + "'");
                rs.next();
                String invoiceId = rs.getString("id");

                ResultSet rs2 = MySQL.search("SELECT * FROM `payment_type` WHERE `name`='" + paymentMethod + "'");
                rs2.next();
                String paymentMethodId = rs2.getString("id");

                String balance = jTextField14.getText();

                MySQL.iud("INSERT INTO `invoice_payment`(`invoice_id`, `payment_type_id`, `payment`, `balance`) VALUES ('" + invoiceId + "', '" + paymentMethodId + "','" + payment + "','" + balance + "')");
                // Invoice Payment Insert

                // Invoice Item INSERT & Stock UPDATE
                Vector v = new Vector();
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String stockId = jTable1.getValueAt(i, 1).toString();
                    String quantity = jTable1.getValueAt(i, 5).toString();
                    String productName = jTable1.getValueAt(i, 4).toString();
                    String price = jTable1.getValueAt(i, 6).toString();
                    String total = jTable1.getValueAt(i, 9).toString();

                    v.add(new InvoiceReport(stockId, productName, quantity, price, total));

                    ResultSet stockRs2 = MySQL.search("SELECT * FROM `stock` WHERE `id` = '" + stockId + "'");
                    stockRs2.next();

                    int availableQuantity = Integer.parseInt(stockRs2.getString("quantity"));
                    int newQuantity = availableQuantity - Integer.parseInt(quantity);

                    MySQL.iud("UPDATE `stock` SET `quantity` = '" + newQuantity + "' WHERE `id` = '" + stockId + "'");

                    MySQL.iud("INSERT INTO `invoice_item` (`quantity`, `stock_id`, `invoice_id`) VALUES ('" + quantity + "', '" + stockId + "', '" + invoiceId + "')");
                }

                InputStream filePath = Invoice.class.getResourceAsStream("/reports/sp_invoice.jasper");

                HashMap parameters = new HashMap();
                parameters.put("Parameter1", invoiceId);
                parameters.put("Parameter2", df.format(Double.parseDouble(jTextField12.getText())));
                parameters.put("Parameter3", df.format(Double.parseDouble(jTextField13.getText())));
                parameters.put("Parameter4", df.format(Double.parseDouble(jTextField14.getText())));

                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(v);

                clearFields();
                jTextField12.setText("0.00");
                jTextField13.setText("");
                jTextField13.setEditable(false);
                jComboBox1.setSelectedIndex(0);
                jTextField14.setText("0.00");
                jTextField14.setBackground(Color.WHITE);

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);
                JOptionPane.showMessageDialog(this, "New invoice created", "Success", JOptionPane.INFORMATION_MESSAGE);

                JasperPrint jp = JasperFillManager.fillReport(filePath, parameters, dataSource);
                JasperViewer.viewReport(jp, false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jDateChooser3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser3PropertyChange
        // TODO add your handling code here:
        if (jDateChooser3.getDate() != null) {
            Date date = jDateChooser3.getDate();
            if (date == null) {
                loadInvoices();
            } else {
                searchInvoice(sdf1.format(date));
            }
        }
    }//GEN-LAST:event_jDateChooser3PropertyChange

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        loadInvoices();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable2.getSelectedRow();

            if (selectedRow != -1) {
                try {
                    String invoiceId = jTable2.getValueAt(selectedRow, 0).toString();

                    ResultSet invoiceRs = MySQL.search("SELECT * FROM `invoice` INNER JOIN `invoice_item` ON `invoice`.`id` = `invoice_item`.`invoice_id` INNER JOIN `stock` ON `invoice_item`.`stock_id` = `stock`.`id` INNER JOIN `product` ON `stock`.`product_id` = `product`.`id` WHERE `invoice`.`id` = '" + invoiceId + "'");

                    Vector beans = new Vector();
                    while (invoiceRs.next()) {
                        String itemCode = invoiceRs.getString("stock.id");
                        String productName = invoiceRs.getString("product.name");
                        String quantity = invoiceRs.getString("invoice_item.quantity");
                        String price = df.format(Double.parseDouble(invoiceRs.getString("stock.selling_price")));
                        double total = Double.parseDouble(invoiceRs.getString("stock.selling_price")) * Double.parseDouble(invoiceRs.getString("invoice_item.quantity"));
                        beans.add(new InvoiceReport(itemCode, productName, quantity, price, String.valueOf(total)));
                    }

                    ResultSet invoiceRs2 = MySQL.search("SELECT * FROM `invoice` INNER JOIN `invoice_payment` ON `invoice_payment`.`invoice_id` = `invoice`.`id` WHERE `invoice`.`id` = '" + invoiceId + "'");
                    invoiceRs2.next();

                    HashMap parameters = new HashMap();
                    parameters.put("Parameter1", invoiceRs2.getString("invoice.id"));
                    double price = Double.parseDouble(invoiceRs2.getString("invoice_payment.payment")) - Double.parseDouble(invoiceRs2.getString("invoice_payment.balance"));
                    parameters.put("Parameter2", df.format(price));
                    parameters.put("Parameter3", df.format(Double.parseDouble(invoiceRs2.getString("invoice_payment.payment"))));
                    parameters.put("Parameter4", df.format(Double.parseDouble(invoiceRs2.getString("invoice_payment.balance"))));

                    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(beans);

                    InputStream filePath = Invoice.class.getResourceAsStream("/reports/sp_invoice.jasper");

                    JasperPrint jp = JasperFillManager.fillReport(filePath, parameters, dataSource);
                    JasperViewer.viewReport(jp, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
