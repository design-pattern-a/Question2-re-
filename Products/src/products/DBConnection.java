package products;

//import java.beans.Statement;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "");
            
            st = con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void getName(){
        try{
            String query = "select name from sold_products";
            rs = st.executeQuery(query);
            
            while(rs.next()){
                String name = rs.getString("name");
                
//                System.out.println("name: " + name);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void fillCombo(JComboBox comb_name){
        try{
            String query = "select name from sold_products";
            rs = st.executeQuery(query);
            
            while(rs.next()){
                String name = rs.getString("name");
                comb_name.addItem(name);
            }
        }
        catch(Exception e){
            
        }
    }
    public void add(String name, String amount){
        int prev;
        int new_amt = 0;
        int arg_amt = Integer.valueOf(amount);
        try{
            String query2 = "select amount from sold_products where name = '"+ name +"'";
            rs = st.executeQuery(query2);
            while(rs.next()){
                String prev_amt = rs.getString("amount");
                prev = Integer.valueOf(prev_amt);
                new_amt = arg_amt + prev;
                
            }
            String query = "update sold_products set amount = '" + new_amt + "' where name = '" + name + "'";
            pst = con.prepareStatement(query);
            pst.execute();
            System.out.println(new_amt);
        }
        catch(Exception e){
            
        }
    }
    public void fetch(String query, JTable table){
        try{
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            
        }
    }
    
    public void sort(){
        try{
            String query;
        }
        catch(Exception e){
            
        }
    }
}
