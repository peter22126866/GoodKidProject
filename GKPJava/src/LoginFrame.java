import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class LoginFrame{

    public  DBConnector Database = new DBConnector();
    private Frame login;
    private Label laUser;
    private Label laPasswd;
    private TextField tfUser;
    private TextField tfPasswd;
    private Button btnFalse;
    private Button btnTrue;

    public LoginFrame(){
    
        this.login = new Frame("login");
        this.login.setLayout(new GridLayout(3,2));
        this.login.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.login.setLocation(525, 350);
        this.login.setSize(350,150);
        
        this.laUser = new Label("User: ");
        this.laPasswd = new Label("Password: ");
        this.tfUser = new TextField("",10);
        this.tfPasswd = new TextField("",10);

        tfPasswd.setEchoChar('*');
        this.btnFalse=new Button("Cancel");
        this.btnFalse.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
        });
        this.btnTrue = new Button("Enter");
        this.btnTrue.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int temp = Database.Login(tfUser.getText(),tfPasswd.getText());
                if(temp == 0){
                    //new KidFrame(ssid);
                    login.setVisible(false);
                }else if(temp == 1){
                    new ParentFrame(tfUser.getText());
                    login.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "登入失敗", "錯誤", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        login.add(laUser);
        login.add(tfUser);
        login.add(laPasswd);
        login.add(tfPasswd);
        login.add(btnFalse);
        login.add(btnTrue);
        login.setVisible(true);
    
        
    }
}