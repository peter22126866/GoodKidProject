import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnector {
    private String url = "jdbc:mysql://web.csie2.nptu.edu.tw:3306/cbb108026_GKPtest";
    private String user = "cbb108026";
    private String password = "dj84n0vul3";
    public boolean isConnect = false;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public DBConnector()
    {
        this.isConnect = Connect(user, password);
    }

    public boolean Connect(String user, String password)
    {
        this.user = user;
        this.password = password;
        try{
            
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            stmt = conn.createStatement();
            System.out.println(conn);
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public void Login(String user, String password) {
        try{
            rs = stmt.executeQuery("SELECT * FROM Login WHERE SSID='"+user+"' AND pass_word='"+password+"'");
            rs.next();
            System.out.printf("%s %s %d\n",rs.getString("SSID"),rs.getString("pass_word"),rs.getInt("identity"));
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "登入失敗", "錯誤", JOptionPane.ERROR_MESSAGE);
        }
    }
}