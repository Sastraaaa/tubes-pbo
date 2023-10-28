package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi {
    private Connection conn;
    private Statement stm;
    ResultSet rs;
    public void koneksi () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/db_transaksibuah","root","");
            stm=conn.createStatement();
        }catch(SQLException ex) {
            System.err.print(ex);
        }catch(ClassNotFoundException ex) {
            System.err.print(ex);
        }
    }
    public ResultSet getData(String SQLString)
    {
        try
        {
        rs=stm.executeQuery(SQLString);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"error: "
                    +e.getMessage(),"Komunikasi error pada method getdata",
                    JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
//    akhir public result
    public void query(String SQLString)
    {
        try {
            stm.execute(SQLString);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog
                    (null,"error"+e.getMessage(),"Komunikasi error pada method query",
                     JOptionPane.WARNING_MESSAGE);
        }
    }
}

