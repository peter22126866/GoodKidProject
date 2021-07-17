import java.awt.*;
import java.awt.event.*;

public class LoginFrame{

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

        this.tfUser.setText("cbb108026");
        this.tfPasswd.setText("dj84n0vul3");

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