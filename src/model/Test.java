
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.Vector;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author poojithairosha
 */
public class Test {

    public static void main(String[] args) {

//        try {
//            double profit = 0.00;
//            
//            ResultSet invoiceRs = MySQL.search("SELECT * FROM `invoice` WHERE invoice.date_time LIKE '2022-07-23%'");
//
//            while (invoiceRs.next()) {
//                ResultSet invoiceItemRs = MySQL.search("SELECT * FROM `invoice_item` INNER JOIN stock ON invoice_item.stock_id = stock.id WHERE invoice_item.invoice_id = '" + invoiceRs.getString("id") + "'");
//                
//                while(invoiceItemRs.next()) {
//                    String quantity = invoiceItemRs.getString("invoice_item.quantity");
//                    String sellingPrice = invoiceItemRs.getString("stock.selling_price");
//                    
//                    ResultSet grnItemRs = MySQL.search("SELECT * FROM grn_item WHERE stock_id = '"+invoiceItemRs.getString("stock.id")+"'");
//                    grnItemRs.next();
//                    
//                    String buyingPrice = grnItemRs.getString("grn_item.buying_price");
//                    
//                    double itemProfit = Double.parseDouble(sellingPrice) - Double.parseDouble(buyingPrice);
//                    
//                    profit += itemProfit * Integer.parseInt(quantity);
//                }
//            }
//            
//            System.out.println("Profit: " + profit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(new Date()));
//        try {
//            int noOfProducts = 0;
//
//            ResultSet rs = MySQL.search("SELECT * FROM stock INNER JOIN product ON stock.product_id = product.id WHERE stock.quantity < 10");
//
//            while (rs.next()) {
//                ResultSet rs2 = MySQL.search("SELECT * FROM stock WHERE product_id = '" + rs.getString("stock.product_id") + "' AND quantity > 10");
//
//                if (rs2.next()) {
//                    continue;
//                } else {
//                    noOfProducts++;
//                    System.out.println(rs.getString("product.name"));
//                }
//            }
//
//            System.out.println(noOfProducts);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Color c = new Color(74, 86, 108);
//        Color c1 = new Color(74, 67, 108);
//        
//        System.out.println(c.equals(c1));



//        try {
//            InputStream filePath = Test.class.getResourceAsStream("../reports/sp_invoice.jasper");
//            
//            HashMap parameters = new HashMap();
//            parameters.put("Parameter1", "1233");
//            parameters.put("Parameter2", "1");
//            parameters.put("Parameter3", "500");
//            parameters.put("Parameter4", "1000");
//            parameters.put("Parameter5", "500");
//            
//            
//            Vector beans = new Vector();
//            
//            beans.add(new InvoiceReport("ABC", "ABC", "ABC", "ABC", "ABC"));
//            beans.add(new InvoiceReport("ABC", "ABC", "ABC", "ABC", "ABC"));
//            beans.add(new InvoiceReport("ABC", "ABC", "ABC", "ABC", "ABC"));
//            beans.add(new InvoiceReport("ABC", "ABC", "ABC", "ABC", "ABC"));
//            beans.add(new InvoiceReport("ABC", "ABC", "ABC", "ABC", "ABC"));
//            
//            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(beans);
//            
//            JasperPrint jasperPrint = JasperFillManager.fillReport(filePath, parameters, dataSource);
//            JasperViewer.viewReport(jasperPrint);
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//         System.out.println((int)(Math.random() * 1000));

//            String date = "2022-07-03 08:32:50";
//            
//            String[] d = date.split(" ");
//            System.out.println(d[0]);


    }

}
