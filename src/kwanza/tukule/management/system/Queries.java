/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwanza.tukule.management.system;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Mariwa
 */
public class Queries {
Connection con = null;
ResultSet rs = null;
ResultSet rs2 = null;
PreparedStatement pst = null;
PreparedStatement pst2 = null;
PreparedStatement pst3 = null;
public String user;
public String role;
public String CustomerId;
public String CustomerName;
public String CustomerNumber;
public String CustomerDeliverer;
public String CustomerLocation;
public String CustomerStatus;
    public ArrayList stockQuery() throws SQLException {
  String query2 = "SELECT * FROM stock INNER JOIN category ON stock.Category_id=category.id";
  Connection connect = databaseConnection.connection();
               ArrayList stocks = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("id"),
                                rs.getString("Category_Name"),
                                rs.getString("Name"),
                                rs.getString("Price"),
                                rs.getString("Quantity"),
                                 rs.getDouble("Buying_price")};
                    stocks.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return stocks;
    }
    public void print(JTable Table){
        try{
            Boolean printData0 = Table.print();
            if (printData0){
                JOptionPane.showMessageDialog(null,"Done Printing");
            }
            else{
                JOptionPane.showMessageDialog(null,"Printing...");
            }
        } catch (PrinterException ex) {
            Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList stockQuery1() throws SQLException {
               String query2 = "SELECT * FROM stock INNER JOIN category ON stock.Category_id=category.id";
               Connection connect = databaseConnection.connection();
                ArrayList stocks1 = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("id"),
                                rs.getString("Category_Name"),
                                rs.getString("Name"),
                                rs.getString("Price"),
                                rs.getString("Quantity")};
                    stocks1.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return stocks1;
    }
    public ArrayList categoriesQuery() throws SQLException {
           String query2 = "SELECT * FROM category";
           Connection connect = databaseConnection.connection();
            ArrayList categories = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("id"),
                                rs.getString("Category_Name")
                                };
                    categories.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return categories;
    }
    public ArrayList categoriesQuery1() throws SQLException {
        String query2 = "SELECT * FROM category";
        Connection connect = databaseConnection.connection();
        ArrayList categories1 = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("id"),
                                rs.getString("Category_Name")
                                };
                    categories1.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return categories1;
    }
    public ArrayList returnedQuery() throws SQLException {
        String query2 = "SELECT * FROM orders INNER JOIN customers ON orders.Customer_id = customers.id INNER JOIN category ON orders.Category_id = category.id INNER JOIN stock ON orders.Stock_id = stock.id where orders.Returned > 0 and DATE(orders.Created_at) > CURRENT_DATE()-1";
        Connection connect = databaseConnection.connection();
        ArrayList returned = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("orders.id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("customers.Deliverer"),
                                rs.getString("category.Category_Name"),
                                rs.getString("stock.Name"),
                                rs.getInt("orders.Quantity"),
                                rs.getInt("orders.Returned")
                                };
                    returned.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return returned;
    }
    public ArrayList blacklistQuery1() throws SQLException {
         String query2 = "SELECT * FROM orders INNER JOIN customers ON orders.Customer_id=customers.id WHERE orders.id IN (SELECT MAX(orders.id) FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.Status='blacklisted'  GROUP BY customers.id );";
        Connection connect = databaseConnection.connection();
         ArrayList blackList1 = new ArrayList();
         try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                double paid = 0.0;
                while(rs.next()){
                    Object o[]={rs.getInt("customers.id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("customers.Location"),
                                paid,
                                rs.getString("orders.Balance")};
                    blackList1.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
         finally{
            if(connect!=null){
                connect.close();
            }
        }
         return blackList1;
    }
    public ArrayList customersQuery1() throws SQLException {
        String query2 = "select * from customers where Status='clean' or Status='fined' or Status='credit' or Status='no delivery'";
        Connection connect = databaseConnection.connection();
        ArrayList customers1 = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("id"),
                                rs.getString("Name"),
                                rs.getString("Number"),
                                rs.getString("Location"),
                                rs.getString("Deliverer"),
                                rs.getString("Status"),
                                  rs.getString("Note")};
                    customers1.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return customers1;
    }
    public ArrayList customersQuery2() throws SQLException {
        String query2 = "select * from customers where Status='clean' or Status='fined' or Status='credit' or Status='no delivery'";
       Connection connect = databaseConnection.connection();
        ArrayList customers2 = new ArrayList();
        try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()){
                    Object o[]={rs.getInt("id"),
                                rs.getString("Name"),
                                rs.getString("Number"),
                                rs.getString("Location"),
                                rs.getString("Deliverer"),
                                rs.getString("Status")};
                    customers2.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally{
            if(connect!=null){
                connect.close();
            }
        }
        return customers2;
    }
    public ArrayList blacklistQuery2() throws SQLException {
                 String query2 = "SELECT * FROM orders INNER JOIN customers ON orders.Customer_id=customers.id WHERE orders.Created_at IN (SELECT MAX(orders.id) FROM orders INNER JOIN customers ON orders.Customer_id=customers.id where customers.Status='blacklisted'  GROUP BY customers.id );";
                Connection connect = databaseConnection.connection();
                 ArrayList blackList2 = new ArrayList();
                 try {
                pst = connect.prepareStatement(query2);
                rs=pst.executeQuery();
                double paid = 0.0;
                while(rs.next()){
                    Object o[]={rs.getInt("customers.id"),
                                rs.getString("customers.Name"),
                                rs.getString("customers.Number"),
                                rs.getString("customers.Location"),
                                paid,
                                rs.getString("orders.Balance")};
                    blackList2.add(o);         
                }
              } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 finally{
            if(connect!=null){
                connect.close();
            }
        }
                 return blackList2;
    }
    public ArrayList valuationQuery() throws SQLException {
        Connection connect = databaseConnection.connection();
        String query2 = "select s.id as sid, s.Name as sname,\n" +
"       sum(case when date(o.Late_Order) =  CURRENT_DATE-4 then o.Quantity else 0 end) as sum1,\n" +
"       sum(case when date(o.Late_Order) =  CURRENT_DATE-3 then o.Quantity else 0 end) as sum2,\n" +
"       sum(case when date(o.Late_Order) =  CURRENT_DATE-2 then o.Quantity else 0 end) as sum3,\n" +
"       sum(case when date(o.Late_Order) =  CURRENT_DATE-1 then o.Quantity else 0 end) as sum4,\n" +
"       sum(case when date(o.Late_Order) =  CURRENT_DATE then o.Quantity else 0 end) as sum5\n" +
"from orders o inner join\n" +
"     stock s\n" +
"     on o.Stock_id = s.id \n" +
"group by s.id; ";
        ArrayList valuation = new ArrayList();
        String query = "select * from stock";
        try {       
            pst = connect.prepareStatement(query2);
            rs=pst.executeQuery();
            pst2 = connect.prepareStatement(query);
            rs2=pst2.executeQuery();
            while(rs.next() && rs2.next()){
                int sum1 = rs.getInt("sum1");
                int sum2 = rs.getInt("sum2");
                int sum3 = rs.getInt("sum3");
                int sum4 = rs.getInt("sum4");
                int sum5 = rs.getInt("sum5");
                int qty = rs2.getInt("Quantity");
                double buying_price = rs2.getDouble("Buying_price");
                double value = qty*buying_price;
                Object o[]={rs.getString("sid"),
                    rs.getString("sname"),
                    sum1,
                    sum2,
                    sum3,
                    sum4,
                    sum5,
                    rs2.getInt("Opening_stock"),
                    rs2.getInt("purchased"),
                    qty,
                    buying_price,
                    value
                };
                valuation.add(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(connect!=null){
                connect.close();
            }
        }
        
      return valuation; 
    }
}
